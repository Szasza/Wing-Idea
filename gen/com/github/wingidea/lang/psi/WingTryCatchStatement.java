// This is a generated file. Not intended for manual editing.
package com.github.wingidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WingTryCatchStatement extends WingElement {

  @NotNull
  WingBlockStatement getBlockStatement();

  @Nullable
  WingCatchBlock getCatchBlock();

  @Nullable
  WingFinallyBlock getFinallyBlock();

}
