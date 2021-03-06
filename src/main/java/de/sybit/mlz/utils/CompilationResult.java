

package de.sybit.mlz.utils;

import com.sun.tools.javac.tree.JCTree;
import com.sun.tools.javac.util.Context;


final class CompilationResult extends Compilation {

  private final JCTree.JCCompilationUnit compilationUnit;

  private final Context context;

  private final String source;

  CompilationResult(
      JCTree.JCCompilationUnit compilationUnit,
      Context context,
      String source) {
    if (compilationUnit == null) {
      throw new NullPointerException("Null compilationUnit");
    }
    this.compilationUnit = compilationUnit;
    if (context == null) {
      throw new NullPointerException("Null context");
    }
    this.context = context;
    if (source == null) {
      throw new NullPointerException("Null source");
    }
    this.source = source;
  }

  @Override
  public JCTree.JCCompilationUnit compilationUnit() {
    return compilationUnit;
  }

  @Override
  public Context context() {
    return context;
  }

  @Override
  public String source() {
    return source;
  }

  @Override
  public String toString() {
    return "Compilation{"
         + "compilationUnit=" + compilationUnit + ", "
         + "context=" + context + ", "
         + "source=" + source
        + "}";
  }

  @Override
  public boolean equals(Object o) {
    if (o == this) {
      return true;
    }
    if (o instanceof Compilation) {
      Compilation that = (Compilation) o;
      return (this.compilationUnit.equals(that.compilationUnit()))
           && (this.context.equals(that.context()))
           && (this.source.equals(that.source()));
    }
    return false;
  }

  @Override
  public int hashCode() {
    int h$ = 1;
    h$ *= 1000003;
    h$ ^= compilationUnit.hashCode();
    h$ *= 1000003;
    h$ ^= context.hashCode();
    h$ *= 1000003;
    h$ ^= source.hashCode();
    return h$;
  }

}
