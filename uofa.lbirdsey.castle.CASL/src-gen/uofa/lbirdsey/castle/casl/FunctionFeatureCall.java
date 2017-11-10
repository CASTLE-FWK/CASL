/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Feature Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.FunctionFeatureCall#getProcess <em>Process</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.FunctionFeatureCall#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getFunctionFeatureCall()
 * @model
 * @generated
 */
public interface FunctionFeatureCall extends EObject
{
  /**
   * Returns the value of the '<em><b>Process</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Process</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Process</em>' reference.
   * @see #setProcess(Function)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getFunctionFeatureCall_Process()
   * @model
   * @generated
   */
  Function getProcess();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.FunctionFeatureCall#getProcess <em>Process</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Process</em>' reference.
   * @see #getProcess()
   * @generated
   */
  void setProcess(Function value);

  /**
   * Returns the value of the '<em><b>Inputs</b></em>' containment reference list.
   * The list contents are of type {@link uofa.lbirdsey.castle.casl.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Inputs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Inputs</em>' containment reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getFunctionFeatureCall_Inputs()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getInputs();

} // FunctionFeatureCall
