package singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class SingletonHolderTest {

  @Test
  public void getInstance() {
    // When
    final SingletonHolder instance = SingletonHolder.getInstance();
    final SingletonHolder instance2 = SingletonHolder.getInstance();

    // Then
    assertThat(instance).isNotNull();
    assertThat(instance).isInstanceOf(SingletonHolder.class);
    assertThat(instance).isEqualTo(instance2);
  }
}