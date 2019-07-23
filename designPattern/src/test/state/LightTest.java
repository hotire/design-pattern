package state;

import org.assertj.core.api.Assertions;
import org.junit.Test;

public class LightTest {

  @Test
  public void on_on() {
    // Given
    Light light = new Light();

    // When
    light.on().on();

    // Then
    Assertions.assertThat(light.getCount()).isEqualTo(1);
  }

  @Test
  public void off_off() {
    // Given
    Light light = new Light();

    // When
    light.off().off();

    // Then
    Assertions.assertThat(light.getCount()).isEqualTo(0);
  }

  @Test
  public void on_off() {
    // Given
    Light light = new Light();

    // When
    light.on().off();

    // Then
    Assertions.assertThat(light.getCount()).isEqualTo(2);
  }

  @Test
  public void off_on() {
    // Given
    Light light = new Light();

    // When
    light.off().on();

    // Then
    Assertions.assertThat(light.getCount()).isEqualTo(1);
  }
}
