package composite;

import lombok.Getter;
import lombok.Setter;

/**
 * Leaf
 */
public class File<T> extends Component {
  @Getter
  @Setter
  private T data;

  public File(String name) {
    super(name);
  }

  public File(String name, T data) {
    super(name);
    this.data = data;
  }
}
