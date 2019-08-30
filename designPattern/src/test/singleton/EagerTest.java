package singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class EagerTest {

  @Test
  public void getInstance() {
    // When
    final Eager instance = Eager.getInstance();
    final Eager instance2 = Eager.getInstance();

    // Then
    assertThat(instance).isNotNull();
    assertThat(instance).isInstanceOf(Eager.class);
    assertThat(instance).isEqualTo(instance2);
  }
}