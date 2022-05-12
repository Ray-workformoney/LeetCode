package Array;

import Common.PrintUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author huangrui
 * @date 2022-05-12
 */

public class TwoSum2 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsMap = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (numsMap.containsKey(diff)) {
               res[0] = numsMap.get(diff);
               res[1] = i;
               break;
            } else {
                numsMap.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TwoSum2 twoSum2 = new TwoSum2();
        PrintUtils.print(twoSum2.twoSum(new int[] {3,3}, 6));
    }
}
