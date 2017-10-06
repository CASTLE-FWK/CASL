package uofa.lbirdsey.castle.generator.semanticGroups.helpers;

import com.google.common.base.Objects;
import java.util.ArrayList;
import java.util.HashSet;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.xbase.lib.ExclusiveRange;
import org.eclipse.xtext.xbase.lib.IterableExtensions;
import org.eclipse.xtext.xbase.lib.ListExtensions;
import org.eclipse.xtext.xbase.lib.StringExtensions;
import uofa.lbirdsey.castle.casl.AdaptiveProcess;
import uofa.lbirdsey.castle.casl.Addition;
import uofa.lbirdsey.castle.casl.Agent;
import uofa.lbirdsey.castle.casl.AgentFieldReference;
import uofa.lbirdsey.castle.casl.AgentInteraction;
import uofa.lbirdsey.castle.casl.AgentInteractionFeatureCall;
import uofa.lbirdsey.castle.casl.Agent_Call;
import uofa.lbirdsey.castle.casl.ArithmeticSigned;
import uofa.lbirdsey.castle.casl.Behavior;
import uofa.lbirdsey.castle.casl.BehaviorReactionTime;
import uofa.lbirdsey.castle.casl.BehaviorType;
import uofa.lbirdsey.castle.casl.BooleanExpression;
import uofa.lbirdsey.castle.casl.BooleanNegation;
import uofa.lbirdsey.castle.casl.BooleanType;
import uofa.lbirdsey.castle.casl.CASL_Macro;
import uofa.lbirdsey.castle.casl.CASL_Macro_MetricSwitch;
import uofa.lbirdsey.castle.casl.CAS_Rule_Exception;
import uofa.lbirdsey.castle.casl.Comparison;
import uofa.lbirdsey.castle.casl.DataTypeDeclaration;
import uofa.lbirdsey.castle.casl.ElseIfExpr;
import uofa.lbirdsey.castle.casl.Entity_Feature;
import uofa.lbirdsey.castle.casl.Environment;
import uofa.lbirdsey.castle.casl.EnvironmentFieldReference;
import uofa.lbirdsey.castle.casl.EnvironmentInteraction;
import uofa.lbirdsey.castle.casl.EnvironmentInteractionFeatureCall;
import uofa.lbirdsey.castle.casl.Environment_Call;
import uofa.lbirdsey.castle.casl.Equals;
import uofa.lbirdsey.castle.casl.Expression;
import uofa.lbirdsey.castle.casl.FeatureCall;
import uofa.lbirdsey.castle.casl.FeatureCallExp;
import uofa.lbirdsey.castle.casl.Field;
import uofa.lbirdsey.castle.casl.FloatType;
import uofa.lbirdsey.castle.casl.ForEachLoop;
import uofa.lbirdsey.castle.casl.ForLoop;
import uofa.lbirdsey.castle.casl.Formula;
import uofa.lbirdsey.castle.casl.Function;
import uofa.lbirdsey.castle.casl.FunctionCall;
import uofa.lbirdsey.castle.casl.FunctionParameter;
import uofa.lbirdsey.castle.casl.Group;
import uofa.lbirdsey.castle.casl.GroupExternalInteraction;
import uofa.lbirdsey.castle.casl.GroupExternalInteractionFeatureCall;
import uofa.lbirdsey.castle.casl.GroupFieldReference;
import uofa.lbirdsey.castle.casl.GroupInternalInteraction;
import uofa.lbirdsey.castle.casl.GroupInternalInteractionsFeatureCall;
import uofa.lbirdsey.castle.casl.Group_Call;
import uofa.lbirdsey.castle.casl.IfStatement;
import uofa.lbirdsey.castle.casl.IntType;
import uofa.lbirdsey.castle.casl.Interaction;
import uofa.lbirdsey.castle.casl.InteractionTriggerTypes;
import uofa.lbirdsey.castle.casl.InteractionType;
import uofa.lbirdsey.castle.casl.MacroCall;
import uofa.lbirdsey.castle.casl.Multiplication;
import uofa.lbirdsey.castle.casl.NonPrimitiveType;
import uofa.lbirdsey.castle.casl.NumberLiteral;
import uofa.lbirdsey.castle.casl.PrimitiveType;
import uofa.lbirdsey.castle.casl.SelfAssignedFormula;
import uofa.lbirdsey.castle.casl.SelfCall;
import uofa.lbirdsey.castle.casl.SelfCallExpr;
import uofa.lbirdsey.castle.casl.StringLiteral;
import uofa.lbirdsey.castle.casl.StringType;
import uofa.lbirdsey.castle.casl.Subtraction;
import uofa.lbirdsey.castle.casl.Symbol;
import uofa.lbirdsey.castle.casl.SystemCallObj;
import uofa.lbirdsey.castle.casl.Type;
import uofa.lbirdsey.castle.casl.TypeRef;
import uofa.lbirdsey.castle.generator.semanticGroups.FeatureCallGenerator;
import uofa.lbirdsey.castle.generator.semanticGroups.MacroGenerator;
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Constants;
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Helpers;
import uofa.lbirdsey.castle.generator.semanticGroups.helpers.Printers;

@SuppressWarnings("all")
public class HelperFunctions {
  public static String inferMethodType(final EList<EObject> body) {
    final EObject finalTerm = IterableExtensions.<EObject>head(ListExtensions.<EObject>reverseView(body));
    String output = "";
    output = HelperFunctions.inferGeneralType(finalTerm);
    return output;
  }
  
