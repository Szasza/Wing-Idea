// This is a generated file. Not intended for manual editing.
package com.github.wingidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WingExpression extends WingElement {

  @Nullable
  WingCall getCall();

  @Nullable
  WingClosure getClosure();

  @Nullable
  WingCollectionLiteral getCollectionLiteral();

  @Nullable
  WingIntrinsic getIntrinsic();

  @Nullable
  WingJsonLiteral getJsonLiteral();

  @Nullable
  WingLiteral getLiteral();

  @Nullable
  WingOptionalUnwrap getOptionalUnwrap();

  @Nullable
  WingStructLiteral getStructLiteral();

  @Nullable
  WingTypeIntrinsic getTypeIntrinsic();

}
