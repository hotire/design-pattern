package singleton;

/**
 * 
 * @author : hoTire
 * @comment : Eager
 */
public class Eager {
	private static Eager instance = new Eager();
	private Eager() {}
	public static Eager getInstance() {
		return instance;
	}
}
