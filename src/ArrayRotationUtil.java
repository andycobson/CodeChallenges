import java.util.Arrays;

public class ArrayRotationUtil {

    // Brute force method
    public static void brute_rotateRight(int[] arr, int r){
        r %= arr.length;
        int temp, prev;

        for(int i = 0; i < r; i++){
            prev = arr[arr.length - 1];
            for(int j = 0; j < arr.length; j++){
                temp = arr[j];
                arr[j] = prev;
                prev = temp;
            }
        }
    }

    public static void brute_rotateLeft(int[] arr, int r){
        r %= arr.length;
        int temp, prev;

        for(int i = 0; i < r; i++){
            prev = arr[0];
            for(int j = arr.length - 1; j >= 0; j--){
                temp = arr[j];
                arr[j] = prev;
                prev = temp;
            }
        }
    }

    // Temporary Variable method
    public static void tv_rotateLeft(int[] arr, int r){
        r %= arr.length;
        for(int i = 0; i < r; i++){
            int temp = arr[0];
            for(int j = 0; j < arr.length - 1; j++){
                arr[j] = arr[j + 1];
            }
            arr[arr.length-1] = temp;
        }
    }

    public static void tv_rotateRight(int[] arr, int r){
        r %= arr.length;
        for(int i = 0; i < r; i++){
            int temp = arr[arr.length-1];
            for(int j = arr.length - 1; j >= 1; j--){
                arr[j] = arr[j - 1];
            }
            arr[0] = temp;
        }
    }

    // Temp Array method
    public static void ta_rotateRight(int[] arr, int r){
        r %= arr.length;
        int[] temp = new int[r];
        for(int i = 0; i < r; i++) {
            temp[i] = arr[arr.length - r + i];
        }
        for(int i = arr.length - r - 1; i >= 0; i--){
            arr[i + r] = arr[i];
        }
        for(int i = 0; i < r; i++) {
            arr[i] =  temp[i];
        }
    }

    public static void ta_rotateLeft(int[] arr, int r){
        r %= arr.length;
        int[] temp = new int[r];
        for(int i = 0; i < r; i++) {
            temp[i] = arr[i];
        }
        for(int i = r; i < arr.length; i++){
            arr[i - r] = arr[i];
        }
        for(int i = 0; i < r; i++) {
            arr[i + arr.length - r] =  temp[i];
        }
    }

    // Auxiliary Array Method
    public static void aa_rotateRight(int[] arr, int r){
        r %= arr.length;
        int[] aux = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            aux[(i + r) % arr.length] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = aux[i];
        }
    }

    public static void aa_rotateLeft(int[] arr, int r) {
        r %= arr.length;
        int[] aux = new int[arr.length];

        for (int i = 0; i < arr.length; ++i) {
            aux[i] = arr[(i + r) % arr.length];
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = aux[i];
        }
    }

    // Juggling Algorithm
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        } else {
            return gcd(b, a % b);
        }
    }

    public static void jug_rotateRight(int[] arr, int r) {
        r = r % arr.length;
        r = arr.length - r;
        int i, j, k, temp;

        int gcd = gcd(r, arr.length);

        for (i = 0; i < gcd; i++) {
            temp = arr[arr.length - i - 1];
            j = arr.length - i - 1;

            while (true) {
                k = (j + r) % arr.length;
                if (k == arr.length - i - 1) {
                    break;
                }
                arr[j] = arr[k];
                j = k;
            }
            arr[k] = temp;
        }
    }

    public static void jug_rotateLeft(int[] arr, int r){
        r = r % arr.length;
        int i, j, k, temp;

        int gcd = gcd(r, arr.length);

        for (i = 0; i < gcd; i++) {
            temp = arr[i];
            j = i;

            while (true) {
                k = (j + r) % arr.length;
                if (k == i) {
                    break;
                }
                arr[j] = arr[k];
                j = k;
            }
            arr[k] = temp;
        }
    }

    // Reversal Algorithm
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void ra_rotateRight(int[] arr, int r) {
        r %= arr.length;

        reverse(arr, 0, arr.length - 1);
        reverse(arr, 0, r - 1);
        reverse(arr, r, arr.length - 1);
    }

    public static void ra_rotateLeft(int[] arr, int r) {
        r %= arr.length;

        reverse(arr, 0 , r - 1);
        reverse(arr, r, arr.length - 1);
        reverse(arr, 0, arr.length - 1);
    }


    // Block Swap Algorithm
    private static void swap(int[] arr, int a, int b, int r){
        for( int i = 0; i < r; i++){
            int temp = arr[a + i];
            arr[a + i] = arr[b + i];
            arr[b + i] = temp;
        }
    }

    public static void bl_leftRotate(int arr[], int r){
        int n = arr.length;

        // if the number of elements to rotate = 0 or equal to size of array
        if(r == 0 || r == n) return;

        int i = r;
        int j = n - r;

        // Perform block swaps till the size of 2 subarrays is not equal
        while(i != j){
            // subarray A size is less
            if (i < j){
                swap(arr, r - i, r - i + j, i);
                j -= 1;
            }

            // subarray B size is less
            else{
                swap(arr, r - i, r, j);
                i -= j;
            }

            // At the end, block swap elements of A and B
            swap(arr, r - i, r, i);
        }
    }

}
