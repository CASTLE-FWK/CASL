/**
 * generated by Xtext 2.12.0
 */
package uofa.lbirdsey.castle.casl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Self Call Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.SelfCallExpr#getSelfCall <em>Self Call</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getSelfCallExpr()
 * @model
 * @generated
 */
public interface SelfCallExpr extends Expression
{
  /**
   * Returns the value of the '<em><b>Self Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Self Call</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Self Call</em>' containment reference.
   * @see #setSelfCall(SelfCall)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSelfCallExpr_SelfCall()
   * @model containment="true"
   * @generated
   */
  SelfCall getSelfCall();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.SelfCallExpr#getSelfCall <em>Self Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Self Call</em>' containment reference.
   * @see #getSelfCall()
   * @generated
   */
  void setSelfCall(SelfCall value);

} // SelfCallExpr
