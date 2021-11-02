package DynamicProgramming;

/**
 * [152]乘积最大子数组
 * @author : huangrui
 * @version :
 * @date : 2021-11-02 15:44
 **/
public class MaxProduct {

    public static int maxProduct(int[] nums) {

        int max = nums[0], min = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                // 当前值为负数 交换最大值最小值
                int temp = max;
                max = min;
                min = temp;
            }
            // 记录当前最大值和最小值
            max = Math.max(max * nums[i], nums[i]);
            min = Math.min(min * nums[i], nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProduct(nums));
    }
}
