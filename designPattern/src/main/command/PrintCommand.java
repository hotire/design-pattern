package command;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PrintCommand<T> implements Command {

  private final T data;

  @Override
  public void execute() {
    System.out.println(data);
  }
}
