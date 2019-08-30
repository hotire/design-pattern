package singleton;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class DoubleCheckedLockingTest {

  @Test
  public void getInstance() {
    // When
    final DoubleCheckedLocking instance = DoubleCheckedLocking.getInstance();
    final DoubleCheckedLocking instance2 = DoubleCheckedLocking.getInstance();

    // Then
    assertThat(instance).isNotNull();
    assertThat(instance).isInstanceOf(DoubleCheckedLocking.class);
    assertThat(instance).isEqualTo(instance2);
  }
}