package DynamicProgramming;

/**
 * [剑指 offer 10 - I] 斐波那契数列
 * @author : huangrui
 * @version :
 * @date : 2021-12-30 11:19
 **/
public class Fib {

    public int fib(int n) {

        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int a = 0, b = 1, sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib(5));
    }
}
