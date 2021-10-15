package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
/**
 * [46]全排列
 * @author : huangrui
 * @version :
 * @date : 2021-10-15 15:55
 **/
public class Permute {

    public static List<List<Integer>> permute(int[] nums) {
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        dfs(numList, res, current);
        return res;
    }

    /**
     * 每次取出一个数加入当前组合
     * 每取出一个数就从剩余数组里删除这个数 直到剩余数组为空 完成一次排列
     * @param numList
     * @param res
     * @param current
     */
    private static void dfs(List<Integer> numList, List<List<Integer>> res, List<Integer> current) {
        if (numList.isEmpty()) {
            // 数组为空 将当前组合加入结果集
            res.add(current);
            return;
        }
        for (int i = 0; i < numList.size(); i++) {
            // 取出一个数
            int tempNum = numList.get(i);
            List<Integer> tempCurList = new ArrayList<>(current);
            // 每取出一个数 将其加入当前组合
            tempCurList.add(tempNum);
            List<Integer> tempNumList = new ArrayList<>(numList);
            // 并从剩余数组里移除这个数
            tempNumList.remove(i);
            // 继续加入下一个数
            dfs(tempNumList, res, tempCurList);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        permute(nums).forEach(x -> {
            x.forEach(System.out::print);
            System.out.println();
        });
    }
}
