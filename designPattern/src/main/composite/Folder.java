package composite;

import java.util.List;

/**
 * Composite
 */
public class Folder extends Component {

  private List<Component> components;

  public Folder(List<Component> components) {
    this.components = components;
  }

  public Folder add(Component component) {
    this.components.add(component);
    return this;
  }
  public Folder remove(Component component) {
    this.components.remove(component);
    return this;
  }
}
