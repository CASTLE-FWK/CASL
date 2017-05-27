/**
 * generated by Xtext 2.12.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Rules</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.Group_Rules#getLayout_type <em>Layout type</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroup_Rules()
 * @model
 * @generated
 */
public interface Group_Rules extends EObject
{
  /**
   * Returns the value of the '<em><b>Layout type</b></em>' attribute.
   * The literals are from the enumeration {@link uofa.lbirdsey.castle.casl.LayoutType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Layout type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Layout type</em>' attribute.
   * @see uofa.lbirdsey.castle.casl.LayoutType
   * @see #setLayout_type(LayoutType)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroup_Rules_Layout_type()
   * @model
   * @generated
   */
  LayoutType getLayout_type();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.Group_Rules#getLayout_type <em>Layout type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Layout type</em>' attribute.
   * @see uofa.lbirdsey.castle.casl.LayoutType
   * @see #getLayout_type()
   * @generated
   */
  void setLayout_type(LayoutType value);

} // Group_Rules
