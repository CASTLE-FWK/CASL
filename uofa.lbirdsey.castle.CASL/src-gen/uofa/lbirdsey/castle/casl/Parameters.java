/**
 * generated by Xtext 2.12.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Parameters</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.Parameters#getFields <em>Fields</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getParameters()
 * @model
 * @generated
 */
public interface Parameters extends EObject
{
  /**
   * Returns the value of the '<em><b>Fields</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fields</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fields</em>' containment reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getParameters_Fields()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getFields();

} // Parameters
