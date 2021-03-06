/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sub System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.SubSystem#getName <em>Name</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.SubSystem#getSubsystem_type <em>Subsystem type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.SubSystem#getFunctionParameters <em>Function Parameters</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.SubSystem#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getSubSystem()
 * @model
 * @generated
 */
public interface SubSystem extends Entity_Feature
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
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSubSystem_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.SubSystem#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Subsystem type</b></em>' attribute.
   * The literals are from the enumeration {@link uofa.lbirdsey.castle.casl.SubSystemType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Subsystem type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Subsystem type</em>' attribute.
   * @see uofa.lbirdsey.castle.casl.SubSystemType
   * @see #setSubsystem_type(SubSystemType)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSubSystem_Subsystem_type()
   * @model
   * @generated
   */
  SubSystemType getSubsystem_type();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.SubSystem#getSubsystem_type <em>Subsystem type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Subsystem type</em>' attribute.
   * @see uofa.lbirdsey.castle.casl.SubSystemType
   * @see #getSubsystem_type()
   * @generated
   */
  void setSubsystem_type(SubSystemType value);

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
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSubSystem_FunctionParameters()
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
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getSubSystem_Body()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getBody();

} // SubSystem
