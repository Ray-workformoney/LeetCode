package Array;

/**
 * [215] Kth Largest Element in an Array
 * 2022年8月16日 快排没写出来
 * @author huangrui
 * @date 2022/8/16
 */
public class FindKthLargest3 {

    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;
        int low = 0;
        int high = nums.length - 1;
        while (true) {
            int position = position(nums, low, high);
            if (position == target) {
                return nums[position];
            } else if (position < target) {
                low = position + 1;
            } else {
                high = position - 1;
            }
        }
    }

    public int position(int[] nums, int low, int high) {
        int temp = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= temp) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= temp) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = temp;
        return low;
    }

    public static void main(String[] args) {
        FindKthLargest3 findKthLargest3 = new FindKthLargest3();
        System.out.println(findKthLargest3.findKthLargest(new int[] {
                3,
                2,
                1,
                5,
                6,
                4
        }, 2));
    }
}
