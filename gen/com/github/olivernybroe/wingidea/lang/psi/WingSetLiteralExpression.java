// This is a generated file. Not intended for manual editing.
package com.github.olivernybroe.wingidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WingSetLiteralExpression extends WingExpression {

  @Nullable
  WingContainerValueType getContainerValueType();

  @NotNull
  List<WingExpression> getExpressionList();

}
