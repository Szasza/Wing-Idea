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

public class WingClassImplementationImpl extends WingElementImpl implements WingClassImplementation {

  public WingClassImplementationImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitClassImplementation(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<WingClassField> getClassFieldList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingClassField.class);
  }

  @Override
  @NotNull
  public List<WingInflightMethodDefinition> getInflightMethodDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingInflightMethodDefinition.class);
  }

  @Override
  @NotNull
  public List<WingInitializer> getInitializerList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingInitializer.class);
  }

  @Override
  @NotNull
  public List<WingMethodDefinition> getMethodDefinitionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, WingMethodDefinition.class);
  }

}
