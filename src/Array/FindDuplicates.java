package Array;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * [442]数组中重复的数据
 * @author : huangrui
 * @version :
 * @date : 2021-09-22 15:40
 **/
public class FindDuplicates {

    /**
     * 利用Set去重 加入失败的元素说明已经出现过
     * @param nums
     * @return
     */
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        Set<Integer> temp = new HashSet<>();
        for (Integer num : nums) {
            if(!temp.add(num)) {
                // set加入失败说明已经有过一样的元素了
                res.add(num);
            }
        }
        return res;
    }

    /**
     * 原地哈希 利用1 ≤ a[i] ≤ n 将每个元素a[i]映射到数组下标去
     * @param nums
     * @return
     */
    public static List<Integer> findDuplicatesHash(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int len = nums.length;
        if (len == 1) {
            return res;
        }
        for (int i = 0; i < len; i++) {
            // 对于nums[i] 让nums[nums[i] - 1]加上数组的长度
            // 如果nums[i]只出现过一次 那么nums[nums[i] - 1]肯定小于2倍数组长度
            int j = nums[i] % len;
            j = j == 0 ? len : j;
            nums[j - 1] += len;
        }
        int max = len * 2;
        for (int i = 0; i < len; i++) {
            if (nums[i] > max) {
                // 大于2倍数组长度 说明出现过2次以上
                res.add(i + 1);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,1};
        findDuplicatesHash(nums).forEach(System.out::println);
    }
}
