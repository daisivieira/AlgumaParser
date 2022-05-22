package br.ufscar.dc.compiladores.alguma.generator;

import br.ufscar.dc.compiladores.alguma.alguma.Comando;
import br.ufscar.dc.compiladores.alguma.alguma.ComandoAtribuicao;
import br.ufscar.dc.compiladores.alguma.alguma.ComandoCondicao;
import br.ufscar.dc.compiladores.alguma.alguma.ComandoEntrada;
import br.ufscar.dc.compiladores.alguma.alguma.ComandoRepeticao;
import br.ufscar.dc.compiladores.alguma.alguma.ComandoSaida;
import br.ufscar.dc.compiladores.alguma.alguma.Declaracao;
import br.ufscar.dc.compiladores.alguma.alguma.ExpressaoAritmetica;
import br.ufscar.dc.compiladores.alguma.alguma.ExpressaoRelacional;
import br.ufscar.dc.compiladores.alguma.alguma.FatorAritmetico;
import br.ufscar.dc.compiladores.alguma.alguma.FatorNumero;
import br.ufscar.dc.compiladores.alguma.alguma.FatorSubExpressao;
import br.ufscar.dc.compiladores.alguma.alguma.FatorVariavel;
import br.ufscar.dc.compiladores.alguma.alguma.OutroFatorAritmetico;
import br.ufscar.dc.compiladores.alguma.alguma.OutroTermoAritmetico;
import br.ufscar.dc.compiladores.alguma.alguma.OutroTermoRelacional;
import br.ufscar.dc.compiladores.alguma.alguma.Programa;
import br.ufscar.dc.compiladores.alguma.alguma.SubAlgoritmo;
import br.ufscar.dc.compiladores.alguma.alguma.TermoAritmetico;
import br.ufscar.dc.compiladores.alguma.alguma.TermoComparacaoRelacional;
import br.ufscar.dc.compiladores.alguma.alguma.TermoRelacional;
import br.ufscar.dc.compiladores.alguma.alguma.TermoSubExpressaoRelacional;
import com.google.common.base.Objects;
import com.google.common.collect.Iterables;
import java.util.Arrays;
import java.util.function.Consumer;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtend2.lib.StringConcatenation;
import org.eclipse.xtext.generator.AbstractGenerator;
import org.eclipse.xtext.generator.IFileSystemAccess2;
import org.eclipse.xtext.generator.IGeneratorContext;
import org.eclipse.xtext.xbase.lib.IteratorExtensions;

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
@SuppressWarnings("all")
public class AlgumaGenerator extends AbstractGenerator {
  @Override
  public void doGenerate(final Resource resource, final IFileSystemAccess2 fsa, final IGeneratorContext context) {
    Iterable<Programa> _filter = Iterables.<Programa>filter(IteratorExtensions.<EObject>toIterable(resource.getAllContents()), Programa.class);
    for (final Programa e : _filter) {
      fsa.generateFile("Programa.java", this.compilePrograma(e));
    }
  }

