/**
 * generated by Xtext 2.27.0.M2
 */
package br.ufscar.dc.compiladores.alguma2.alguma2;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see br.ufscar.dc.compiladores.alguma2.alguma2.Alguma2Package
 * @generated
 */
public interface Alguma2Factory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  Alguma2Factory eINSTANCE = br.ufscar.dc.compiladores.alguma2.alguma2.impl.Alguma2FactoryImpl.init();

  /**
   * Returns a new object of class '<em>Programa</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Programa</em>'.
   * @generated
   */
  Programa createPrograma();

  /**
   * Returns a new object of class '<em>Declaracao</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Declaracao</em>'.
   * @generated
   */
  Declaracao createDeclaracao();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  Alguma2Package getAlguma2Package();

} //Alguma2Factory
