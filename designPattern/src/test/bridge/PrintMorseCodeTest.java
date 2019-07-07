package bridge;

import org.junit.Test;

public class PrintMorseCodeTest {

  @Test
  public void print() {
    new PrintMorseCode().dot().dash().space();
  }
}