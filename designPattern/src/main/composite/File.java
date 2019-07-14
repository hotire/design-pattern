package composite;

import lombok.Data;

/**
 * Leaf
 */
@Data
public class File<T> extends Component{
  T data;
}
