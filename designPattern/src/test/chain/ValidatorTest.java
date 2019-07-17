package chain;

import static org.junit.Assert.*;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class ValidatorTest {

  @Test
  public void chain() {
    // Given
    Request request = new Request();
    Validator validator = new DefaultValidator();

    // When
    validator.process(request);

    // Then
    Assertions.assertThat(request.getError()).isInstanceOf(IllegalStateException.class);
  }
}