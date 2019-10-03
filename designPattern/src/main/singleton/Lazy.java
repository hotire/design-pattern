package singleton;

import java.util.Optional;

/**
 * 
 * @author : hoTire
 * @comment : Lazy
 */
public class Lazy {
	private static Lazy instance;
	private Lazy() {}
	public static Lazy getInstance() {
		return Optional.ofNullable(instance)
			.orElseGet(() -> instance = new Lazy());
	}
	private Object readResolve() {
		return getInstance();
	}
}
