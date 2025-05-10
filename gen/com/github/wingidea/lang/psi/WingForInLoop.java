// This is a generated file. Not intended for manual editing.
package com.github.wingidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WingForInLoop extends WingElement {

  @Nullable
  WingBlock getBlock();

  @Nullable
  WingExpression getExpression();

  @Nullable
  WingLoopRange getLoopRange();

  @Nullable
  PsiElement getIdentifier();

}
