package String;

import java.util.ArrayList;
import java.util.List;
/**
 * [22]括号生成
 * @author : huangrui
 * @version :
 * @date : 2021-10-13 17:40
 **/
public class GenerateParenthesis {

    public static List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs("", n, n, res);
        return res;
    }

    private static void dfs(String currentStr, int left, int right, List<String> res) {

        if (left == 0 && right == 0) {
            // 结束递归
            res.add(currentStr);
            return;
        }
        if (left > 0) {
            // 左括号有剩余 加上一个左括号
            dfs(currentStr + "(", left - 1, right, res);
        }
        if (right > left && right > 0) {
            // 右括号剩余数量大于左括号且有括号有剩余 加上一个右括号
            dfs(currentStr + ")", left, right - 1, res);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(3).forEach(System.out::println);
    }
}
