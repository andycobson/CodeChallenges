import java.util.*;

public class OperationsOnArrays {

    public static int lastStoneWeight(int[] stones){
        if(stones.length == 1){ return stones[0]; }
        int i = stones.length - 1;
        Arrays.sort(stones);
        while (stones[i - 1] != 0) {
            if(stones[i - 1] == stones[i]){
                stones[i - 1] = 0;
                stones[i] = 0;
            } else if (stones[i - 1] != stones[i]) {
                stones[i - 1] = stones[i] - stones[i - 1];
                stones[i] = 0;
            }
            Arrays.sort(stones);
        }
        return stones[stones.length - 1];
    }

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

    public static boolean containersDuplicate(int[] nums){
        Set<Integer> map = new HashSet<>();
        for(int i : nums){
            if(map.contains(i)){
                return true;
            }
            map.add(i);
        }
        return false;
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
