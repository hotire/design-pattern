package facade;

import java.util.Map;

/**
 * https://jusungpark.tistory.com/23
 */
public class Facade {

  private SubSystem01 subSystem01;
  private SubSystem02 subSystem02;

  public Facade(SubSystem01 subSystem01, SubSystem02 subSystem02) {
    this.subSystem01 = subSystem01;
    this.subSystem02 = subSystem02;
  }

  public Map<String, String> process() {
    return Map.of("subSystem01", subSystem01.process(),
      "subSystem02", subSystem02.process());
  }
}
