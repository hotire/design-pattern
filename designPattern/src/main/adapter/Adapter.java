package adapter;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class Adapter implements PrintAble{
  private final Adaptee adaptee;

  @Override
  public PrintAble print() {
    adaptee.print();
    return this;
  }
}
