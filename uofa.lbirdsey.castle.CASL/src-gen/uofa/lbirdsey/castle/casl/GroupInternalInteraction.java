/**
 * generated by Xtext 2.11.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Group Internal Interaction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.GroupInternalInteraction#getName <em>Name</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.GroupInternalInteraction#getInteraction_type <em>Interaction type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.GroupInternalInteraction#getTrigger_type <em>Trigger type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.GroupInternalInteraction#getTriggerParam <em>Trigger Param</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.GroupInternalInteraction#getFunctionParameters <em>Function Parameters</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.GroupInternalInteraction#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroupInternalInteraction()
 * @model
 * @generated
 */
public interface GroupInternalInteraction extends Entity_Feature
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
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroupInternalInteraction_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.GroupInternalInteraction#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Interaction type</b></em>' attribute.
   * The literals are from the enumeration {@link uofa.lbirdsey.castle.casl.InteractionType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Interaction type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Interaction type</em>' attribute.
   * @see uofa.lbirdsey.castle.casl.InteractionType
   * @see #setInteraction_type(InteractionType)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroupInternalInteraction_Interaction_type()
   * @model
   * @generated
   */
  InteractionType getInteraction_type();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.GroupInternalInteraction#getInteraction_type <em>Interaction type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Interaction type</em>' attribute.
   * @see uofa.lbirdsey.castle.casl.InteractionType
   * @see #getInteraction_type()
   * @generated
   */
  void setInteraction_type(InteractionType value);

  /**
   * Returns the value of the '<em><b>Trigger type</b></em>' attribute.
   * The literals are from the enumeration {@link uofa.lbirdsey.castle.casl.InteractionTriggerTypes}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trigger type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trigger type</em>' attribute.
   * @see uofa.lbirdsey.castle.casl.InteractionTriggerTypes
   * @see #setTrigger_type(InteractionTriggerTypes)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroupInternalInteraction_Trigger_type()
   * @model
   * @generated
   */
  InteractionTriggerTypes getTrigger_type();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.GroupInternalInteraction#getTrigger_type <em>Trigger type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trigger type</em>' attribute.
   * @see uofa.lbirdsey.castle.casl.InteractionTriggerTypes
   * @see #getTrigger_type()
   * @generated
   */
  void setTrigger_type(InteractionTriggerTypes value);

  /**
   * Returns the value of the '<em><b>Trigger Param</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Trigger Param</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Trigger Param</em>' containment reference.
   * @see #setTriggerParam(InteractionTriggerParameter)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroupInternalInteraction_TriggerParam()
   * @model containment="true"
   * @generated
   */
  InteractionTriggerParameter getTriggerParam();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.GroupInternalInteraction#getTriggerParam <em>Trigger Param</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Trigger Param</em>' containment reference.
   * @see #getTriggerParam()
   * @generated
   */
  void setTriggerParam(InteractionTriggerParameter value);

  /**
   * Returns the value of the '<em><b>Function Parameters</b></em>' containment reference list.
   * The list contents are of type {@link uofa.lbirdsey.castle.casl.Symbol}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Function Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Function Parameters</em>' containment reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroupInternalInteraction_FunctionParameters()
   * @model containment="true"
   * @generated
   */
  EList<Symbol> getFunctionParameters();

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
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getGroupInternalInteraction_Body()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getBody();

} // GroupInternalInteraction