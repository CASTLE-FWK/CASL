/**
 * generated by Xtext 2.11.0
 */
package uofa.lbirdsey.castle.casl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.Group#getGroup_rules <em>Group rules</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.Group#getGroup_parameters <em>Group parameters</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.Group#getGroup_functions <em>Group functions</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.Group#getGroup_behaviors <em>Group behaviors</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.Group#getGroup_external_interactions <em>Group external interactions</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.Group#getGroup_internal_interactions <em>Group internal interactions</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroup()
 * @model
 * @generated
 */
public interface Group extends Entity
{
  /**
   * Returns the value of the '<em><b>Group rules</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group rules</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group rules</em>' containment reference.
   * @see #setGroup_rules(Group_Rules)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroup_Group_rules()
   * @model containment="true"
   * @generated
   */
  Group_Rules getGroup_rules();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.Group#getGroup_rules <em>Group rules</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Group rules</em>' containment reference.
   * @see #getGroup_rules()
   * @generated
   */
  void setGroup_rules(Group_Rules value);

  /**
   * Returns the value of the '<em><b>Group parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group parameters</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group parameters</em>' containment reference.
   * @see #setGroup_parameters(Parameters)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroup_Group_parameters()
   * @model containment="true"
   * @generated
   */
  Parameters getGroup_parameters();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.Group#getGroup_parameters <em>Group parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Group parameters</em>' containment reference.
   * @see #getGroup_parameters()
   * @generated
   */
  void setGroup_parameters(Parameters value);

  /**
   * Returns the value of the '<em><b>Group functions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group functions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group functions</em>' containment reference.
   * @see #setGroup_functions(Functions)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroup_Group_functions()
   * @model containment="true"
   * @generated
   */
  Functions getGroup_functions();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.Group#getGroup_functions <em>Group functions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Group functions</em>' containment reference.
   * @see #getGroup_functions()
   * @generated
   */
  void setGroup_functions(Functions value);

  /**
   * Returns the value of the '<em><b>Group behaviors</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group behaviors</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group behaviors</em>' containment reference.
   * @see #setGroup_behaviors(Behaviors)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroup_Group_behaviors()
   * @model containment="true"
   * @generated
   */
  Behaviors getGroup_behaviors();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.Group#getGroup_behaviors <em>Group behaviors</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Group behaviors</em>' containment reference.
   * @see #getGroup_behaviors()
   * @generated
   */
  void setGroup_behaviors(Behaviors value);

  /**
   * Returns the value of the '<em><b>Group external interactions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group external interactions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group external interactions</em>' containment reference.
   * @see #setGroup_external_interactions(GroupExternalInteractions)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroup_Group_external_interactions()
   * @model containment="true"
   * @generated
   */
  GroupExternalInteractions getGroup_external_interactions();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.Group#getGroup_external_interactions <em>Group external interactions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Group external interactions</em>' containment reference.
   * @see #getGroup_external_interactions()
   * @generated
   */
  void setGroup_external_interactions(GroupExternalInteractions value);

  /**
   * Returns the value of the '<em><b>Group internal interactions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group internal interactions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group internal interactions</em>' containment reference.
   * @see #setGroup_internal_interactions(GroupInternalInteractions)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroup_Group_internal_interactions()
   * @model containment="true"
   * @generated
   */
  GroupInternalInteractions getGroup_internal_interactions();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.Group#getGroup_internal_interactions <em>Group internal interactions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Group internal interactions</em>' containment reference.
   * @see #getGroup_internal_interactions()
   * @generated
   */
  void setGroup_internal_interactions(GroupInternalInteractions value);

} // Group
