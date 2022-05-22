/**
 * generated by Xtext 2.27.0.M2
 */
package br.ufscar.dc.compiladores.alguma.alguma;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Expressao Aritmetica</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link br.ufscar.dc.compiladores.alguma.alguma.ExpressaoAritmetica#getTermo1 <em>Termo1</em>}</li>
 *   <li>{@link br.ufscar.dc.compiladores.alguma.alguma.ExpressaoAritmetica#getOutrosTermos <em>Outros Termos</em>}</li>
 * </ul>
 *
 * @see br.ufscar.dc.compiladores.alguma.alguma.AlgumaPackage#getExpressaoAritmetica()
 * @model
 * @generated
 */
public interface ExpressaoAritmetica extends EObject
{
  /**
   * Returns the value of the '<em><b>Termo1</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Termo1</em>' containment reference.
   * @see #setTermo1(TermoAritmetico)
   * @see br.ufscar.dc.compiladores.alguma.alguma.AlgumaPackage#getExpressaoAritmetica_Termo1()
   * @model containment="true"
   * @generated
   */
  TermoAritmetico getTermo1();

  /**
   * Sets the value of the '{@link br.ufscar.dc.compiladores.alguma.alguma.ExpressaoAritmetica#getTermo1 <em>Termo1</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Termo1</em>' containment reference.
   * @see #getTermo1()
   * @generated
   */
  void setTermo1(TermoAritmetico value);

  /**
   * Returns the value of the '<em><b>Outros Termos</b></em>' containment reference list.
   * The list contents are of type {@link br.ufscar.dc.compiladores.alguma.alguma.OutroTermoAritmetico}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Outros Termos</em>' containment reference list.
   * @see br.ufscar.dc.compiladores.alguma.alguma.AlgumaPackage#getExpressaoAritmetica_OutrosTermos()
   * @model containment="true"
   * @generated
   */
  EList<OutroTermoAritmetico> getOutrosTermos();

} // ExpressaoAritmetica
