package Array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
/**
 * [56]合并区间
 * @author : huangrui
 * @version :
 * @date : 2021-10-27 17:34
 **/
public class MergeInterval {

    public static int[][] merge(int[][] intervals) {

        if (intervals.length == 1) {
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));
        int[][] res = new int[intervals.length][2];
        res[0] = intervals[0];
        int index = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= res[index][1]) {
                // 当前区间与已保存区间存在重合部分
                // 将合并后区间的右端点扩大到 Max(当前区间的右端点, 已保存区间的右端点)
                res[index][1] = Math.max(intervals[i][1], res[index][1]);
            } else {
                // 不存在重合部分
                // 当前区间单独加入结果集中
                index++;
                res[index] = intervals[i];
            }

        }
        return Arrays.copyOf(res, index + 1);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals);
        Arrays.asList(res).forEach(ints -> Collections.singletonList(ints).forEach(System.out::println));
    }
}
