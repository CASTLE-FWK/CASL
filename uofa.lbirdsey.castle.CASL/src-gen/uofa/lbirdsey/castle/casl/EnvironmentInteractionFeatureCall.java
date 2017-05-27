/**
 * generated by Xtext 2.12.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Environment Interaction Feature Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.EnvironmentInteractionFeatureCall#getEnv <em>Env</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.EnvironmentInteractionFeatureCall#getProcess <em>Process</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.EnvironmentInteractionFeatureCall#getInputs <em>Inputs</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getEnvironmentInteractionFeatureCall()
 * @model
 * @generated
 */
public interface EnvironmentInteractionFeatureCall extends EObject
{
  /**
   * Returns the value of the '<em><b>Env</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Env</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Env</em>' reference.
   * @see #setEnv(Symbol)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getEnvironmentInteractionFeatureCall_Env()
   * @model
   * @generated
   */
  Symbol getEnv();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.EnvironmentInteractionFeatureCall#getEnv <em>Env</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Env</em>' reference.
   * @see #getEnv()
   * @generated
   */
  void setEnv(Symbol value);

  /**
   * Returns the value of the '<em><b>Process</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Process</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Process</em>' reference.
   * @see #setProcess(EnvironmentInteraction)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getEnvironmentInteractionFeatureCall_Process()
   * @model
   * @generated
   */
  EnvironmentInteraction getProcess();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.EnvironmentInteractionFeatureCall#getProcess <em>Process</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Process</em>' reference.
   * @see #getProcess()
   * @generated
   */
  void setProcess(EnvironmentInteraction value);

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
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getEnvironmentInteractionFeatureCall_Inputs()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getInputs();

} // EnvironmentInteractionFeatureCall
