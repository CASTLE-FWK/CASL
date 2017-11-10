/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Enum Call</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.EnumCall#getEn <em>En</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.EnumCall#getEntype <em>Entype</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getEnumCall()
 * @model
 * @generated
 */
public interface EnumCall extends EObject
{
  /**
   * Returns the value of the '<em><b>En</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>En</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>En</em>' reference.
   * @see #setEn(uofa.lbirdsey.castle.casl.Enum)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getEnumCall_En()
   * @model
   * @generated
   */
  uofa.lbirdsey.castle.casl.Enum getEn();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.EnumCall#getEn <em>En</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>En</em>' reference.
   * @see #getEn()
   * @generated
   */
  void setEn(uofa.lbirdsey.castle.casl.Enum value);

  /**
   * Returns the value of the '<em><b>Entype</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Entype</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Entype</em>' reference.
   * @see #setEntype(Symbol)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getEnumCall_Entype()
   * @model
   * @generated
   */
  Symbol getEntype();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.EnumCall#getEntype <em>Entype</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Entype</em>' reference.
   * @see #getEntype()
   * @generated
   */
  void setEntype(Symbol value);

} // EnumCall
