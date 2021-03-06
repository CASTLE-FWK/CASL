/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function Parameter</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.FunctionParameter#getType <em>Type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.FunctionParameter#getAgent <em>Agent</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.FunctionParameter#getEnv <em>Env</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.FunctionParameter#getGrp <em>Grp</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.FunctionParameter#getObj <em>Obj</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.FunctionParameter#getUseGroup <em>Use Group</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.FunctionParameter#getUseAgent <em>Use Agent</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.FunctionParameter#getUseEnv <em>Use Env</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.FunctionParameter#getUseObj <em>Use Obj</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.FunctionParameter#getUseType <em>Use Type</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getFunctionParameter()
 * @model
 * @generated
 */
public interface FunctionParameter extends Symbol
{
  /**
   * Returns the value of the '<em><b>Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' containment reference.
   * @see #setType(PrimitiveType)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getFunctionParameter_Type()
   * @model containment="true"
   * @generated
   */
  PrimitiveType getType();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.FunctionParameter#getType <em>Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' containment reference.
   * @see #getType()
   * @generated
   */
  void setType(PrimitiveType value);

  /**
   * Returns the value of the '<em><b>Agent</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Agent</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Agent</em>' reference.
   * @see #setAgent(Agent)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getFunctionParameter_Agent()
   * @model
   * @generated
   */
  Agent getAgent();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.FunctionParameter#getAgent <em>Agent</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Agent</em>' reference.
   * @see #getAgent()
   * @generated
   */
  void setAgent(Agent value);

  /**
   * Returns the value of the '<em><b>Env</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Env</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Env</em>' reference.
   * @see #setEnv(Environment)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getFunctionParameter_Env()
   * @model
   * @generated
   */
  Environment getEnv();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.FunctionParameter#getEnv <em>Env</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Env</em>' reference.
   * @see #getEnv()
   * @generated
   */
  void setEnv(Environment value);

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
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getFunctionParameter_Grp()
   * @model
   * @generated
   */
  Group getGrp();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.FunctionParameter#getGrp <em>Grp</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Grp</em>' reference.
   * @see #getGrp()
   * @generated
   */
  void setGrp(Group value);

  /**
   * Returns the value of the '<em><b>Obj</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Obj</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Obj</em>' reference.
   * @see #setObj(NonPrimitiveType)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getFunctionParameter_Obj()
   * @model
   * @generated
   */
  NonPrimitiveType getObj();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.FunctionParameter#getObj <em>Obj</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Obj</em>' reference.
   * @see #getObj()
   * @generated
   */
  void setObj(NonPrimitiveType value);

  /**
   * Returns the value of the '<em><b>Use Group</b></em>' reference list.
   * The list contents are of type {@link uofa.lbirdsey.castle.casl.Group}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Group</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Group</em>' reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getFunctionParameter_UseGroup()
   * @model
   * @generated
   */
  EList<Group> getUseGroup();

  /**
   * Returns the value of the '<em><b>Use Agent</b></em>' reference list.
   * The list contents are of type {@link uofa.lbirdsey.castle.casl.Agent}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Agent</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Agent</em>' reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getFunctionParameter_UseAgent()
   * @model
   * @generated
   */
  EList<Agent> getUseAgent();

  /**
   * Returns the value of the '<em><b>Use Env</b></em>' reference list.
   * The list contents are of type {@link uofa.lbirdsey.castle.casl.Environment}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Env</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Env</em>' reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getFunctionParameter_UseEnv()
   * @model
   * @generated
   */
  EList<Environment> getUseEnv();

  /**
   * Returns the value of the '<em><b>Use Obj</b></em>' reference list.
   * The list contents are of type {@link uofa.lbirdsey.castle.casl.NonPrimitiveType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Obj</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Obj</em>' reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getFunctionParameter_UseObj()
   * @model
   * @generated
   */
  EList<NonPrimitiveType> getUseObj();

  /**
   * Returns the value of the '<em><b>Use Type</b></em>' containment reference list.
   * The list contents are of type {@link uofa.lbirdsey.castle.casl.PrimitiveType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Use Type</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Use Type</em>' containment reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getFunctionParameter_UseType()
   * @model containment="true"
   * @generated
   */
  EList<PrimitiveType> getUseType();

} // FunctionParameter
