package state;

public class Light implements LightState {
  protected LightState lightState;

  public Light() {
    lightState = offState;
  }

  private LightState offState = new LightState() {
    @Override
    public LightState on() {
      System.out.println("on");
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
      System.out.println("off");
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
