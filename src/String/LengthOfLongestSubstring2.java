package String;

import java.util.HashMap;
import java.util.Map;
/**
 * [3]无重复字符的最长子串
 * @author : huangrui
 * @version :
 * @date : 2021-12-09 16:04
 **/
public class LengthOfLongestSubstring2 {

    public static int lengthOfLongestSubstring(String s) {

        if (s.length() <= 1) {
            return s.length();
        }
        Map<Character, Integer> index = new HashMap<>();
        int maxLen = 0;
        int begin = 0;
        for (int i = 0; i < s.length(); i++) {
            if (index.containsKey(s.charAt(i))) {
                begin = begin + 1;
                i = begin;
                index.clear();
            }
            int thisLen = i - begin + 1;
            maxLen = Math.max(maxLen, thisLen);
            index.put(s.charAt(i), i);
        }
        int finalLen = s.length() - begin;
        maxLen = Math.max(finalLen, maxLen);
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
