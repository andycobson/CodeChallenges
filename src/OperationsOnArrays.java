import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class OperationsOnArrays {

    public static int[] twoSumFromArrayBrute(int[] arr, int x){
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j < arr.length; j++){
                if(arr[i] + arr[j] == x){
                    return new int[] { i, j };
                }
            }
        }
        return null;
    }

    public static int[] twoSumFromArrayBest(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        return null;
    }

    public static HashSet<Integer> theOddOnesOut(int[] arr){
        HashSet<Integer> matchingI = new HashSet<Integer>();
        for (int i : arr){
            if(matchingI.contains(i)){
                matchingI.remove(i);
            }else{
                matchingI.add(i);
            }
        }
        return matchingI;
    }

    public static int maxSubArray(int[] nums){
        int maxSubarray = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int currentSubarray = 0;
            for (int j = i; j < nums.length; j++) {
                currentSubarray += nums[j];
                maxSubarray = Math.max(maxSubarray, currentSubarray);
            }
        }
        return maxSubarray;
    }

}
