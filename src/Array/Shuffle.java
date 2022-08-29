package Array;

import Common.PrintUtils;

/**
 * @author huangrui
 * @date 2022/8/29
 */
public class Shuffle {

    public int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        for (int i = 0, j = n, c = 0; j < nums.length; c++) {
           res[c] = c % 2 == 0 ? nums[i++] : nums[j++];
        }
        return res;
    }

    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle();
        PrintUtils.print(shuffle.shuffle(new int[] {1,1,2,2}, 2));
    }
}
