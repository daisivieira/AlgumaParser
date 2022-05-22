/**
 * generated by Xtext 2.27.0.M2
 */
package br.ufscar.dc.compiladores.alguma.alguma.util;

import br.ufscar.dc.compiladores.alguma.alguma.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see br.ufscar.dc.compiladores.alguma.alguma.AlgumaPackage
 * @generated
 */
public class AlgumaAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static AlgumaPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AlgumaAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = AlgumaPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected AlgumaSwitch<Adapter> modelSwitch =
    new AlgumaSwitch<Adapter>()
    {
      @Override
      public Adapter casePrograma(Programa object)
      {
        return createProgramaAdapter();
      }
      @Override
      public Adapter caseDeclaracao(Declaracao object)
      {
        return createDeclaracaoAdapter();
      }
      @Override
      public Adapter caseExpressaoAritmetica(ExpressaoAritmetica object)
      {
        return createExpressaoAritmeticaAdapter();
      }
      @Override
      public Adapter caseOutroTermoAritmetico(OutroTermoAritmetico object)
      {
        return createOutroTermoAritmeticoAdapter();
      }
      @Override
      public Adapter caseTermoAritmetico(TermoAritmetico object)
      {
        return createTermoAritmeticoAdapter();
      }
      @Override
      public Adapter caseOutroFatorAritmetico(OutroFatorAritmetico object)
      {
        return createOutroFatorAritmeticoAdapter();
      }
      @Override
      public Adapter caseFatorAritmetico(FatorAritmetico object)
      {
        return createFatorAritmeticoAdapter();
      }
      @Override
      public Adapter caseFatorNumero(FatorNumero object)
      {
        return createFatorNumeroAdapter();
      }
      @Override
      public Adapter caseFatorVariavel(FatorVariavel object)
      {
        return createFatorVariavelAdapter();
      }
      @Override
      public Adapter caseFatorSubExpressao(FatorSubExpressao object)
      {
        return createFatorSubExpressaoAdapter();
      }
      @Override
      public Adapter caseExpressaoRelacional(ExpressaoRelacional object)
      {
        return createExpressaoRelacionalAdapter();
      }
      @Override
      public Adapter caseOutroTermoRelacional(OutroTermoRelacional object)
      {
        return createOutroTermoRelacionalAdapter();
      }
      @Override
      public Adapter caseTermoRelacional(TermoRelacional object)
      {
        return createTermoRelacionalAdapter();
      }
      @Override
      public Adapter caseTermoComparacaoRelacional(TermoComparacaoRelacional object)
      {
        return createTermoComparacaoRelacionalAdapter();
      }
      @Override
      public Adapter caseTermoSubExpressaoRelacional(TermoSubExpressaoRelacional object)
      {
        return createTermoSubExpressaoRelacionalAdapter();
      }
      @Override
      public Adapter caseComando(Comando object)
      {
        return createComandoAdapter();
      }
      @Override
      public Adapter caseComandoAtribuicao(ComandoAtribuicao object)
      {
        return createComandoAtribuicaoAdapter();
      }
      @Override
      public Adapter caseComandoEntrada(ComandoEntrada object)
      {
        return createComandoEntradaAdapter();
      }
      @Override
      public Adapter caseComandoSaida(ComandoSaida object)
      {
        return createComandoSaidaAdapter();
      }
      @Override
      public Adapter caseComandoCondicao(ComandoCondicao object)
      {
        return createComandoCondicaoAdapter();
      }
      @Override
      public Adapter caseComandoRepeticao(ComandoRepeticao object)
      {
        return createComandoRepeticaoAdapter();
      }
      @Override
      public Adapter caseSubAlgoritmo(SubAlgoritmo object)
      {
        return createSubAlgoritmoAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.Programa <em>Programa</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.Programa
   * @generated
   */
  public Adapter createProgramaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.Declaracao <em>Declaracao</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.Declaracao
   * @generated
   */
  public Adapter createDeclaracaoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.ExpressaoAritmetica <em>Expressao Aritmetica</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.ExpressaoAritmetica
   * @generated
   */
  public Adapter createExpressaoAritmeticaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.OutroTermoAritmetico <em>Outro Termo Aritmetico</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.OutroTermoAritmetico
   * @generated
   */
  public Adapter createOutroTermoAritmeticoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.TermoAritmetico <em>Termo Aritmetico</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.TermoAritmetico
   * @generated
   */
  public Adapter createTermoAritmeticoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.OutroFatorAritmetico <em>Outro Fator Aritmetico</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.OutroFatorAritmetico
   * @generated
   */
  public Adapter createOutroFatorAritmeticoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.FatorAritmetico <em>Fator Aritmetico</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.FatorAritmetico
   * @generated
   */
  public Adapter createFatorAritmeticoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.FatorNumero <em>Fator Numero</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.FatorNumero
   * @generated
   */
  public Adapter createFatorNumeroAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.FatorVariavel <em>Fator Variavel</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.FatorVariavel
   * @generated
   */
  public Adapter createFatorVariavelAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.FatorSubExpressao <em>Fator Sub Expressao</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.FatorSubExpressao
   * @generated
   */
  public Adapter createFatorSubExpressaoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.ExpressaoRelacional <em>Expressao Relacional</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.ExpressaoRelacional
   * @generated
   */
  public Adapter createExpressaoRelacionalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.OutroTermoRelacional <em>Outro Termo Relacional</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.OutroTermoRelacional
   * @generated
   */
  public Adapter createOutroTermoRelacionalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.TermoRelacional <em>Termo Relacional</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.TermoRelacional
   * @generated
   */
  public Adapter createTermoRelacionalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.TermoComparacaoRelacional <em>Termo Comparacao Relacional</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.TermoComparacaoRelacional
   * @generated
   */
  public Adapter createTermoComparacaoRelacionalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.TermoSubExpressaoRelacional <em>Termo Sub Expressao Relacional</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.TermoSubExpressaoRelacional
   * @generated
   */
  public Adapter createTermoSubExpressaoRelacionalAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.Comando <em>Comando</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.Comando
   * @generated
   */
  public Adapter createComandoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.ComandoAtribuicao <em>Comando Atribuicao</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.ComandoAtribuicao
   * @generated
   */
  public Adapter createComandoAtribuicaoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.ComandoEntrada <em>Comando Entrada</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.ComandoEntrada
   * @generated
   */
  public Adapter createComandoEntradaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.ComandoSaida <em>Comando Saida</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.ComandoSaida
   * @generated
   */
  public Adapter createComandoSaidaAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.ComandoCondicao <em>Comando Condicao</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.ComandoCondicao
   * @generated
   */
  public Adapter createComandoCondicaoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.ComandoRepeticao <em>Comando Repeticao</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.ComandoRepeticao
   * @generated
   */
  public Adapter createComandoRepeticaoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link br.ufscar.dc.compiladores.alguma.alguma.SubAlgoritmo <em>Sub Algoritmo</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see br.ufscar.dc.compiladores.alguma.alguma.SubAlgoritmo
   * @generated
   */
  public Adapter createSubAlgoritmoAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //AlgumaAdapterFactory
