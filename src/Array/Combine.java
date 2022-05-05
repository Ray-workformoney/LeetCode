package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Common.PrintUtils;
/**
 * [77]组合
 * @author : huangrui
 * @version :
 * @date : 2021-12-15 19:34
 **/
public class Combine {

    public List<List<Integer>> combine(int n, int k) {

        int[] nums = new int[n];
        for (int i = 1; i <= n; i++) {
            nums[i - 1] = i;
        }
        List<List<Integer>> r = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> combine = new ArrayList<>();
            combine.add(nums[i]);
            dfs(Arrays.copyOfRange(nums, i + 1, nums.length), k, combine, r);
        }
        return r;
    }

    private void dfs(int[] nums, int k, List<Integer> combine, List<List<Integer>> result) {

        if (combine.size() == k) {
            result.add(combine);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            List<Integer> newCombine = new ArrayList<>(combine);
            newCombine.add(nums[i]);
            dfs(Arrays.copyOfRange(nums, i + 1, nums.length), k, newCombine, result);
        }
    }

    public static void main(String[] args) {
        Combine combine = new Combine();
        PrintUtils.print(combine.combine(4, 2));
    }
}
