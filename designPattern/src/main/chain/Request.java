package chain;

import java.util.HashMap;
import java.util.Map;
import lombok.Data;

@Data
public class Request {
  private Map<String ,Object> params = new HashMap<>();
  private Throwable error;
}
