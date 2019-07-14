package composite;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

/**
 *  Composite pattern
 */
public class ComponentTest {

  @Test
  public void composite() {
    // Given
    Folder root = new Folder("root");
    Folder home = new Folder("home");
    Folder user = new Folder("user");
    Folder hotire = new Folder("hotire");
    File java = new File("java");
    File track1 = new File("track1");
    File track2 = new File("track2");


    // When
    root
      .add(home
        .add(java))
      .add(user
        .add(hotire
          .add(track1)
          .add(track2)));

    // Then
    assertThat(root.getChildren()).contains(home, user);
    assertThat(home.getChildren()).contains(java);
    assertThat(user.getChildren()).contains(hotire);
    assertThat(hotire.getChildren()).contains(track1, track2);
  }
}