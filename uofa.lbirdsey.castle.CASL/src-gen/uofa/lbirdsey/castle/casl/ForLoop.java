/**
 * generated by Xtext 2.12.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>For Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.ForLoop#getInit <em>Init</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.ForLoop#getCondition <em>Condition</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.ForLoop#getShifter <em>Shifter</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.ForLoop#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getForLoop()
 * @model
 * @generated
 */
public interface ForLoop extends Expression
{
  /**
   * Returns the value of the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Init</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Init</em>' containment reference.
   * @see #setInit(EObject)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getForLoop_Init()
   * @model containment="true"
   * @generated
   */
  EObject getInit();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.ForLoop#getInit <em>Init</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Init</em>' containment reference.
   * @see #getInit()
   * @generated
   */
  void setInit(EObject value);

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
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getForLoop_Condition()
   * @model containment="true"
   * @generated
   */
  Expression getCondition();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.ForLoop#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(Expression value);

  /**
   * Returns the value of the '<em><b>Shifter</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Shifter</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Shifter</em>' containment reference.
   * @see #setShifter(EObject)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getForLoop_Shifter()
   * @model containment="true"
   * @generated
   */
  EObject getShifter();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.ForLoop#getShifter <em>Shifter</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Shifter</em>' containment reference.
   * @see #getShifter()
   * @generated
   */
  void setShifter(EObject value);

  /**
   * Returns the value of the '<em><b>Body</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Body</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Body</em>' containment reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getForLoop_Body()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getBody();

} // ForLoop
