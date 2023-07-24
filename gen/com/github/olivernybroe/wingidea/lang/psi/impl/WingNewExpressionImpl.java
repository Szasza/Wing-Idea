// This is a generated file. Not intended for manual editing.
package com.github.olivernybroe.wingidea.lang.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.olivernybroe.wingidea.lang.psi.WingElementTypes.*;
import com.github.olivernybroe.wingidea.lang.psi.*;

public class WingNewExpressionImpl extends WingExpressionImpl implements WingNewExpression {

  public WingNewExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitNewExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public WingArgumentList getArgumentList() {
    return findNotNullChildByClass(WingArgumentList.class);
  }

  @Override
  @Nullable
  public WingCustomType getCustomType() {
    return findChildByClass(WingCustomType.class);
  }

  @Override
  @NotNull
  public List<WingExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingExpression.class);
  }

  @Override
  @Nullable
  public WingMutableContainerType getMutableContainerType() {
    return findChildByClass(WingMutableContainerType.class);
  }

}
