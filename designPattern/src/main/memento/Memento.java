package memento;

import lombok.AccessLevel;
import lombok.Getter;

public class Memento<T> {
    @Getter(AccessLevel.PROTECTED)
    private T state;

    protected Memento(T state) {
      this.state = state;
    }
}
