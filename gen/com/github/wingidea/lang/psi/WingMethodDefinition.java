// This is a generated file. Not intended for manual editing.
package com.github.wingidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WingMethodDefinition extends WingElement {

  @Nullable
  WingBlock getBlock();

  @NotNull
  List<WingMethodModifiers> getMethodModifiersList();

  @NotNull
  WingParameterList getParameterList();

  @Nullable
  WingReturnType getReturnType();

  @NotNull
  PsiElement getIdentifier();

}
