
import java.util.*;
public class Main {
    public static void main(String[] args){
        int[] twoSumArray = new int[]{ 2, 4, 1, 7, 9};
        int[] pairsArray = new int[]{ 1, 1, 2, 2, 3, 3, 3, 3, 4, 5, 5, 6, 6, 6, 7, 7, 7, 7, 7, 7, 8, 8, 8, 8, 8};
        int x = 8;
        //String[] strs = new String[]{ "flower", "flow", "flight"};
        //String st1 = longestCommonPrefix(strs);

        //int l = longestSubstringWRC2("bbc");

        System.out.println(myStoi("    -42"));

        //System.out.println(Arrays.toString(twoSumFromArrayBrute(twoSumArray, x)));
        //System.out.println(theOddOnesOut(pairsArray));
    }

    public static String myStoi(String s){
        boolean negate = false;
        StringBuilder stb = new StringBuilder();
        char c;
        for(int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            if(c != ' '){
                if (c > 48 && c < 58){
                    stb.append(c);
                } else if (c == '-'){
                    negate = !negate;
                } else{
                    if(stb.capacity() == 0){
                        return "0";
                    }
                }
            } else{
                if(stb.length() > 0) {
                    break;
                }
            }
        }

        return stb.toString();
    }

    public static String longestCommonPrefix(String[] strs){
        StringBuilder stB = new StringBuilder();
        HashMap<Character, mutableInt> freq = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            for(int j = 0; j < strs[i].length(); j++){
                mutableInt count = freq.get(strs[i].charAt(j));
                if (count == null){
                    freq.put(strs[i].charAt(j), new mutableInt());
                }else{
                    count.increment();
                }
            }
        }
        System.out.println(freq);
        return stB.toString();
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

    //My implementation; tbh not very good.
    public static String longestSubstringWRC1(String s){ // Longest Substring without repeating characters
        HashSet<Character> strSet = new HashSet<>();
        //StringBuilder stB = new StringBuilder();
        int bIndex = 0;
        int i;
        String longest = "";
        /*
        Iterating through a String. charAt is fastest with short length strings, reflection is better for long length strings
         */
        for(i = 0; i < s.length(); i++){
            if(strSet.contains(s.charAt(i))){
                if(longest.length() < s.substring(bIndex,i).length()) {
                    longest = s.substring(bIndex, i);
                }
                i = bIndex + 1;
                bIndex = i;
                strSet.clear();
            }
            strSet.add(s.charAt(i));
        }
        if(longest.length() < s.substring(bIndex,i).length()){
            longest = s.substring(bIndex,i);
        }
        return longest;
    }

    // An implementation that is close to the best.
    public static int longestSubstringWRC2(String s){ // Longest Substring without repeating characters
        Map<Character, Integer> strSet = new HashMap<>();
        int start = 0, len = 0;

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(strSet.containsKey(c)){
                if(strSet.get(c) >= start){
                    start = strSet.get(c) + 1;
                }
            }
            len = Math.max(len, i-start+1);
            strSet.put(c, i);
        }

        return len;
    }

    public int[] twoSumFromArrayBest(int[] nums, int target) {
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
}

class mutableInt{
    int value = 1;
    public void increment(){ value = value + 1; }
    public int getValue() { return value; }
    public String toString(){
        return String.valueOf(value);
    }
}
