package adapter;

import org.junit.Test;

public class AdapterTest {

  @Test
  public void print(){
    PrintAble printAble = new Adapter(new Target());
    printAble.print().print();
  }
}