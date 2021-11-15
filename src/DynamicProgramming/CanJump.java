package DynamicProgramming;

import java.util.Arrays;
/**
 * [55]跳跃游戏
 * @author : huangrui
 * @version :
 * @date : 2021-11-15 15:39
 **/
public class CanJump {

    /**
     * @param nums
     * @return
     */
    public static boolean canJump(int[] nums) {

        int len = nums.length;
        // dp[i] 代表能否跳到 i 这个位置
        int[] dp = new int[len];
        Arrays.fill(dp, 0);
        dp[0] = 1;
        int i = 0;
        while (i < len) {
            if (dp[i] == 1) {
                // 若当前位置能够到达 根据当前位置能跳跃的长度填充 dp 数组
                for (int j = i; j < len && j <= i + nums[i]; j++) {
                    dp[j] = 1;
                }
                if (dp[len - 1] == 1) {
                    // 若最后一个位置已经能够到达 提前退出
                    break;
                }
                i++;
            } else {
                break;
            }
        }
        return dp[len - 1] == 1;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[] {3,2,1,0,4}));
    }
}
