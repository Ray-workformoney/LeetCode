package String;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author huangrui
 */
public class LengthOfLongestSubstring {
    private static int lengthOfLongestSubstring(String s){
        int start = 0, end = 0, maxSize = 0;
        while (start < s.length()){
            Set<Character> subString = new HashSet<>();
            Map<Character, Integer> index = new HashMap<>();
            while (end < s.length() && subString.add(s.charAt(end))){
                index.put(s.charAt(end), end);
                end++;
            }
            int size = end - start;
            maxSize = Math.max(size, maxSize);
            if (end >= s.length()) {
                break;
            }
            start = index.get(s.charAt(end)) + 1;
            end = start;
        }
        return maxSize;
    }

    public static void main(String[] args){
        String s = "dvdf";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
