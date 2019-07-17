package chain;

import java.util.Optional;

public abstract class Validator {

  private Validator nextValidator;

  public Validator() { }

  public Validator(Validator nextValidator) {
    this.nextValidator = nextValidator;
  }

  public void process(Request request) {
    if (validate(request)) {
      Optional.ofNullable(nextValidator)
        .ifPresent(validator -> validator.process(request));
    }

  }

  protected abstract boolean validate(Request request);



}
