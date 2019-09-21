package reactor;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;

public class ReadHandler extends Handler {

  private StringBuilder sb = new StringBuilder();

  ReadHandler(Selector sel, SocketChannel c) throws IOException {
    super(sel, c);
  }

  @Override
  protected void process(int readCount) {
    sb.setLength(0);

    input.flip();
    byte[] subStringBytes = new byte[readCount];
    byte[] array = input.array();
    System.arraycopy(array, 0, subStringBytes, 0, readCount);
    sb.append(new String(subStringBytes));
    input.clear();

    output = ByteBuffer.wrap((sb.toString().trim() + "\n").getBytes());
  }
}
