package proxy;

import java.lang.reflect.Proxy;
import java.util.Random;
import java.util.Stack;

/**
 * 
 * @author : hoTire
 * @comment : Sorting Utils
 */
public class SortingUtils implements Sortable {

	private SortingUtils() {};
	private static Sortable instance = SortingUtils.newInstance();
	private static Sortable newInstance() {
		Sortable sortingUtils = new SortingUtils();
		return (Sortable) Proxy.newProxyInstance(sortingUtils.getClass().getClassLoader(),
				sortingUtils.getClass().getInterfaces(), new DynamicInvocationHandler(sortingUtils));
	}
	public static Sortable getInstance() {
		return instance;
	}
	public void quickSort(int[] arr) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(0); // L
		stack.push(arr.length - 1); // R
		while (!stack.isEmpty()) {
			int R = stack.pop();
			int L = stack.pop();
			if (R > L) {
				int index = new Random().nextInt(R - L + 1) + L;
				swap(arr, index, R);
				int pivot = R;
				int begin = L - 1;
				int end = R;

				while (begin < end) {
					while (begin < end && arr[++begin] < arr[pivot]);
					while (begin < end && arr[--end] < arr[pivot]);
					swap(arr, begin, end);
				}
				swap(arr, pivot, begin);

				stack.push(L); // L
				stack.push(begin - 1); // R
				stack.push(begin + 1); // L
				stack.push(R); // R
			}
		}
	}

	public void mergeSort(int[] arr) {
		int[] b = new int[arr.length + 1]; // tmp 배열
		int num = arr.length;
		for (int k = 1; k < num; k *= 2) { // 1, 2, 4, 8 ....
			for (int left = 0; left + k < num; left += k * 2) { // 0 1 / 2 3
				int right = left + k; // right = 1
				int rend = right + k; // rend = 2
				if (rend > num) rend = (int) num;
				int count = left;
				int begin = left;
				int center = right;
				while (begin < right && center < rend) {
					if (arr[begin] <= arr[center]) {
						b[count++] = arr[begin++];
					} else {
						b[count++] = arr[center++];
					}
				}
				while (begin < right) b[count++] = arr[begin++];
				while (center < rend) b[count++] = arr[center++];
				for (int i = left; i < rend; i++)
					arr[i] = b[i];
			}
		}
	};

	public void swap(int[] arr, int x, int y) {
		int temp = x;
		x = y;
		y = temp;
	}
}
