package singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serializer {

  public static void writeObject(Object target) throws IOException {
    writeObject(target, "connectFactory.ser");
  }

  public static void writeObject(Object target, String file) throws IOException {
    ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
    oos.writeObject(target);
    oos.close();
  }

  @SuppressWarnings("unchecked")
  public static <T> T readObject(Class<T> type, String file) throws IOException, ClassNotFoundException {
    ObjectInputStream osi = new ObjectInputStream(new FileInputStream(file));
    T result = (T) osi.readObject();
    osi.close();
    return result;
  }

  @SuppressWarnings("unchecked")
  public static <T> T readObject(Class<T> type) throws IOException, ClassNotFoundException {
    return readObject(type, "connectFactory.ser");
  }
}
