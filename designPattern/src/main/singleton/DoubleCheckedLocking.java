package singleton;

import java.util.Optional;

/**
 * 
 * @author : hoTire
 * @comment : DCL
 */
public class DoubleCheckedLocking {
	private static volatile DoubleCheckedLocking instance;
	private DoubleCheckedLocking(){};
	public static DoubleCheckedLocking getInstance() {
		return Optional.ofNullable(instance)
			.orElseGet(() -> {
				synchronized(DoubleCheckedLocking.class) {
					return Optional.ofNullable(instance)
						.orElseGet(() -> instance = new DoubleCheckedLocking());
				}
			});
	}
}
