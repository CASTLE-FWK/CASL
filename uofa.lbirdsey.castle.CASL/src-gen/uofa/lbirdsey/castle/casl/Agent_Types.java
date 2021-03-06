/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Agent Types</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.Agent_Types#getAgent_types <em>Agent types</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getAgent_Types()
 * @model
 * @generated
 */
public interface Agent_Types extends EObject
{
  /**
   * Returns the value of the '<em><b>Agent types</b></em>' containment reference list.
   * The list contents are of type {@link uofa.lbirdsey.castle.casl.Agent_Type_Name}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Agent types</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Agent types</em>' containment reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getAgent_Types_Agent_types()
   * @model containment="true"
   * @generated
   */
  EList<Agent_Type_Name> getAgent_types();

} // Agent_Types
