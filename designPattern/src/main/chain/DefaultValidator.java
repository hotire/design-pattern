package chain;

public class DefaultValidator extends Validator{

  public DefaultValidator(){}

  public DefaultValidator(Validator nextValidator) {
    super(nextValidator);
  }

  @Override
  protected boolean validate(Request request) {
    if (!request.getParams().containsKey("test")) {
      request.setError(new IllegalStateException("empty test value"));
      return false;
    }
    return true;
  }
}
