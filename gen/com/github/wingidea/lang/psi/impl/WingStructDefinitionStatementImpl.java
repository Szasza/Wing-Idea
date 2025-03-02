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

public class WingStructDefinitionStatementImpl extends WingElementImpl implements WingStructDefinitionStatement {

  public WingStructDefinitionStatementImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitStructDefinitionStatement(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WingAccessModifier getAccessModifier() {
    return findChildByClass(WingAccessModifier.class);
  }

  @Override
  @NotNull
  public List<WingStructField> getStructFieldList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingStructField.class);
  }

}
