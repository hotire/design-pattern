package main.facade;


import facade.Facade;
import facade.SubSystem01;
import facade.SubSystem02;
import java.util.Map;
import org.assertj.core.api.Assertions;
import org.junit.Test;


public class FacadeTest {

  @Test
  public void process() {
    // Given
    Facade facade = new Facade(new SubSystem01(), new SubSystem02());

    // When
    Map<String, String> result = facade.process();

    // Then
    Assertions.assertThat(result.size()).isEqualTo(2);
    Assertions.assertThat(result).containsKey("subSystem01");
    Assertions.assertThat(result).containsKey("subSystem02");
  }

}
