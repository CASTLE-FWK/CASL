package uofa.lbirdsey.castle.validation;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import uofa.lbirdsey.castle.casl.Behavior;
import uofa.lbirdsey.castle.casl.BehaviorType;
import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.FeatureCallExp;
import uofa.lbirdsey.castle.casl.Interaction;
import uofa.lbirdsey.castle.casl.InteractionFeatureCall;
import uofa.lbirdsey.castle.casl.InteractionType;
import uofa.lbirdsey.castle.validation.AbstractCASLValidator;

/**
 * This class handles the validation of the features
 */
@SuppressWarnings("all")
public class FeatureValidator extends AbstractCASLValidator {
  @Check
  public void checkBehavior(final Behavior behavior) {
    Behavior fn = behavior;
    EList<EObject> behaviorBody = fn.getBody();
    for (final EObject bb : behaviorBody) {
      if ((bb instanceof FeatureCallExp)) {
        EObject beh = ((FeatureCallExp) bb).getFunc().getFc();
        if (((beh instanceof InteractionFeatureCall) && Objects.equal(fn.getBehavior_type(), BehaviorType.SELF))) {
          String _name = fn.getName();
          String _plus = (_name + " contains an Interaction but Behavior Type is set to SELF. Change to AFFECT or remove the INTERACTION");
          this.error(_plus, 
            CaslPackage.eINSTANCE.getBehavior_Name());
        } else {
          if (((!(beh instanceof InteractionFeatureCall)) && (!Objects.equal(fn.getBehavior_type(), BehaviorType.SELF)))) {
            String _name_1 = fn.getName();
            String _plus_1 = (_name_1 + " is set to AFFECT but has no INTERACTION.");
            this.error(_plus_1, CaslPackage.eINSTANCE.getBehavior_Name());
          }
        }
      }
    }
  }
  
  /**
   * Interactions have 3 types: QUERY, INDIRECT, COMMUNICATION
   * What this validator does is check to see if:
   *  0: Make sure an actual interaction is happening
   * 	1: A QUERY interaction is a request
   *  2: A COMMUNICATE interaction is an acknowledged 2 way request
   *  3: An INDIRECT interaction can't be validated
   */
  @Check
  public void checkInteractions(final Interaction inter) {
    final InteractionType interType = inter.getInteraction_type();
    final EList<EObject> interBody = inter.getBody();
    boolean isAnInteraction = false;
    for (final EObject ib : interBody) {
    }
  }
}