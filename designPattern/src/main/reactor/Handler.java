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
import java.util.Optional;

public final class Handler implements Runnable {
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
    handlerMap.put(READING, () -> {
      try {
        read();
      } catch (IOException e) {
        e.printStackTrace();
      }
    });

    handlerMap.put(SENDING, () -> {
      try {
        send();
      } catch (IOException e) {
        e.printStackTrace();
      }
    });
  }

  void process() { /* ... */ }

  // class Handler continued
  public void run() {
    Optional.ofNullable(handlerMap.get(state))
      .orElseThrow()
      .run();
  }

  void read() throws IOException {
    int readCount = socket.read(input);
    if (readCount > 0) {
      process();
    }

    state = SENDING;
    // Normally also do first write now
    sk.interestOps(SelectionKey.OP_WRITE);
  }

  void send() throws IOException {
    socket.write(output);
  }
}
