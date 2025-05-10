// This is a generated file. Not intended for manual editing.
package com.github.wingidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WingClassDefinition extends WingElement {

  @NotNull
  WingClassImplementation getClassImplementation();

  @Nullable
  WingClassModifiers getClassModifiers();

  @NotNull
  List<WingTypeIdentifier> getTypeIdentifierList();

  @NotNull
  PsiElement getIdentifier();

}
