/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Concern</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.Concern#getName <em>Name</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.Concern#getDesc <em>Desc</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.Concern#getStateFields <em>State Fields</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getConcern()
 * @model
 * @generated
 */
public interface Concern extends EObject
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
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getConcern_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.Concern#getName <em>Name</em>}' attribute.
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
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getConcern_Desc()
   * @model
   * @generated
   */
  String getDesc();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.Concern#getDesc <em>Desc</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Desc</em>' attribute.
   * @see #getDesc()
   * @generated
   */
  void setDesc(String value);

  /**
   * Returns the value of the '<em><b>State Fields</b></em>' containment reference list.
   * The list contents are of type {@link uofa.lbirdsey.castle.casl.State_Block_Refs}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>State Fields</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>State Fields</em>' containment reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getConcern_StateFields()
   * @model containment="true"
   * @generated
   */
  EList<State_Block_Refs> getStateFields();

} // Concern
