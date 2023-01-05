package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangrui
 * @date 2023/1/5
 */
public class CountPairs {

    public int countPairs(int[] nums, int low, int high) {
        int count = 0;
        nums = Arrays.stream(nums).sorted().toArray();
        for (int i = 0;  i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int r = nums[i] ^ nums[j];
                if (low <= r && r <= high) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {7881,760,709,2937,1245,720,5187,6361,3793,141,7238};
        CountPairs countPairs = new CountPairs();
        System.out.println(countPairs.countPairs(nums, 1492, 3832));
    }
}
