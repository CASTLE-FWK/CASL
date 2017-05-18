/**
 * generated by Xtext 2.11.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Raw Java Block</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.Raw_Java_Block#getName <em>Name</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.Raw_Java_Block#getRawStatements <em>Raw Statements</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getRaw_Java_Block()
 * @model
 * @generated
 */
public interface Raw_Java_Block extends EObject
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
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getRaw_Java_Block_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.Raw_Java_Block#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Raw Statements</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Raw Statements</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Raw Statements</em>' attribute list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getRaw_Java_Block_RawStatements()
   * @model unique="false"
   * @generated
   */
  EList<String> getRawStatements();

} // Raw_Java_Block