  public CharSequence compilePrograma(final Programa p) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("public class Programa {");
    _builder.newLine();
    {
      EList<Declaracao> _declaracoes = p.getDeclaracoes();
      for(final Declaracao d : _declaracoes) {
        _builder.append("\t");
        _builder.append("static ");
        String _tipo = this.getTipo(d);
        _builder.append(_tipo, "\t");
        _builder.append(" ");
        String _name = d.getName();
        _builder.append(_name, "\t");
        _builder.append(";");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.newLine();
    _builder.append("\t");
    _builder.append("public static void main(String args[]) {");
    _builder.newLine();
    {
      EList<Comando> _comandos = p.getComandos();
      for(final Comando c : _comandos) {
        _builder.append("\t\t");
        CharSequence _compileComando = this.compileComando(c);
        _builder.append(_compileComando, "\t\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("\t");
    _builder.append("}");
    _builder.newLine();
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public String getTipo(final Declaracao d) {
    String _tipo = d.getTipo();
    boolean _equals = Objects.equal(_tipo, "INTEIRO");
    if (_equals) {
      return "int";
    } else {
      return "double";
    }
  }

  protected CharSequence _compileComando(final ComandoAtribuicao c) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = c.getVariavel().getName();
    _builder.append(_name);
    _builder.append(" = ");
    StringConcatenation _compileExpressao = this.compileExpressao(c.getExp());
    _builder.append(_compileExpressao);
    _builder.append(";");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected CharSequence _compileComando(final ComandoEntrada c) {
    StringConcatenation _builder = new StringConcatenation();
    {
      String _tipo = c.getVariavel().getTipo();
      boolean _equals = Objects.equal(_tipo, "INTEIRO");
      if (_equals) {
        String _name = c.getVariavel().getName();
        _builder.append(_name);
        _builder.append(" = Integer.parseInt(System.console().readLine());");
        _builder.newLineIfNotEmpty();
      } else {
        String _tipo_1 = c.getVariavel().getTipo();
        boolean _equals_1 = Objects.equal(_tipo_1, "REAL");
        if (_equals_1) {
          String _name_1 = c.getVariavel().getName();
          _builder.append(_name_1);
          _builder.append(" = Double.parseDouble(System.console().readLine());");
          _builder.newLineIfNotEmpty();
        }
      }
    }
    return _builder;
  }

  protected CharSequence _compileComando(final ComandoSaida c) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("System.out.println( ");
    String _name = c.getVariavel().getName();
    _builder.append(_name);
    _builder.append(" );");
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected CharSequence _compileComando(final ComandoCondicao c) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("if( ");
    StringConcatenation _compileExpressaoRelacional = this.compileExpressaoRelacional(c.getExp());
    _builder.append(_compileExpressaoRelacional);
    _builder.append(" ) ");
    Object _compileComando = this.compileComando(c.getCmd1());
    _builder.append(_compileComando);
    _builder.newLineIfNotEmpty();
    {
      Comando _cmd2 = c.getCmd2();
      boolean _tripleNotEquals = (_cmd2 != null);
      if (_tripleNotEquals) {
        _builder.append("else ");
        Object _compileComando_1 = this.compileComando(c.getCmd2());
        _builder.append(_compileComando_1);
        _builder.append(" ");
      }
    }
    _builder.newLineIfNotEmpty();
    _builder.newLine();
    return _builder;
  }

  protected CharSequence _compileComando(final ComandoRepeticao c) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("while( ");
    StringConcatenation _compileExpressaoRelacional = this.compileExpressaoRelacional(c.getExp());
    _builder.append(_compileExpressaoRelacional);
    _builder.append(" ) ");
    Object _compileComando = this.compileComando(c.getCmd());
    _builder.append(_compileComando);
    _builder.newLineIfNotEmpty();
    return _builder;
  }

  protected CharSequence _compileComando(final SubAlgoritmo s) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("{");
    _builder.newLine();
    {
      EList<Comando> _comandos = s.getComandos();
      for(final Comando c : _comandos) {
        _builder.append("\t");
        Object _compileComando = this.compileComando(c);
        _builder.append(_compileComando, "\t");
        _builder.newLineIfNotEmpty();
      }
    }
    _builder.append("}");
    _builder.newLine();
    return _builder;
  }

  public StringConcatenation compileExpressao(final ExpressaoAritmetica e) {
    final StringConcatenation ret = new StringConcatenation();
    ret.append(this.compileTermo(e.getTermo1()));
    final Consumer<OutroTermoAritmetico> _function = (OutroTermoAritmetico ot) -> {
      String _operador = ot.getOperador();
      String _plus = (" " + _operador);
      String _plus_1 = (_plus + " ");
      StringConcatenation _compileTermo = this.compileTermo(ot.getTermo());
      String _plus_2 = (_plus_1 + _compileTermo);
      ret.append(_plus_2);
    };
    e.getOutrosTermos().forEach(_function);
    return ret;
  }

  public StringConcatenation compileTermo(final TermoAritmetico t) {
    final StringConcatenation ret = new StringConcatenation();
    ret.append(this.compileFator(t.getFator1()));
    final Consumer<OutroFatorAritmetico> _function = (OutroFatorAritmetico of) -> {
      String _operador = of.getOperador();
      String _plus = (" " + _operador);
      String _plus_1 = (_plus + " ");
      CharSequence _compileFator = this.compileFator(of.getFator());
      String _plus_2 = (_plus_1 + _compileFator);
      ret.append(_plus_2);
    };
    t.getOutrosFatores().forEach(_function);
    return ret;
  }

  protected CharSequence _compileFator(final FatorNumero fn) {
    StringConcatenation _builder = new StringConcatenation();
    int _numero = fn.getNumero();
    _builder.append(_numero);
    return _builder;
  }

  protected CharSequence _compileFator(final FatorVariavel fv) {
    StringConcatenation _builder = new StringConcatenation();
    String _name = fv.getVariavel().getName();
    _builder.append(_name);
    return _builder;
  }

  protected CharSequence _compileFator(final FatorSubExpressao fse) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("( ");
    Object _compileExpressao = this.compileExpressao(fse.getExpressao());
    _builder.append(_compileExpressao);
    _builder.append(" )");
    return _builder;
  }

  public StringConcatenation compileExpressaoRelacional(final ExpressaoRelacional e) {
    final StringConcatenation ret = new StringConcatenation();
    ret.append(this.compileTermoRelacional(e.getTermo1()));
    final Consumer<OutroTermoRelacional> _function = (OutroTermoRelacional ot) -> {
      String _compileOperadorBooleano = this.compileOperadorBooleano(ot.getOperador());
      String _plus = (" " + _compileOperadorBooleano);
      String _plus_1 = (_plus + " ");
      CharSequence _compileTermoRelacional = this.compileTermoRelacional(ot.getTermo());
      String _plus_2 = (_plus_1 + _compileTermoRelacional);
      ret.append(_plus_2);
    };
    e.getOutrosTermos().forEach(_function);
    return ret;
  }

  public String compileOperadorBooleano(final String s) {
    boolean _equals = Objects.equal(s, "E");
    if (_equals) {
      return "&&";
    } else {
      return "||";
    }
  }

  protected CharSequence _compileTermoRelacional(final TermoComparacaoRelacional tcr) {
    StringConcatenation _compileExpressao = this.compileExpressao(tcr.getExp1());
    String _plus = (_compileExpressao + " ");
    String _compileOperadorRelacional = this.compileOperadorRelacional(tcr.getOpRel());
    String _plus_1 = (_plus + _compileOperadorRelacional);
    String _plus_2 = (_plus_1 + " ");
    StringConcatenation _compileExpressao_1 = this.compileExpressao(tcr.getExp2());
    return (_plus_2 + _compileExpressao_1);
  }

  public String compileOperadorRelacional(final String s) {
    boolean _equals = Objects.equal(s, "<");
    if (_equals) {
      return "<";
    } else {
      boolean _equals_1 = Objects.equal(s, "<=");
      if (_equals_1) {
        return "<=";
      } else {
        boolean _equals_2 = Objects.equal(s, ">");
        if (_equals_2) {
          return ">";
        } else {
          boolean _equals_3 = Objects.equal(s, ">=");
          if (_equals_3) {
            return ">=";
          } else {
            boolean _equals_4 = Objects.equal(s, "<>");
            if (_equals_4) {
              return "!=";
            } else {
              boolean _equals_5 = Objects.equal(s, "=");
              if (_equals_5) {
                return "==";
              }
            }
          }
        }
      }
    }
    return null;
  }

  protected CharSequence _compileTermoRelacional(final TermoSubExpressaoRelacional tser) {
    StringConcatenation _builder = new StringConcatenation();
    _builder.append("( ");
    ExpressaoRelacional _expRel = tser.getExpRel();
    _builder.append(_expRel);
    _builder.append(" )");
    return _builder;
  }

  public CharSequence compileComando(final Comando c) {
    if (c instanceof ComandoAtribuicao) {
      return _compileComando((ComandoAtribuicao)c);
    } else if (c instanceof ComandoCondicao) {
      return _compileComando((ComandoCondicao)c);
    } else if (c instanceof ComandoEntrada) {
      return _compileComando((ComandoEntrada)c);
    } else if (c instanceof ComandoRepeticao) {
      return _compileComando((ComandoRepeticao)c);
    } else if (c instanceof ComandoSaida) {
      return _compileComando((ComandoSaida)c);
    } else if (c instanceof SubAlgoritmo) {
      return _compileComando((SubAlgoritmo)c);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(c).toString());
    }
  }

  public CharSequence compileFator(final FatorAritmetico fn) {
    if (fn instanceof FatorNumero) {
      return _compileFator((FatorNumero)fn);
    } else if (fn instanceof FatorSubExpressao) {
      return _compileFator((FatorSubExpressao)fn);
    } else if (fn instanceof FatorVariavel) {
      return _compileFator((FatorVariavel)fn);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(fn).toString());
    }
  }

  public CharSequence compileTermoRelacional(final TermoRelacional tcr) {
    if (tcr instanceof TermoComparacaoRelacional) {
      return _compileTermoRelacional((TermoComparacaoRelacional)tcr);
    } else if (tcr instanceof TermoSubExpressaoRelacional) {
      return _compileTermoRelacional((TermoSubExpressaoRelacional)tcr);
    } else {
      throw new IllegalArgumentException("Unhandled parameter types: " +
        Arrays.<Object>asList(tcr).toString());
    }
  }
}
