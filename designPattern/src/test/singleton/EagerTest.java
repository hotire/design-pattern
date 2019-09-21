package singleton;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class EagerTest {

  @Test
  public void getInstance() {
    // When
    final Eager instance = Eager.getInstance();
    final Eager instance2 = Eager.getInstance();

    // Then
    assertThat(instance).isNotNull();
    assertThat(instance).isInstanceOf(Eager.class);
    assertThat(instance).isEqualTo(instance2);
  }

  @Test
  public void serializable() throws IOException, ClassNotFoundException {
    // When
    final Eager instance = Eager.getInstance();
    Serializer.writeObject(instance);

    // When
    final Eager result = Serializer.readObject(Eager.class);

    // Then
    Assertions.assertThat(instance).isEqualTo(result);
  }
}