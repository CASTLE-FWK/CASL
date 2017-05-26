/**
 * generated by Xtext 2.11.0
 */
package uofa.lbirdsey.castle.casl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.Group_Call#getGroupCall <em>Group Call</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.Group_Call#getGrp <em>Grp</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.Group_Call#getQnc <em>Qnc</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroup_Call()
 * @model
 * @generated
 */
public interface Group_Call extends Expression
{
  /**
   * Returns the value of the '<em><b>Group Call</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group Call</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group Call</em>' containment reference.
   * @see #setGroupCall(Group_Call)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroup_Call_GroupCall()
   * @model containment="true"
   * @generated
   */
  Group_Call getGroupCall();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.Group_Call#getGroupCall <em>Group Call</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Group Call</em>' containment reference.
   * @see #getGroupCall()
   * @generated
   */
  void setGroupCall(Group_Call value);

  /**
   * Returns the value of the '<em><b>Grp</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Grp</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Grp</em>' reference.
   * @see #setGrp(Group)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroup_Call_Grp()
   * @model
   * @generated
   */
  Group getGrp();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.Group_Call#getGrp <em>Grp</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Grp</em>' reference.
   * @see #getGrp()
   * @generated
   */
  void setGrp(Group value);

  /**
   * Returns the value of the '<em><b>Qnc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Qnc</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Qnc</em>' attribute.
   * @see #setQnc(String)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroup_Call_Qnc()
   * @model
   * @generated
   */
  String getQnc();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.Group_Call#getQnc <em>Qnc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Qnc</em>' attribute.
   * @see #getQnc()
   * @generated
   */
  void setQnc(String value);

} // Group_Call