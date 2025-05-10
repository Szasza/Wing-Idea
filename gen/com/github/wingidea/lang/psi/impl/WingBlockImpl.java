// This is a generated file. Not intended for manual editing.
package com.github.wingidea.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.wingidea.lang.psi.WingElementTypes.*;
import com.github.wingidea.lang.psi.*;

public class WingBlockImpl extends WingElementImpl implements WingBlock {

  public WingBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<WingBreakStatement> getBreakStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingBreakStatement.class);
  }

  @Override
  @NotNull
  public List<WingClassDefinition> getClassDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingClassDefinition.class);
  }

  @Override
  @NotNull
  public List<WingContinueStatement> getContinueStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingContinueStatement.class);
  }

  @Override
  @NotNull
  public List<WingEnumDefinition> getEnumDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingEnumDefinition.class);
  }

  @Override
  @NotNull
  public List<WingExpressionStatement> getExpressionStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingExpressionStatement.class);
  }

  @Override
  @NotNull
  public List<WingForInLoop> getForInLoopList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingForInLoop.class);
  }

  @Override
  @NotNull
  public List<WingIfLetStatement> getIfLetStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingIfLetStatement.class);
  }

  @Override
  @NotNull
  public List<WingIfStatement> getIfStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingIfStatement.class);
  }

  @Override
  @NotNull
  public List<WingImportStatement> getImportStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingImportStatement.class);
  }

  @Override
  @NotNull
  public List<WingInterfaceDefinition> getInterfaceDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingInterfaceDefinition.class);
  }

  @Override
  @NotNull
  public List<WingLiftStatement> getLiftStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingLiftStatement.class);
  }

  @Override
  @NotNull
  public List<WingReturnStatement> getReturnStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingReturnStatement.class);
  }

  @Override
  @NotNull
  public List<WingStructDefinition> getStructDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingStructDefinition.class);
  }

  @Override
  @NotNull
  public List<WingSuperConstructorStatement> getSuperConstructorStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingSuperConstructorStatement.class);
  }

  @Override
  @NotNull
  public List<WingTestStatement> getTestStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingTestStatement.class);
  }

  @Override
  @NotNull
  public List<WingThrowStatement> getThrowStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingThrowStatement.class);
  }

  @Override
  @NotNull
  public List<WingTryCatchStatement> getTryCatchStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingTryCatchStatement.class);
  }

  @Override
  @NotNull
  public List<WingVariableAssignmentStatement> getVariableAssignmentStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingVariableAssignmentStatement.class);
  }

  @Override
  @NotNull
  public List<WingVariableDefinitionStatement> getVariableDefinitionStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingVariableDefinitionStatement.class);
  }

  @Override
  @NotNull
  public List<WingWhileStatement> getWhileStatementList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingWhileStatement.class);
  }

}
