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

public class WingCatchBlockImpl extends WingElementImpl implements WingCatchBlock {

  public WingCatchBlockImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitCatchBlock(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public WingBlockStatement getBlockStatement() {
    return findNotNullChildByClass(WingBlockStatement.class);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

}
