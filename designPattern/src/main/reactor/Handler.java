package reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public final class Handler implements Runnable {
  final SocketChannel socket;
  final SelectionKey sk;
  ByteBuffer input = ByteBuffer.allocate(1024);
  ByteBuffer output = ByteBuffer.allocate(1024);
  static final int READING = 0, SENDING = 1;
  int state = READING;

  Handler(Selector sel, SocketChannel c)
    throws IOException {
    socket = c;
    c.configureBlocking(false);
    // Optionally try first read now
    sk = socket.register(sel, 0);
    sk.attach(this);
    sk.interestOps(SelectionKey.OP_READ);
    sel.wakeup();
  }

  void process() { /* ... */ }

  // class Handler continued
  public void run() {
    try {
      if (state == READING) read();
      else if (state == SENDING) send();
    } catch (IOException ex) { /* ... */ }
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
