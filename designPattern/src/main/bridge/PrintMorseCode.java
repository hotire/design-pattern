package bridge;

public class PrintMorseCode implements MorseCode{

  public MorseCode dot(){
    System.out.println(".");
    return this;
  }

  public MorseCode dash(){
    System.out.println("-");
    return this;
  }

  public MorseCode space(){
    System.out.println(" ");
    return this;
  }
}
