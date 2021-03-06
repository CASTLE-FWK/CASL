/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Else If Expr</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.ElseIfExpr#getElseifCond <em>Elseif Cond</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.ElseIfExpr#getElseifthen <em>Elseifthen</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getElseIfExpr()
 * @model
 * @generated
 */
public interface ElseIfExpr extends EObject
{
  /**
   * Returns the value of the '<em><b>Elseif Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elseif Cond</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elseif Cond</em>' containment reference.
   * @see #setElseifCond(Expression)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getElseIfExpr_ElseifCond()
   * @model containment="true"
   * @generated
   */
  Expression getElseifCond();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.ElseIfExpr#getElseifCond <em>Elseif Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Elseif Cond</em>' containment reference.
   * @see #getElseifCond()
   * @generated
   */
  void setElseifCond(Expression value);

  /**
   * Returns the value of the '<em><b>Elseifthen</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elseifthen</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elseifthen</em>' containment reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getElseIfExpr_Elseifthen()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getElseifthen();

} // ElseIfExpr
