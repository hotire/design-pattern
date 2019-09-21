package reactor;

import static reactor.HandlerState.PROCESSING;
import static reactor.HandlerState.SENDING;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class HandlerWithThreadPool extends Handler {

  private Executor executor;

  public HandlerWithThreadPool(Selector sel, SocketChannel c) throws IOException {
    super(sel, c);
    executor = Executors.newFixedThreadPool(2);
  }

  public HandlerWithThreadPool(Selector sel, SocketChannel c, Executor executor) throws IOException {
    super(sel, c);
    this.executor = executor;
  }

  @Override
  public void read() {
    int readCount = 0;

    try {
      readCount = socket.read(input);
    } catch (IOException ignore) {
      // ignore
    }

    if (readCount > 0) {
      state = PROCESSING;
      executor.execute(new Processor(readCount));
    }

    sk.interestOps(SelectionKey.OP_WRITE);
  }

  protected synchronized void processAndHandOff(int readCount) {
    process(readCount);
    state = SENDING;
  }

  class Processor implements Runnable {
    int readCount;
    Processor(int readCount) {
      this.readCount =  readCount;
    }
    public void run() {
      processAndHandOff(readCount);
    }
  }
}
