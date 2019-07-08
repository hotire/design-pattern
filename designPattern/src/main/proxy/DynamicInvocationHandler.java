package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.UndeclaredThrowableException;

/**
 * https://hamait.tistory.com/868
 */
public class DynamicInvocationHandler implements InvocationHandler {
	private Object delegate;

	public DynamicInvocationHandler(Object delegate) {
		this.delegate = delegate;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		long startTime = System.nanoTime();
		try {
			method.invoke(delegate, args);
		} catch (Throwable t){
			throw unwrapThrowable(t);
		}
		long estimatedTime = System.nanoTime() - startTime;
		System.out.println(method.getName() + " : " + estimatedTime + "ns");
		return null;
	}

	public Throwable unwrapThrowable(Throwable t) {
		Throwable t2 = t;
		while (true) {
			if (t2 instanceof InvocationTargetException) {
				t2 = ((InvocationTargetException) t).getTargetException();
			} else if (t instanceof UndeclaredThrowableException) {
				t2 = ((UndeclaredThrowableException) t).getUndeclaredThrowable();
			} else {
				return t2;
			}
		}
	}

}
