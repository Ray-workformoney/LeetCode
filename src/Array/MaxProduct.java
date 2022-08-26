package Array;

import java.util.Arrays;

/**
 * @author huangrui
 * @date 2022/8/26
 */
public class MaxProduct {

    public int maxProductSort(int[] nums) {
        Arrays.sort(nums);
        return (nums[nums.length - 1] - 1) * (nums[nums.length - 2] - 1);
    }

    public int maxProduct(int[] nums) {
        int max = 1, second = 1;
        for (int num : nums) {
            if (num >= max) {
                second = max;
                max = num;
            } else if (num > second) {
                second = num;
            }
        }
        return (max - 1) * (second - 1);
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maxProduct(new int[]{3,4,5,2}));
    }
}
