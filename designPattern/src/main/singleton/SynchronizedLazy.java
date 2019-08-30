package singleton;

import java.util.Optional;

/**
 * 
 * @author : hoTire
 * @comment : thread safe
 */
public class SynchronizedLazy {
	private static volatile SynchronizedLazy instance;
	private SynchronizedLazy(){}
	public static synchronized  SynchronizedLazy getInstance() {
		return Optional.ofNullable(instance)
			.orElseGet(() -> instance = new SynchronizedLazy());
	}
	public static SynchronizedLazy getInstanceByBlock() {
		synchronized (SynchronizedLazy.class) {
			return Optional.ofNullable(instance)
				.orElseGet(() -> instance = new SynchronizedLazy());
		}
	}
}
