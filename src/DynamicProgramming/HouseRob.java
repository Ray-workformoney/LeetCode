package DynamicProgramming;

/**
 * @program: LeetCode_J
 * @description: 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，
 * 影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 * @author: huangrui
 * @create: 2020-07-10 11:23
 **/

public class HouseRob {

    /**
     * 思路：维护一个数组robMoney, robMoney[i]表示抢劫从0到i个房子所获得的最大金钱,
     * 易知robMoney[0]=nums[0],robMoney[1]=Max(nums[0], nums[1]);
     * 每个房子有抢与不抢两种状态,因为不可抢与其相邻的房子,故对第i个房子有,抢:num[i]+robMoney[i-2],不抢:robMoney[i-1]
     * 所以robMoney[i]=Max(num[i]+robMoney[i-2],robMoney[i-1])
     * 对nums遍历完成后,robMoney的最后一个元素即为所得金钱最大值
     */

    public static int rob(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] robMoney = new int[nums.length];
        robMoney[0] = nums[0];
        robMoney[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            robMoney[i] = Math.max(nums[i] + robMoney[i - 2], robMoney[i - 1]);
        }
        return robMoney[nums.length - 1];
    }

    public static void main(String[] args) {
        int[] nums = {2,7,9,3,1};
        System.out.println(rob(nums));
    }
}
