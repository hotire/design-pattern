package command;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.Test;

public class PrintCommandTest {

  @Test
  public void print() {
    List<Command> commands = Lists.newArrayList();

    commands.add(new PrintCommand<>("Hello"));
    commands.add(new PrintCommand<>(2));
    commands.add(new PrintCommand<>("World"));

    commands.forEach(Command::execute);

  }
}