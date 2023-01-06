package Math;

/**
 * @author huangrui
 * @date 2023/1/6
 */
public class CountEven {

    public int countEven(int num) {
        int count = 0;
        for (int i = 2; i <= num; i++) {
           int r = count(i);
           if (r <= num && r % 2 == 0) {
               count++;
           }
        }
        return count;
    }

    private int count(int num) {
        int res = 0;
        while (num >= 10) {
            res += num % 10;
            num /= 10;
        }
        res += num;
        return res;
    }

    public static void main(String[] args) {
        CountEven countEven = new CountEven();
        System.out.println(countEven.countEven(30));
    }
}
