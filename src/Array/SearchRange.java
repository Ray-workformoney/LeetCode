package Array;

import java.util.Arrays;
/**
 * [34]在排序数组中查找元素的第一个和最后一个位置
 * @author : huangrui
 * @version :
 * @date : 2021-09-28 15:12
 **/
public class SearchRange {

    /**
     * 二分查找
     * @param nums
     * @param target
     * @return
     */
    public static int[] searchRange(int[] nums, int target) {

        if (nums.length == 0) {
            return new int[] {-1, -1};
        }
        int index = find(nums, 0, nums.length - 1, target);
        if (index == -1) {
            // 没找到 直接返回
            return new int[] {-1, -1};
        }
        // 找到了 向前 向后找到边界
        int low = index, high = index;
        while (low >= 0 && nums[low] == target) {
            low--;
        }
        while (high <= nums.length - 1 && nums[high] == target) {
            high++;
        }
        return new int[] {++low, --high};
    }

    private static int find(int[] nums, int low, int high, int target) {

        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {6};
        int target = 6;
        Arrays.stream(searchRange(nums, target)).forEach(System.out::print);
    }
}
