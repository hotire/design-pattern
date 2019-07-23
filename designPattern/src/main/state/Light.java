package state;

import lombok.Getter;

public class Light implements LightState {
  protected LightState lightState;

  @Getter
  private int count = 0;

  public Light() {
    lightState = offState;
  }

  private LightState offState = new LightState() {
    @Override
    public LightState on() {
      count++;
      lightState = onState;
      return this;
    }

    @Override
    public LightState off() {
      lightState = this;
      return this;
    }
  };

  private LightState onState = new LightState() {
    @Override
    public LightState on() {
      lightState = this;
      return this;
    }

    @Override
    public LightState off() {
      count++;
      lightState = offState;
      return this;
    }
  };

  public LightState on() {
    lightState.on();
    return this;
  }

  public LightState off() {
    lightState.off();
    return this;
  }
}
