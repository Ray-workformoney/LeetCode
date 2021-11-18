package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * [40]数组总和2
 * @author : huangrui
 * @version :
 * @date : 2021-11-17 16:29
 **/
public class CombinationSum2 {

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        Arrays.sort(candidates);
        Set<List<Integer>> res = new HashSet<>();
        List<Integer> currentList = new ArrayList<>();
        dfs(candidates, currentList,0, res, target);
        return new ArrayList<>(res);
    }

    private static void dfs(int[] candidates, List<Integer> currentList, int currentSum, Set<List<Integer>> res, int target) {

       if (candidates.length == 0) {
           return;
       }
       for (int i = 0; i < candidates.length; i++) {
           int tempSum = currentSum;
           int thisNum = candidates[i];
           List<Integer> tempList = new ArrayList<>(currentList);
           int j = i;
           while (j < candidates.length && candidates[j] == thisNum && tempSum < target) {
               // 相同的数直接加起来 避免重复递归
               tempSum = tempSum + candidates[j];
               tempList.add(candidates[j]);
               j++;
               if (tempSum == target) {
                   break;
               }
           }
           if (tempSum > target) {
               continue;
           }
           if (tempSum < target) {
               dfs(Arrays.copyOfRange(candidates, j, candidates.length), tempList, tempSum, res, target);
           } else {
               res.add(tempList);
           }
       }
    }

    public static void main(String[] args) {
        int[] candidates = new int[] {2,5,2,1,2};
        int target = 5;
        List<List<Integer>> res = combinationSum2(candidates, target);
        System.out.println(res);
    }

}
