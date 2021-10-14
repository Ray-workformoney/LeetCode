package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * [39]组合总和
 * @author : huangrui
 * @version :
 * @date : 2021-10-14 15:54
 **/
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(candidates, res, temp, 0, target);
        return res;
    }

    private static void dfs(int[] candidates, List<List<Integer>> res, List<Integer> current, int currentSum, int target) {
        if (candidates.length == 0) {
            return;
        }
        for (int i = 0; i < candidates.length; i++) {
            int tempSum = currentSum + candidates[i];
            if (tempSum == target) {
                // 找到了 保存当前的这个组合
                List<Integer> tempList = new ArrayList<>(current);
                tempList.add(candidates[i]);
                res.add(tempList);
            }
            if (tempSum < target) {
                // 往下继续找
                List<Integer> tempList = new ArrayList<>(current);
                tempList.add(candidates[i]);
                dfs(Arrays.copyOfRange(candidates, i, candidates.length), res, tempList, tempSum, target);
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = {2,7,6,3,5,1};
        int target = 9;
        combinationSum(candidates, target).forEach(x -> {
            x.forEach(System.out::print);
            System.out.println();
        });
    }
}
