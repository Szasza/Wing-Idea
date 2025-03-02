// This is a generated file. Not intended for manual editing.
package com.github.wingidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WingInflightClosureExpression extends WingExpression {

  @NotNull
  WingArgumentList getArgumentList();

  @NotNull
  WingBlockStatement getBlockStatement();

  @Nullable
  WingTypeAnnotation getTypeAnnotation();

}
