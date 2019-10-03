package singleton;

import java.io.Serializable;

/**
 * 
 * @author : hoTire
 * @comment : Holder
 */
public class SingletonHolder implements Serializable {
	private SingletonHolder(){}
	private static class Holder {
		private static final SingletonHolder INSTANCE = new SingletonHolder();
	}
	public static SingletonHolder getInstance() {
		return Holder.INSTANCE;
	}

	private Object readResolve() {
		return getInstance();
	}
}
