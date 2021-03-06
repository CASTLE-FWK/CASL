/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Self Assigned Formula</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.SelfAssignedFormula#getRef <em>Ref</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.SelfAssignedFormula#getObjField <em>Obj Field</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.SelfAssignedFormula#getExpr <em>Expr</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getSelfAssignedFormula()
 * @model
 * @generated
 */
public interface SelfAssignedFormula extends EObject
{
  /**
   * Returns the value of the '<em><b>Ref</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ref</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ref</em>' reference.
   * @see #setRef(Symbol)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSelfAssignedFormula_Ref()
   * @model
   * @generated
   */
  Symbol getRef();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.SelfAssignedFormula#getRef <em>Ref</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ref</em>' reference.
   * @see #getRef()
   * @generated
   */
  void setRef(Symbol value);

  /**
   * Returns the value of the '<em><b>Obj Field</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Obj Field</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Obj Field</em>' reference.
   * @see #setObjField(Symbol)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSelfAssignedFormula_ObjField()
   * @model
   * @generated
   */
  Symbol getObjField();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.SelfAssignedFormula#getObjField <em>Obj Field</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Obj Field</em>' reference.
   * @see #getObjField()
   * @generated
   */
  void setObjField(Symbol value);

  /**
   * Returns the value of the '<em><b>Expr</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr</em>' containment reference.
   * @see #setExpr(Expression)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSelfAssignedFormula_Expr()
   * @model containment="true"
   * @generated
   */
  Expression getExpr();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.SelfAssignedFormula#getExpr <em>Expr</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr</em>' containment reference.
   * @see #getExpr()
   * @generated
   */
  void setExpr(Expression value);

} // SelfAssignedFormula
