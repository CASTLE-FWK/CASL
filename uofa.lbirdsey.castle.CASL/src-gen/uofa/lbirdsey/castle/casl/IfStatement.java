/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Statement</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.IfStatement#getCondition <em>Condition</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.IfStatement#getThen <em>Then</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.IfStatement#getElseifexpr <em>Elseifexpr</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.IfStatement#getElseexp <em>Elseexp</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getIfStatement()
 * @model
 * @generated
 */
public interface IfStatement extends Expression
{
  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(Expression)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getIfStatement_Condition()
   * @model containment="true"
   * @generated
   */
  Expression getCondition();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.IfStatement#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Expression value);

  /**
   * Returns the value of the '<em><b>Then</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then</em>' containment reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getIfStatement_Then()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getThen();

  /**
   * Returns the value of the '<em><b>Elseifexpr</b></em>' containment reference list.
   * The list contents are of type {@link uofa.lbirdsey.castle.casl.ElseIfExpr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elseifexpr</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elseifexpr</em>' containment reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getIfStatement_Elseifexpr()
   * @model containment="true"
   * @generated
   */
  EList<ElseIfExpr> getElseifexpr();

  /**
   * Returns the value of the '<em><b>Elseexp</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Elseexp</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Elseexp</em>' containment reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getIfStatement_Elseexp()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getElseexp();

} // IfStatement
