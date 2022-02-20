package Array;

/**
 * [6012] 统计各位数字之和为偶数的数字个数
 * @author : huangrui
 * @version :
 * @date : 2022-02-20 14:39
 **/
public class CountEven {

    public int countEven(int num) {

        int res = 0;
        for (int n = 1; n <= num; n++) {
            int c = n;
            int sum = 0;
            while (c > 0) {
                sum += c % 10;
                c = c / 10;
            }
            if (sum % 2 == 0) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountEven countEven = new CountEven();
        System.out.println(countEven.countEven(4));
    }

}
