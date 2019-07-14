package visitor;

import java.util.function.Consumer;

public interface Visitable extends Consumer<Visitor> {
  int getNum();
}
