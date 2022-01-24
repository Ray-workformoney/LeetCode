package Math;

/**
 * [剑指offer16]数值的整数次方
 * @author : huangrui
 * @version :
 * @date : 2022-01-13 14:02
 **/
public class MyPow {

    public double myPow(double x, int n) {

        if (Double.valueOf(x).equals(1.0)) {
           return x;
        }
        if (x == 0) {
            return 0;
        }
        long n2 = n;
        if (n2 < 0) {
            x = 1 / x;
            n2 = -n2;
        }
        double res = 1;
        while (n2 >  0) {
            if ((n2 & 1) == 1) {
                res *= x;
            }
            x *= x;
            n2 /= 2;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
