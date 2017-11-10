/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Null Type Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.NullTypeLiteral#getNulltype <em>Nulltype</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getNullTypeLiteral()
 * @model
 * @generated
 */
public interface NullTypeLiteral extends Expression
{
  /**
   * Returns the value of the '<em><b>Nulltype</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nulltype</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nulltype</em>' containment reference.
   * @see #setNulltype(NullType)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getNullTypeLiteral_Nulltype()
   * @model containment="true"
   * @generated
   */
  NullType getNulltype();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.NullTypeLiteral#getNulltype <em>Nulltype</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Nulltype</em>' containment reference.
   * @see #getNulltype()
   * @generated
   */
  void setNulltype(NullType value);

} // NullTypeLiteral
