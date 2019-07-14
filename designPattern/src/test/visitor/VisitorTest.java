package visitor;



import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.IntStream;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.junit.Test;

public class VisitorTest {


  @RequiredArgsConstructor
  class VisitableA implements Visitable {

    private final int num;

    @Override
    public int getNum() {
      return num;
    }

    @Override
    public void accept(Visitor visitor) {
      visitor.visit(this);
    }
  }

  class VisitorA implements Visitor {
    @Getter
    private int sum;

    @Override
    public void visit(Visitable visitable) {
      sum += visitable.getNum();
    }

  }

  @Test
  public void visit() {
    // Given
    VisitorA visitor = new VisitorA();

    // When
    IntStream.rangeClosed(1, 5)
      .mapToObj(VisitableA::new)
      .forEach(visitableA -> visitableA.accept(visitor));

    // Then
    assertThat(visitor.getSum()).isEqualTo(15);
  }
}