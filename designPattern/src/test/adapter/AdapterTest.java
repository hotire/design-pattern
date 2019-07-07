package adapter;

import static org.junit.Assert.*;

import org.junit.Test;

public class AdapterTest {

  @Test
  public void print(){
    PrintAble printAble = new Adapter(new Adaptee());
    printAble.print().print();
  }
}