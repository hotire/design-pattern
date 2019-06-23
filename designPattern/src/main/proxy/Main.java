package proxy;

/**
 * 
 * @author : hoTire
 * @comment : Test
 */
public class Main {
	public static void main(String args[]) {
		int[] arr = new int[]{1,2,3,4,5};
		Sortable sortingUtils = SortingUtils.getInstance();
		sortingUtils.quickSort(arr);
	}
}
