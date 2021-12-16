package DynamicProgramming;

/**
 * [1911]最大子序列交替和
 * @author : huangrui
 * @version :
 * @date : 2021-12-16 17:30
 **/
public class MaxAlternatingSum {

    public long maxAlternatingSum(int[] nums) {

        if (nums.length <= 2) {
            return nums[0];
        }
        long[][] dp = new long[2][nums.length];
        dp[0][0] = nums[0];
        dp[1][0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[0][i] = Math.max(nums[i], Math.max(dp[1][i - 1] + nums[i], dp[0][i - 1]));
            dp[1][i] = Math.max(dp[0][i - 1] - nums[i], dp[1][i - 1]);
        }
        return dp[0][nums.length - 1];
    }

    public static void main(String[] args) {
        MaxAlternatingSum maxAlternatingSum = new MaxAlternatingSum();
        System.out.println(maxAlternatingSum.maxAlternatingSum(new int[] {6,2,1,2,4,5}));
    }
}
