package memento;

import lombok.Getter;

public class Originator<T> {

  @Getter
  private T state;

  public Memento<T> createMemento() {
    return new Memento<>(state);
  }

  public void resotreMemento(Memento<T> memento) {
    this.state = memento.getState();
  }

  public Originator<T> setState(T state) {
    this.state = state;
    return this;
  }
}
