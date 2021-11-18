package Array;

import java.util.Arrays;
/**
 * [135]分发糖果
 * @author : huangrui
 * @version :
 * @date : 2021-11-18 15:48
 **/
public class Candy {

    public static int candy(int[] ratings) {

        int len = ratings.length;
        if (len <= 1) {
            return len;
        }
        int[] candyLeft = new int[len];
        int[] candyRight = new int[len];
        Arrays.fill(candyLeft, 1);
        Arrays.fill(candyRight, 1);
        // 从左往右
        for (int i = 1; i < len; i++) {
           if (ratings[i] > ratings[i - 1]) {
               candyLeft[i] = candyLeft[i - 1] + 1;
           }
        }
        int count = candyLeft[len - 1];
        // 从右往左
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                candyRight[i] = candyRight[i + 1] + 1;
            }
            count = count + Math.max(candyLeft[i], candyRight[i]);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(candy(new int[] {0,1,2,5,3,2,7}));
    }
}
