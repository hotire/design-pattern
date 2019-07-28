package reactor;

import static reactor.HandlerState.READING;
import static reactor.HandlerState.SENDING;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.HashMap;
import java.util.Map;

public class Handler implements Runnable {

  protected final SocketChannel socket;

  protected final SelectionKey sk;

  protected ByteBuffer input = ByteBuffer.allocate(1024);

  protected ByteBuffer output = ByteBuffer.allocate(1024);

  protected HandlerState state = READING;

  protected Map<HandlerState, Runnable> handlerMap;

  Handler(Selector sel, SocketChannel c) throws IOException {
    this.socket = c;
    c.configureBlocking(false);
    // Optionally try first read now
    this.sk = socket.register(sel, 0);
    this.sk.attach(this);
    this.sk.interestOps(SelectionKey.OP_READ);
    sel.wakeup();

    handlerMap = new HashMap<>();
    handlerMap.put(READING, this::read);
    handlerMap.put(SENDING, this::send);
  }

  void process(int readCount) {}

  // class Handler continued
  public void run() {
    handlerMap.get(state).run();
  }

  void read() {
    int readCount = 0;

    try {
      readCount = socket.read(input);
    } catch (IOException e) {
//      throw new RuntimeException(e);
//      System.out.println("Connection closed," );
    }

    if (readCount > 0) {
      process(readCount);
    }

    state = SENDING;
    // Normally also do first write now
    sk.interestOps(SelectionKey.OP_WRITE);
  }

  void send() {
    try {
      socket.write(output);
      sk.interestOps(SelectionKey.OP_READ);
      state = READING;
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}
