package Array;

import java.util.ArrayList;
import java.util.List;
/**
 * [448]找到所有数组中消失的数字
 * @author : huangrui
 * @version :
 * @date : 2021-09-30 17:50
 **/
public class FindDisappearedNumbers {

    /**
     * 原地哈希
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {

        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int num = nums[i] % len;
            num = num == 0 ? len : num;
            nums[num - 1] += len;
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (nums[i] <= len) {
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {};
        findDisappearedNumbers(nums).forEach(System.out::print);
    }
}
