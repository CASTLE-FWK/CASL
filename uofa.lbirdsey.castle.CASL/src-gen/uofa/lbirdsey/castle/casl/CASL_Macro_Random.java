/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CASL Macro Random</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.CASL_Macro_Random#getType <em>Type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.CASL_Macro_Random#getLow <em>Low</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.CASL_Macro_Random#getHigh <em>High</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_Random()
 * @model
 * @generated
 */
public interface CASL_Macro_Random extends CASL_Macro
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * The literals are from the enumeration {@link uofa.lbirdsey.castle.casl.RandomType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see uofa.lbirdsey.castle.casl.RandomType
   * @see #setType(RandomType)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_Random_Type()
   * @model
   * @generated
   */
  RandomType getType();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.CASL_Macro_Random#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see uofa.lbirdsey.castle.casl.RandomType
   * @see #getType()
   * @generated
   */
  void setType(RandomType value);

  /**
   * Returns the value of the '<em><b>Low</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Low</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Low</em>' containment reference.
   * @see #setLow(Expression)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_Random_Low()
   * @model containment="true"
   * @generated
   */
  Expression getLow();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.CASL_Macro_Random#getLow <em>Low</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Low</em>' containment reference.
   * @see #getLow()
   * @generated
   */
  void setLow(Expression value);

  /**
   * Returns the value of the '<em><b>High</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>High</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>High</em>' containment reference.
   * @see #setHigh(Expression)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_Random_High()
   * @model containment="true"
   * @generated
   */
  Expression getHigh();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.CASL_Macro_Random#getHigh <em>High</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>High</em>' containment reference.
   * @see #getHigh()
   * @generated
   */
  void setHigh(Expression value);

} // CASL_Macro_Random
