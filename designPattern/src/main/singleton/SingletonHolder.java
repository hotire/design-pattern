package singleton;

/**
 * 
 * @author : hoTire
 * @comment : Holder
 */
public class SingletonHolder {
	private SingletonHolder(){}
	private static class Holder {
		private final static SingletonHolder instance = new SingletonHolder();
	}
	public static SingletonHolder getInstance() {
		return Holder.instance;
	}
}
