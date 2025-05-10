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

public class WingIfLetStatementImpl extends WingElementImpl implements WingIfLetStatement {

  public WingIfLetStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitIfLetStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<WingBlock> getBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingBlock.class);
  }

  @Override
  @NotNull
  public List<WingElIfBlock> getElIfBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingElIfBlock.class);
  }

  @Override
  @NotNull
  public List<WingElIfLetBlock> getElIfLetBlockList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingElIfLetBlock.class);
  }

  @Override
  @NotNull
  public WingExpression getExpression() {
    return findNotNullChildByClass(WingExpression.class);
  }

  @Override
  @Nullable
  public WingReassignable getReassignable() {
    return findChildByClass(WingReassignable.class);
  }

  @Override
  @NotNull
  public PsiElement getIdentifier() {
    return findNotNullChildByType(IDENTIFIER);
  }

}
