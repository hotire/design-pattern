package singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SynchronizedLazyTest {

  @Test
  public void getInstance() {
    // When
    final SynchronizedLazy instance = SynchronizedLazy.getInstance();
    final SynchronizedLazy instance2 = SynchronizedLazy.getInstance();

    // Then
    assertThat(instance).isNotNull();
    assertThat(instance).isInstanceOf(SynchronizedLazy.class);
    assertThat(instance).isEqualTo(instance2);
  }

  @Test
  public void getInstanceByBlock() {
    // When
    final SynchronizedLazy instance = SynchronizedLazy.getInstanceByBlock();
    final SynchronizedLazy instance2 = SynchronizedLazy.getInstanceByBlock();

    // Then
    assertThat(instance).isNotNull();
    assertThat(instance).isInstanceOf(SynchronizedLazy.class);
    assertThat(instance).isEqualTo(instance2);
  }
}