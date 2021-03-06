/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Adaptive Process</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link uofa.lbirdsey.castle.casl.AdaptiveProcess#getName <em>Name</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.AdaptiveProcess#getAdaptation_type <em>Adaptation type</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.AdaptiveProcess#getAdaptationDelay <em>Adaptation Delay</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.AdaptiveProcess#getFunctionParameters <em>Function Parameters</em>}</li>
 *   <li>{@link uofa.lbirdsey.castle.casl.AdaptiveProcess#getBody <em>Body</em>}</li>
 * </ul>
 *
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getAdaptiveProcess()
 * @model
 * @generated
 */
public interface AdaptiveProcess extends Entity_Feature
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
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getAdaptiveProcess_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.AdaptiveProcess#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Adaptation type</b></em>' attribute.
   * The literals are from the enumeration {@link uofa.lbirdsey.castle.casl.AdaptationType}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Adaptation type</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Adaptation type</em>' attribute.
   * @see uofa.lbirdsey.castle.casl.AdaptationType
   * @see #setAdaptation_type(AdaptationType)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getAdaptiveProcess_Adaptation_type()
   * @model
   * @generated
   */
  AdaptationType getAdaptation_type();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.AdaptiveProcess#getAdaptation_type <em>Adaptation type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Adaptation type</em>' attribute.
   * @see uofa.lbirdsey.castle.casl.AdaptationType
   * @see #getAdaptation_type()
   * @generated
   */
  void setAdaptation_type(AdaptationType value);

  /**
   * Returns the value of the '<em><b>Adaptation Delay</b></em>' attribute.
   * The literals are from the enumeration {@link uofa.lbirdsey.castle.casl.AdaptationDelay}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Adaptation Delay</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Adaptation Delay</em>' attribute.
   * @see uofa.lbirdsey.castle.casl.AdaptationDelay
   * @see #setAdaptationDelay(AdaptationDelay)
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getAdaptiveProcess_AdaptationDelay()
   * @model
   * @generated
   */
  AdaptationDelay getAdaptationDelay();

  /**
   * Sets the value of the '{@link uofa.lbirdsey.castle.casl.AdaptiveProcess#getAdaptationDelay <em>Adaptation Delay</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Adaptation Delay</em>' attribute.
   * @see uofa.lbirdsey.castle.casl.AdaptationDelay
   * @see #getAdaptationDelay()
   * @generated
   */
  void setAdaptationDelay(AdaptationDelay value);

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
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getAdaptiveProcess_FunctionParameters()
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
   * @see uofa.lbirdsey.castle.casl.CaslPackage#getAdaptiveProcess_Body()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getBody();

} // AdaptiveProcess
