
package br.ufscar.dc.compiladores.alguma.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import br.ufscar.dc.compiladores.alguma.alguma.Programa
import br.ufscar.dc.compiladores.alguma.alguma.Declaracao
import br.ufscar.dc.compiladores.alguma.alguma.ComandoAtribuicao
import br.ufscar.dc.compiladores.alguma.alguma.ComandoEntrada
import br.ufscar.dc.compiladores.alguma.alguma.ComandoSaida
import br.ufscar.dc.compiladores.alguma.alguma.ComandoCondicao
import br.ufscar.dc.compiladores.alguma.alguma.ComandoRepeticao
import br.ufscar.dc.compiladores.alguma.alguma.SubAlgoritmo
import br.ufscar.dc.compiladores.alguma.alguma.ExpressaoAritmetica
import br.ufscar.dc.compiladores.alguma.alguma.TermoAritmetico
import br.ufscar.dc.compiladores.alguma.alguma.FatorNumero
import br.ufscar.dc.compiladores.alguma.alguma.FatorVariavel
import br.ufscar.dc.compiladores.alguma.alguma.FatorSubExpressao
import br.ufscar.dc.compiladores.alguma.alguma.ExpressaoRelacional
import br.ufscar.dc.compiladores.alguma.alguma.TermoComparacaoRelacional
import br.ufscar.dc.compiladores.alguma.alguma.TermoSubExpressaoRelacional
import org.eclipse.xtend2.lib.StringConcatenation

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class AlgumaGenerator extends AbstractGenerator {

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		for (e : resource.allContents.toIterable.filter(Programa)) {
			fsa.generateFile("Programa.java", e.compilePrograma)
		}
	}

	def compilePrograma(Programa p) '''
		public class Programa {
			�FOR d : p.declaracoes�
				static �getTipo(d)� �d.name�;
			�ENDFOR�
			
			public static void main(String args[]) {
				�FOR c : p.comandos�
					�c.compileComando�
				�ENDFOR�
			}
		}
	'''

	def getTipo(Declaracao d) {
		if(d.tipo == "INTEIRO") return "int" else return "double"
	}
 
	def dispatch compileComando(ComandoAtribuicao c) '''
		�c.variavel.name� = �c.exp.compileExpressao�;
	'''

	def dispatch compileComando(ComandoEntrada c) '''
		�IF c.variavel.tipo == "INTEIRO"�
			�c.variavel.name� = Integer.parseInt(System.console().readLine());
		�ELSEIF c.variavel.tipo == "REAL"�
			�c.variavel.name� = Double.parseDouble(System.console().readLine());
		�ENDIF�
	'''

	def dispatch compileComando(ComandoSaida c) '''
		System.out.println( �c.variavel.name� );
	'''

	def dispatch compileComando(ComandoCondicao c) '''
		if( �c.exp.compileExpressaoRelacional� ) �c.cmd1.compileComando�
		�IF c.cmd2 !== null�else �c.cmd2.compileComando� �ENDIF�
		
	'''

	def dispatch compileComando(ComandoRepeticao c) '''
		while( �c.exp.compileExpressaoRelacional� ) �c.cmd.compileComando�
	'''

	def dispatch compileComando(SubAlgoritmo s) '''
		{
			�FOR c : s.comandos�
				�c.compileComando�
			�ENDFOR�
		}
	'''

	def compileExpressao(ExpressaoAritmetica e) {
		val ret = new StringConcatenation
		ret.append(e.termo1.compileTermo)
		e.outrosTermos.forEach[ ot |
			ret.append(" " + ot.operador + " " + ot.termo.compileTermo)
		]
		
		return ret
	}
	
	def compileTermo(TermoAritmetico t) {
		val ret = new StringConcatenation
		ret.append(t.fator1.compileFator)
		t.outrosFatores.forEach[ of |
			ret.append(" " + of.operador + " " + of.fator.compileFator)
		]
		return ret
	}
	
	def dispatch compileFator(FatorNumero fn) '''�fn.numero�'''
	
	def dispatch compileFator(FatorVariavel fv) '''�fv.variavel.name�'''
	
	def dispatch compileFator(FatorSubExpressao fse) '''( �fse.expressao.compileExpressao� )'''
	
	def compileExpressaoRelacional(ExpressaoRelacional e) {
		val ret = new StringConcatenation
		ret.append(e.termo1.compileTermoRelacional)
		e.outrosTermos.forEach[ ot |
			ret.append(" " + ot.operador.compileOperadorBooleano + " " + ot.termo.compileTermoRelacional)
		]
		return ret
	}
	
	def compileOperadorBooleano(String s) {
		if(s == "E") return "&&" else return "||"
	}
	
	def dispatch compileTermoRelacional(TermoComparacaoRelacional tcr) {
		return tcr.exp1.compileExpressao + " " + tcr.opRel.compileOperadorRelacional + " " + tcr.exp2.compileExpressao 
	}
	
	def compileOperadorRelacional(String s) {
		if(s == "<") return "<"
		else if(s == "<=") return "<="
		else if(s == ">") return ">"
		else if(s == ">=") return ">="
		else if(s == "<>") return "!="
		else if(s == "=") return "=="
	}
	
	def dispatch compileTermoRelacional(TermoSubExpressaoRelacional tser) '''( �tser.expRel� )'''
	
}