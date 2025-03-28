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

public class WingReferenceExpressionImpl extends WingExpressionImpl implements WingReferenceExpression {

  public WingReferenceExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitReferenceExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<WingAccessor> getAccessorList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingAccessor.class);
  }

  @Override
  @NotNull
  public List<WingArgumentList> getArgumentListList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingArgumentList.class);
  }

}
