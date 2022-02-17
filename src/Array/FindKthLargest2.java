package Array;

/**
 * [215] Kth Largest Element in an Array
 * @author : huangrui
 * @version :
 * @date : 2022-02-17 16:36
 **/
public class FindKthLargest2 {

    public int findKthLargest(int[] nums, int k) {

        int target = nums.length - k;
        int low = 0, high = nums.length - 1;
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

    private int position(int[] nums, int low, int high) {

        int p = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= p) {
                high--;
            }
            nums[low] = nums[high];
            while (low < high && nums[low] <= p) {
                low++;
            }
            nums[high] = nums[low];
        }
        nums[low] = p;
        return low;
    }

    public static void main(String[] args) {
        FindKthLargest2 findKthLargest2 = new FindKthLargest2();
        System.out.println(findKthLargest2.findKthLargest(new int[] {
            3,
            2,
            1,
            5,
            6,
            4
        }, 2));
    }
}
