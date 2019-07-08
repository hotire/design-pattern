package bridge;

import org.junit.Test;

public class DefaultMorseCodeTest {

  @Test
  public void print() {
    new DefaultMorseCode(new MorseCodeFunction() {

      @Override
      public void dot() {
        System.out.println(".");
      }

      @Override
      public void dash() {
        System.out.println("-");
      }

      @Override
      public void space() {
        System.out.println(" ");
      }
    }).dot().dash().space();
  }
}