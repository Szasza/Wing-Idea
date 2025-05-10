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

public class WingExpressionImpl extends WingElementImpl implements WingExpression {

  public WingExpressionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull WingVisitor visitor) {
    visitor.visitExpression(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof WingVisitor) accept((WingVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public WingCall getCall() {
    return findChildByClass(WingCall.class);
  }

  @Override
  @Nullable
  public WingClosure getClosure() {
    return findChildByClass(WingClosure.class);
  }

  @Override
  @Nullable
  public WingCollectionLiteral getCollectionLiteral() {
    return findChildByClass(WingCollectionLiteral.class);
  }

  @Override
  @Nullable
  public WingIntrinsic getIntrinsic() {
    return findChildByClass(WingIntrinsic.class);
  }

  @Override
  @Nullable
  public WingJsonLiteral getJsonLiteral() {
    return findChildByClass(WingJsonLiteral.class);
  }

  @Override
  @Nullable
  public WingLiteral getLiteral() {
    return findChildByClass(WingLiteral.class);
  }

  @Override
  @Nullable
  public WingOptionalUnwrap getOptionalUnwrap() {
    return findChildByClass(WingOptionalUnwrap.class);
  }

  @Override
  @Nullable
  public WingStructLiteral getStructLiteral() {
    return findChildByClass(WingStructLiteral.class);
  }

  @Override
  @Nullable
  public WingTypeIntrinsic getTypeIntrinsic() {
    return findChildByClass(WingTypeIntrinsic.class);
  }

}
