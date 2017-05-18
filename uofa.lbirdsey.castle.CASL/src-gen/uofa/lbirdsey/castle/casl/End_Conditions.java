/**
 * generated by Xtext 2.11.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>End Conditions</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.End_Conditions#getEnd_conditions <em>End conditions</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getEnd_Conditions()
 * @model
 * @generated
 */
public interface End_Conditions extends EObject
{
  /**
   * Returns the value of the '<em><b>End conditions</b></em>' containment reference list.
   * The list contents are of type {@link uofa.lbirdsey.castle.casl.End_Condition}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End conditions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End conditions</em>' containment reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getEnd_Conditions_End_conditions()
   * @model containment="true"
   * @generated
   */
  EList<End_Condition> getEnd_conditions();

} // End_Conditions
