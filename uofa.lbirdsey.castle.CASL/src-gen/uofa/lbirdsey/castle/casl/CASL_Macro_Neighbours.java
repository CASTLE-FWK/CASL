/**
 * generated by Xtext 2.12.0
 */
package uofa.lbirdsey.castle.casl;

import java.math.BigDecimal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CASL Macro Neighbours</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.CASL_Macro_Neighbours#getWorldType <em>World Type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.CASL_Macro_Neighbours#getSearchType <em>Search Type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.CASL_Macro_Neighbours#getDist <em>Dist</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_Neighbours()
 * @model
 * @generated
 */
public interface CASL_Macro_Neighbours extends CASL_Macro
{
  /**
   * Returns the value of the '<em><b>World Type</b></em>' attribute.
   * The literals are from the enumeration {@link uofa.lbirdsey.castle.casl.LayoutType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>World Type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>World Type</em>' attribute.
   * @see uofa.lbirdsey.castle.casl.LayoutType
   * @see #setWorldType(LayoutType)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_Neighbours_WorldType()
   * @model
   * @generated
   */
  LayoutType getWorldType();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.CASL_Macro_Neighbours#getWorldType <em>World Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>World Type</em>' attribute.
   * @see uofa.lbirdsey.castle.casl.LayoutType
   * @see #getWorldType()
   * @generated
   */
  void setWorldType(LayoutType value);

  /**
   * Returns the value of the '<em><b>Search Type</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Search Type</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Search Type</em>' reference.
   * @see #setSearchType(Entity)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_Neighbours_SearchType()
   * @model
   * @generated
   */
  Entity getSearchType();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.CASL_Macro_Neighbours#getSearchType <em>Search Type</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Search Type</em>' reference.
   * @see #getSearchType()
   * @generated
   */
  void setSearchType(Entity value);

  /**
   * Returns the value of the '<em><b>Dist</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dist</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dist</em>' attribute.
   * @see #setDist(BigDecimal)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_Neighbours_Dist()
   * @model
   * @generated
   */
  BigDecimal getDist();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.CASL_Macro_Neighbours#getDist <em>Dist</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dist</em>' attribute.
   * @see #getDist()
   * @generated
   */
  void setDist(BigDecimal value);

} // CASL_Macro_Neighbours
