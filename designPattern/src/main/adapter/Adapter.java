package adapter;

import lombok.RequiredArgsConstructor;


/**
 * https://lalwr.blogspot.com/2016/03/adapter-vs-facade-vs-decorator.html
 * https://free-strings.blogspot.com/2016/04/adapter-decorator-facade-proxy.html
 *
 * 한 클래스의 인터페이스를 클라이언트에서 사용하고자 하는 다른 인터페이스로 변환합니다.
 */
@RequiredArgsConstructor
public class Adapter implements PrintAble {
  private final Target target;

  @Override
  public PrintAble print() {
    target.print();
    return this;
  }
}
