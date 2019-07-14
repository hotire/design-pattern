package visitor;

import java.util.function.Consumer;

@FunctionalInterface
public interface Visitor extends Consumer<Visitable> {
  void visit(Visitable visitable);

  default void accept(Visitable visitable) {
    visit(visitable);
  }
}
