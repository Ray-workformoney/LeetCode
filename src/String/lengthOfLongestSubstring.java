package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lengthOfLongestSubstring {
    public static int LengthOfLongestSubstring(String s){
        int start = 0, end = 0, maxSize = 0;
        while (start < s.length()){
            Set<Character> subString = new HashSet<>();
            Map<Character, Integer> index = new HashMap<>();
            while (end < s.length() && subString.add(s.charAt(end))){
                index.put(s.charAt(end), end);
                end++;
            }
            int size = end - start;
            maxSize = (size > maxSize) ? size : maxSize;
            if (end >= s.length())
                break;
            start = index.get(s.charAt(end)) + 1;
            end = start;
        }
        return maxSize;
    }

    public static void main(String[] Args){
        String s = "dvdf";
        System.out.println(LengthOfLongestSubstring(s));
    }
}
