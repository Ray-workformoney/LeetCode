package Array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
/**
 * [128]最长连续序列
 * @author : huangrui
 * @version :
 * @date : 2021-11-16 15:15
 **/
public class LongestConsecutive {

    public static int longestConsecutive(int[] nums) {

        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        if (numSet.isEmpty()) {
            return 0;
        }
        int maxLen = 1;
        for (int num : nums) {
            if (!numSet.contains(num - 1)) {
                // 只有当前数字是序列的第一个数字的时候才进入
                int currentNum = num;
                int currentLen = 1;
                while (numSet.contains(currentNum+ 1)) {
                    currentNum = currentNum + 1;
                    currentLen = currentLen + 1;
                }
                maxLen = Math.max(currentLen, maxLen);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[] {100,4,200,1,3,2}));
    }
}
