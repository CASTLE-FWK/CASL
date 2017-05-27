/**
 * generated by Xtext 2.12.0
 */
package uofa.lbirdsey.castle.casl;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Field</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.Field#getDeclaration <em>Declaration</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.Field#getAgentFieldRef <em>Agent Field Ref</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.Field#getEnvFieldRef <em>Env Field Ref</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.Field#getGrpFieldRef <em>Grp Field Ref</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getField()
 * @model
 * @generated
 */
public interface Field extends Entity_Feature
{
  /**
   * Returns the value of the '<em><b>Declaration</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Declaration</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Declaration</em>' containment reference.
   * @see #setDeclaration(Symbol)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getField_Declaration()
   * @model containment="true"
   * @generated
   */
  Symbol getDeclaration();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.Field#getDeclaration <em>Declaration</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Declaration</em>' containment reference.
   * @see #getDeclaration()
   * @generated
   */
  void setDeclaration(Symbol value);

  /**
   * Returns the value of the '<em><b>Agent Field Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Agent Field Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Agent Field Ref</em>' containment reference.
   * @see #setAgentFieldRef(Symbol)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getField_AgentFieldRef()
   * @model containment="true"
   * @generated
   */
  Symbol getAgentFieldRef();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.Field#getAgentFieldRef <em>Agent Field Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Agent Field Ref</em>' containment reference.
   * @see #getAgentFieldRef()
   * @generated
   */
  void setAgentFieldRef(Symbol value);

  /**
   * Returns the value of the '<em><b>Env Field Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Env Field Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Env Field Ref</em>' containment reference.
   * @see #setEnvFieldRef(Symbol)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getField_EnvFieldRef()
   * @model containment="true"
   * @generated
   */
  Symbol getEnvFieldRef();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.Field#getEnvFieldRef <em>Env Field Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Env Field Ref</em>' containment reference.
   * @see #getEnvFieldRef()
   * @generated
   */
  void setEnvFieldRef(Symbol value);

  /**
   * Returns the value of the '<em><b>Grp Field Ref</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Grp Field Ref</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Grp Field Ref</em>' containment reference.
   * @see #setGrpFieldRef(Symbol)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getField_GrpFieldRef()
   * @model containment="true"
   * @generated
   */
  Symbol getGrpFieldRef();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.Field#getGrpFieldRef <em>Grp Field Ref</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Grp Field Ref</em>' containment reference.
   * @see #getGrpFieldRef()
   * @generated
   */
  void setGrpFieldRef(Symbol value);

} // Field
