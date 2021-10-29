package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/**
 * [78]子集
 * @author : huangrui
 * @version :
 * @date : 2021-10-29 14:31
 **/
public class Subsets {

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        result.add(Collections.emptyList());
        dfs(nums, 0, nums.length - 1, result, current);
        return result;
    }

    private static void dfs(int[] nums, int start, int end, List<List<Integer>> res, List<Integer> curr) {
        if (start > end) {
            return;
        }
        for (int i = start; i <= end; i++) {
            List<Integer> copy = new ArrayList<>(curr);
            // 每加一个数就把当前组合添加到结果集
            copy.add(nums[i]);
            res.add(new ArrayList<>(copy));
            dfs(nums, i + 1, end, res, copy);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> res = subsets(nums);
        res.forEach(l -> {
            l.forEach(System.out::print);
            System.out.println();
        });
    }
}
