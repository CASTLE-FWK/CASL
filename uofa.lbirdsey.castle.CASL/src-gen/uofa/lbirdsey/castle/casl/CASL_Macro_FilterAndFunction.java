/**
 * generated by Xtext 2.11.0
 */
package uofa.lbirdsey.castle.casl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CASL Macro Filter And Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.CASL_Macro_FilterAndFunction#getSym <em>Sym</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.CASL_Macro_FilterAndFunction#getCond <em>Cond</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.CASL_Macro_FilterAndFunction#getMisc <em>Misc</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_FilterAndFunction()
 * @model
 * @generated
 */
public interface CASL_Macro_FilterAndFunction extends CASL_Macro
{
  /**
   * Returns the value of the '<em><b>Sym</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sym</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sym</em>' reference.
   * @see #setSym(Symbol)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_FilterAndFunction_Sym()
   * @model
   * @generated
   */
  Symbol getSym();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.CASL_Macro_FilterAndFunction#getSym <em>Sym</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sym</em>' reference.
   * @see #getSym()
   * @generated
   */
  void setSym(Symbol value);

  /**
   * Returns the value of the '<em><b>Cond</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cond</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cond</em>' containment reference.
   * @see #setCond(Expression)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_FilterAndFunction_Cond()
   * @model containment="true"
   * @generated
   */
  Expression getCond();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.CASL_Macro_FilterAndFunction#getCond <em>Cond</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cond</em>' containment reference.
   * @see #getCond()
   * @generated
   */
  void setCond(Expression value);

  /**
   * Returns the value of the '<em><b>Misc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Misc</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Misc</em>' attribute.
   * @see #setMisc(String)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_FilterAndFunction_Misc()
   * @model
   * @generated
   */
  String getMisc();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.CASL_Macro_FilterAndFunction#getMisc <em>Misc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Misc</em>' attribute.
   * @see #getMisc()
   * @generated
   */
  void setMisc(String value);

} // CASL_Macro_FilterAndFunction