package DynamicProgramming;

/**
 * [647]回文子串
 * @author : huangrui
 * @version :
 * @date : 2021-11-03 17:12
 **/
public class CountSubstrings {

    /**
     * 中心扩散法
     * @param s
     * @return
     */
    public static int countSubstrings(String s) {

        if (s.isEmpty()) {
            return 0;
        }
        if (s.length() == 1) {
            return s.length();
        }
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1) ? 3 : 2;
        }
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddStrCount = centerSpread(s, i, i);
            int evenStrCount = centerSpread(s, i, i + 1);
            res = res + oddStrCount + evenStrCount;
        }
        return res;
    }

    /**
     * 每次返回以 s[left]s[right] 为中心的字符的回文子串数量
     * @param s
     * @param left
     * @param right
     * @return
     */
    private static int centerSpread(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                count++;
                left--;
                right++;
            } else {
                break;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(countSubstrings(s));
    }

}
