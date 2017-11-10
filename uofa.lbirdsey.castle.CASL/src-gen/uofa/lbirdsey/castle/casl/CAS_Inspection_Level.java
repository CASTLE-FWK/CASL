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
 * A representation of the literals of the enumeration '<em><b>CAS Inspection Level</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see uofa.lbirdsey.castle.casl.CaslPackage#getCAS_Inspection_Level()
 * @model
 * @generated
 */
public enum CAS_Inspection_Level implements Enumerator
{
  /**
   * The '<em><b>STRONG</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #STRONG_VALUE
   * @generated
   * @ordered
   */
  STRONG(0, "STRONG", "strong"),

  /**
   * The '<em><b>WEAK</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #WEAK_VALUE
   * @generated
   * @ordered
   */
  WEAK(1, "WEAK", "weak"),

  /**
   * The '<em><b>NONE</b></em>' literal object.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #NONE_VALUE
   * @generated
   * @ordered
   */
  NONE(2, "NONE", "none");

  /**
   * The '<em><b>STRONG</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>STRONG</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #STRONG
   * @model literal="strong"
   * @generated
   * @ordered
   */
  public static final int STRONG_VALUE = 0;

  /**
   * The '<em><b>WEAK</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>WEAK</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #WEAK
   * @model literal="weak"
   * @generated
   * @ordered
   */
  public static final int WEAK_VALUE = 1;

  /**
   * The '<em><b>NONE</b></em>' literal value.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of '<em><b>NONE</b></em>' literal object isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @see #NONE
   * @model literal="none"
   * @generated
   * @ordered
   */
  public static final int NONE_VALUE = 2;

  /**
   * An array of all the '<em><b>CAS Inspection Level</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static final CAS_Inspection_Level[] VALUES_ARRAY =
    new CAS_Inspection_Level[]
    {
      STRONG,
      WEAK,
      NONE,
    };

  /**
   * A public read-only list of all the '<em><b>CAS Inspection Level</b></em>' enumerators.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static final List<CAS_Inspection_Level> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

  /**
   * Returns the '<em><b>CAS Inspection Level</b></em>' literal with the specified literal value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param literal the literal.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static CAS_Inspection_Level get(String literal)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      CAS_Inspection_Level result = VALUES_ARRAY[i];
      if (result.toString().equals(literal))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>CAS Inspection Level</b></em>' literal with the specified name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param name the name.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static CAS_Inspection_Level getByName(String name)
  {
    for (int i = 0; i < VALUES_ARRAY.length; ++i)
    {
      CAS_Inspection_Level result = VALUES_ARRAY[i];
      if (result.getName().equals(name))
      {
        return result;
      }
    }
    return null;
  }

  /**
   * Returns the '<em><b>CAS Inspection Level</b></em>' literal with the specified integer value.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the integer value.
   * @return the matching enumerator or <code>null</code>.
   * @generated
   */
  public static CAS_Inspection_Level get(int value)
  {
    switch (value)
    {
      case STRONG_VALUE: return STRONG;
      case WEAK_VALUE: return WEAK;
      case NONE_VALUE: return NONE;
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
  private CAS_Inspection_Level(int value, String name, String literal)
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
  
} //CAS_Inspection_Level
