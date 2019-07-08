/*给定一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？找出所有满足条件且不重复的三元组。
        注意：答案中不可以包含重复的三元组。
        例如, 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
        满足要求的三元组集合为：
        [
        [-1, 0, 1],
        [-1, -1, 2]
        ]

解法:先排序,对于每一个元素num[i],寻找剩下的数中和为-num[i]的两个数
指针j,k分别指向数组中在num[i]之后的剩下的数组,判断num[j] + num[k] 是否等于-num[i],
若等,将i,j,k代表的三个数加入集合中;若小于,j向右移;若大于,k向左移*/

package Array;

import java.util.*;

public class ThreeSum {
    private static List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> temp_res = new HashSet<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++){
            if (nums[i] > 0){
                break;
            }
            int target = 0 - nums[i];
            for (int j = i + 1, k = nums.length - 1; j < k;){
                int plus = nums[j] + nums[k];
                if (plus == target){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[i]);
                    res.add(nums[j]);
                    res.add(nums[k]);
                    j++;
                    k--;
                    temp_res.add(res);
                } else if (plus < target){
                    j++;
                }else {
                    k--;
                }
            }
        }
        result.addAll(temp_res);

        return result;
    }

    public static void main(String[] Args){
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum(nums);
        for(List<Integer> res : result){
            for (Integer num : res){
                System.out.print(num + ", ");
            }
            System.out.println();
        }
    }

}
