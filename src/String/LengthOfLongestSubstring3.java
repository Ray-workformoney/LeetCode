package String;

import java.util.HashMap;
import java.util.Map;
/**[3] Longest Substring Without Repeating Characters
 *
 * @author : huangrui
 * @version :
 * @date : 2022-02-15 18:36
 **/
public class LengthOfLongestSubstring3 {

    /**
     * 滑动窗口
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> index = new HashMap<>();
        int begin = 0, end = 0, maxLen = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (index.containsKey(c)) {
                maxLen = Math.max(maxLen, end - begin + 1);
                begin = Math.max(begin, index.get(c) + 1);
            }
            end = i;
            index.put(c, i);
        }
        maxLen = Math.max(maxLen, end - begin + 1);
        return maxLen;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring3 lengthOfLongestSubstring3 = new LengthOfLongestSubstring3();
        System.out.println(lengthOfLongestSubstring3.lengthOfLongestSubstring(" "));
    }
}
