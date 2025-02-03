// This is a generated file. Not intended for manual editing.
package com.github.wingidea.lang.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface WingClassImplementation extends WingElement {

  @NotNull
  List<WingClassField> getClassFieldList();

  @NotNull
  List<WingInflightMethodDefinition> getInflightMethodDefinitionList();

  @NotNull
  List<WingInitializer> getInitializerList();

  @NotNull
  List<WingMethodDefinition> getMethodDefinitionList();

}
