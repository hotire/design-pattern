package singleton;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import org.assertj.core.api.Assertions;
import org.junit.Test;

public class SingletonHolderTest {

  @Test
  public void getInstance() {
    // When
    final SingletonHolder instance = SingletonHolder.getInstance();
    final SingletonHolder instance2 = SingletonHolder.getInstance();

    // Then
    assertThat(instance).isNotNull();
    assertThat(instance).isInstanceOf(SingletonHolder.class);
    assertThat(instance).isEqualTo(instance2);
  }

  @Test
  public void serializable() throws IOException, ClassNotFoundException {
    // When
    final SingletonHolder instance = SingletonHolder.getInstance();
    Serializer.writeObject(instance, "holder");

    // When
    final SingletonHolder result = Serializer.readObject(SingletonHolder.class, "holder");

    // Then
    Assertions.assertThat(instance).isEqualTo(result);
  }
}