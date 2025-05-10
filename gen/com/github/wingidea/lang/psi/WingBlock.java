// This is a generated file. Not intended for manual editing.
package com.github.wingidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WingBlock extends WingElement {

  @NotNull
  List<WingBreakStatement> getBreakStatementList();

  @NotNull
  List<WingClassDefinition> getClassDefinitionList();

  @NotNull
  List<WingContinueStatement> getContinueStatementList();

  @NotNull
  List<WingEnumDefinition> getEnumDefinitionList();

  @NotNull
  List<WingExpressionStatement> getExpressionStatementList();

  @NotNull
  List<WingForInLoop> getForInLoopList();

  @NotNull
  List<WingIfLetStatement> getIfLetStatementList();

  @NotNull
  List<WingIfStatement> getIfStatementList();

  @NotNull
  List<WingImportStatement> getImportStatementList();

  @NotNull
  List<WingInterfaceDefinition> getInterfaceDefinitionList();

  @NotNull
  List<WingLiftStatement> getLiftStatementList();

  @NotNull
  List<WingReturnStatement> getReturnStatementList();

  @NotNull
  List<WingStructDefinition> getStructDefinitionList();

  @NotNull
  List<WingSuperConstructorStatement> getSuperConstructorStatementList();

  @NotNull
  List<WingTestStatement> getTestStatementList();

  @NotNull
  List<WingThrowStatement> getThrowStatementList();

  @NotNull
  List<WingTryCatchStatement> getTryCatchStatementList();

  @NotNull
  List<WingVariableAssignmentStatement> getVariableAssignmentStatementList();

  @NotNull
  List<WingVariableDefinitionStatement> getVariableDefinitionStatementList();

  @NotNull
  List<WingWhileStatement> getWhileStatementList();

}
