package reactor;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * http://i5on9i.blogspot.com/2013/11/reactor-pattern.html
 * https://jongmin92.github.io/2019/03/05/Java/java-reactor-pattern/
 * https://ozt88.tistory.com/25
 *
 * NIO
 * https://palpit.tistory.com/645
 * https://velog.io/@victor/IO-%EC%8B%9C-buffer%EB%A5%BC-%EC%84%A4%EC%A0%95%ED%95%98%EB%A9%B4-%EB%B9%A0%EB%A5%B8-%EC%9D%B4%EC%9C%A0
 */

public class Reactor implements Runnable {

  private final Selector selector;

  private final ServerSocketChannel serverSocket;

  public Reactor(int port) throws IOException {
    selector = Selector.open();
    serverSocket = ServerSocketChannel.open();
    serverSocket.socket().bind(
      new InetSocketAddress(port));
    serverSocket.configureBlocking(false);
    SelectionKey sk =
      serverSocket.register(selector, SelectionKey.OP_ACCEPT);
    sk.attach(new Acceptor());
  }

  public void run() {
    System.out.println("Server listening to port: " + serverSocket.socket().getLocalPort());

    try {
      while (!Thread.interrupted()) {
        selector.select(); // blocking
        selector.selectedKeys().forEach(this::dispatch);
      }
    } catch (IOException ex) {
      System.exit(1);
    }
  }

  void dispatch(SelectionKey k) {
    Runnable r = (Runnable) (k.attachment());
    if (r != null) {
      r.run();
    }
  }

  class Acceptor implements Runnable { // inner

    public void run() {
      try {
        SocketChannel c = serverSocket.accept();
        if (c != null) {
          System.out.println("new client connected");
          new ReadHandler(selector, c);
        }
      } catch (IOException ex) { /* ... */ }
    }
  }
}
