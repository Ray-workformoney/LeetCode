package String;

import java.util.Stack;
/**
 * [32]最长有效括号
 * @author : huangrui
 * @version :
 * @date : 2021-09-29 16:00
 **/
public class LongestValidParentheses {

    /**
     * 用一个数组记录匹配的括号位置 遍历数组 统计最长连续匹配括号的长度
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {

        Stack<Integer> stack = new Stack<>();
        int[] temp = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if ("(".equals(c.toString())) {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    int index = stack.pop();
                    temp[index] = 1;
                    temp[i] = 1;
                } else {
                    temp[i] = 0;
                }
            }
        }
        while (!stack.isEmpty()) {
            int index = stack.pop();
            temp[index] = 0;
        }
        int res = 0, len = 0;
        for (int j : temp) {
            if (j == 1) {
                len++;
                res = Math.max(len, res);
            } else {
                res = Math.max(len, res);
                len = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestValidParentheses("()(((()"));
    }
}
