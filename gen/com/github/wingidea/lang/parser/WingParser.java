// This is a generated file. Not intended for manual editing.
package com.github.wingidea.lang.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.wingidea.lang.psi.WingElementTypes.*;
import static com.github.wingidea.lang.parser.WingParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class WingParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return Schema(b, l + 1);
  }

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(AWAIT_EXPRESSION, BINARY_EXPRESSION, DEFER_EXPRESSION, EXPRESSION,
      NEW_EXPRESSION, PARENTHESIZED_EXPRESSION, REFERENCE_EXPRESSION, STRUCTURED_ACCESS_EXPRESSION,
      UNARY_EXPRESSION),
  };

  /* ********************************************************** */
  // PUBLIC
  //     | PROTECTED
  //     | INTERNAL
  public static boolean AccessModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AccessModifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ACCESS_MODIFIER, "<access modifier>");
    r = consumeToken(b, PUBLIC);
    if (!r) r = consumeToken(b, PROTECTED);
    if (!r) r = consumeToken(b, INTERNAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOT
  //     | '?.'
  public static boolean Accessor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Accessor")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ACCESSOR, "<accessor>");
    r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, "?.");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PositionalArgument
  //     | KeywordArgument
  public static boolean Argument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Argument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGUMENT, "<argument>");
    r = PositionalArgument(b, l + 1);
    if (!r) r = KeywordArgument(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LEFT_PARENTHESIS (Argument (COMMA Argument)* COMMA?)? RIGHT_PARENTHESIS
  public static boolean ArgumentList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PARENTHESIS);
    r = r && ArgumentList_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESIS);
    exit_section_(b, m, ARGUMENT_LIST, r);
    return r;
  }

  // (Argument (COMMA Argument)* COMMA?)?
  private static boolean ArgumentList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1")) return false;
    ArgumentList_1_0(b, l + 1);
    return true;
  }

  // Argument (COMMA Argument)* COMMA?
  private static boolean ArgumentList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Argument(b, l + 1);
    r = r && ArgumentList_1_0_1(b, l + 1);
    r = r && ArgumentList_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA Argument)*
  private static boolean ArgumentList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ArgumentList_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ArgumentList_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA Argument
  private static boolean ArgumentList_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Argument(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean ArgumentList_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArgumentList_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // BuiltInContainerType? LEFT_SQUARE_BRACE Expression (COMMA Expression)* COMMA? RIGHT_SQUARE_BRACE
  public static boolean ArrayLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARRAY_LITERAL, "<array literal>");
    r = ArrayLiteral_0(b, l + 1);
    r = r && consumeToken(b, LEFT_SQUARE_BRACE);
    r = r && Expression(b, l + 1);
    r = r && ArrayLiteral_3(b, l + 1);
    r = r && ArrayLiteral_4(b, l + 1);
    r = r && consumeToken(b, RIGHT_SQUARE_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BuiltInContainerType?
  private static boolean ArrayLiteral_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayLiteral_0")) return false;
    BuiltInContainerType(b, l + 1);
    return true;
  }

  // (COMMA Expression)*
  private static boolean ArrayLiteral_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayLiteral_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ArrayLiteral_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ArrayLiteral_3", c)) break;
    }
    return true;
  }

  // COMMA Expression
  private static boolean ArrayLiteral_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayLiteral_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean ArrayLiteral_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ArrayLiteral_4")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // ASSIGNMENT
  //     | PLUS_ASSIGNMENT
  //     | MINUS_ASSIGNMENT
  public static boolean AssignmentOperator(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AssignmentOperator")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGNMENT_OPERATOR, "<assignment operator>");
    r = consumeToken(b, ASSIGNMENT);
    if (!r) r = consumeToken(b, PLUS_ASSIGNMENT);
    if (!r) r = consumeToken(b, MINUS_ASSIGNMENT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // AWAIT Expression
  public static boolean AwaitExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "AwaitExpression")) return false;
    if (!nextTokenIs(b, AWAIT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, AWAIT);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, AWAIT_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // Expression Operators Expression
  public static boolean BinaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BinaryExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINARY_EXPRESSION, "<binary expression>");
    r = Expression(b, l + 1);
    r = r && Operators(b, l + 1);
    r = r && Expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LEFT_CURLY_BRACE Statement* RIGHT_CURLY_BRACE
  public static boolean Block(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Block")) return false;
    if (!nextTokenIs(b, LEFT_CURLY_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_CURLY_BRACE);
    r = r && Block_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACE);
    exit_section_(b, m, BLOCK, r);
    return r;
  }

  // Statement*
  private static boolean Block_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Block_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Block_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // BREAK SEMICOLON
  public static boolean BreakStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BreakStatement")) return false;
    if (!nextTokenIs(b, BREAK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, BREAK, SEMICOLON);
    exit_section_(b, m, BREAK_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // ImmutableContainerType
  //     | MutableContainerType
  static boolean BuiltInContainerType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInContainerType")) return false;
    boolean r;
    r = ImmutableContainerType(b, l + 1);
    if (!r) r = MutableContainerType(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // "num"
  //     | "bool"
  //     | "any"
  //     | "str"
  //     | "void"
  //     | "duration"
  //     | "datetime"
  //     | "regex"
  //     | "bytes"
  static boolean BuiltInType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "BuiltInType")) return false;
    boolean r;
    r = consumeToken(b, "num");
    if (!r) r = consumeToken(b, "bool");
    if (!r) r = consumeToken(b, "any");
    if (!r) r = consumeToken(b, "str");
    if (!r) r = consumeToken(b, "void");
    if (!r) r = consumeToken(b, "duration");
    if (!r) r = consumeToken(b, "datetime");
    if (!r) r = consumeToken(b, "regex");
    if (!r) r = consumeToken(b, "bytes");
    return r;
  }

  /* ********************************************************** */
  // (Expression | SuperCall) ArgumentList
  public static boolean Call(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Call")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CALL, "<call>");
    r = Call_0(b, l + 1);
    r = r && ArgumentList(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Expression | SuperCall
  private static boolean Call_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Call_0")) return false;
    boolean r;
    r = Expression(b, l + 1);
    if (!r) r = SuperCall(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // CATCH (IDENTIFIER | ParenthesizedIdentifier)? Block
  public static boolean CatchBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CatchBlock")) return false;
    if (!nextTokenIs(b, CATCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CATCH);
    r = r && CatchBlock_1(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, CATCH_BLOCK, r);
    return r;
  }

  // (IDENTIFIER | ParenthesizedIdentifier)?
  private static boolean CatchBlock_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CatchBlock_1")) return false;
    CatchBlock_1_0(b, l + 1);
    return true;
  }

  // IDENTIFIER | ParenthesizedIdentifier
  private static boolean CatchBlock_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CatchBlock_1_0")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = ParenthesizedIdentifier(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ClassModifiers? CLASS IDENTIFIER (EXTENDS CustomType)? (IMPLEMENTS CustomType (COMMA CustomType)*)? ClassImplementation
  public static boolean ClassDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_DEFINITION, "<class definition>");
    r = ClassDefinition_0(b, l + 1);
    r = r && consumeTokens(b, 0, CLASS, IDENTIFIER);
    r = r && ClassDefinition_3(b, l + 1);
    r = r && ClassDefinition_4(b, l + 1);
    r = r && ClassImplementation(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ClassModifiers?
  private static boolean ClassDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinition_0")) return false;
    ClassModifiers(b, l + 1);
    return true;
  }

  // (EXTENDS CustomType)?
  private static boolean ClassDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinition_3")) return false;
    ClassDefinition_3_0(b, l + 1);
    return true;
  }

  // EXTENDS CustomType
  private static boolean ClassDefinition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinition_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    r = r && CustomType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (IMPLEMENTS CustomType (COMMA CustomType)*)?
  private static boolean ClassDefinition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinition_4")) return false;
    ClassDefinition_4_0(b, l + 1);
    return true;
  }

  // IMPLEMENTS CustomType (COMMA CustomType)*
  private static boolean ClassDefinition_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinition_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IMPLEMENTS);
    r = r && CustomType(b, l + 1);
    r = r && ClassDefinition_4_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA CustomType)*
  private static boolean ClassDefinition_4_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinition_4_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ClassDefinition_4_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ClassDefinition_4_0_2", c)) break;
    }
    return true;
  }

  // COMMA CustomType
  private static boolean ClassDefinition_4_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassDefinition_4_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && CustomType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FieldModifiers? IDENTIFIER TypeAnnotation (ASSIGNMENT Expression)? SEMICOLON
  public static boolean ClassField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassField")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_FIELD, "<class field>");
    r = ClassField_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && TypeAnnotation(b, l + 1);
    r = r && ClassField_3(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // FieldModifiers?
  private static boolean ClassField_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassField_0")) return false;
    FieldModifiers(b, l + 1);
    return true;
  }

  // (ASSIGNMENT Expression)?
  private static boolean ClassField_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassField_3")) return false;
    ClassField_3_0(b, l + 1);
    return true;
  }

  // ASSIGNMENT Expression
  private static boolean ClassField_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassField_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGNMENT);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_CURLY_BRACE (Initializer | MethodDefinition | ClassField)* RIGHT_CURLY_BRACE
  public static boolean ClassImplementation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassImplementation")) return false;
    if (!nextTokenIs(b, LEFT_CURLY_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_CURLY_BRACE);
    r = r && ClassImplementation_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACE);
    exit_section_(b, m, CLASS_IMPLEMENTATION, r);
    return r;
  }

  // (Initializer | MethodDefinition | ClassField)*
  private static boolean ClassImplementation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassImplementation_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ClassImplementation_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ClassImplementation_1", c)) break;
    }
    return true;
  }

  // Initializer | MethodDefinition | ClassField
  private static boolean ClassImplementation_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassImplementation_1_0")) return false;
    boolean r;
    r = Initializer(b, l + 1);
    if (!r) r = MethodDefinition(b, l + 1);
    if (!r) r = ClassField(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // AccessModifier PhaseSpecifier
  //     | PhaseSpecifier AccessModifier
  public static boolean ClassModifiers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassModifiers")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLASS_MODIFIERS, "<class modifiers>");
    r = ClassModifiers_0(b, l + 1);
    if (!r) r = ClassModifiers_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // AccessModifier PhaseSpecifier
  private static boolean ClassModifiers_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassModifiers_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AccessModifier(b, l + 1);
    r = r && PhaseSpecifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PhaseSpecifier AccessModifier
  private static boolean ClassModifiers_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClassModifiers_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PhaseSpecifier(b, l + 1);
    r = r && AccessModifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ClosureModifiers? ParameterList ReturnType? ARROW Block
  public static boolean Closure(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Closure")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLOSURE, "<closure>");
    r = Closure_0(b, l + 1);
    r = r && ParameterList(b, l + 1);
    r = r && Closure_2(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && Block(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ClosureModifiers?
  private static boolean Closure_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Closure_0")) return false;
    ClosureModifiers(b, l + 1);
    return true;
  }

  // ReturnType?
  private static boolean Closure_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Closure_2")) return false;
    ReturnType(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // PhaseSpecifier
  public static boolean ClosureModifiers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ClosureModifiers")) return false;
    if (!nextTokenIs(b, "<closure modifiers>", INFLIGHT_SPECIFIER, UNPHASED_SPECIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLOSURE_MODIFIERS, "<closure modifiers>");
    r = PhaseSpecifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ArrayLiteral
  //     | MapLiteral
  public static boolean CollectionLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CollectionLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COLLECTION_LITERAL, "<collection literal>");
    r = ArrayLiteral(b, l + 1);
    if (!r) r = MapLiteral(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LESS_THAN Type GREATER_THAN
  public static boolean ContainerValueType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContainerValueType")) return false;
    if (!nextTokenIs(b, LESS_THAN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS_THAN);
    r = r && Type(b, l + 1);
    r = r && consumeToken(b, GREATER_THAN);
    exit_section_(b, m, CONTAINER_VALUE_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // CONTINUE SEMICOLON
  public static boolean ContinueStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ContinueStatement")) return false;
    if (!nextTokenIs(b, CONTINUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CONTINUE, SEMICOLON);
    exit_section_(b, m, CONTINUE_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // TypeIdentifier (DOT TypeIdentifier)*
  static boolean CustomType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CustomType")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypeIdentifier(b, l + 1);
    r = r && CustomType_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (DOT TypeIdentifier)*
  private static boolean CustomType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CustomType_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!CustomType_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "CustomType_1", c)) break;
    }
    return true;
  }

  // DOT TypeIdentifier
  private static boolean CustomType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CustomType_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && TypeIdentifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DEFER Expression
  public static boolean DeferExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "DeferExpression")) return false;
    if (!nextTokenIs(b, DEFER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DEFER);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, DEFER_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // Number "ms"
  //     | Number "s"
  //     | Number "m"
  //     | Number "h"
  //     | Number "d"
  //     | Number "mo"
  //     | Number "y"
  public static boolean Duration(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Duration")) return false;
    if (!nextTokenIs(b, "<duration>", DECIMAL, INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DURATION, "<duration>");
    r = Duration_0(b, l + 1);
    if (!r) r = Duration_1(b, l + 1);
    if (!r) r = Duration_2(b, l + 1);
    if (!r) r = Duration_3(b, l + 1);
    if (!r) r = Duration_4(b, l + 1);
    if (!r) r = Duration_5(b, l + 1);
    if (!r) r = Duration_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Number "ms"
  private static boolean Duration_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Duration_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Number(b, l + 1);
    r = r && consumeToken(b, "ms");
    exit_section_(b, m, null, r);
    return r;
  }

  // Number "s"
  private static boolean Duration_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Duration_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Number(b, l + 1);
    r = r && consumeToken(b, "s");
    exit_section_(b, m, null, r);
    return r;
  }

  // Number "m"
  private static boolean Duration_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Duration_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Number(b, l + 1);
    r = r && consumeToken(b, "m");
    exit_section_(b, m, null, r);
    return r;
  }

  // Number "h"
  private static boolean Duration_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Duration_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Number(b, l + 1);
    r = r && consumeToken(b, "h");
    exit_section_(b, m, null, r);
    return r;
  }

  // Number "d"
  private static boolean Duration_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Duration_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Number(b, l + 1);
    r = r && consumeToken(b, "d");
    exit_section_(b, m, null, r);
    return r;
  }

  // Number "mo"
  private static boolean Duration_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Duration_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Number(b, l + 1);
    r = r && consumeToken(b, "mo");
    exit_section_(b, m, null, r);
    return r;
  }

  // Number "y"
  private static boolean Duration_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Duration_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Number(b, l + 1);
    r = r && consumeToken(b, "y");
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ELSE IF Expression Block
  public static boolean ElIfBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ElIfBlock")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSE, IF);
    r = r && Expression(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, EL_IF_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // ELSE IF LET Reassignable? IDENTIFIER ASSIGNMENT Expression Block
  public static boolean ElIfLetBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ElIfLetBlock")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSE, IF, LET);
    r = r && ElIfLetBlock_3(b, l + 1);
    r = r && consumeTokens(b, 0, IDENTIFIER, ASSIGNMENT);
    r = r && Expression(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, EL_IF_LET_BLOCK, r);
    return r;
  }

  // Reassignable?
  private static boolean ElIfLetBlock_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ElIfLetBlock_3")) return false;
    Reassignable(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // AccessModifier? ENUM IDENTIFIER LEFT_CURLY_BRACE (EnumField (COMMA EnumField)* COMMA?)? RIGHT_CURLY_BRACE
  public static boolean EnumDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDefinition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, ENUM_DEFINITION, "<enum definition>");
    r = EnumDefinition_0(b, l + 1);
    r = r && consumeTokens(b, 1, ENUM, IDENTIFIER, LEFT_CURLY_BRACE);
    p = r; // pin = ENUM
    r = r && report_error_(b, EnumDefinition_4(b, l + 1));
    r = p && consumeToken(b, RIGHT_CURLY_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // AccessModifier?
  private static boolean EnumDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDefinition_0")) return false;
    AccessModifier(b, l + 1);
    return true;
  }

  // (EnumField (COMMA EnumField)* COMMA?)?
  private static boolean EnumDefinition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDefinition_4")) return false;
    EnumDefinition_4_0(b, l + 1);
    return true;
  }

  // EnumField (COMMA EnumField)* COMMA?
  private static boolean EnumDefinition_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDefinition_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EnumField(b, l + 1);
    r = r && EnumDefinition_4_0_1(b, l + 1);
    r = r && EnumDefinition_4_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA EnumField)*
  private static boolean EnumDefinition_4_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDefinition_4_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!EnumDefinition_4_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "EnumDefinition_4_0_1", c)) break;
    }
    return true;
  }

  // COMMA EnumField
  private static boolean EnumDefinition_4_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDefinition_4_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && EnumField(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean EnumDefinition_4_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumDefinition_4_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean EnumField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EnumField")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, ENUM_FIELD, r);
    return r;
  }

  /* ********************************************************** */
  // BinaryExpression
  //     | UnaryExpression
  //     | NewExpression
  //     | Literal
  //     | ReferenceExpression
  //     | Call
  //     | Closure
  //     | AwaitExpression
  //     | DeferExpression
  //     | CollectionLiteral
  //     | ParenthesizedExpression
  //     | JsonLiteral
  //     | StructLiteral
  //     | OptionalUnwrap
  //     | Intrinsic
  //     | TypeIntrinsic
  public static boolean Expression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXPRESSION, "<expression>");
    r = BinaryExpression(b, l + 1);
    if (!r) r = UnaryExpression(b, l + 1);
    if (!r) r = NewExpression(b, l + 1);
    if (!r) r = Literal(b, l + 1);
    if (!r) r = ReferenceExpression(b, l + 1);
    if (!r) r = Call(b, l + 1);
    if (!r) r = Closure(b, l + 1);
    if (!r) r = AwaitExpression(b, l + 1);
    if (!r) r = DeferExpression(b, l + 1);
    if (!r) r = CollectionLiteral(b, l + 1);
    if (!r) r = ParenthesizedExpression(b, l + 1);
    if (!r) r = JsonLiteral(b, l + 1);
    if (!r) r = StructLiteral(b, l + 1);
    if (!r) r = OptionalUnwrap(b, l + 1);
    if (!r) r = Intrinsic(b, l + 1);
    if (!r) r = TypeIntrinsic(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression SEMICOLON
  public static boolean ExpressionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExpressionStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPRESSION_STATEMENT, "<expression statement>");
    r = Expression(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // EXTERN String
  public static boolean ExternModifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ExternModifier")) return false;
    if (!nextTokenIs(b, EXTERN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTERN);
    r = r && String(b, l + 1);
    exit_section_(b, m, EXTERN_MODIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // AccessModifier
  //     | STATIC
  //     | PhaseSpecifier
  //     | Reassignable
  public static boolean FieldModifiers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FieldModifiers")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD_MODIFIERS, "<field modifiers>");
    r = AccessModifier(b, l + 1);
    if (!r) r = consumeToken(b, STATIC);
    if (!r) r = PhaseSpecifier(b, l + 1);
    if (!r) r = Reassignable(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FINALLY Block
  public static boolean FinallyBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FinallyBlock")) return false;
    if (!nextTokenIs(b, FINALLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FINALLY);
    r = r && Block(b, l + 1);
    exit_section_(b, m, FINALLY_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // FOR IDENTIFIER IN (Expression | LoopRange) Block
  public static boolean ForInLoop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForInLoop")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, FOR_IN_LOOP, null);
    r = consumeTokens(b, 1, FOR, IDENTIFIER, IN);
    p = r; // pin = FOR
    r = r && report_error_(b, ForInLoop_3(b, l + 1));
    r = p && Block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // Expression | LoopRange
  private static boolean ForInLoop_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ForInLoop_3")) return false;
    boolean r;
    r = Expression(b, l + 1);
    if (!r) r = LoopRange(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // PhaseSpecifier? ParameterTypeList [COLON Type]
  public static boolean FunctionType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_TYPE, "<function type>");
    r = FunctionType_0(b, l + 1);
    r = r && ParameterTypeList(b, l + 1);
    r = r && FunctionType_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PhaseSpecifier?
  private static boolean FunctionType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType_0")) return false;
    PhaseSpecifier(b, l + 1);
    return true;
  }

  // [COLON Type]
  private static boolean FunctionType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType_2")) return false;
    FunctionType_2_0(b, l + 1);
    return true;
  }

  // COLON Type
  private static boolean FunctionType_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FunctionType_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IF LET Reassignable? IDENTIFIER ASSIGNMENT Expression Block (ElIfLetBlock | ElIfBlock)* (ELSE Block)VAR?
  public static boolean IfLetStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfLetStatement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IF, LET);
    r = r && IfLetStatement_2(b, l + 1);
    r = r && consumeTokens(b, 0, IDENTIFIER, ASSIGNMENT);
    r = r && Expression(b, l + 1);
    r = r && Block(b, l + 1);
    r = r && IfLetStatement_7(b, l + 1);
    r = r && IfLetStatement_8(b, l + 1);
    r = r && IfLetStatement_9(b, l + 1);
    exit_section_(b, m, IF_LET_STATEMENT, r);
    return r;
  }

  // Reassignable?
  private static boolean IfLetStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfLetStatement_2")) return false;
    Reassignable(b, l + 1);
    return true;
  }

  // (ElIfLetBlock | ElIfBlock)*
  private static boolean IfLetStatement_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfLetStatement_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!IfLetStatement_7_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "IfLetStatement_7", c)) break;
    }
    return true;
  }

  // ElIfLetBlock | ElIfBlock
  private static boolean IfLetStatement_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfLetStatement_7_0")) return false;
    boolean r;
    r = ElIfLetBlock(b, l + 1);
    if (!r) r = ElIfBlock(b, l + 1);
    return r;
  }

  // ELSE Block
  private static boolean IfLetStatement_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfLetStatement_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // VAR?
  private static boolean IfLetStatement_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfLetStatement_9")) return false;
    consumeToken(b, VAR);
    return true;
  }

  /* ********************************************************** */
  // IF Expression Block ElIfBlock* (ELSE Block)?
  public static boolean IfStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && Expression(b, l + 1);
    r = r && Block(b, l + 1);
    r = r && IfStatement_3(b, l + 1);
    r = r && IfStatement_4(b, l + 1);
    exit_section_(b, m, IF_STATEMENT, r);
    return r;
  }

  // ElIfBlock*
  private static boolean IfStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ElIfBlock(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "IfStatement_3", c)) break;
    }
    return true;
  }

  // (ELSE Block)?
  private static boolean IfStatement_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_4")) return false;
    IfStatement_4_0(b, l + 1);
    return true;
  }

  // ELSE Block
  private static boolean IfStatement_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IfStatement_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && Block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ("Array" | "Set" | "Map" | "Promise") ContainerValueType
  static boolean ImmutableContainerType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImmutableContainerType")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ImmutableContainerType_0(b, l + 1);
    r = r && ContainerValueType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "Array" | "Set" | "Map" | "Promise"
  private static boolean ImmutableContainerType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImmutableContainerType_0")) return false;
    boolean r;
    r = consumeToken(b, "Array");
    if (!r) r = consumeToken(b, "Set");
    if (!r) r = consumeToken(b, "Map");
    if (!r) r = consumeToken(b, "Promise");
    return r;
  }

  /* ********************************************************** */
  // BRING (IDENTIFIER|STRING_LITERAL)? (ALIAS IDENTIFIER)? SEMICOLON
  public static boolean ImportStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportStatement")) return false;
    if (!nextTokenIs(b, BRING)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, IMPORT_STATEMENT, null);
    r = consumeToken(b, BRING);
    p = r; // pin = BRING
    r = r && report_error_(b, ImportStatement_1(b, l + 1));
    r = p && report_error_(b, ImportStatement_2(b, l + 1)) && r;
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // (IDENTIFIER|STRING_LITERAL)?
  private static boolean ImportStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportStatement_1")) return false;
    ImportStatement_1_0(b, l + 1);
    return true;
  }

  // IDENTIFIER|STRING_LITERAL
  private static boolean ImportStatement_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportStatement_1_0")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, STRING_LITERAL);
    return r;
  }

  // (ALIAS IDENTIFIER)?
  private static boolean ImportStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportStatement_2")) return false;
    ImportStatement_2_0(b, l + 1);
    return true;
  }

  // ALIAS IDENTIFIER
  private static boolean ImportStatement_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ImportStatement_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ALIAS, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ASSIGNMENT
  public static boolean InclusiveRange(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InclusiveRange")) return false;
    if (!nextTokenIs(b, ASSIGNMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGNMENT);
    exit_section_(b, m, INCLUSIVE_RANGE, r);
    return r;
  }

  /* ********************************************************** */
  // PhaseSpecifier? NEW ParameterList Block
  public static boolean Initializer(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Initializer")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INITIALIZER, "<initializer>");
    r = Initializer_0(b, l + 1);
    r = r && consumeToken(b, NEW);
    p = r; // pin = NEW
    r = r && report_error_(b, ParameterList(b, l + 1));
    r = p && Block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // PhaseSpecifier?
  private static boolean Initializer_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Initializer_0")) return false;
    PhaseSpecifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // InterfaceModifiers? INTERFACE IDENTIFIER (EXTENDS CustomType (COMMA CustomType)*)? InterfaceImplementation
  public static boolean InterfaceDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDefinition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, INTERFACE_DEFINITION, "<interface definition>");
    r = InterfaceDefinition_0(b, l + 1);
    r = r && consumeTokens(b, 1, INTERFACE, IDENTIFIER);
    p = r; // pin = INTERFACE
    r = r && report_error_(b, InterfaceDefinition_3(b, l + 1));
    r = p && InterfaceImplementation(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // InterfaceModifiers?
  private static boolean InterfaceDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDefinition_0")) return false;
    InterfaceModifiers(b, l + 1);
    return true;
  }

  // (EXTENDS CustomType (COMMA CustomType)*)?
  private static boolean InterfaceDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDefinition_3")) return false;
    InterfaceDefinition_3_0(b, l + 1);
    return true;
  }

  // EXTENDS CustomType (COMMA CustomType)*
  private static boolean InterfaceDefinition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDefinition_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    r = r && CustomType(b, l + 1);
    r = r && InterfaceDefinition_3_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA CustomType)*
  private static boolean InterfaceDefinition_3_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDefinition_3_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!InterfaceDefinition_3_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "InterfaceDefinition_3_0_2", c)) break;
    }
    return true;
  }

  // COMMA CustomType
  private static boolean InterfaceDefinition_3_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceDefinition_3_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && CustomType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_CURLY_BRACE (MethodDefinition | ClassField)* RIGHT_CURLY_BRACE
  public static boolean InterfaceImplementation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceImplementation")) return false;
    if (!nextTokenIs(b, LEFT_CURLY_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_CURLY_BRACE);
    r = r && InterfaceImplementation_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACE);
    exit_section_(b, m, INTERFACE_IMPLEMENTATION, r);
    return r;
  }

  // (MethodDefinition | ClassField)*
  private static boolean InterfaceImplementation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceImplementation_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!InterfaceImplementation_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "InterfaceImplementation_1", c)) break;
    }
    return true;
  }

  // MethodDefinition | ClassField
  private static boolean InterfaceImplementation_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceImplementation_1_0")) return false;
    boolean r;
    r = MethodDefinition(b, l + 1);
    if (!r) r = ClassField(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // AccessModifier PhaseSpecifier
  //     | PhaseSpecifier AccessModifier
  public static boolean InterfaceModifiers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceModifiers")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTERFACE_MODIFIERS, "<interface modifiers>");
    r = InterfaceModifiers_0(b, l + 1);
    if (!r) r = InterfaceModifiers_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // AccessModifier PhaseSpecifier
  private static boolean InterfaceModifiers_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceModifiers_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = AccessModifier(b, l + 1);
    r = r && PhaseSpecifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PhaseSpecifier AccessModifier
  private static boolean InterfaceModifiers_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "InterfaceModifiers_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = PhaseSpecifier(b, l + 1);
    r = r && AccessModifier(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INTRINSIC_IDENTIFIER ArgumentList?
  public static boolean Intrinsic(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Intrinsic")) return false;
    if (!nextTokenIs(b, INTRINSIC_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, INTRINSIC_IDENTIFIER);
    r = r && Intrinsic_1(b, l + 1);
    exit_section_(b, m, INTRINSIC, r);
    return r;
  }

  // ArgumentList?
  private static boolean Intrinsic_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Intrinsic_1")) return false;
    ArgumentList(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // JsonTypes
  static boolean JsonContainerType(PsiBuilder b, int l) {
    return JsonTypes(b, l + 1);
  }

  /* ********************************************************** */
  // (JsonContainerType Expression)
  //     | JsonMapLiteral
  public static boolean JsonLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JSON_LITERAL, "<json literal>");
    r = JsonLiteral_0(b, l + 1);
    if (!r) r = JsonMapLiteral(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // JsonContainerType Expression
  private static boolean JsonLiteral_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonLiteral_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = JsonContainerType(b, l + 1);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  //     | ((String | IDENTIFIER) COLON Expression)
  public static boolean JsonLiteralMember(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonLiteralMember")) return false;
    if (!nextTokenIs(b, "<json literal member>", IDENTIFIER, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JSON_LITERAL_MEMBER, "<json literal member>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = JsonLiteralMember_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (String | IDENTIFIER) COLON Expression
  private static boolean JsonLiteralMember_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonLiteralMember_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = JsonLiteralMember_1_0(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // String | IDENTIFIER
  private static boolean JsonLiteralMember_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonLiteralMember_1_0")) return false;
    boolean r;
    r = String(b, l + 1);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  /* ********************************************************** */
  // LEFT_CURLY_BRACE JsonLiteralMember (COMMA JsonLiteralMember)* COMMA? RIGHT_CURLY_BRACE
  public static boolean JsonMapLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonMapLiteral")) return false;
    if (!nextTokenIs(b, LEFT_CURLY_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_CURLY_BRACE);
    r = r && JsonLiteralMember(b, l + 1);
    r = r && JsonMapLiteral_2(b, l + 1);
    r = r && JsonMapLiteral_3(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACE);
    exit_section_(b, m, JSON_MAP_LITERAL, r);
    return r;
  }

  // (COMMA JsonLiteralMember)*
  private static boolean JsonMapLiteral_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonMapLiteral_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!JsonMapLiteral_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "JsonMapLiteral_2", c)) break;
    }
    return true;
  }

  // COMMA JsonLiteralMember
  private static boolean JsonMapLiteral_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonMapLiteral_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && JsonLiteralMember(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean JsonMapLiteral_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonMapLiteral_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // "Json"
  //     | "MutJson"
  public static boolean JsonTypes(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "JsonTypes")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JSON_TYPES, "<json types>");
    r = consumeToken(b, "Json");
    if (!r) r = consumeToken(b, "MutJson");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER COLON Expression
  public static boolean KeywordArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "KeywordArgument")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, COLON);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, KEYWORD_ARGUMENT, r);
    return r;
  }

  /* ********************************************************** */
  // Expression COLON (IDENTIFIER | LEFT_SQUARE_BRACE IDENTIFIER (COMMA IDENTIFIER)* RIGHT_SQUARE_BRACE)
  public static boolean LiftQualification(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiftQualification")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LIFT_QUALIFICATION, "<lift qualification>");
    r = Expression(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && LiftQualification_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER | LEFT_SQUARE_BRACE IDENTIFIER (COMMA IDENTIFIER)* RIGHT_SQUARE_BRACE
  private static boolean LiftQualification_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiftQualification_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = LiftQualification_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LEFT_SQUARE_BRACE IDENTIFIER (COMMA IDENTIFIER)* RIGHT_SQUARE_BRACE
  private static boolean LiftQualification_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiftQualification_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LEFT_SQUARE_BRACE, IDENTIFIER);
    r = r && LiftQualification_2_1_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_SQUARE_BRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA IDENTIFIER)*
  private static boolean LiftQualification_2_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiftQualification_2_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!LiftQualification_2_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "LiftQualification_2_1_2", c)) break;
    }
    return true;
  }

  // COMMA IDENTIFIER
  private static boolean LiftQualification_2_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiftQualification_2_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_CURLY_BRACE LiftQualification (COMMA LiftQualification)* RIGHT_CURLY_BRACE
  public static boolean LiftQualifications(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiftQualifications")) return false;
    if (!nextTokenIs(b, LEFT_CURLY_BRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_CURLY_BRACE);
    r = r && LiftQualification(b, l + 1);
    r = r && LiftQualifications_2(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACE);
    exit_section_(b, m, LIFT_QUALIFICATIONS, r);
    return r;
  }

  // (COMMA LiftQualification)*
  private static boolean LiftQualifications_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiftQualifications_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!LiftQualifications_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "LiftQualifications_2", c)) break;
    }
    return true;
  }

  // COMMA LiftQualification
  private static boolean LiftQualifications_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiftQualifications_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && LiftQualification(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LIFT LiftQualifications Block
  public static boolean LiftStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiftStatement")) return false;
    if (!nextTokenIs(b, LIFT)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, LIFT_STATEMENT, null);
    r = consumeToken(b, LIFT);
    p = r; // pin = LIFT
    r = r && report_error_(b, LiftQualifications(b, l + 1));
    r = p && Block(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // String
  //     | Number
  //     | BOOL
  //     | Duration
  //     | NIL
  public static boolean Literal(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Literal")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL, "<literal>");
    r = String(b, l + 1);
    if (!r) r = Number(b, l + 1);
    if (!r) r = consumeToken(b, BOOL);
    if (!r) r = Duration(b, l + 1);
    if (!r) r = consumeToken(b, NIL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // OR
  //     | AND
  public static boolean LogicalOperators(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LogicalOperators")) return false;
    if (!nextTokenIs(b, "<logical operators>", AND, OR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOGICAL_OPERATORS, "<logical operators>");
    r = consumeToken(b, OR);
    if (!r) r = consumeToken(b, AND);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression '..' InclusiveRange? Expression
  public static boolean LoopRange(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LoopRange")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOOP_RANGE, "<loop range>");
    r = Expression(b, l + 1);
    r = r && consumeToken(b, "..");
    r = r && LoopRange_2(b, l + 1);
    r = r && Expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // InclusiveRange?
  private static boolean LoopRange_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LoopRange_2")) return false;
    InclusiveRange(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // BuiltInContainerType? LEFT_CURLY_BRACE MapLiteralMember (COMMA MapLiteralMember)* COMMA? RIGHT_CURLY_BRACE
  public static boolean MapLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapLiteral")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAP_LITERAL, "<map literal>");
    r = MapLiteral_0(b, l + 1);
    r = r && consumeToken(b, LEFT_CURLY_BRACE);
    r = r && MapLiteralMember(b, l + 1);
    r = r && MapLiteral_3(b, l + 1);
    r = r && MapLiteral_4(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // BuiltInContainerType?
  private static boolean MapLiteral_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapLiteral_0")) return false;
    BuiltInContainerType(b, l + 1);
    return true;
  }

  // (COMMA MapLiteralMember)*
  private static boolean MapLiteral_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapLiteral_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!MapLiteral_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MapLiteral_3", c)) break;
    }
    return true;
  }

  // COMMA MapLiteralMember
  private static boolean MapLiteral_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapLiteral_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && MapLiteralMember(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean MapLiteral_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapLiteral_4")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // Expression ARROW Expression
  public static boolean MapLiteralMember(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MapLiteralMember")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAP_LITERAL_MEMBER, "<map literal member>");
    r = Expression(b, l + 1);
    r = r && consumeToken(b, ARROW);
    r = r && Expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ADDITION
  //     | SUBTRACTION
  //     | MULTIPLY
  //     | DIVIDE
  //     | MODULO
  //     | FLOOR_DIVIDE
  //     | POWER
  public static boolean MathematicalOperators(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MathematicalOperators")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATHEMATICAL_OPERATORS, "<mathematical operators>");
    r = consumeToken(b, ADDITION);
    if (!r) r = consumeToken(b, SUBTRACTION);
    if (!r) r = consumeToken(b, MULTIPLY);
    if (!r) r = consumeToken(b, DIVIDE);
    if (!r) r = consumeToken(b, MODULO);
    if (!r) r = consumeToken(b, FLOOR_DIVIDE);
    if (!r) r = consumeToken(b, POWER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean MemberIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MemberIdentifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, MEMBER_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // MethodModifiers* IDENTIFIER ParameterList ReturnType? (Block | SEMICOLON)
  public static boolean MethodDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_DEFINITION, "<method definition>");
    r = MethodDefinition_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && ParameterList(b, l + 1);
    r = r && MethodDefinition_3(b, l + 1);
    r = r && MethodDefinition_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // MethodModifiers*
  private static boolean MethodDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodDefinition_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!MethodModifiers(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "MethodDefinition_0", c)) break;
    }
    return true;
  }

  // ReturnType?
  private static boolean MethodDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodDefinition_3")) return false;
    ReturnType(b, l + 1);
    return true;
  }

  // Block | SEMICOLON
  private static boolean MethodDefinition_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodDefinition_4")) return false;
    boolean r;
    r = Block(b, l + 1);
    if (!r) r = consumeToken(b, SEMICOLON);
    return r;
  }

  /* ********************************************************** */
  // ExternModifier
  //     | AccessModifier
  //     | STATIC
  //     | PhaseSpecifier
  public static boolean MethodModifiers(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MethodModifiers")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD_MODIFIERS, "<method modifiers>");
    r = ExternModifier(b, l + 1);
    if (!r) r = AccessModifier(b, l + 1);
    if (!r) r = consumeToken(b, STATIC);
    if (!r) r = PhaseSpecifier(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ("MutSet" | "MutMap" | "MutArray") ContainerValueType
  static boolean MutableContainerType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MutableContainerType")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = MutableContainerType_0(b, l + 1);
    r = r && ContainerValueType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // "MutSet" | "MutMap" | "MutArray"
  private static boolean MutableContainerType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "MutableContainerType_0")) return false;
    boolean r;
    r = consumeToken(b, "MutSet");
    if (!r) r = consumeToken(b, "MutMap");
    if (!r) r = consumeToken(b, "MutArray");
    return r;
  }

  /* ********************************************************** */
  // (Expression | JsonContainerType) Accessor MemberIdentifier?
  public static boolean NestedIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NestedIdentifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NESTED_IDENTIFIER, "<nested identifier>");
    r = NestedIdentifier_0(b, l + 1);
    r = r && Accessor(b, l + 1);
    r = r && NestedIdentifier_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Expression | JsonContainerType
  private static boolean NestedIdentifier_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NestedIdentifier_0")) return false;
    boolean r;
    r = Expression(b, l + 1);
    if (!r) r = JsonContainerType(b, l + 1);
    return r;
  }

  // MemberIdentifier?
  private static boolean NestedIdentifier_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NestedIdentifier_2")) return false;
    MemberIdentifier(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // NEW (CustomType | MutableContainerType) ArgumentList (ALIAS Expression)? (IN Expression)?
  public static boolean NewExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NewExpression")) return false;
    if (!nextTokenIs(b, NEW)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEW);
    r = r && NewExpression_1(b, l + 1);
    r = r && ArgumentList(b, l + 1);
    r = r && NewExpression_3(b, l + 1);
    r = r && NewExpression_4(b, l + 1);
    exit_section_(b, m, NEW_EXPRESSION, r);
    return r;
  }

  // CustomType | MutableContainerType
  private static boolean NewExpression_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NewExpression_1")) return false;
    boolean r;
    r = CustomType(b, l + 1);
    if (!r) r = MutableContainerType(b, l + 1);
    return r;
  }

  // (ALIAS Expression)?
  private static boolean NewExpression_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NewExpression_3")) return false;
    NewExpression_3_0(b, l + 1);
    return true;
  }

  // ALIAS Expression
  private static boolean NewExpression_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NewExpression_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ALIAS);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (IN Expression)?
  private static boolean NewExpression_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NewExpression_4")) return false;
    NewExpression_4_0(b, l + 1);
    return true;
  }

  // IN Expression
  private static boolean NewExpression_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "NewExpression_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IN);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INTEGER
  //     | DECIMAL
  public static boolean Number(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Number")) return false;
    if (!nextTokenIs(b, "<number>", DECIMAL, INTEGER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NUMBER, "<number>");
    r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, DECIMAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // MathematicalOperators
  //     | LogicalOperators
  //     | RelationalOperators
  //     | UNWRAP_OR
  public static boolean Operators(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Operators")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPERATORS, "<operators>");
    r = MathematicalOperators(b, l + 1);
    if (!r) r = LogicalOperators(b, l + 1);
    if (!r) r = RelationalOperators(b, l + 1);
    if (!r) r = consumeToken(b, UNWRAP_OR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression NOT
  public static boolean OptionalUnwrap(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "OptionalUnwrap")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPTIONAL_UNWRAP, "<optional unwrap>");
    r = Expression(b, l + 1);
    r = r && consumeToken(b, NOT);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Reassignable? VARIADIC? IDENTIFIER TypeAnnotation?
  public static boolean ParameterDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterDefinition")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAMETER_DEFINITION, "<parameter definition>");
    r = ParameterDefinition_0(b, l + 1);
    r = r && ParameterDefinition_1(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && ParameterDefinition_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Reassignable?
  private static boolean ParameterDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterDefinition_0")) return false;
    Reassignable(b, l + 1);
    return true;
  }

  // VARIADIC?
  private static boolean ParameterDefinition_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterDefinition_1")) return false;
    consumeToken(b, VARIADIC);
    return true;
  }

  // TypeAnnotation?
  private static boolean ParameterDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterDefinition_3")) return false;
    TypeAnnotation(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LEFT_PARENTHESIS ParameterDefinition (COMMA ParameterDefinition)* COMMA? RIGHT_PARENTHESIS
  public static boolean ParameterList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PARENTHESIS);
    r = r && ParameterDefinition(b, l + 1);
    r = r && ParameterList_2(b, l + 1);
    r = r && ParameterList_3(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESIS);
    exit_section_(b, m, PARAMETER_LIST, r);
    return r;
  }

  // (COMMA ParameterDefinition)*
  private static boolean ParameterList_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ParameterList_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ParameterList_2", c)) break;
    }
    return true;
  }

  // COMMA ParameterDefinition
  private static boolean ParameterList_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && ParameterDefinition(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean ParameterList_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterList_3")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // LEFT_PARENTHESIS [Type (COMMA Type)* COMMA?] RIGHT_PARENTHESIS
  public static boolean ParameterTypeList(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterTypeList")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PARENTHESIS);
    r = r && ParameterTypeList_1(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESIS);
    exit_section_(b, m, PARAMETER_TYPE_LIST, r);
    return r;
  }

  // [Type (COMMA Type)* COMMA?]
  private static boolean ParameterTypeList_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterTypeList_1")) return false;
    ParameterTypeList_1_0(b, l + 1);
    return true;
  }

  // Type (COMMA Type)* COMMA?
  private static boolean ParameterTypeList_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterTypeList_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Type(b, l + 1);
    r = r && ParameterTypeList_1_0_1(b, l + 1);
    r = r && ParameterTypeList_1_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA Type)*
  private static boolean ParameterTypeList_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterTypeList_1_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ParameterTypeList_1_0_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ParameterTypeList_1_0_1", c)) break;
    }
    return true;
  }

  // COMMA Type
  private static boolean ParameterTypeList_1_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterTypeList_1_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Type(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean ParameterTypeList_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParameterTypeList_1_0_2")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // LEFT_PARENTHESIS Expression RIGHT_PARENTHESIS
  public static boolean ParenthesizedExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParenthesizedExpression")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PARENTHESIS);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESIS);
    exit_section_(b, m, PARENTHESIZED_EXPRESSION, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_PARENTHESIS IDENTIFIER RIGHT_PARENTHESIS
  public static boolean ParenthesizedIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParenthesizedIdentifier")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LEFT_PARENTHESIS, IDENTIFIER, RIGHT_PARENTHESIS);
    exit_section_(b, m, PARENTHESIZED_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // LEFT_PARENTHESIS Type RIGHT_PARENTHESIS
  public static boolean ParenthesizedType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ParenthesizedType")) return false;
    if (!nextTokenIs(b, LEFT_PARENTHESIS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LEFT_PARENTHESIS);
    r = r && Type(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESIS);
    exit_section_(b, m, PARENTHESIZED_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // UNPHASED_SPECIFIER
  //     | INFLIGHT_SPECIFIER
  public static boolean PhaseSpecifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PhaseSpecifier")) return false;
    if (!nextTokenIs(b, "<phase specifier>", INFLIGHT_SPECIFIER, UNPHASED_SPECIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PHASE_SPECIFIER, "<phase specifier>");
    r = consumeToken(b, UNPHASED_SPECIFIER);
    if (!r) r = consumeToken(b, INFLIGHT_SPECIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Expression
  public static boolean PositionalArgument(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PositionalArgument")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POSITIONAL_ARGUMENT, "<positional argument>");
    r = Expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VAR
  public static boolean Reassignable(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Reassignable")) return false;
    if (!nextTokenIs(b, VAR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, VAR);
    exit_section_(b, m, REASSIGNABLE, r);
    return r;
  }

  /* ********************************************************** */
  // NestedIdentifier
  //     | ReferenceIdentifier
  //     | StructuredAccessExpression
  public static boolean ReferenceExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReferenceExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, REFERENCE_EXPRESSION, "<reference expression>");
    r = NestedIdentifier(b, l + 1);
    if (!r) r = ReferenceIdentifier(b, l + 1);
    if (!r) r = StructuredAccessExpression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean ReferenceIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReferenceIdentifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, REFERENCE_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // EQUAL
  //     | NOT_EQUAL
  //     | GREATER_THAN
  //     | GREATER_THAN_OR_EQUAL
  //     | LESS_THAN_OR_EQUAL
  //     | LESS_THAN
  public static boolean RelationalOperators(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "RelationalOperators")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATIONAL_OPERATORS, "<relational operators>");
    r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, NOT_EQUAL);
    if (!r) r = consumeToken(b, GREATER_THAN);
    if (!r) r = consumeToken(b, GREATER_THAN_OR_EQUAL);
    if (!r) r = consumeToken(b, LESS_THAN_OR_EQUAL);
    if (!r) r = consumeToken(b, LESS_THAN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // RETURN Expression? SEMICOLON
  public static boolean ReturnStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, RETURN_STATEMENT, null);
    r = consumeToken(b, RETURN);
    p = r; // pin = RETURN
    r = r && report_error_(b, ReturnStatement_1(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // Expression?
  private static boolean ReturnStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnStatement_1")) return false;
    Expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TypeAnnotation
  public static boolean ReturnType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ReturnType")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TypeAnnotation(b, l + 1);
    exit_section_(b, m, RETURN_TYPE, r);
    return r;
  }

  /* ********************************************************** */
  // Statement*
  static boolean Schema(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Schema")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Statement(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "Schema", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // TestStatement
  //     | ImportStatement
  //     | ExpressionStatement
  //     | VariableDefinitionStatement
  //     | VariableAssignmentStatement
  //     | ReturnStatement
  //     | ClassDefinition
  //     | InterfaceDefinition
  //     | ForInLoop
  //     | WhileStatement
  //     | BreakStatement
  //     | ContinueStatement
  //     | IfStatement
  //     | IfLetStatement
  //     | StructDefinition
  //     | EnumDefinition
  //     | TryCatchStatement
  //     | SuperConstructorStatement
  //     | ThrowStatement
  //     | LiftStatement
  static boolean Statement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Statement")) return false;
    boolean r;
    r = TestStatement(b, l + 1);
    if (!r) r = ImportStatement(b, l + 1);
    if (!r) r = ExpressionStatement(b, l + 1);
    if (!r) r = VariableDefinitionStatement(b, l + 1);
    if (!r) r = VariableAssignmentStatement(b, l + 1);
    if (!r) r = ReturnStatement(b, l + 1);
    if (!r) r = ClassDefinition(b, l + 1);
    if (!r) r = InterfaceDefinition(b, l + 1);
    if (!r) r = ForInLoop(b, l + 1);
    if (!r) r = WhileStatement(b, l + 1);
    if (!r) r = BreakStatement(b, l + 1);
    if (!r) r = ContinueStatement(b, l + 1);
    if (!r) r = IfStatement(b, l + 1);
    if (!r) r = IfLetStatement(b, l + 1);
    if (!r) r = StructDefinition(b, l + 1);
    if (!r) r = EnumDefinition(b, l + 1);
    if (!r) r = TryCatchStatement(b, l + 1);
    if (!r) r = SuperConstructorStatement(b, l + 1);
    if (!r) r = ThrowStatement(b, l + 1);
    if (!r) r = LiftStatement(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // STRING_LITERAL
  public static boolean String(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "String")) return false;
    if (!nextTokenIs(b, STRING_LITERAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING_LITERAL);
    exit_section_(b, m, STRING, r);
    return r;
  }

  /* ********************************************************** */
  // AccessModifier? STRUCT IDENTIFIER (EXTENDS CustomType (COMMA CustomType)*)? LEFT_CURLY_BRACE StructField* RIGHT_CURLY_BRACE
  public static boolean StructDefinition(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDefinition")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_DEFINITION, "<struct definition>");
    r = StructDefinition_0(b, l + 1);
    r = r && consumeTokens(b, 1, STRUCT, IDENTIFIER);
    p = r; // pin = STRUCT
    r = r && report_error_(b, StructDefinition_3(b, l + 1));
    r = p && report_error_(b, consumeToken(b, LEFT_CURLY_BRACE)) && r;
    r = p && report_error_(b, StructDefinition_5(b, l + 1)) && r;
    r = p && consumeToken(b, RIGHT_CURLY_BRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // AccessModifier?
  private static boolean StructDefinition_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDefinition_0")) return false;
    AccessModifier(b, l + 1);
    return true;
  }

  // (EXTENDS CustomType (COMMA CustomType)*)?
  private static boolean StructDefinition_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDefinition_3")) return false;
    StructDefinition_3_0(b, l + 1);
    return true;
  }

  // EXTENDS CustomType (COMMA CustomType)*
  private static boolean StructDefinition_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDefinition_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXTENDS);
    r = r && CustomType(b, l + 1);
    r = r && StructDefinition_3_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COMMA CustomType)*
  private static boolean StructDefinition_3_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDefinition_3_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!StructDefinition_3_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StructDefinition_3_0_2", c)) break;
    }
    return true;
  }

  // COMMA CustomType
  private static boolean StructDefinition_3_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDefinition_3_0_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && CustomType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // StructField*
  private static boolean StructDefinition_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructDefinition_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!StructField(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StructDefinition_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER TypeAnnotation SEMICOLON
  public static boolean StructField(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructField")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && TypeAnnotation(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, STRUCT_FIELD, r);
    return r;
  }

  /* ********************************************************** */
  // CustomType LEFT_CURLY_BRACE StructLiteralMember* (COMMA StructLiteralMember)* COMMA? RIGHT_CURLY_BRACE
  public static boolean StructLiteral(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructLiteral")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CustomType(b, l + 1);
    r = r && consumeToken(b, LEFT_CURLY_BRACE);
    r = r && StructLiteral_2(b, l + 1);
    r = r && StructLiteral_3(b, l + 1);
    r = r && StructLiteral_4(b, l + 1);
    r = r && consumeToken(b, RIGHT_CURLY_BRACE);
    exit_section_(b, m, STRUCT_LITERAL, r);
    return r;
  }

  // StructLiteralMember*
  private static boolean StructLiteral_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructLiteral_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!StructLiteralMember(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StructLiteral_2", c)) break;
    }
    return true;
  }

  // (COMMA StructLiteralMember)*
  private static boolean StructLiteral_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructLiteral_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!StructLiteral_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "StructLiteral_3", c)) break;
    }
    return true;
  }

  // COMMA StructLiteralMember
  private static boolean StructLiteral_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructLiteral_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && StructLiteralMember(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // COMMA?
  private static boolean StructLiteral_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructLiteral_4")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  //     | (IDENTIFIER COLON Expression)
  public static boolean StructLiteralMember(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructLiteralMember")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = StructLiteralMember_1(b, l + 1);
    exit_section_(b, m, STRUCT_LITERAL_MEMBER, r);
    return r;
  }

  // IDENTIFIER COLON Expression
  private static boolean StructLiteralMember_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructLiteralMember_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, COLON);
    r = r && Expression(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expression LEFT_SQUARE_BRACE Expression RIGHT_SQUARE_BRACE
  public static boolean StructuredAccessExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "StructuredAccessExpression")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRUCTURED_ACCESS_EXPRESSION, "<structured access expression>");
    r = Expression(b, l + 1);
    r = r && consumeToken(b, LEFT_SQUARE_BRACE);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, RIGHT_SQUARE_BRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // SUPER DOT IDENTIFIER
  public static boolean SuperCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuperCall")) return false;
    if (!nextTokenIs(b, SUPER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SUPER, DOT, IDENTIFIER);
    exit_section_(b, m, SUPER_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // SUPER ArgumentList SEMICOLON
  public static boolean SuperConstructorStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "SuperConstructorStatement")) return false;
    if (!nextTokenIs(b, SUPER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SUPER);
    r = r && ArgumentList(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, SUPER_CONSTRUCTOR_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // TEST String Block
  public static boolean TestStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TestStatement")) return false;
    if (!nextTokenIs(b, TEST)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TEST);
    r = r && String(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, TEST_STATEMENT, r);
    return r;
  }

  /* ********************************************************** */
  // THROW Expression? SEMICOLON
  public static boolean ThrowStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ThrowStatement")) return false;
    if (!nextTokenIs(b, THROW)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, THROW_STATEMENT, null);
    r = consumeToken(b, THROW);
    p = r; // pin = THROW
    r = r && report_error_(b, ThrowStatement_1(b, l + 1));
    r = p && consumeToken(b, SEMICOLON) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // Expression?
  private static boolean ThrowStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ThrowStatement_1")) return false;
    Expression(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TRY Block CatchBlock? FinallyBlock?
  public static boolean TryCatchStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryCatchStatement")) return false;
    if (!nextTokenIs(b, TRY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TRY);
    r = r && Block(b, l + 1);
    r = r && TryCatchStatement_2(b, l + 1);
    r = r && TryCatchStatement_3(b, l + 1);
    exit_section_(b, m, TRY_CATCH_STATEMENT, r);
    return r;
  }

  // CatchBlock?
  private static boolean TryCatchStatement_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryCatchStatement_2")) return false;
    CatchBlock(b, l + 1);
    return true;
  }

  // FinallyBlock?
  private static boolean TryCatchStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TryCatchStatement_3")) return false;
    FinallyBlock(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // CustomType QUESTION_MARK?
  //     | BuiltInType QUESTION_MARK?
  //     | BuiltInContainerType QUESTION_MARK?
  //     | JsonContainerType QUESTION_MARK?
  //     | FunctionType QUESTION_MARK?
  //     | ParenthesizedType QUESTION_MARK?
  public static boolean Type(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE, "<type>");
    r = Type_0(b, l + 1);
    if (!r) r = Type_1(b, l + 1);
    if (!r) r = Type_2(b, l + 1);
    if (!r) r = Type_3(b, l + 1);
    if (!r) r = Type_4(b, l + 1);
    if (!r) r = Type_5(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CustomType QUESTION_MARK?
  private static boolean Type_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = CustomType(b, l + 1);
    r = r && Type_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // QUESTION_MARK?
  private static boolean Type_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_0_1")) return false;
    consumeToken(b, QUESTION_MARK);
    return true;
  }

  // BuiltInType QUESTION_MARK?
  private static boolean Type_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BuiltInType(b, l + 1);
    r = r && Type_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // QUESTION_MARK?
  private static boolean Type_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_1_1")) return false;
    consumeToken(b, QUESTION_MARK);
    return true;
  }

  // BuiltInContainerType QUESTION_MARK?
  private static boolean Type_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = BuiltInContainerType(b, l + 1);
    r = r && Type_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // QUESTION_MARK?
  private static boolean Type_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_2_1")) return false;
    consumeToken(b, QUESTION_MARK);
    return true;
  }

  // JsonContainerType QUESTION_MARK?
  private static boolean Type_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = JsonContainerType(b, l + 1);
    r = r && Type_3_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // QUESTION_MARK?
  private static boolean Type_3_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_3_1")) return false;
    consumeToken(b, QUESTION_MARK);
    return true;
  }

  // FunctionType QUESTION_MARK?
  private static boolean Type_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FunctionType(b, l + 1);
    r = r && Type_4_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // QUESTION_MARK?
  private static boolean Type_4_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_4_1")) return false;
    consumeToken(b, QUESTION_MARK);
    return true;
  }

  // ParenthesizedType QUESTION_MARK?
  private static boolean Type_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ParenthesizedType(b, l + 1);
    r = r && Type_5_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // QUESTION_MARK?
  private static boolean Type_5_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Type_5_1")) return false;
    consumeToken(b, QUESTION_MARK);
    return true;
  }

  /* ********************************************************** */
  // COLON Type
  public static boolean TypeAnnotation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeAnnotation")) return false;
    if (!nextTokenIs(b, COLON)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && Type(b, l + 1);
    exit_section_(b, m, TYPE_ANNOTATION, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean TypeIdentifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeIdentifier")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, TYPE_IDENTIFIER, r);
    return r;
  }

  /* ********************************************************** */
  // AT_TYPE LEFT_PARENTHESIS Type RIGHT_PARENTHESIS
  public static boolean TypeIntrinsic(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TypeIntrinsic")) return false;
    if (!nextTokenIs(b, AT_TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AT_TYPE, LEFT_PARENTHESIS);
    r = r && Type(b, l + 1);
    r = r && consumeToken(b, RIGHT_PARENTHESIS);
    exit_section_(b, m, TYPE_INTRINSIC, r);
    return r;
  }

  /* ********************************************************** */
  // UnaryOperators Expression
  public static boolean UnaryExpression(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryExpression")) return false;
    if (!nextTokenIs(b, "<unary expression>", NOT, SUBTRACTION)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_EXPRESSION, "<unary expression>");
    r = UnaryOperators(b, l + 1);
    r = r && Expression(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NOT
  //     | SUBTRACTION
  public static boolean UnaryOperators(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "UnaryOperators")) return false;
    if (!nextTokenIs(b, "<unary operators>", NOT, SUBTRACTION)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNARY_OPERATORS, "<unary operators>");
    r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, SUBTRACTION);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ReferenceExpression AssignmentOperator Expression SEMICOLON
  public static boolean VariableAssignmentStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableAssignmentStatement")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_ASSIGNMENT_STATEMENT, "<variable assignment statement>");
    r = ReferenceExpression(b, l + 1);
    r = r && AssignmentOperator(b, l + 1);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LET Reassignable? IDENTIFIER TypeAnnotation? ASSIGNMENT Expression SEMICOLON
  public static boolean VariableDefinitionStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinitionStatement")) return false;
    if (!nextTokenIs(b, LET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LET);
    r = r && VariableDefinitionStatement_1(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && VariableDefinitionStatement_3(b, l + 1);
    r = r && consumeToken(b, ASSIGNMENT);
    r = r && Expression(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, VARIABLE_DEFINITION_STATEMENT, r);
    return r;
  }

  // Reassignable?
  private static boolean VariableDefinitionStatement_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinitionStatement_1")) return false;
    Reassignable(b, l + 1);
    return true;
  }

  // TypeAnnotation?
  private static boolean VariableDefinitionStatement_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "VariableDefinitionStatement_3")) return false;
    TypeAnnotation(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // WHILE Expression Block
  public static boolean WhileStatement(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WhileStatement")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && Expression(b, l + 1);
    r = r && Block(b, l + 1);
    exit_section_(b, m, WHILE_STATEMENT, r);
    return r;
  }

}
