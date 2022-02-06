import java.util.Arrays;

public class ArraySortingUtil {

    public static void java_sort(int[] arr){
        // Uses Tim sort for objects
        // Uses QuickSort for primitives
        // Both are O(NlogN)
        Arrays.sort(arr);
    }

    public static void bubble_sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j >= i + 1; j--) {
                if (arr[j] < arr[j - 1]){
                    int temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void selection_sort(int[] arr){
        for (int i = 0; i < arr.length - 1; i++) {
            int min_idx = i;
            for(int j = i + 1; j< arr.length;j++){
                if(arr[j] < arr[min_idx]){
                    min_idx = j;
                }
            }

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }
    }
}
