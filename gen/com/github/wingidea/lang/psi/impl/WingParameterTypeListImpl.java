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

public class WingParameterTypeListImpl extends WingElementImpl implements WingParameterTypeList {

  public WingParameterTypeListImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitParameterTypeList(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<WingType> getTypeList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingType.class);
  }

}