  public static String inferTypeFromDeclaration(final DataTypeDeclaration dtd) {
    String output = "";
    PrimitiveType _type = dtd.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      output = dtd.getType().getName();
    } else {
      NonPrimitiveType _obj = dtd.getObj();
      boolean _tripleNotEquals_1 = (_obj != null);
      if (_tripleNotEquals_1) {
        NonPrimitiveType _obj_1 = dtd.getObj();
        if ((_obj_1 instanceof uofa.lbirdsey.castle.casl.Object)) {
          NonPrimitiveType _obj_2 = dtd.getObj();
          output = ((uofa.lbirdsey.castle.casl.Object) _obj_2).getName();
        } else {
          NonPrimitiveType _obj_3 = dtd.getObj();
          output = ((uofa.lbirdsey.castle.casl.Enum) _obj_3).getName();
        }
        NonPrimitiveType _useObj = dtd.getUseObj();
        boolean _tripleNotEquals_2 = (_useObj != null);
        if (_tripleNotEquals_2) {
          String _output = output;
          String _name = dtd.getUseObj().getName();
          String _plus = ("<" + _name);
          String _plus_1 = (_plus + ">");
          output = (_output + _plus_1);
        } else {
          PrimitiveType _useType = dtd.getUseType();
          boolean _tripleNotEquals_3 = (_useType != null);
          if (_tripleNotEquals_3) {
            String _output_1 = output;
            String _name_1 = dtd.getUseType().getName();
            String _plus_2 = ("<" + _name_1);
            String _plus_3 = (_plus_2 + ">");
            output = (_output_1 + _plus_3);
          } else {
            Group _useGroup = dtd.getUseGroup();
            boolean _tripleNotEquals_4 = (_useGroup != null);
            if (_tripleNotEquals_4) {
              String _output_2 = output;
              String _name_2 = dtd.getUseGroup().getName();
              String _plus_4 = ("<" + _name_2);
              String _plus_5 = (_plus_4 + ">");
              output = (_output_2 + _plus_5);
            } else {
              Agent _useAgent = dtd.getUseAgent();
              boolean _tripleNotEquals_5 = (_useAgent != null);
              if (_tripleNotEquals_5) {
                String _output_3 = output;
                String _name_3 = dtd.getUseAgent().getName();
                String _plus_6 = ("<" + _name_3);
                String _plus_7 = (_plus_6 + ">");
                output = (_output_3 + _plus_7);
              } else {
                Environment _useEnv = dtd.getUseEnv();
                boolean _tripleNotEquals_6 = (_useEnv != null);
                if (_tripleNotEquals_6) {
                  String _output_4 = output;
                  String _name_4 = dtd.getUseEnv().getName();
                  String _plus_8 = ("<" + _name_4);
                  String _plus_9 = (_plus_8 + ">");
                  output = (_output_4 + _plus_9);
                }
              }
            }
          }
        }
      }
    }
    return output;
  }
  
  public static String inferFunctionParameterType(final FunctionParameter fp) {
    String output = "";
    PrimitiveType _type = fp.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      output = fp.getType().getName();
    } else {
      NonPrimitiveType _obj = fp.getObj();
      boolean _tripleNotEquals_1 = (_obj != null);
      if (_tripleNotEquals_1) {
        NonPrimitiveType _obj_1 = fp.getObj();
        if ((_obj_1 instanceof uofa.lbirdsey.castle.casl.Object)) {
          NonPrimitiveType _obj_2 = fp.getObj();
          output = ((uofa.lbirdsey.castle.casl.Object) _obj_2).getName();
        } else {
          NonPrimitiveType _obj_3 = fp.getObj();
          output = ((uofa.lbirdsey.castle.casl.Enum) _obj_3).getName();
        }
        NonPrimitiveType _useObj = fp.getUseObj();
        boolean _tripleNotEquals_2 = (_useObj != null);
        if (_tripleNotEquals_2) {
          String _output = output;
          String _name = fp.getUseObj().getName();
          String _plus = ("<" + _name);
          String _plus_1 = (_plus + ">");
          output = (_output + _plus_1);
        } else {
          PrimitiveType _useType = fp.getUseType();
          boolean _tripleNotEquals_3 = (_useType != null);
          if (_tripleNotEquals_3) {
            String _output_1 = output;
            String _name_1 = fp.getUseType().getName();
            String _plus_2 = ("<" + _name_1);
            String _plus_3 = (_plus_2 + ">");
            output = (_output_1 + _plus_3);
          } else {
            Group _useGroup = fp.getUseGroup();
            boolean _tripleNotEquals_4 = (_useGroup != null);
            if (_tripleNotEquals_4) {
              String _output_2 = output;
              String _name_2 = fp.getUseGroup().getName();
              String _plus_4 = ("<" + _name_2);
              String _plus_5 = (_plus_4 + ">");
              output = (_output_2 + _plus_5);
            } else {
              Agent _useAgent = fp.getUseAgent();
              boolean _tripleNotEquals_5 = (_useAgent != null);
              if (_tripleNotEquals_5) {
                String _output_3 = output;
                String _name_3 = fp.getUseAgent().getName();
                String _plus_6 = ("<" + _name_3);
                String _plus_7 = (_plus_6 + ">");
                output = (_output_3 + _plus_7);
              } else {
                Environment _useEnv = fp.getUseEnv();
                boolean _tripleNotEquals_6 = (_useEnv != null);
                if (_tripleNotEquals_6) {
                  String _output_4 = output;
                  String _name_4 = fp.getUseEnv().getName();
                  String _plus_8 = ("<" + _name_4);
                  String _plus_9 = (_plus_8 + ">");
                  output = (_output_4 + _plus_9);
                }
              }
            }
          }
        }
      } else {
        Agent _agent = fp.getAgent();
        boolean _tripleNotEquals_7 = (_agent != null);
        if (_tripleNotEquals_7) {
          output = fp.getAgent().getName();
        } else {
          Environment _env = fp.getEnv();
          boolean _tripleNotEquals_8 = (_env != null);
          if (_tripleNotEquals_8) {
            output = fp.getEnv().getName();
          } else {
            Group _grp = fp.getGrp();
            boolean _tripleNotEquals_9 = (_grp != null);
            if (_tripleNotEquals_9) {
              output = fp.getGrp().getName();
            }
          }
        }
      }
    }
    return output;
  }
  
  public static String inferExpressionType(final Expression expr) {
    String output = "";
    if ((expr instanceof Expression)) {
      if ((expr instanceof SelfCallExpr)) {
        output = "selfcall";
        SelfCall sce = ((SelfCallExpr) expr).getSelfCall();
        Symbol _ref = sce.getRef();
        boolean _tripleNotEquals = (_ref != null);
        if (_tripleNotEquals) {
          output = HelperFunctions.inferSymbolType(sce.getRef());
        } else {
          FunctionCall _fc = sce.getFc();
          boolean _tripleNotEquals_1 = (_fc != null);
          if (_tripleNotEquals_1) {
            Symbol _returnType = sce.getFc().getFunc().getReturnType();
            boolean _tripleNotEquals_2 = (_returnType != null);
            if (_tripleNotEquals_2) {
              output = HelperFunctions.inferSymbolType(sce.getFc().getFunc().getReturnType());
            } else {
              output = "void";
            }
          } else {
            FeatureCall _fec = sce.getFec();
            boolean _tripleNotEquals_3 = (_fec != null);
            if (_tripleNotEquals_3) {
              FeatureCall featCall = sce.getFec();
              output = FeatureCallGenerator.inferFeatureCallType(featCall);
            }
          }
        }
      } else {
        if ((expr instanceof NumberLiteral)) {
          output = "float";
        } else {
          if ((expr instanceof BooleanType)) {
            output = "bool";
          } else {
            if ((expr instanceof SystemCallObj)) {
              output = "systemcall";
            } else {
              if ((expr instanceof StringLiteral)) {
                output = "string";
              } else {
                if ((expr instanceof TypeRef)) {
                  output = HelperFunctions.inferSymbolType(((TypeRef) expr).getType());
                } else {
                  if ((expr instanceof FeatureCallExp)) {
                    output = FeatureCallGenerator.inferFeatureCallType(((FeatureCallExp) expr));
                  } else {
                    if ((expr instanceof IfStatement)) {
                      output = HelperFunctions.inferIfStatementReturnType(((IfStatement) expr));
                    } else {
                      if ((expr instanceof BooleanExpression)) {
                        output = "andor";
                      } else {
                        if ((expr instanceof Comparison)) {
                          output = "comparison";
                        } else {
                          if ((expr instanceof Equals)) {
                            output = "equals";
                          } else {
                            if ((expr instanceof Addition)) {
                              output = "addition";
                            } else {
                              if ((expr instanceof Subtraction)) {
                                output = "subtraction";
                              } else {
                                if ((expr instanceof Multiplication)) {
                                  output = "multi";
                                } else {
                                  if ((expr instanceof BooleanNegation)) {
                                    output = "boolean";
                                  } else {
                                    if ((expr instanceof ArithmeticSigned)) {
                                      output = "arithmeticsigned";
                                    } else {
                                      if ((expr instanceof MacroCall)) {
                                        output = MacroGenerator.macroCallReturnType(((MacroCall) expr));
                                      } else {
                                        output = "void";
                                      }
                                    }
                                  }
                                }
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return output;
  }
  
  public static String inferGeneralType(final EObject eobj) {
    String output = "";
    if ((eobj instanceof Field)) {
      final Field ftf = ((Field) eobj);
      Symbol _declaration = ftf.getDeclaration();
      boolean _tripleNotEquals = (_declaration != null);
      if (_tripleNotEquals) {
        Symbol _declaration_1 = ftf.getDeclaration();
        output = HelperFunctions.inferTypeFromDeclaration(((DataTypeDeclaration) _declaration_1));
      } else {
        Symbol _agentFieldRef = ftf.getAgentFieldRef();
        boolean _tripleNotEquals_1 = (_agentFieldRef != null);
        if (_tripleNotEquals_1) {
          Symbol _agentFieldRef_1 = ftf.getAgentFieldRef();
          output = ((AgentFieldReference) _agentFieldRef_1).getAgent().getName();
        } else {
          Symbol _envFieldRef = ftf.getEnvFieldRef();
          boolean _tripleNotEquals_2 = (_envFieldRef != null);
          if (_tripleNotEquals_2) {
            Symbol _envFieldRef_1 = ftf.getEnvFieldRef();
            output = ((EnvironmentFieldReference) _envFieldRef_1).getEnv().getName();
          }
        }
      }
    } else {
      if ((eobj instanceof Formula)) {
        final Formula ftf_1 = ((Formula) eobj);
        Symbol _sym = ftf_1.getSym();
        if ((_sym instanceof AgentFieldReference)) {
          Symbol _sym_1 = ftf_1.getSym();
          output = ((AgentFieldReference) _sym_1).getAgent().getName();
        } else {
          Symbol _sym_2 = ftf_1.getSym();
          if ((_sym_2 instanceof EnvironmentFieldReference)) {
            Symbol _sym_3 = ftf_1.getSym();
            output = ((EnvironmentFieldReference) _sym_3).getEnv().getName();
          } else {
            Symbol _sym_4 = ftf_1.getSym();
            if ((_sym_4 instanceof DataTypeDeclaration)) {
              Symbol _sym_5 = ftf_1.getSym();
              DataTypeDeclaration dtd = ((DataTypeDeclaration) _sym_5);
              output = HelperFunctions.inferTypeFromDeclaration(((DataTypeDeclaration) dtd));
            } else {
              Symbol _sym_6 = ftf_1.getSym();
              if ((_sym_6 instanceof FunctionParameter)) {
                Symbol _sym_7 = ftf_1.getSym();
                FunctionParameter fp = ((FunctionParameter) _sym_7);
                output = HelperFunctions.inferFunctionParameterType(fp);
              }
            }
          }
        }
      } else {
        if ((eobj instanceof SelfAssignedFormula)) {
          final SelfAssignedFormula ftf_2 = ((SelfAssignedFormula) eobj);
          Symbol _ref = ftf_2.getRef();
          if ((_ref instanceof AgentFieldReference)) {
            Symbol _ref_1 = ftf_2.getRef();
            output = ((AgentFieldReference) _ref_1).getAgent().getName();
          } else {
            Symbol _ref_2 = ftf_2.getRef();
            if ((_ref_2 instanceof EnvironmentFieldReference)) {
              Symbol _ref_3 = ftf_2.getRef();
              output = ((EnvironmentFieldReference) _ref_3).getEnv().getName();
            } else {
              Symbol _ref_4 = ftf_2.getRef();
              if ((_ref_4 instanceof DataTypeDeclaration)) {
                Symbol _ref_5 = ftf_2.getRef();
                DataTypeDeclaration dtd_1 = ((DataTypeDeclaration) _ref_5);
                output = HelperFunctions.inferTypeFromDeclaration(((DataTypeDeclaration) dtd_1));
              } else {
                Symbol _ref_6 = ftf_2.getRef();
                if ((_ref_6 instanceof FunctionParameter)) {
                  Symbol _ref_7 = ftf_2.getRef();
                  FunctionParameter fp_1 = ((FunctionParameter) _ref_7);
                  output = HelperFunctions.inferFunctionParameterType(fp_1);
                }
              }
            }
          }
        } else {
          if ((eobj instanceof FunctionCall)) {
            Symbol _returnType = ((FunctionCall) eobj).getFunc().getReturnType();
            boolean _tripleNotEquals_3 = (_returnType != null);
            if (_tripleNotEquals_3) {
              output = HelperFunctions.inferSymbolType(((FunctionCall) eobj).getFunc().getReturnType());
            } else {
              output = "void";
            }
          } else {
            if ((eobj instanceof FeatureCallExp)) {
              output = FeatureCallGenerator.inferFeatureCallType(((FeatureCallExp) eobj));
            } else {
              if ((eobj instanceof Expression)) {
                output = HelperFunctions.inferExpressionType(((Expression) eobj));
              } else {
                if ((eobj instanceof uofa.lbirdsey.castle.casl.Enum)) {
                  output = ((uofa.lbirdsey.castle.casl.Enum) eobj).getName();
                } else {
                  if ((eobj instanceof SelfCall)) {
                    output = "selfcall";
                  } else {
                    output = "void";
                  }
                }
              }
            }
          }
        }
      }
    }
    return output;
  }
  
  public static String inferIfStatementReturnType(final IfStatement ifstate) {
    final EObject finalTerm = IterableExtensions.<EObject>head(ListExtensions.<EObject>reverseView(ifstate.getThen()));
    String returnType = HelperFunctions.inferGeneralType(finalTerm);
    String output = "";
    output = returnType;
    EList<ElseIfExpr> _elseifexpr = ifstate.getElseifexpr();
    boolean _tripleNotEquals = (_elseifexpr != null);
    if (_tripleNotEquals) {
      EList<ElseIfExpr> _elseifexpr_1 = ifstate.getElseifexpr();
      for (final ElseIfExpr elseif : _elseifexpr_1) {
        {
          String tmpReturn = HelperFunctions.inferGeneralType(IterableExtensions.<EObject>head(ListExtensions.<EObject>reverseView(elseif.getElseifthen())));
          if (((tmpReturn.compareTo(returnType) != 0) && (returnType.length() == 0))) {
            Constants.throwCASLError("error with inferring elseif exp", "inferIfStatementReturnType", HelperFunctions.class.getClass().toString());
            output = (returnType + "_ERROR");
          } else {
            returnType = tmpReturn;
          }
        }
      }
    }
    EList<EObject> _elseexp = ifstate.getElseexp();
    boolean _tripleNotEquals_1 = (_elseexp != null);
    if (_tripleNotEquals_1) {
      String tmpReturn = HelperFunctions.inferGeneralType(IterableExtensions.<EObject>head(ListExtensions.<EObject>reverseView(ifstate.getElseexp())));
      if (((tmpReturn.compareTo(returnType) != 0) && (returnType.length() == 0))) {
        Constants.throwCASLError("error with inferring else exp", "inferIfStatementReturnType", HelperFunctions.class.getClass().toString());
        output = (returnType + "_ERROR");
      } else {
        returnType = tmpReturn;
      }
    }
    return output;
  }
  
  public static String parseBodyElement(final EObject statement, final Entity_Feature caller) {
    String strOut = "";
    if ((statement instanceof Field)) {
      String _strOut = strOut;
      String _printFieldDeclarations = Printers.printFieldDeclarations(((Field) statement));
      String _plus = (_printFieldDeclarations + Constants.SC);
      strOut = (_strOut + _plus);
    } else {
      if ((statement instanceof FunctionCall)) {
        FunctionCall st = ((FunctionCall) statement);
        Function _func = st.getFunc();
        boolean _tripleNotEquals = (_func != null);
        if (_tripleNotEquals) {
          String _strOut_1 = strOut;
          String _name = ((FunctionCall) statement).getFunc().getName();
          String _plus_1 = (_name + "(THINGS TO PASS)");
          String _plus_2 = (_plus_1 + Constants.SC);
          strOut = (_strOut_1 + _plus_2);
        } else {
          EList<Symbol> _fields = st.getFields();
          boolean _tripleNotEquals_1 = (_fields != null);
          if (_tripleNotEquals_1) {
          }
        }
      } else {
        if ((statement instanceof MacroCall)) {
          final CASL_Macro mc = ((MacroCall) statement).getMacroCall().getMacro();
          if ((mc instanceof CASL_Macro_MetricSwitch)) {
            String _strOut_2 = strOut;
            String _metric_ToOutput = HelperFunctions.metric_ToOutput(caller, ((CASL_Macro_MetricSwitch) mc));
            strOut = (_strOut_2 + _metric_ToOutput);
          } else {
            String _strOut_3 = strOut;
            Object _printExpression = Printers.printExpression(((Expression)statement), null);
            String _plus_3 = (_printExpression + Constants.SC);
            strOut = (_strOut_3 + _plus_3);
          }
        } else {
          if ((statement instanceof Expression)) {
            String _strOut_4 = strOut;
            Object _printExpression_1 = Printers.printExpression(((Expression) statement));
            String _plus_4 = (_printExpression_1 + Constants.SC);
            strOut = (_strOut_4 + _plus_4);
          } else {
            if ((statement instanceof Formula)) {
              String _strOut_5 = strOut;
              String _printFormula = HelperFunctions.printFormula(((Formula) statement));
              String _plus_5 = (_printFormula + Constants.SC);
              strOut = (_strOut_5 + _plus_5);
            } else {
              if ((statement instanceof SelfAssignedFormula)) {
                String _strOut_6 = strOut;
                String _printSelfAssignedFormula = HelperFunctions.printSelfAssignedFormula(((SelfAssignedFormula) statement));
                String _plus_6 = (_printSelfAssignedFormula + Constants.SC);
                strOut = (_strOut_6 + _plus_6);
              } else {
                Constants.throwCASLError("error with body element", "parseBodyElement", "HelperFunctions");
                String _strOut_7 = strOut;
                strOut = (_strOut_7 + "ERROR WITH BODY ELEMENT");
              }
            }
          }
        }
      }
    }
    return strOut;
  }
  
  public static EObject getInteractionFromStatement(final EObject statement) {
    Object _xblockexpression = null;
    {
      String strOut = "";
      Object _xifexpression = null;
      if ((statement instanceof Field)) {
        Symbol _declaration = ((Field) statement).getDeclaration();
        boolean _tripleNotEquals = (_declaration != null);
        if (_tripleNotEquals) {
          Symbol _declaration_1 = ((Field) statement).getDeclaration();
          return HelperFunctions.getInteractionFromStatement(((DataTypeDeclaration) _declaration_1).getExpr());
        }
      } else {
        Object _xifexpression_1 = null;
        if ((statement instanceof FunctionCall)) {
          Object _xblockexpression_1 = null;
          {
            FunctionCall st = ((FunctionCall) statement);
            Object _xifexpression_2 = null;
            Function _func = st.getFunc();
            boolean _tripleNotEquals_1 = (_func != null);
            if (_tripleNotEquals_1) {
              _xifexpression_2 = null;
            } else {
              Object _xifexpression_3 = null;
              EList<Symbol> _fields = st.getFields();
              boolean _tripleNotEquals_2 = (_fields != null);
              if (_tripleNotEquals_2) {
                _xifexpression_3 = null;
              }
              _xifexpression_2 = _xifexpression_3;
            }
            _xblockexpression_1 = _xifexpression_2;
          }
          _xifexpression_1 = _xblockexpression_1;
        } else {
          Object _xifexpression_2 = null;
          if ((statement instanceof MacroCall)) {
            Object _xblockexpression_2 = null;
            {
              final CASL_Macro mc = ((MacroCall) statement).getMacroCall().getMacro();
              Object _xifexpression_3 = null;
              if ((mc instanceof CASL_Macro_MetricSwitch)) {
                _xifexpression_3 = null;
              } else {
                _xifexpression_3 = null;
              }
              _xblockexpression_2 = _xifexpression_3;
            }
            _xifexpression_2 = _xblockexpression_2;
          } else {
            Object _xifexpression_3 = null;
            if ((statement instanceof Expression)) {
              Object _xblockexpression_3 = null;
              {
                final Expression expr = ((Expression) statement);
                Object _xifexpression_4 = null;
                if ((expr instanceof SelfCallExpr)) {
                  return FeatureCallGenerator.getFeatureCallFeatureType(((SelfCallExpr) expr).getSelfCall().getFec());
                } else {
                  Object _xifexpression_5 = null;
                  if ((expr instanceof FeatureCallExp)) {
                    return FeatureCallGenerator.getFeatureCallFeatureType(((FeatureCallExp) expr).getFunc());
                  } else {
                    Object _xifexpression_6 = null;
                    if ((expr instanceof Group_Call)) {
                      _xifexpression_6 = null;
                    } else {
                      Object _xifexpression_7 = null;
                      if ((expr instanceof Agent_Call)) {
                        _xifexpression_7 = null;
                      } else {
                        Object _xifexpression_8 = null;
                        if ((expr instanceof Environment_Call)) {
                          _xifexpression_8 = null;
                        }
                        _xifexpression_7 = _xifexpression_8;
                      }
                      _xifexpression_6 = _xifexpression_7;
                    }
                    _xifexpression_5 = _xifexpression_6;
                  }
                  _xifexpression_4 = _xifexpression_5;
                }
                _xblockexpression_3 = _xifexpression_4;
              }
              _xifexpression_3 = _xblockexpression_3;
            } else {
              Object _xifexpression_4 = null;
              if ((statement instanceof Formula)) {
                _xifexpression_4 = null;
              } else {
                Object _xifexpression_5 = null;
                if ((statement instanceof SelfAssignedFormula)) {
                  Object _xifexpression_6 = null;
                  if ((HelperFunctions.isAnInteraction(((SelfAssignedFormula) statement).getRef()) || HelperFunctions.isAnInteraction(((SelfAssignedFormula) statement).getObjField()))) {
                    _xifexpression_6 = null;
                  }
                  _xifexpression_5 = _xifexpression_6;
                } else {
                  Constants.throwCASLError("error with finding interaction in statement", "getInteractionFromStatement", "HelperFunctions");
                  return null;
                }
                _xifexpression_4 = _xifexpression_5;
              }
              _xifexpression_3 = _xifexpression_4;
            }
            _xifexpression_2 = _xifexpression_3;
          }
          _xifexpression_1 = _xifexpression_2;
        }
        _xifexpression = _xifexpression_1;
      }
      _xblockexpression = _xifexpression;
    }
    return ((EObject)_xblockexpression);
  }
  
  public static boolean isAnInteraction(final EObject eo) {
    if ((((((eo instanceof Interaction) || (eo instanceof GroupExternalInteraction)) || (eo instanceof GroupInternalInteraction)) || (eo instanceof AgentInteraction)) || (eo instanceof EnvironmentInteraction))) {
      return true;
    }
    return false;
  }
  
  public static String printFunctionParameter(final FunctionParameter fp) {
    String _inferFunctionParameterType = HelperFunctions.inferFunctionParameterType(fp);
    String _plus = (_inferFunctionParameterType + " ");
    String _name = fp.getName();
    return (_plus + _name);
  }
  
  public static String printFunctionParameters(final EList<Symbol> fps) {
    final int parameterSize = fps.size();
    String strOut = "";
    if ((parameterSize == 0)) {
      return "";
    } else {
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, (parameterSize - 1), true);
      for (final Integer i : _doubleDotLessThan) {
        String _strOut = strOut;
        Symbol _get = fps.get((i).intValue());
        String _printFunctionParameter = HelperFunctions.printFunctionParameter(((FunctionParameter) _get));
        String _plus = (_printFunctionParameter + ", ");
        strOut = (_strOut + _plus);
      }
      String _strOut_1 = strOut;
      Symbol _get_1 = fps.get((parameterSize - 1));
      String _printFunctionParameter_1 = HelperFunctions.printFunctionParameter(((FunctionParameter) _get_1));
      strOut = (_strOut_1 + _printFunctionParameter_1);
      return strOut;
    }
  }
  
  public static String printRuleExceptionArgs(final EList<CAS_Rule_Exception> ruleArgs) {
    final int parameterSize = ruleArgs.size();
    String strOut = "";
    if ((parameterSize == 0)) {
      return "";
    } else {
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, (parameterSize - 1), true);
      for (final Integer i : _doubleDotLessThan) {
        String _strOut = strOut;
        CAS_Rule_Exception _get = ruleArgs.get((i).intValue());
        String _upperCase = ((CAS_Rule_Exception) _get).toString().toUpperCase();
        String _plus = ("CAS_Rule_Exception." + _upperCase);
        String _plus_1 = (_plus + ", ");
        strOut = (_strOut + _plus_1);
      }
      String _strOut_1 = strOut;
      CAS_Rule_Exception _get_1 = ruleArgs.get((parameterSize - 1));
      String _upperCase_1 = ((CAS_Rule_Exception) _get_1).toString().toUpperCase();
      String _plus_2 = ("CAS_Rule_Exception." + _upperCase_1);
      strOut = (_strOut_1 + _plus_2);
      return strOut;
    }
  }
  
  public static String printFunctionArgs(final EList<Expression> far) {
    final int parameterSize = far.size();
    String strOut = "";
    if ((parameterSize == 0)) {
      return "";
    } else {
      ExclusiveRange _doubleDotLessThan = new ExclusiveRange(0, (parameterSize - 1), true);
      for (final Integer i : _doubleDotLessThan) {
        String _strOut = strOut;
        Expression _get = far.get((i).intValue());
        Object _printExpression = Printers.printExpression(((Expression) _get));
        String _plus = (_printExpression + ", ");
        strOut = (_strOut + _plus);
      }
      String _strOut_1 = strOut;
      Expression _get_1 = far.get((parameterSize - 1));
      Object _printExpression_1 = Printers.printExpression(((Expression) _get_1));
      strOut = (_strOut_1 + _printExpression_1);
      return strOut;
    }
  }
  
  public static String printFormula(final Formula formula) {
    String strOut = "";
    String _strOut = strOut;
    String _name = formula.getSym().getName();
    strOut = (_strOut + _name);
    Symbol _objField = formula.getObjField();
    boolean _tripleNotEquals = (_objField != null);
    if (_tripleNotEquals) {
      String _strOut_1 = strOut;
      String _name_1 = formula.getObjField().getName();
      String _plus = ("." + _name_1);
      strOut = (_strOut_1 + _plus);
    }
    String _strOut_2 = strOut;
    Object _printExpression = Printers.printExpression(formula.getExpr());
    String _plus_1 = (" = " + _printExpression);
    strOut = (_strOut_2 + _plus_1);
    return strOut;
  }
  
  public static String printSelfAssignedFormula(final SelfAssignedFormula saf) {
    String strOut = "";
    String _strOut = strOut;
    String _name = saf.getRef().getName();
    String _plus = ("this." + _name);
    strOut = (_strOut + _plus);
    Symbol _objField = saf.getObjField();
    boolean _tripleNotEquals = (_objField != null);
    if (_tripleNotEquals) {
      String _strOut_1 = strOut;
      String _name_1 = saf.getObjField().getName();
      String _plus_1 = ("." + _name_1);
      strOut = (_strOut_1 + _plus_1);
    }
    String _strOut_2 = strOut;
    Object _printExpression = Printers.printExpression(saf.getExpr());
    String _plus_2 = (" = " + _printExpression);
    strOut = (_strOut_2 + _plus_2);
    return strOut;
  }
  
  public static String printSelfCall(final SelfCallExpr sce) {
    final SelfCall sc = sce.getSelfCall();
    String output = "this";
    FunctionCall _fc = sc.getFc();
    boolean _tripleNotEquals = (_fc != null);
    if (_tripleNotEquals) {
      String _output = output;
      String _printFunctionCall = HelperFunctions.printFunctionCall(sc.getFc());
      String _plus = ("." + _printFunctionCall);
      output = (_output + _plus);
    } else {
      Symbol _ref = sc.getRef();
      boolean _tripleNotEquals_1 = (_ref != null);
      if (_tripleNotEquals_1) {
        String _output_1 = output;
        String _name = sc.getRef().getName();
        String _plus_1 = ("." + _name);
        output = (_output_1 + _plus_1);
      } else {
        FeatureCall _fec = sc.getFec();
        boolean _tripleNotEquals_2 = (_fec != null);
        if (_tripleNotEquals_2) {
          String _output_2 = output;
          CharSequence _printFeatureCall = FeatureCallGenerator.printFeatureCall(sc.getFec());
          String _plus_2 = ("." + _printFeatureCall);
          output = (_output_2 + _plus_2);
        }
      }
    }
    return output;
  }
  
  public static String printFunctionCall(final FunctionCall fc) {
    String output = "";
    String _output = output;
    String _name = fc.getObj().getName();
    output = (_output + _name);
    Function _func = fc.getFunc();
    boolean _tripleNotEquals = (_func != null);
    if (_tripleNotEquals) {
      String _output_1 = output;
      String _name_1 = fc.getFunc().getName();
      String _plus = ("." + _name_1);
      output = (_output_1 + _plus);
      String _output_2 = output;
      String _printFunctionArgs = HelperFunctions.printFunctionArgs(fc.getInputs());
      String _plus_1 = ("(" + _printFunctionArgs);
      String _plus_2 = (_plus_1 + ")");
      output = (_output_2 + _plus_2);
    } else {
      EList<Symbol> _fields = fc.getFields();
      boolean _tripleNotEquals_1 = (_fields != null);
      if (_tripleNotEquals_1) {
        EList<Symbol> _fields_1 = fc.getFields();
        for (final Symbol fields : _fields_1) {
          String _output_3 = output;
          String _name_2 = fields.getName();
          String _plus_3 = ("." + _name_2);
          output = (_output_3 + _plus_3);
        }
      }
    }
    return output;
  }
  
  public static String inferSymbolType(final Symbol sym) {
    String output = "";
    if ((sym instanceof AgentFieldReference)) {
      output = "sym=afr";
    } else {
      if ((sym instanceof EnvironmentFieldReference)) {
        output = "sym=efr";
      } else {
        if ((sym instanceof FunctionParameter)) {
          FunctionParameter fp = ((FunctionParameter) sym);
          output = HelperFunctions.inferFunctionParameterType(fp);
        } else {
          if ((sym instanceof DataTypeDeclaration)) {
            DataTypeDeclaration dtd = ((DataTypeDeclaration) sym);
            output = HelperFunctions.inferTypeFromDeclaration(dtd);
          }
        }
      }
    }
    return output;
  }
  
  public static String getFieldName(final Field f) {
    Symbol _declaration = f.getDeclaration();
    boolean _tripleNotEquals = (_declaration != null);
    if (_tripleNotEquals) {
      return f.getDeclaration().getName();
    } else {
      Symbol _agentFieldRef = f.getAgentFieldRef();
      boolean _tripleNotEquals_1 = (_agentFieldRef != null);
      if (_tripleNotEquals_1) {
        return f.getAgentFieldRef().getName();
      } else {
        Symbol _envFieldRef = f.getEnvFieldRef();
        boolean _tripleNotEquals_2 = (_envFieldRef != null);
        if (_tripleNotEquals_2) {
          return f.getEnvFieldRef().getName();
        } else {
          Symbol _grpFieldRef = f.getGrpFieldRef();
          boolean _tripleNotEquals_3 = (_grpFieldRef != null);
          if (_tripleNotEquals_3) {
            return f.getGrpFieldRef().getName();
          } else {
            return "";
          }
        }
      }
    }
  }
  
  public static String getFieldType(final Field f) {
    String output = "";
    Symbol _declaration = f.getDeclaration();
    boolean _tripleNotEquals = (_declaration != null);
    if (_tripleNotEquals) {
      Symbol _declaration_1 = f.getDeclaration();
      final DataTypeDeclaration fdt = ((DataTypeDeclaration) _declaration_1);
      NonPrimitiveType _obj = fdt.getObj();
      boolean _tripleNotEquals_1 = (_obj != null);
      if (_tripleNotEquals_1) {
        NonPrimitiveType _obj_1 = fdt.getObj();
        if ((_obj_1 instanceof uofa.lbirdsey.castle.casl.Enum)) {
          NonPrimitiveType _obj_2 = fdt.getObj();
          String _custom = ((uofa.lbirdsey.castle.casl.Enum) _obj_2).getCustom();
          boolean _tripleNotEquals_2 = (_custom != null);
          if (_tripleNotEquals_2) {
            output = "CUSTOM:";
          }
          NonPrimitiveType _useObj = fdt.getUseObj();
          boolean _tripleNotEquals_3 = (_useObj != null);
          if (_tripleNotEquals_3) {
            String _output = output;
            String _name = fdt.getObj().getName();
            String _plus = ("Enums." + _name);
            output = (_output + _plus);
          } else {
            String _output_1 = output;
            String _name_1 = fdt.getObj().getName();
            String _plus_1 = ("Enums." + _name_1);
            output = (_output_1 + _plus_1);
          }
        } else {
          NonPrimitiveType _obj_3 = fdt.getObj();
          if ((_obj_3 instanceof uofa.lbirdsey.castle.casl.Object)) {
            NonPrimitiveType _obj_4 = fdt.getObj();
            String _custom_1 = ((uofa.lbirdsey.castle.casl.Object) _obj_4).getCustom();
            boolean _tripleNotEquals_4 = (_custom_1 != null);
            if (_tripleNotEquals_4) {
              output = "CUSTOM:";
            }
            NonPrimitiveType _useObj_1 = fdt.getUseObj();
            boolean _tripleNotEquals_5 = (_useObj_1 != null);
            if (_tripleNotEquals_5) {
              String _output_2 = output;
              String _name_2 = fdt.getObj().getName();
              String _plus_2 = (_name_2 + "<");
              String _name_3 = fdt.getUseObj().getName();
              String _plus_3 = (_plus_2 + _name_3);
              String _plus_4 = (_plus_3 + ">");
              output = (_output_2 + _plus_4);
            } else {
              Group _useGroup = fdt.getUseGroup();
              boolean _tripleNotEquals_6 = (_useGroup != null);
              if (_tripleNotEquals_6) {
                String _output_3 = output;
                String _name_4 = fdt.getObj().getName();
                String _plus_5 = (_name_4 + "<");
                String _firstUpper = StringExtensions.toFirstUpper(fdt.getUseGroup().getName());
                String _plus_6 = (_plus_5 + _firstUpper);
                String _plus_7 = (_plus_6 + ">");
                output = (_output_3 + _plus_7);
              } else {
                Agent _useAgent = fdt.getUseAgent();
                boolean _tripleNotEquals_7 = (_useAgent != null);
                if (_tripleNotEquals_7) {
                  String _output_4 = output;
                  String _name_5 = fdt.getObj().getName();
                  String _plus_8 = (_name_5 + "<");
                  String _firstUpper_1 = StringExtensions.toFirstUpper(fdt.getUseAgent().getName());
                  String _plus_9 = (_plus_8 + _firstUpper_1);
                  String _plus_10 = (_plus_9 + ">");
                  output = (_output_4 + _plus_10);
                } else {
                  Environment _useEnv = fdt.getUseEnv();
                  boolean _tripleNotEquals_8 = (_useEnv != null);
                  if (_tripleNotEquals_8) {
                    String _output_5 = output;
                    String _name_6 = fdt.getObj().getName();
                    String _plus_11 = (_name_6 + "<");
                    String _firstUpper_2 = StringExtensions.toFirstUpper(fdt.getUseEnv().getName());
                    String _plus_12 = (_plus_11 + _firstUpper_2);
                    String _plus_13 = (_plus_12 + ">");
                    output = (_output_5 + _plus_13);
                  } else {
                    String _output_6 = output;
                    String _name_7 = fdt.getObj().getName();
                    output = (_output_6 + _name_7);
                  }
                }
              }
            }
          }
        }
      } else {
        PrimitiveType _type = fdt.getType();
        boolean _tripleNotEquals_9 = (_type != null);
        if (_tripleNotEquals_9) {
          String _output_7 = output;
          String _name_8 = fdt.getType().getName();
          output = (_output_7 + _name_8);
        }
      }
    } else {
      Symbol _agentFieldRef = f.getAgentFieldRef();
      boolean _tripleNotEquals_10 = (_agentFieldRef != null);
      if (_tripleNotEquals_10) {
        Symbol _agentFieldRef_1 = f.getAgentFieldRef();
        final AgentFieldReference afr = ((AgentFieldReference) _agentFieldRef_1);
        String _firstUpper_3 = StringExtensions.toFirstUpper(afr.getAgent().getName());
        String _plus_14 = ("agents." + _firstUpper_3);
        output = _plus_14;
      } else {
        Symbol _envFieldRef = f.getEnvFieldRef();
        boolean _tripleNotEquals_11 = (_envFieldRef != null);
        if (_tripleNotEquals_11) {
          Symbol _envFieldRef_1 = f.getEnvFieldRef();
          final EnvironmentFieldReference efr = ((EnvironmentFieldReference) _envFieldRef_1);
          String _firstUpper_4 = StringExtensions.toFirstUpper(efr.getEnv().getName());
          String _plus_15 = ("environments." + _firstUpper_4);
          output = _plus_15;
        } else {
          Symbol _grpFieldRef = f.getGrpFieldRef();
          boolean _tripleNotEquals_12 = (_grpFieldRef != null);
          if (_tripleNotEquals_12) {
            Symbol _grpFieldRef_1 = f.getGrpFieldRef();
            final GroupFieldReference gfr = ((GroupFieldReference) _grpFieldRef_1);
            String _firstUpper_5 = StringExtensions.toFirstUpper(gfr.getGrp().getName());
            String _plus_16 = ("groups." + _firstUpper_5);
            output = _plus_16;
          }
        }
      }
    }
    return output;
  }
  
  public static String getSymbolType(final Symbol t) {
    if ((t instanceof Field)) {
      return HelperFunctions.getFieldType(((Field) t));
    } else {
      final FunctionParameter fp = ((FunctionParameter) t);
      NonPrimitiveType _obj = fp.getObj();
      boolean _tripleNotEquals = (_obj != null);
      if (_tripleNotEquals) {
        NonPrimitiveType _obj_1 = fp.getObj();
        if ((_obj_1 instanceof uofa.lbirdsey.castle.casl.Object)) {
          return fp.getObj().getName();
        } else {
          NonPrimitiveType _obj_2 = fp.getObj();
          if ((_obj_2 instanceof uofa.lbirdsey.castle.casl.Enum)) {
            String _name = fp.getObj().getName();
            return ("Enums." + _name);
          }
        }
      } else {
        Agent _agent = fp.getAgent();
        boolean _tripleNotEquals_1 = (_agent != null);
        if (_tripleNotEquals_1) {
          return fp.getAgent().getName();
        } else {
          Environment _env = fp.getEnv();
          boolean _tripleNotEquals_2 = (_env != null);
          if (_tripleNotEquals_2) {
            return fp.getEnv().getName();
          } else {
            Group _grp = fp.getGrp();
            boolean _tripleNotEquals_3 = (_grp != null);
            if (_tripleNotEquals_3) {
              return fp.getGrp().getName();
            }
          }
        }
      }
    }
    return null;
  }
  
  public static String generateGettersSetters(final Field field) {
    return HelperFunctions.generateGettersSetters(field, false);
  }
  
  public static String generateGettersSetters(final Field field, final boolean makeStatic) {
    String output = "";
    boolean isStatic = makeStatic;
    Symbol _declaration = field.getDeclaration();
    boolean _tripleNotEquals = (_declaration != null);
    if (_tripleNotEquals) {
      Symbol _declaration_1 = field.getDeclaration();
      DataTypeDeclaration fiedecl = ((DataTypeDeclaration) _declaration_1);
      if (((fiedecl.getInitInclude() != null) || makeStatic)) {
        isStatic = true;
        String _output = output;
        String _firstUpper = StringExtensions.toFirstUpper(fiedecl.getName());
        String _plus = ("public static void set" + _firstUpper);
        String _plus_1 = (_plus + "(");
        output = (_output + _plus_1);
      } else {
        String _output_1 = output;
        String _firstUpper_1 = StringExtensions.toFirstUpper(fiedecl.getName());
        String _plus_2 = ("public void set" + _firstUpper_1);
        String _plus_3 = (_plus_2 + "(");
        output = (_output_1 + _plus_3);
      }
      PrimitiveType _type = fiedecl.getType();
      boolean _tripleNotEquals_1 = (_type != null);
      if (_tripleNotEquals_1) {
        String _output_2 = output;
        String _name = fiedecl.getType().getName();
        output = (_output_2 + _name);
      } else {
        NonPrimitiveType _obj = fiedecl.getObj();
        boolean _tripleNotEquals_2 = (_obj != null);
        if (_tripleNotEquals_2) {
          NonPrimitiveType _obj_1 = fiedecl.getObj();
          if ((_obj_1 instanceof uofa.lbirdsey.castle.casl.Object)) {
            NonPrimitiveType _obj_2 = fiedecl.getObj();
            uofa.lbirdsey.castle.casl.Object npt = ((uofa.lbirdsey.castle.casl.Object) _obj_2);
            String _output_3 = output;
            String _name_1 = npt.getName();
            output = (_output_3 + _name_1);
            NonPrimitiveType _useObj = fiedecl.getUseObj();
            boolean _tripleNotEquals_3 = (_useObj != null);
            if (_tripleNotEquals_3) {
              String _output_4 = output;
              String _name_2 = fiedecl.getUseObj().getName();
              String _plus_4 = ("<" + _name_2);
              String _plus_5 = (_plus_4 + ">");
              output = (_output_4 + _plus_5);
            } else {
              PrimitiveType _useType = fiedecl.getUseType();
              boolean _tripleNotEquals_4 = (_useType != null);
              if (_tripleNotEquals_4) {
                String _output_5 = output;
                String _name_3 = fiedecl.getUseType().getName();
                String _plus_6 = ("<" + _name_3);
                String _plus_7 = (_plus_6 + ">");
                output = (_output_5 + _plus_7);
              } else {
                Group _useGroup = fiedecl.getUseGroup();
                boolean _tripleNotEquals_5 = (_useGroup != null);
                if (_tripleNotEquals_5) {
                  String _output_6 = output;
                  String _name_4 = fiedecl.getUseGroup().getName();
                  String _plus_8 = ("<" + _name_4);
                  String _plus_9 = (_plus_8 + ">");
                  output = (_output_6 + _plus_9);
                } else {
                  Agent _useAgent = fiedecl.getUseAgent();
                  boolean _tripleNotEquals_6 = (_useAgent != null);
                  if (_tripleNotEquals_6) {
                    String _output_7 = output;
                    String _name_5 = fiedecl.getUseAgent().getName();
                    String _plus_10 = ("<" + _name_5);
                    String _plus_11 = (_plus_10 + ">");
                    output = (_output_7 + _plus_11);
                  } else {
                    Environment _useEnv = fiedecl.getUseEnv();
                    boolean _tripleNotEquals_7 = (_useEnv != null);
                    if (_tripleNotEquals_7) {
                      String _output_8 = output;
                      String _name_6 = fiedecl.getUseEnv().getName();
                      String _plus_12 = ("<" + _name_6);
                      String _plus_13 = (_plus_12 + ">");
                      output = (_output_8 + _plus_13);
                    }
                  }
                }
              }
            }
          } else {
            NonPrimitiveType _obj_3 = fiedecl.getObj();
            if ((_obj_3 instanceof uofa.lbirdsey.castle.casl.Enum)) {
              String _output_9 = output;
              String _name_7 = fiedecl.getObj().getName();
              output = (_output_9 + _name_7);
            }
          }
        }
      }
      if (((fiedecl.getInitInclude() != null) || makeStatic)) {
        String _output_10 = output;
        String _name_8 = fiedecl.getName();
        String _plus_14 = (" " + _name_8);
        String _plus_15 = (_plus_14 + "_) {\n\t");
        String _name_9 = fiedecl.getName();
        String _plus_16 = (_plus_15 + _name_9);
        String _plus_17 = (_plus_16 + " = ");
        String _name_10 = fiedecl.getName();
        String _plus_18 = (_plus_17 + _name_10);
        String _plus_19 = (_plus_18 + "_;\n}\n");
        output = (_output_10 + _plus_19);
        String _output_11 = output;
        output = (_output_11 + "public static ");
      } else {
        String _output_12 = output;
        String _name_11 = fiedecl.getName();
        String _plus_20 = (" " + _name_11);
        String _plus_21 = (_plus_20 + "_) {\n\tthis.");
        String _name_12 = fiedecl.getName();
        String _plus_22 = (_plus_21 + _name_12);
        String _plus_23 = (_plus_22 + " = ");
        String _name_13 = fiedecl.getName();
        String _plus_24 = (_plus_23 + _name_13);
        String _plus_25 = (_plus_24 + "_;\n}\n");
        output = (_output_12 + _plus_25);
        String _output_13 = output;
        output = (_output_13 + "public ");
      }
      PrimitiveType _type_1 = fiedecl.getType();
      boolean _tripleNotEquals_8 = (_type_1 != null);
      if (_tripleNotEquals_8) {
        String _output_14 = output;
        String _name_14 = fiedecl.getType().getName();
        output = (_output_14 + _name_14);
      } else {
        NonPrimitiveType _obj_4 = fiedecl.getObj();
        boolean _tripleNotEquals_9 = (_obj_4 != null);
        if (_tripleNotEquals_9) {
          NonPrimitiveType _obj_5 = fiedecl.getObj();
          if ((_obj_5 instanceof uofa.lbirdsey.castle.casl.Object)) {
            NonPrimitiveType _obj_6 = fiedecl.getObj();
            uofa.lbirdsey.castle.casl.Object npt_1 = ((uofa.lbirdsey.castle.casl.Object) _obj_6);
            String _output_15 = output;
            String _name_15 = npt_1.getName();
            output = (_output_15 + _name_15);
            NonPrimitiveType _useObj_1 = fiedecl.getUseObj();
            boolean _tripleNotEquals_10 = (_useObj_1 != null);
            if (_tripleNotEquals_10) {
              String _output_16 = output;
              String _name_16 = fiedecl.getUseObj().getName();
              String _plus_26 = ("<" + _name_16);
              String _plus_27 = (_plus_26 + ">");
              output = (_output_16 + _plus_27);
            } else {
              PrimitiveType _useType_1 = fiedecl.getUseType();
              boolean _tripleNotEquals_11 = (_useType_1 != null);
              if (_tripleNotEquals_11) {
                String _output_17 = output;
                String _name_17 = fiedecl.getUseType().getName();
                String _plus_28 = ("<" + _name_17);
                String _plus_29 = (_plus_28 + ">");
                output = (_output_17 + _plus_29);
              } else {
                Group _useGroup_1 = fiedecl.getUseGroup();
                boolean _tripleNotEquals_12 = (_useGroup_1 != null);
                if (_tripleNotEquals_12) {
                  String _output_18 = output;
                  String _name_18 = fiedecl.getUseGroup().getName();
                  String _plus_30 = ("<" + _name_18);
                  String _plus_31 = (_plus_30 + ">");
                  output = (_output_18 + _plus_31);
                } else {
                  Agent _useAgent_1 = fiedecl.getUseAgent();
                  boolean _tripleNotEquals_13 = (_useAgent_1 != null);
                  if (_tripleNotEquals_13) {
                    String _output_19 = output;
                    String _name_19 = fiedecl.getUseAgent().getName();
                    String _plus_32 = ("<" + _name_19);
                    String _plus_33 = (_plus_32 + ">");
                    output = (_output_19 + _plus_33);
                  } else {
                    Environment _useEnv_1 = fiedecl.getUseEnv();
                    boolean _tripleNotEquals_14 = (_useEnv_1 != null);
                    if (_tripleNotEquals_14) {
                      String _output_20 = output;
                      String _name_20 = fiedecl.getUseEnv().getName();
                      String _plus_34 = ("<" + _name_20);
                      String _plus_35 = (_plus_34 + ">");
                      output = (_output_20 + _plus_35);
                    }
                  }
                }
              }
            }
          } else {
            NonPrimitiveType _obj_7 = fiedecl.getObj();
            if ((_obj_7 instanceof uofa.lbirdsey.castle.casl.Enum)) {
              String _output_21 = output;
              String _name_21 = fiedecl.getObj().getName();
              output = (_output_21 + _name_21);
            }
          }
        }
      }
      if (((fiedecl.getInitInclude() != null) || makeStatic)) {
        String _output_22 = output;
        String _firstUpper_2 = StringExtensions.toFirstUpper(fiedecl.getName());
        String _plus_36 = (" get" + _firstUpper_2);
        String _plus_37 = (_plus_36 + "() {\n\treturn ");
        String _name_22 = fiedecl.getName();
        String _plus_38 = (_plus_37 + _name_22);
        String _plus_39 = (_plus_38 + ";\n}\n");
        output = (_output_22 + _plus_39);
      } else {
        String _output_23 = output;
        String _firstUpper_3 = StringExtensions.toFirstUpper(fiedecl.getName());
        String _plus_40 = (" get" + _firstUpper_3);
        String _plus_41 = (_plus_40 + "() {\n\treturn this.");
        String _name_23 = fiedecl.getName();
        String _plus_42 = (_plus_41 + _name_23);
        String _plus_43 = (_plus_42 + ";\n}\n");
        output = (_output_23 + _plus_43);
      }
    } else {
      Symbol _agentFieldRef = field.getAgentFieldRef();
      boolean _tripleNotEquals_15 = (_agentFieldRef != null);
      if (_tripleNotEquals_15) {
        Symbol _agentFieldRef_1 = field.getAgentFieldRef();
        AgentFieldReference fieagent = ((AgentFieldReference) _agentFieldRef_1);
        String _output_24 = output;
        String _firstUpper_4 = StringExtensions.toFirstUpper(fieagent.getName());
        String _plus_44 = ("public void set" + _firstUpper_4);
        String _plus_45 = (_plus_44 + "(");
        String _name_24 = fieagent.getAgent().getName();
        String _plus_46 = (_plus_45 + _name_24);
        String _plus_47 = (_plus_46 + " ");
        String _name_25 = fieagent.getName();
        String _plus_48 = (_plus_47 + _name_25);
        String _plus_49 = (_plus_48 + ")");
        output = (_output_24 + _plus_49);
        String _output_25 = output;
        String _name_26 = fieagent.getName();
        String _plus_50 = ("{\n\t\tthis." + _name_26);
        String _plus_51 = (_plus_50 + " = ");
        String _name_27 = fieagent.getName();
        String _plus_52 = (_plus_51 + _name_27);
        String _plus_53 = (_plus_52 + ";\n}\n");
        output = (_output_25 + _plus_53);
        String _output_26 = output;
        String _name_28 = fieagent.getAgent().getName();
        String _plus_54 = ("public " + _name_28);
        String _plus_55 = (_plus_54 + " get");
        String _firstUpper_5 = StringExtensions.toFirstUpper(fieagent.getName());
        String _plus_56 = (_plus_55 + _firstUpper_5);
        String _plus_57 = (_plus_56 + "() {\n\treturn this.");
        String _name_29 = fieagent.getName();
        String _plus_58 = (_plus_57 + _name_29);
        String _plus_59 = (_plus_58 + ";\n}\n");
        output = (_output_26 + _plus_59);
      } else {
        Symbol _envFieldRef = field.getEnvFieldRef();
        boolean _tripleNotEquals_16 = (_envFieldRef != null);
        if (_tripleNotEquals_16) {
          Symbol _envFieldRef_1 = field.getEnvFieldRef();
          EnvironmentFieldReference fieenv = ((EnvironmentFieldReference) _envFieldRef_1);
          String _output_27 = output;
          String _firstUpper_6 = StringExtensions.toFirstUpper(fieenv.getName());
          String _plus_60 = ("public void set" + _firstUpper_6);
          String _plus_61 = (_plus_60 + "(");
          String _name_30 = fieenv.getEnv().getName();
          String _plus_62 = (_plus_61 + _name_30);
          String _plus_63 = (_plus_62 + " ");
          String _name_31 = fieenv.getName();
          String _plus_64 = (_plus_63 + _name_31);
          String _plus_65 = (_plus_64 + 
            ") {\n\t\tthis.");
          String _name_32 = fieenv.getName();
          String _plus_66 = (_plus_65 + _name_32);
          String _plus_67 = (_plus_66 + " = ");
          String _name_33 = fieenv.getName();
          String _plus_68 = (_plus_67 + _name_33);
          String _plus_69 = (_plus_68 + ";\n}\n");
          output = (_output_27 + _plus_69);
          String _output_28 = output;
          String _name_34 = fieenv.getEnv().getName();
          String _plus_70 = ("public " + _name_34);
          String _plus_71 = (_plus_70 + " get");
          String _firstUpper_7 = StringExtensions.toFirstUpper(fieenv.getName());
          String _plus_72 = (_plus_71 + _firstUpper_7);
          String _plus_73 = (_plus_72 + "() {\n\treturn this.");
          String _name_35 = fieenv.getName();
          String _plus_74 = (_plus_73 + _name_35);
          String _plus_75 = (_plus_74 + 
            ";\n}\n");
          output = (_output_28 + _plus_75);
        }
      }
    }
    return output;
  }
  
  public static String locateType(final String candidate) {
    ArrayList<EObject> _types = Helpers.getTypes();
    for (final EObject type : _types) {
      if ((type instanceof Type)) {
        Type tat = ((Type) type);
        if ((tat instanceof uofa.lbirdsey.castle.casl.Object)) {
          String _custom = ((uofa.lbirdsey.castle.casl.Object) tat).getCustom();
          boolean _tripleNotEquals = (_custom != null);
          if (_tripleNotEquals) {
            int _compareToIgnoreCase = ((Type) type).getName().compareToIgnoreCase(candidate);
            boolean _equals = (_compareToIgnoreCase == 0);
            if (_equals) {
              String _name = ((Type)type).getName();
              return ("CUSTOM:" + _name);
            }
          }
        }
        int _compareToIgnoreCase_1 = ((Type) type).getName().compareToIgnoreCase(candidate);
        boolean _equals_1 = (_compareToIgnoreCase_1 == 0);
        if (_equals_1) {
          return ((Type)type).getName();
        }
      } else {
        if ((type instanceof Agent)) {
          int _compareToIgnoreCase_2 = ((Agent) type).getName().compareToIgnoreCase(candidate);
          boolean _equals_2 = (_compareToIgnoreCase_2 == 0);
          if (_equals_2) {
            String _name_1 = ((Agent)type).getName();
            return ("agents." + _name_1);
          }
        } else {
          if ((type instanceof Environment)) {
            int _compareToIgnoreCase_3 = ((Environment) type).getName().compareToIgnoreCase(candidate);
            boolean _equals_3 = (_compareToIgnoreCase_3 == 0);
            if (_equals_3) {
              String _name_2 = ((Environment)type).getName();
              return ("environments." + _name_2);
            }
          } else {
            if ((type instanceof Group)) {
              int _compareToIgnoreCase_4 = ((Group) type).getName().compareToIgnoreCase(candidate);
              boolean _equals_4 = (_compareToIgnoreCase_4 == 0);
              if (_equals_4) {
                String _name_3 = ((Group)type).getName();
                return ("groups." + _name_3);
              }
            }
          }
        }
      }
    }
    return ("TYPE NOT FOUND: " + candidate);
  }
  
  public static String parseTypesAsString(final String iC, final String systemRoot) {
    String output = "";
    boolean _contains = iC.contains("List");
    if (_contains) {
      output = "import java.util.List;";
      return output;
    }
    boolean _contains_1 = iC.contains("string");
    if (_contains_1) {
      return output;
    }
    boolean _contains_2 = iC.contains("LayoutParameters");
    if (_contains_2) {
      return output;
    } else {
      if ((((iC.endsWith("Continuous") || iC.endsWith("Grid")) || iC.endsWith("string")) || iC.endsWith("Vector2"))) {
        return output;
      }
    }
    if (((iC.startsWith("agents.") || iC.startsWith("groups.")) || iC.startsWith("environments."))) {
      String _output = output;
      output = (_output + (((("import " + systemRoot) + ".") + iC) + ";"));
    } else {
      boolean _startsWith = iC.startsWith("CUSTOM:");
      if (_startsWith) {
        String object = iC.split(":")[1];
        boolean _startsWith_1 = object.startsWith("Enums");
        if (_startsWith_1) {
          String _output_1 = output;
          output = (_output_1 + (((("import " + systemRoot) + ".") + object) + ";"));
        } else {
          String _output_2 = output;
          output = (_output_2 + (((("import " + systemRoot) + ".objects.") + object) + ";"));
        }
      } else {
        boolean _contains_3 = iC.contains("<");
        if (_contains_3) {
          int typeBegin = iC.indexOf("<");
          String paramType = iC.substring(0, typeBegin);
          boolean _checkForReservedLayoutWords = HelperFunctions.checkForReservedLayoutWords(paramType);
          boolean _not = (!_checkForReservedLayoutWords);
          if (_not) {
            String _output_3 = output;
            String _substring = iC.substring(0, typeBegin);
            String _plus = ("import castleComponents.objects." + _substring);
            String _plus_1 = (_plus + ";");
            output = (_output_3 + _plus_1);
          }
          int typeEnd = iC.indexOf(">");
          String _output_4 = output;
          String _parseTypesAsString = HelperFunctions.parseTypesAsString(HelperFunctions.locateType(iC.substring((typeBegin + 1), typeEnd)), systemRoot);
          output = (_output_4 + _parseTypesAsString);
        } else {
          boolean _startsWith_2 = iC.startsWith("Enums.");
          if (_startsWith_2) {
            String _output_5 = output;
            output = (_output_5 + (("import castleComponents." + iC) + ";"));
          } else {
            if ((iC.startsWith("int") || (iC.startsWith("bool") || iC.startsWith("float")))) {
              output = "";
            } else {
              int _length = iC.length();
              boolean _greaterThan = (_length > 0);
              if (_greaterThan) {
                boolean _checkForReservedLayoutWords_1 = HelperFunctions.checkForReservedLayoutWords(iC);
                boolean _not_1 = (!_checkForReservedLayoutWords_1);
                if (_not_1) {
                  String _output_6 = output;
                  output = (_output_6 + (("import castleComponents.objects." + iC) + ";"));
                }
              }
            }
          }
        }
      }
    }
    return output;
  }
  
  public static boolean checkForReservedLayoutWords(final String str) {
    return (((((str.compareToIgnoreCase("continuous") == 0) || 
      (str.compareToIgnoreCase("grid") == 0)) || 
      (str.compareToIgnoreCase("network") == 0)) || 
      (str.compareToIgnoreCase("map2d") == 0)) || 
      (str.compareToIgnoreCase("torus") == 0));
  }
  
  public static String parseTypesAsType(final EObject iC, final String systemRoot) {
    String output = "";
    String ss = HelperFunctions.getFieldType(((Field) iC));
    return output;
  }
  
  public static String initialiseFunctionParameterReturn(final FunctionParameter fp) {
    PrimitiveType _type = fp.getType();
    boolean _tripleNotEquals = (_type != null);
    if (_tripleNotEquals) {
      PrimitiveType _type_1 = fp.getType();
      if ((_type_1 instanceof IntType)) {
        return "-0";
      } else {
        PrimitiveType _type_2 = fp.getType();
        if ((_type_2 instanceof FloatType)) {
          return "-0.0";
        } else {
          PrimitiveType _type_3 = fp.getType();
          if ((_type_3 instanceof BooleanType)) {
            return "false";
          } else {
            PrimitiveType _type_4 = fp.getType();
            if ((_type_4 instanceof StringType)) {
              return "";
            }
          }
        }
      }
    } else {
      NonPrimitiveType _obj = fp.getObj();
      boolean _tripleNotEquals_1 = (_obj != null);
      if (_tripleNotEquals_1) {
        return "null";
      }
    }
    return null;
  }
  
  public static String metric_ToOutput(final Entity_Feature ef, final CASL_Macro_MetricSwitch mc) {
    String output = "";
    if ((ef instanceof Interaction)) {
      final Interaction in = ((Interaction) ef);
      final String interType = in.getInteraction_type().getName();
      EList<Symbol> _functionParameters = in.getFunctionParameters();
      for (final Symbol p : _functionParameters) {
        {
          final FunctionParameter fp = ((FunctionParameter) p);
          if ((((fp.getAgent() != null) || (fp.getEnv() != null)) || (fp.getGrp() != null))) {
            String _output = output;
            String _name = fp.getName();
            String _plus = ("addInteraction(" + _name);
            String _plus_1 = (_plus + ", InteractionType.");
            String _upperCase = interType.toUpperCase();
            String _plus_2 = (_plus_1 + _upperCase);
            String _plus_3 = (_plus_2 + ", \"");
            String _name_1 = in.getName();
            String _plus_4 = (_plus_3 + _name_1);
            String _plus_5 = (_plus_4 + "\");\n");
            output = (_output + _plus_5);
          }
        }
      }
      EList<EObject> _body = in.getBody();
      for (final EObject b : _body) {
        {
          final EObject featureType = HelperFunctions.getInteractionFromStatement(b);
          if ((featureType instanceof GroupInternalInteractionsFeatureCall)) {
            final GroupInternalInteractionsFeatureCall gii = ((GroupInternalInteractionsFeatureCall) featureType);
            String _output = output;
            String _name = gii.getGrp().getName();
            String _plus = ("addInteraction(" + _name);
            String _plus_1 = (_plus + ", InteractionType.");
            String _upperCase = interType.toUpperCase();
            String _plus_2 = (_plus_1 + _upperCase);
            String _plus_3 = (_plus_2 + ", \"");
            String _name_1 = in.getName();
            String _plus_4 = (_plus_3 + _name_1);
            String _plus_5 = (_plus_4 + "\");\n");
            output = (_output + _plus_5);
          } else {
            if ((featureType instanceof AgentInteractionFeatureCall)) {
              final AgentInteractionFeatureCall gii_1 = ((AgentInteractionFeatureCall) featureType);
              String _output_1 = output;
              String _name_2 = gii_1.getAgt().getName();
              String _plus_6 = ("addInteraction(" + _name_2);
              String _plus_7 = (_plus_6 + ", InteractionType.");
              String _upperCase_1 = interType.toUpperCase();
              String _plus_8 = (_plus_7 + _upperCase_1);
              String _plus_9 = (_plus_8 + ", \"");
              String _name_3 = in.getName();
              String _plus_10 = (_plus_9 + _name_3);
              String _plus_11 = (_plus_10 + "\");\n");
              output = (_output_1 + _plus_11);
            } else {
              if ((featureType instanceof GroupExternalInteractionFeatureCall)) {
                final GroupExternalInteractionFeatureCall gii_2 = ((GroupExternalInteractionFeatureCall) featureType);
                String _output_2 = output;
                String _name_4 = gii_2.getGrp().getName();
                String _plus_12 = ("addInteraction(" + _name_4);
                String _plus_13 = (_plus_12 + ", InteractionType.");
                String _upperCase_2 = interType.toUpperCase();
                String _plus_14 = (_plus_13 + _upperCase_2);
                String _plus_15 = (_plus_14 + ", \"");
                String _name_5 = in.getName();
                String _plus_16 = (_plus_15 + _name_5);
                String _plus_17 = (_plus_16 + "\");\n");
                output = (_output_2 + _plus_17);
              } else {
                if ((featureType instanceof EnvironmentInteractionFeatureCall)) {
                  final EnvironmentInteractionFeatureCall gii_3 = ((EnvironmentInteractionFeatureCall) featureType);
                  String _output_3 = output;
                  String _name_6 = gii_3.getEnv().getName();
                  String _plus_18 = ("addInteraction(" + _name_6);
                  String _plus_19 = (_plus_18 + ", InteractionType.");
                  String _upperCase_3 = interType.toUpperCase();
                  String _plus_20 = (_plus_19 + _upperCase_3);
                  String _plus_21 = (_plus_20 + ", \"");
                  String _name_7 = in.getName();
                  String _plus_22 = (_plus_21 + _name_7);
                  String _plus_23 = (_plus_22 + "\");\n");
                  output = (_output_3 + _plus_23);
                }
              }
            }
          }
        }
      }
    } else {
      if ((ef instanceof Behavior)) {
        final Behavior be = ((Behavior) ef);
        String _output = output;
        String _name = be.getName();
        String _plus = ("updateFeature(\"" + _name);
        String _plus_1 = (_plus + "\",FeatureTypes.BEHAVIOR)");
        String _plus_2 = (_plus_1 + Constants.LINE_END);
        output = (_output + _plus_2);
        EList<EObject> _body_1 = be.getBody();
        for (final EObject beb : _body_1) {
        }
      } else {
        if ((ef instanceof AdaptiveProcess)) {
          final AdaptiveProcess ap = ((AdaptiveProcess) ef);
          String _output_1 = output;
          String _name_1 = ap.getName();
          String _plus_3 = ("updateFeature(\"" + _name_1);
          String _plus_4 = (_plus_3 + "\",FeatureTypes.ADAPTATION)");
          String _plus_5 = (_plus_4 + Constants.LINE_END);
          output = (_output_1 + _plus_5);
        } else {
          if ((ef instanceof GroupExternalInteraction)) {
            final GroupExternalInteraction ei = ((GroupExternalInteraction) ef);
            String _output_2 = output;
            String _name_2 = ei.getName();
            String _plus_6 = ("updateFeature(\"" + _name_2);
            String _plus_7 = (_plus_6 + "\",FeatureTypes.EXTERNAL_INTERACTION)");
            String _plus_8 = (_plus_7 + Constants.LINE_END);
            output = (_output_2 + _plus_8);
          } else {
            if ((ef instanceof GroupInternalInteraction)) {
              final GroupInternalInteraction ii = ((GroupInternalInteraction) ef);
              String _output_3 = output;
              String _name_3 = ii.getName();
              String _plus_9 = ("updateFeature(\"" + _name_3);
              String _plus_10 = (_plus_9 + "\",FeatureTypes.INTERNAL_INTERACTION)");
              String _plus_11 = (_plus_10 + Constants.LINE_END);
              output = (_output_3 + _plus_11);
            }
          }
        }
      }
    }
    EList<Expression> _manualUpdates = mc.getManualUpdates();
    boolean _tripleNotEquals = (_manualUpdates != null);
    if (_tripleNotEquals) {
      EList<Expression> _manualUpdates_1 = mc.getManualUpdates();
      for (final Expression ex : _manualUpdates_1) {
        {
          String _output_4 = output;
          output = (_output_4 + "updateParameter(\"");
          Object _printExpression = Printers.printExpression(ex);
          String _plus_12 = (_printExpression + "\", ");
          Object _printExpression_1 = Printers.printExpression(ex);
          String _plus_13 = (_plus_12 + _printExpression_1);
          String _plus_14 = (_plus_13 + ")");
          /* (_plus_14 + Constants.LINE_END); */
        }
      }
    }
    return output;
  }
  
  public static String debug_PrintBehavior(final Behavior b) {
    String _name = b.getName();
    String _plus = ("Behavior: " + _name);
    String _plus_1 = (_plus + ", ");
    BehaviorType _behavior_type = b.getBehavior_type();
    String _plus_2 = (_plus_1 + _behavior_type);
    String _plus_3 = (_plus_2 + ", ");
    BehaviorReactionTime _behavior_reaction_time = b.getBehavior_reaction_time();
    return (_plus_3 + _behavior_reaction_time);
  }
  
  public static String debug_PrintInteraction(final Interaction i) {
    String _name = i.getName();
    String _plus = ("Interaction: " + _name);
    String _plus_1 = (_plus + ", ");
    InteractionType _interaction_type = i.getInteraction_type();
    String _plus_2 = (_plus_1 + _interaction_type);
    String _plus_3 = (_plus_2 + ", ");
    InteractionTriggerTypes _trigger_type = i.getTrigger_type();
    return (_plus_3 + _trigger_type);
  }
  
  /**
   * We are going about this in the wrong way
   * 1: Figure out return types
   * 2: Make sure each possible return location matches the same type
   * 3: Place "return" where these locations are as going through the body instead of this poor approach
   * Logic:
   * 	1: Go through the body.
   * 	2:
   */
  public static String printMethodBody(final EList<EObject> body, final Entity_Feature caller) {
    String output = "";
    String returnType = HelperFunctions.inferMethodType(body);
    String returnPrint = "";
    boolean _equals = Objects.equal(returnType, "void");
    if (_equals) {
      for (final EObject statement : body) {
        String _output = output;
        String _parseBodyElement = HelperFunctions.parseBodyElement(statement, caller);
        String _plus = (Constants.TAB + _parseBodyElement);
        String _plus_1 = (_plus + Constants.NL);
        output = (_output + _plus_1);
      }
    } else {
      for (int i = 0; (i < (body.size() - 1)); i++) {
        {
          EObject statement_1 = body.get(i);
          String _output_1 = output;
          String _parseBodyElement_1 = HelperFunctions.parseBodyElement(statement_1, caller);
          String _plus_2 = (Constants.TAB + _parseBodyElement_1);
          String _plus_3 = (_plus_2 + Constants.NL);
          output = (_output_1 + _plus_3);
        }
      }
      EObject finalLine = IterableExtensions.<EObject>head(ListExtensions.<EObject>reverseView(body));
      if ((finalLine instanceof Field)) {
        String _output_1 = output;
        String _parseBodyElement_1 = HelperFunctions.parseBodyElement(finalLine, caller);
        String _plus_2 = (Constants.TAB + _parseBodyElement_1);
        String _plus_3 = (_plus_2 + Constants.NL);
        output = (_output_1 + _plus_3);
        Field ff = ((Field) finalLine);
        Symbol _declaration = ff.getDeclaration();
        boolean _tripleNotEquals = (_declaration != null);
        if (_tripleNotEquals) {
          String _returnPrint = returnPrint;
          Symbol _declaration_1 = ff.getDeclaration();
          String _name = ((DataTypeDeclaration) _declaration_1).getName();
          String _plus_4 = ((Constants.TAB + Constants.RETURN_) + _name);
          returnPrint = (_returnPrint + _plus_4);
        } else {
          Symbol _agentFieldRef = ff.getAgentFieldRef();
          boolean _tripleNotEquals_1 = (_agentFieldRef != null);
          if (_tripleNotEquals_1) {
            String _returnPrint_1 = returnPrint;
            Symbol _agentFieldRef_1 = ff.getAgentFieldRef();
            String _name_1 = ((AgentFieldReference) _agentFieldRef_1).getName();
            String _plus_5 = ((Constants.TAB + Constants.RETURN_) + _name_1);
            returnPrint = (_returnPrint_1 + _plus_5);
          } else {
            Symbol _envFieldRef = ff.getEnvFieldRef();
            boolean _tripleNotEquals_2 = (_envFieldRef != null);
            if (_tripleNotEquals_2) {
              String _returnPrint_2 = returnPrint;
              Symbol _envFieldRef_1 = ff.getEnvFieldRef();
              String _name_2 = ((EnvironmentFieldReference) _envFieldRef_1).getName();
              String _plus_6 = ((Constants.TAB + Constants.RETURN_) + _name_2);
              returnPrint = (_returnPrint_2 + _plus_6);
            } else {
              Symbol _grpFieldRef = ff.getGrpFieldRef();
              boolean _tripleNotEquals_3 = (_grpFieldRef != null);
              if (_tripleNotEquals_3) {
                String _returnPrint_3 = returnPrint;
                Symbol _grpFieldRef_1 = ff.getGrpFieldRef();
                String _name_3 = ((GroupFieldReference) _grpFieldRef_1).getName();
                String _plus_7 = ((Constants.TAB + Constants.RETURN_) + _name_3);
                returnPrint = (_returnPrint_3 + _plus_7);
              }
            }
          }
        }
      } else {
        if ((finalLine instanceof Expression)) {
          Expression ee = ((Expression) finalLine);
          if ((ee instanceof IfStatement)) {
            String _returnPrint_4 = returnPrint;
            String _printIfStatement = Printers.printIfStatement(((IfStatement) ee), 1, true);
            String _plus_8 = (Constants.TAB + _printIfStatement);
            returnPrint = (_returnPrint_4 + _plus_8);
          } else {
            if ((ee instanceof ForLoop)) {
            } else {
              if ((ee instanceof ForEachLoop)) {
              } else {
                String _returnPrint_5 = returnPrint;
                Object _printExpression = Printers.printExpression(ee);
                String _plus_9 = (Constants.RETURN_ + _printExpression);
                returnPrint = (_returnPrint_5 + _plus_9);
              }
            }
          }
        } else {
          if ((finalLine instanceof SelfAssignedFormula)) {
            SelfAssignedFormula saf = ((SelfAssignedFormula) finalLine);
            String _output_2 = output;
            String _printSelfAssignedFormula = HelperFunctions.printSelfAssignedFormula(saf);
            String _plus_10 = (Constants.TAB + _printSelfAssignedFormula);
            String _plus_11 = (_plus_10 + Constants.NL);
            output = (_output_2 + _plus_11);
            String _returnPrint_6 = returnPrint;
            String _name_4 = saf.getRef().getName();
            String _plus_12 = (((Constants.TAB + Constants.RETURN_) + "this.") + _name_4);
            returnPrint = (_returnPrint_6 + _plus_12);
          } else {
            if ((finalLine instanceof Formula)) {
              Formula saf_1 = ((Formula) finalLine);
              String _output_3 = output;
              String _printFormula = HelperFunctions.printFormula(saf_1);
              String _plus_13 = (Constants.TAB + _printFormula);
              String _plus_14 = (_plus_13 + Constants.NL);
              output = (_output_3 + _plus_14);
              String _returnPrint_7 = returnPrint;
              String _name_5 = saf_1.getSym().getName();
              String _plus_15 = (((Constants.TAB + Constants.RETURN_) + "this.") + _name_5);
              returnPrint = (_returnPrint_7 + _plus_15);
            } else {
            }
          }
        }
      }
      String _output_4 = output;
      output = (_output_4 + (((Constants.TAB + returnPrint) + ";") + Constants.NL));
    }
    return output;
  }
  
  public static ArrayList<String> populateImports(final EList<EObject> body) {
    ArrayList<String> out = new ArrayList<String>();
    for (final EObject statement : body) {
      if ((statement instanceof Field)) {
        out.add(HelperFunctions.getFieldType(((Field) statement)));
      }
    }
    return out;
  }
  
  public static HashSet<String> parseImportsForGeneration(final ArrayList<String> libImports, final String sysRoot) {
    HashSet<String> importsToPrint = new HashSet<String>();
    for (final String iC : libImports) {
      if ((iC != null)) {
        String str = HelperFunctions.parseTypesAsString(iC, sysRoot);
        String[] splt = str.split(";");
        for (final String s : splt) {
          int _length = s.length();
          boolean _greaterThan = (_length > 0);
          if (_greaterThan) {
            importsToPrint.add((s + ";"));
          }
        }
      }
    }
    return importsToPrint;
  }
  
  /**
   * This turns primitives and common CASLisms into the correct Javaisms
   */
  public static String javafy(final String in) {
    if (in != null) {
      switch (in) {
        case "int":
          return "Integer";
        case "string":
          return "String";
        case "float":
          return "Float";
        default:
          return in;
      }
    } else {
      return in;
    }
  }
}
