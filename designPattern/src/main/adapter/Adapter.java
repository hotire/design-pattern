package adapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Adapter implements PrintAble{
  private final Target target;

  @Override
  public PrintAble print() {
    target.print();
    return this;
  }
}
