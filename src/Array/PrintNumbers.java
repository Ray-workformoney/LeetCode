package Array;

import com.huangrui.leetcode.PrintUtils;
/**
 * [剑指offer17]打印从1到最大的n位数
 * @author : huangrui
 * @version :
 * @date : 2022-01-24 14:55
 **/
public class PrintNumbers {

    public int[] printNumbers(int n) {

        int max = 10;
        for (int i = 2; i <= n; i++) {
            max = max * 10;
        }
        int[] res = new int[max -1];
        for (int i = 1; i < max; i++) {
            res[i - 1] = i;
        }
        return res;
    }

    public static void main(String[] args) {
        PrintNumbers printNumbers = new PrintNumbers();
        PrintUtils.print(printNumbers.printNumbers(3));
    }
}
