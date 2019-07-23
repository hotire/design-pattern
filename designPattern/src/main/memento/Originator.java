package memento;

import lombok.Getter;

public class Originator {

  @Getter
  private String state;

  public Memento createMemento() {
    return new Memento(state);
  }

  public void resotreMement(Memento memento) {
    this.state = memento.getState();
  }

  public Originator setState(String state) {
    this.state = state;
    return this;
  }
}
