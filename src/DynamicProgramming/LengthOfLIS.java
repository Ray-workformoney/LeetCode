package DynamicProgramming;

import java.util.Arrays;
/**
 * [300]最长递增子序列
 * @author : huangrui
 * @version :
 * @date : 2021-11-11 13:50
 **/
public class LengthOfLIS {

    /**
     * 动态规划 dp[i] 为以 nums[i] 结尾的最长递增子序列长度
     * 状态转移方程 dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)
     * @param nums
     * @return
     */
    public static int lengthOfLIS(int[] nums) {

        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int maxLen = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    // nums[i] 可以接在 nums[j] 后面构成递增子序列
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[] {0,1,0,3,2,3}));
    }
}
