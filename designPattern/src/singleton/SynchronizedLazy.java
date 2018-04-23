package singleton;

/**
 * 
 * @author : hoTire
 * @comment : thread safe
 */
public class SynchronizedLazy {
	private static volatile SynchronizedLazy instance;
	private SynchronizedLazy(){};
	public static synchronized  SynchronizedLazy getInstacne() {
		if (instance == null) instance = new SynchronizedLazy(); 
		return instance;
	}
	public static SynchronizedLazy getInstacne2() {
		synchronized (SynchronizedLazy.class) {
			if (instance == null) instance = new SynchronizedLazy(); 
		}
		return instance; 
	}
}
