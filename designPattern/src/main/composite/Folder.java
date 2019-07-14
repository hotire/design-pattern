package composite;

import java.util.HashSet;
import java.util.Set;
import lombok.Getter;

/**
 * Composite
 */
public class Folder extends Component {

  @Getter
  private Set<Component> children;

  public Folder(String name, Set<Component> children) {
    super(name);
    this.children = children;
  }

  public Folder(String name) {
    super(name);
    this.children = new HashSet<>();
  }

  public Folder add(Component component) {
    children.add(component);
    return this;
  }
  public Folder remove(Component component) {
    children.remove(component);
    return this;
  }
}
