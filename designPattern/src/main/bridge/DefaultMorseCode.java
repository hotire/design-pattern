package bridge;

/**
 * https://gyrfalcon.tistory.com/entry/Adapter-vs-Bridge-Composite-vs-Decorator-vs-Proxy-%EB%B9%84%EA%B5%90
 *
 * Bridge 패턴
 *
 * Abstraction과 Implementor을 분리하는 것이 목적이다.
 *
 * 추상이라는 것은 멤버로 Implementor의 인터페이스를 가지고 있고 해당 인터페이스를 통해 호출한다.
 *
 * 구현체가 바뀌어도 Abstraction에 영향을 주지 않는다.
 *
 * Abstraction 코드가 바뀌어도 Implementor에 영향을 주지 않는다.
 *
*/
public class DefaultMorseCode extends AbstractMorseCode {

  public DefaultMorseCode(MorseCodeFunction morseCodeFunction) {
    super(morseCodeFunction);
  }

  @Override
  public MorseCode dot(){
    morseCodeFunction.dot();
    System.out.println("Override dot!!");
    return this;
  }
}
