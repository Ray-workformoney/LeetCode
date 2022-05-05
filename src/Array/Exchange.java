package Array;

import Common.PrintUtils;
/**
 * [剑指offer21]调整数组顺序使奇数位于偶数前面
 * @author : huangrui
 * @version :
 * @date : 2022-01-25 15:14
 **/
public class Exchange {

    public int[] exchange(int[] nums) {

        int odd = 0, even = nums.length - 1;
        while (odd < nums.length && even >= 0 && odd < even) {
            if (nums[odd] % 2 == 0) {
                int temp = nums[odd];
                nums[odd] = nums[even];
                nums[even] = temp;
                even--;
            } else if (nums[odd] % 2 != 0) {
                odd++;
            }
            if (nums[even] % 2 != 0) {
                int temp = nums[even];
                nums[even] = nums[odd];
                nums[odd] = temp;
                odd++;
            } else if (nums[even] % 2 == 0) {
                even--;
            }
        }
        return nums;
    }

    public int[] exchange2(int[] nums) {
        int odd = 0, even = nums.length - 1;
        while (odd < even) {
            while (odd < nums.length && (nums[odd] & 1) == 1) {
                odd++;
            }
            while (even >= 0 && (nums[even] & 1) == 0) {
                even--;
            }
            if (odd < even) {
                int temp = nums[odd];
                nums[odd] = nums[even];
                nums[even] = temp;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        Exchange exchange = new Exchange();
        PrintUtils.print(exchange.exchange2(new int[] {
            1,
            2,
            3,
            4
        }));
    }
}
