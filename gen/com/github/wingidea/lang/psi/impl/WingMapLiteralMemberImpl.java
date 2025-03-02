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

public class WingMapLiteralMemberImpl extends WingElementImpl implements WingMapLiteralMember {

  public WingMapLiteralMemberImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitMapLiteralMember(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<WingExpression> getExpressionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingExpression.class);
  }

}
