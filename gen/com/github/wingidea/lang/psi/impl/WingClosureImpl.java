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

public class WingClosureImpl extends WingElementImpl implements WingClosure {

  public WingClosureImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitClosure(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public WingBlock getBlock() {
    return findNotNullChildByClass(WingBlock.class);
  }

  @Override
  @Nullable
  public WingClosureModifiers getClosureModifiers() {
    return findChildByClass(WingClosureModifiers.class);
  }

  @Override
  @NotNull
  public WingParameterList getParameterList() {
    return findNotNullChildByClass(WingParameterList.class);
  }

  @Override
  @Nullable
  public WingReturnType getReturnType() {
    return findChildByClass(WingReturnType.class);
  }

}
