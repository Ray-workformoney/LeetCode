package Math;

/**
 * [剑指offer14-I]剪绳子
 * @author : huangrui
 * @version :
 * @date : 2022-01-12 15:24
 **/
public class CuttingRope {

    /**
     * 尽量切出长度为3的
     * @param n
     * @return
     */
    public int cuttingRope(int n) {

        if (n <= 3) {
            return n - 1;
        }
        // a 能切多少段长度为3的 b 还剩下的长度
        int a = n / 3, b = n % 3;
        // 如果正好切完 返回3的a次方
        if (b == 0) {
            return (int) Math.pow(3.0, a);
        }
        // 如果还是1 将一个3拆成2*2
        if (b == 1) {
            return (int) Math.pow(3.0, a - 1) * 4;
        }
        // 最后还剩2 返回3的a次方*2
        return (int) Math.pow(3.0, a) * 2;
    }

    public static void main(String[] args) {
        CuttingRope cuttingRope = new CuttingRope();
        System.out.println(cuttingRope.cuttingRope(10));
    }
}
