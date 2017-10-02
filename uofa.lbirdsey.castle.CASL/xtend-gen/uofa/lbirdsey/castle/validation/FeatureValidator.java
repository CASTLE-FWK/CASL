package uofa.lbirdsey.castle.validation;

import com.google.common.base.Objects;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.validation.Check;
import uofa.lbirdsey.castle.casl.Behavior;
import uofa.lbirdsey.castle.casl.BehaviorReactionTime;
import uofa.lbirdsey.castle.casl.BehaviorType;
import uofa.lbirdsey.castle.casl.CaslPackage;
import uofa.lbirdsey.castle.casl.Expression;
import uofa.lbirdsey.castle.casl.FeatureCallExp;
import uofa.lbirdsey.castle.casl.Interaction;
import uofa.lbirdsey.castle.casl.InteractionFeatureCall;
import uofa.lbirdsey.castle.casl.InteractionType;
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.HelperFunctions;
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Helpers;
import uofa.lbirdsey.castle.validation.AbstractCASLValidator;

/**
 * This class handles the validation of the features
 */
@SuppressWarnings("all")
public class FeatureValidator extends AbstractCASLValidator {
  /**
   * This checks to make sure that a BEHAVIOR marked as SELF does not lead to any interactions, directly.
   * Calling a SELF to an AFFECT is fine
   */
  @Check
  public void checkBehavior(final Behavior behavior) {
    final Behavior fn = behavior;
    final EList<EObject> behaviorBody = fn.getBody();
    final BehaviorType behaviorType = fn.getBehavior_type();
    final BehaviorReactionTime reactionType = fn.getBehavior_reaction_time();
    final Expression reactionTime = fn.getReaction_time_parm();
    if ((Objects.equal(reactionType, BehaviorReactionTime.STEP) || Objects.equal(reactionType, BehaviorReactionTime.REPEAT))) {
      if ((reactionTime == null)) {
        String _name = fn.getName();
        String _plus = (_name + " is using ");
        String _plus_1 = (_plus + reactionType);
        String _plus_2 = (_plus_1 + " as the reaction type but has not specified an amount of steps.");
        this.error(_plus_2, 
          CaslPackage.eINSTANCE.getBehavior_Name());
      } else {
        final String rtType = HelperFunctions.inferExpressionType(reactionTime);
        boolean _isANumber = Helpers.isANumber(rtType);
        boolean _not = (!_isANumber);
        if (_not) {
          String _name_1 = fn.getName();
          String _plus_3 = (_name_1 + " has specified an invalid type as the step number.");
          this.error(_plus_3, CaslPackage.eINSTANCE.getBehavior_Name());
        }
      }
    }
    for (final EObject bb : behaviorBody) {
      if ((bb instanceof FeatureCallExp)) {
        EObject beh = ((FeatureCallExp) bb).getFunc().getFc();
        if (((beh instanceof InteractionFeatureCall) && Objects.equal(behaviorType, BehaviorType.SELF))) {
          String _name_2 = fn.getName();
          String _plus_4 = (_name_2 + " contains an Interaction but Behavior Type is set to SELF. Change to AFFECT or remove the INTERACTION");
          this.error(_plus_4, 
            CaslPackage.eINSTANCE.getBehavior_Name());
        } else {
          if (((!(beh instanceof InteractionFeatureCall)) && Objects.equal(behaviorType, BehaviorType.AFFECT))) {
            String _name_3 = fn.getName();
            String _plus_5 = (_name_3 + " is set to AFFECT but has no INTERACTION.");
            this.error(_plus_5, CaslPackage.eINSTANCE.getBehavior_Name());
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
