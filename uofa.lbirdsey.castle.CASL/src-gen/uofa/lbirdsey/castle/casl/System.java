/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.System#getName <em>Name</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.System#getDesc <em>Desc</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.System#getCas_rules <em>Cas rules</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.System#getSystem_parameters <em>System parameters</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.System#getSystem_functions <em>System functions</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.System#getAgent_types <em>Agent types</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.System#getGroup_types <em>Group types</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.System#getEnvironment_types <em>Environment types</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.System#getEnd_conditions <em>End conditions</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSystem_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.System#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Desc</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Desc</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Desc</em>' attribute.
   * @see #setDesc(String)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSystem_Desc()
   * @model
   * @generated
   */
  String getDesc();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.System#getDesc <em>Desc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Desc</em>' attribute.
   * @see #getDesc()
   * @generated
   */
  void setDesc(String value);

  /**
   * Returns the value of the '<em><b>Cas rules</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Cas rules</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Cas rules</em>' containment reference.
   * @see #setCas_rules(CAS_Rules)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSystem_Cas_rules()
   * @model containment="true"
   * @generated
   */
  CAS_Rules getCas_rules();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.System#getCas_rules <em>Cas rules</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Cas rules</em>' containment reference.
   * @see #getCas_rules()
   * @generated
   */
  void setCas_rules(CAS_Rules value);

  /**
   * Returns the value of the '<em><b>System parameters</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>System parameters</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>System parameters</em>' containment reference.
   * @see #setSystem_parameters(Parameters)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSystem_System_parameters()
   * @model containment="true"
   * @generated
   */
  Parameters getSystem_parameters();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.System#getSystem_parameters <em>System parameters</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>System parameters</em>' containment reference.
   * @see #getSystem_parameters()
   * @generated
   */
  void setSystem_parameters(Parameters value);

  /**
   * Returns the value of the '<em><b>System functions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>System functions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>System functions</em>' containment reference.
   * @see #setSystem_functions(Functions)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSystem_System_functions()
   * @model containment="true"
   * @generated
   */
  Functions getSystem_functions();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.System#getSystem_functions <em>System functions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>System functions</em>' containment reference.
   * @see #getSystem_functions()
   * @generated
   */
  void setSystem_functions(Functions value);

  /**
   * Returns the value of the '<em><b>Agent types</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Agent types</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Agent types</em>' containment reference.
   * @see #setAgent_types(Agent_Types)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSystem_Agent_types()
   * @model containment="true"
   * @generated
   */
  Agent_Types getAgent_types();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.System#getAgent_types <em>Agent types</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Agent types</em>' containment reference.
   * @see #getAgent_types()
   * @generated
   */
  void setAgent_types(Agent_Types value);

  /**
   * Returns the value of the '<em><b>Group types</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Group types</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Group types</em>' containment reference.
   * @see #setGroup_types(Group_Types)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSystem_Group_types()
   * @model containment="true"
   * @generated
   */
  Group_Types getGroup_types();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.System#getGroup_types <em>Group types</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Group types</em>' containment reference.
   * @see #getGroup_types()
   * @generated
   */
  void setGroup_types(Group_Types value);

  /**
   * Returns the value of the '<em><b>Environment types</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Environment types</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Environment types</em>' containment reference.
   * @see #setEnvironment_types(Environment_Types)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSystem_Environment_types()
   * @model containment="true"
   * @generated
   */
  Environment_Types getEnvironment_types();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.System#getEnvironment_types <em>Environment types</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Environment types</em>' containment reference.
   * @see #getEnvironment_types()
   * @generated
   */
  void setEnvironment_types(Environment_Types value);

  /**
   * Returns the value of the '<em><b>End conditions</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>End conditions</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>End conditions</em>' containment reference.
   * @see #setEnd_conditions(End_Conditions)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSystem_End_conditions()
   * @model containment="true"
   * @generated
   */
  End_Conditions getEnd_conditions();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.System#getEnd_conditions <em>End conditions</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>End conditions</em>' containment reference.
   * @see #getEnd_conditions()
   * @generated
   */
  void setEnd_conditions(End_Conditions value);

} // System
