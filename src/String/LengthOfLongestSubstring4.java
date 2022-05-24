package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangrui
 */
public class LengthOfLongestSubstring4 {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> index = new HashMap<>();
        int begin = 0, maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (index.containsKey(s.charAt(i)) && (index.get(s.charAt(i)) >= begin)) {
                begin = Math.max(index.get(s.charAt(i)) + 1, begin);
            } else {
                maxLen = Math.max(maxLen, i - begin + 1);
            }
            index.put(s.charAt(i), i);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring4 lengthOfLongestSubstring4 = new LengthOfLongestSubstring4();
        System.out.println(lengthOfLongestSubstring4.lengthOfLongestSubstring("pwwkew"));
    }
}
