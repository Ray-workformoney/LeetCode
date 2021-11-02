package DynamicProgramming;

/**
 * [5]最长回文子串
 * @author : huangrui
 * @version :
 * @date : 2021-11-02 16:07
 **/
public class LongestPalindrome {

    /**
     * 中心扩散法 以s[i]或s[i]s[i + 1]为中心
     * 依次判断中心两边的字符是否相等 得到奇数长度和偶数长度的子串
     * 选择长度最长的作为结果
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {

        if (s.length() == 1) {
            return s;
        }
        if (s.length() == 2) {
            return s.charAt(0) == s.charAt(1) ? s : String.valueOf(s.charAt(0));
        }
        String res = "";
        for (int i = 0; i < s.length() - 1; i++) {
            // 以 s[i] 为中心进行扩散 得到长度为奇数的子串
            String oddStr = centerSpread(s, i, i);
            // 以 s[i]s[i + 1] 进行扩散 得到长度为偶数的子串
            String evenStr = centerSpread(s, i, i + 1);
            String maxStr = oddStr.length() > evenStr.length() ? oddStr : evenStr;
            res = maxStr.length() > res.length() ? maxStr : res;
        }
        return res;
    }

    private static String centerSpread(String s, int left, int right) {
        int len = s.length();
        int i = left;
        int j = right;
        while (i >= 0 && j <= len - 1) {
            if (s.charAt(i) == s.charAt(j)) {
                i--;
                j++;
            } else {
                break;
            }
        }
        // 退出循环的两种情况 i < 0 || s[i] != s[j]
        // 第二种情况说明 s[i + 1] == s[j - 1]
        // 因此截取子串时需要从 i + 1 开始截取
        return s.substring(i + 1, j);
    }

    public static void main(String[] args) {
        String s = "ccb";
        System.out.println(longestPalindrome(s));
    }
}
