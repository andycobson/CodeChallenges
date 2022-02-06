import javafx.util.Pair;

import java.util.*;

public class OperationsOnStrings {

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

    public static Boolean isValid(String s){
        HashMap<Character,Character> maps=new HashMap<Character,Character>();
        maps.put(')','(');
        maps.put(']','[');
        maps.put('}','{');
        Stack<Character> stack=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(maps.containsKey(c)){
                if(stack.empty()||stack.pop()!=maps.get(c))return false;
            }
            else
                stack.push(c);
        }
        return stack.empty();
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

    public static int romanToInteger(String roman) {
        Map<Character, Integer> symbol_map = new HashMap<>();
        symbol_map.put('I', 1);
        symbol_map.put('V', 5);
        symbol_map.put('X', 10);
        symbol_map.put('L', 50);
        symbol_map.put('C', 100);
        symbol_map.put('D', 500);
        symbol_map.put('M', 1000);

        int total = 0, i = 0;

        while(i < roman.length()){
            if (i + 1 < roman.length() && symbol_map.get(roman.charAt(i)) < symbol_map.get(roman.charAt(i + 1))){
                total += symbol_map.get(roman.charAt(i + 1)) - symbol_map.get(roman.charAt(i));
                i += 2;
            } else{
                total += symbol_map.get(roman.charAt(i));
                i += 1;
            }
        }
        return total;
    }

}
