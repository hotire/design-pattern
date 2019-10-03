package singleton;

import java.io.Serializable;

/**
 * 
 * @author : hoTire
 * @comment : Eager
 */
public class Eager implements Serializable {
	private static Eager instance = new Eager();
	private Eager() {}
	public static Eager getInstance() {
		return instance;
	}
	private Object readResolve() {
		return getInstance();
	}
}
