package state;

import org.junit.Test;

public class LightTest {

  @Test
  public void log_onOff() {
    Light light = new Light();

    light.on().on().off().off().on();
  }
}