/**
 * generated by Xtext 2.13.0
 */
package uofa.lbirdsey.castle.casl;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Interaction Trigger Types</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getInteractionTriggerTypes()
 * @model
 * @generated
 */
public enum InteractionTriggerTypes implements Enumerator
{
  /**
   * The '<em><b>STEP</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #STEP_VALUE
   * @generated
   * @ordered
   */
  STEP(0, "STEP", "STEP"),

  /**
   * The '<em><b>STATE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #STATE_VALUE
   * @generated
   * @ordered
   */
  STATE(1, "STATE", "STATE"),

  /**
   * The '<em><b>PARAMETER</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #PARAMETER_VALUE
   * @generated
   * @ordered
   */
  PARAMETER(2, "PARAMETER", "PARAMETER"),

  /**
   * The '<em><b>INPUT</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #INPUT_VALUE
   * @generated
   * @ordered
   */
  INPUT(3, "INPUT", "INPUT");

  /**
   * The '<em><b>STEP</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>STEP</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #STEP
   * @model
   * @generated
   * @ordered
   */
  public static final int STEP_VALUE = 0;

  /**
   * The '<em><b>STATE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>STATE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #STATE
   * @model
   * @generated
   * @ordered
   */
  public static final int STATE_VALUE = 1;

  /**
   * The '<em><b>PARAMETER</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>PARAMETER</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #PARAMETER
   * @model
   * @generated
   * @ordered
   */
  public static final int PARAMETER_VALUE = 2;

  /**
   * The '<em><b>INPUT</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>INPUT</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #INPUT
   * @model
   * @generated
   * @ordered
   */
  public static final int INPUT_VALUE = 3;

  /**
   * An array of all the '<em><b>Interaction Trigger Types</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final InteractionTriggerTypes[] VALUES_ARRAY =
    new InteractionTriggerTypes[]
    {
      STEP,
      STATE,
      PARAMETER,
      INPUT,
    };

  /**
   * A public read-only list of all the '<em><b>Interaction Trigger Types</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<InteractionTriggerTypes> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>Interaction Trigger Types</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static InteractionTriggerTypes get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      InteractionTriggerTypes result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Interaction Trigger Types</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static InteractionTriggerTypes getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      InteractionTriggerTypes result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>Interaction Trigger Types</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static InteractionTriggerTypes get(int value)
  {
    switch (value)
    {
      case STEP_VALUE: return STEP;
      case STATE_VALUE: return STATE;
      case PARAMETER_VALUE: return PARAMETER;
      case INPUT_VALUE: return INPUT;
    }
    return null;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final int value;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String name;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private final String literal;

  /**
   * Only this class can construct instances.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private InteractionTriggerTypes(int value, String name, String literal)
  {
    this.value = value;
    this.name = name;
    this.literal = literal;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getLiteral()
  {
    return literal;
  }

  /**
   * Returns the literal value of the enumerator, which is its string representation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    return literal;
  }
  
} //InteractionTriggerTypes
