package reactor;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ReactorTest {

  public static void main(String args[]) throws IOException {
    Reactor reactor = new Reactor(8080);
    Client client = new Client("127.0.0.1", 8080);
    Executor executor = Executors.newFixedThreadPool(2);


    executor.execute(reactor);
    System.out.println("?");
    client.run();
  }
}