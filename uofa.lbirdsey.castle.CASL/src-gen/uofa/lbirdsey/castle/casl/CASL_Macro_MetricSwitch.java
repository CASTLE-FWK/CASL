/**
 * generated by Xtext 2.12.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CASL Macro Metric Switch</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.CASL_Macro_MetricSwitch#isSw <em>Sw</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.CASL_Macro_MetricSwitch#getManualUpdates <em>Manual Updates</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_MetricSwitch()
 * @model
 * @generated
 */
public interface CASL_Macro_MetricSwitch extends CASL_Macro
{
  /**
   * Returns the value of the '<em><b>Sw</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Sw</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Sw</em>' attribute.
   * @see #setSw(boolean)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_MetricSwitch_Sw()
   * @model
   * @generated
   */
  boolean isSw();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.CASL_Macro_MetricSwitch#isSw <em>Sw</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Sw</em>' attribute.
   * @see #isSw()
   * @generated
   */
  void setSw(boolean value);

  /**
   * Returns the value of the '<em><b>Manual Updates</b></em>' containment reference list.
   * The list contents are of type {@link uofa.lbirdsey.castle.casl.Expression}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Manual Updates</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Manual Updates</em>' containment reference list.
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getCASL_Macro_MetricSwitch_ManualUpdates()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getManualUpdates();

} // CASL_Macro_MetricSwitch
