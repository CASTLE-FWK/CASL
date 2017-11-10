/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub Systems</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.SubSystems#getSubSystems <em>Sub Systems</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.SubSystems#getSubAgents <em>Sub Agents</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.SubSystems#getSubEnvs <em>Sub Envs</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getSubSystems()
 * @model
 * @generated
 */
public interface SubSystems extends EObject
{
  /**
   * Returns the value of the '<em><b>Sub Systems</b></em>' containment reference list.
   * The list contents are of type {@link uofa.lbirdsey.castle.casl.SubSystem}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Systems</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Systems</em>' containment reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSubSystems_SubSystems()
   * @model containment="true"
   * @generated
   */
  EList<SubSystem> getSubSystems();

  /**
   * Returns the value of the '<em><b>Sub Agents</b></em>' containment reference list.
   * The list contents are of type {@link uofa.lbirdsey.castle.casl.Agent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Agents</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Agents</em>' containment reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSubSystems_SubAgents()
   * @model containment="true"
   * @generated
   */
  EList<Agent> getSubAgents();

  /**
   * Returns the value of the '<em><b>Sub Envs</b></em>' containment reference list.
   * The list contents are of type {@link uofa.lbirdsey.castle.casl.Environment}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sub Envs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sub Envs</em>' containment reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSubSystems_SubEnvs()
   * @model containment="true"
   * @generated
   */
  EList<Environment> getSubEnvs();

} // SubSystems
