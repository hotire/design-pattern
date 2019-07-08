package bridge;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AbstractMorseCode implements MorseCode {

  protected final MorseCodeFunction morseCodeFunction;

  @Override
  public MorseCode dot() {
    morseCodeFunction.dot();
    return this;
  }

  @Override
  public MorseCode dash() {
    morseCodeFunction.dash();
    return this;
  }

  @Override
  public MorseCode space() {
    morseCodeFunction.space();
    return this;
  }
}
