package DynamicProgramming;

/**
 * [剑指offer 10-II] 青蛙跳台阶问题
 * @author : huangrui
 * @version :
 * @date : 2021-12-30 14:02
 **/
public class NumWays {

    public int numWays(int n) {
        if (n <= 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }

        int a = 1, b = 2, sum = 0;
        for (int i = 3; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        NumWays numWays = new NumWays();
        System.out.println(numWays.numWays(7));
    }
}
