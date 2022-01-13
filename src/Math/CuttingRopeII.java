package Math;

/**
 * [剑指offer14-II]剪绳子II
 * @author : huangrui
 * @version :
 * @date : 2022-01-12 15:50
 **/
public class CuttingRopeII {

    public int cuttingRope(int n) {

        if (n <= 3) {
            return n - 1;
        }
        long res = 1;
        while (n > 4) {
           res = res * 3 % 1000000007;
           n -= 3;
        }
        return (int) (res * n % 1000000007);

    }

    public static void main(String[] args) {
        CuttingRopeII cuttingRopeII = new CuttingRopeII();
        System.out.println(cuttingRopeII.cuttingRope(120));
    }
}
