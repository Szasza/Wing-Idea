// This is a generated file. Not intended for manual editing.
package com.github.wingidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WingInflightMethodDefinition extends WingElement {

  @Nullable
  WingAccessModifier getAccessModifier();

  @Nullable
  WingBlockStatement getBlockStatement();

  @Nullable
  WingExternModifier getExternModifier();

  @Nullable
  WingParameterList getParameterList();

  @Nullable
  WingTypeAnnotation getTypeAnnotation();

  @NotNull
  PsiElement getIdentifier();

}
