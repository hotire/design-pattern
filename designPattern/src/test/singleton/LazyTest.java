package singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class LazyTest {

  @Test
  public void getInstance() {
    // When
    final Lazy instance = Lazy.getInstance();
    final Lazy instance2 = Lazy.getInstance();

    // Then
    assertThat(instance).isNotNull();
    assertThat(instance).isInstanceOf(Lazy.class);
    assertThat(instance).isEqualTo(instance2);
  }
}