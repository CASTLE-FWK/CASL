/**
 * generated by Xtext 2.12.0
 */
package uofa.lbirdsey.castle.casl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CASL Macro Init Logger</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.CASL_Macro_InitLogger#isMute <em>Mute</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.CASL_Macro_InitLogger#isToConsole <em>To Console</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.CASL_Macro_InitLogger#isToFile <em>To File</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.CASL_Macro_InitLogger#getFilePath <em>File Path</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_InitLogger()
 * @model
 * @generated
 */
public interface CASL_Macro_InitLogger extends CASL_Macro
{
  /**
   * Returns the value of the '<em><b>Mute</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Mute</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Mute</em>' attribute.
   * @see #setMute(boolean)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_InitLogger_Mute()
   * @model
   * @generated
   */
  boolean isMute();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.CASL_Macro_InitLogger#isMute <em>Mute</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Mute</em>' attribute.
   * @see #isMute()
   * @generated
   */
  void setMute(boolean value);

  /**
   * Returns the value of the '<em><b>To Console</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To Console</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To Console</em>' attribute.
   * @see #setToConsole(boolean)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_InitLogger_ToConsole()
   * @model
   * @generated
   */
  boolean isToConsole();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.CASL_Macro_InitLogger#isToConsole <em>To Console</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To Console</em>' attribute.
   * @see #isToConsole()
   * @generated
   */
  void setToConsole(boolean value);

  /**
   * Returns the value of the '<em><b>To File</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>To File</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>To File</em>' attribute.
   * @see #setToFile(boolean)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_InitLogger_ToFile()
   * @model
   * @generated
   */
  boolean isToFile();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.CASL_Macro_InitLogger#isToFile <em>To File</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>To File</em>' attribute.
   * @see #isToFile()
   * @generated
   */
  void setToFile(boolean value);

  /**
   * Returns the value of the '<em><b>File Path</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>File Path</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>File Path</em>' containment reference.
   * @see #setFilePath(Expression)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_InitLogger_FilePath()
   * @model containment="true"
   * @generated
   */
  Expression getFilePath();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.CASL_Macro_InitLogger#getFilePath <em>File Path</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>File Path</em>' containment reference.
   * @see #getFilePath()
   * @generated
   */
  void setFilePath(Expression value);

} // CASL_Macro_InitLogger
