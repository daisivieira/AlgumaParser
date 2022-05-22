/**
 * generated by Xtext 2.27.0.M2
 */
package br.ufscar.dc.compiladores.alguma.alguma;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Programa</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link br.ufscar.dc.compiladores.alguma.alguma.Programa#getDeclaracoes <em>Declaracoes</em>}</li>
 *   <li>{@link br.ufscar.dc.compiladores.alguma.alguma.Programa#getComandos <em>Comandos</em>}</li>
 * </ul>
 *
 * @see br.ufscar.dc.compiladores.alguma.alguma.AlgumaPackage#getPrograma()
 * @model
 * @generated
 */
public interface Programa extends EObject
{
  /**
   * Returns the value of the '<em><b>Declaracoes</b></em>' containment reference list.
   * The list contents are of type {@link br.ufscar.dc.compiladores.alguma.alguma.Declaracao}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declaracoes</em>' containment reference list.
   * @see br.ufscar.dc.compiladores.alguma.alguma.AlgumaPackage#getPrograma_Declaracoes()
   * @model containment="true"
   * @generated
   */
  EList<Declaracao> getDeclaracoes();

  /**
   * Returns the value of the '<em><b>Comandos</b></em>' containment reference list.
   * The list contents are of type {@link br.ufscar.dc.compiladores.alguma.alguma.Comando}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Comandos</em>' containment reference list.
   * @see br.ufscar.dc.compiladores.alguma.alguma.AlgumaPackage#getPrograma_Comandos()
   * @model containment="true"
   * @generated
   */
  EList<Comando> getComandos();

} // Programa
