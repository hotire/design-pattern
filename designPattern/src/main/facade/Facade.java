package facade;

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

  public void process() {
    subSystem01.process();
    subSystem02.process();
  }
}
