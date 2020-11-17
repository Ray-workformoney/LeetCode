package Array;

/**
 * @program: LeetCode_J
 * @description: 搜索旋转排序数组
 * 给你一个整数数组 nums ，和一个整数 target 。
 * 该整数数组原本是按升序排列，但输入时在预先未知的某个点上进行了旋转。（例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2]
 * 请你在数组中搜索 target ，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * 思路：使用二分查找法，首先根据中间数与最右边的数的大小关系确定哪部分的数组是有序的，再判断目标数在哪部分数组中。
 * @author: huangrui
 * @create: 2020-11-17 10:30
 **/

public class SearchRotatedSortedArray {

    public static int search(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] > nums[high]) {
                //如果中间数大于最右边的数，则左半部分是升序的
                if (target < nums[middle] && target >= nums[low]) {
                    //若目标数在左半部分
                    high = middle - 1;
                } else {
                    //目标数在右半部分
                    low = middle + 1;
                }
            } else {
                //如果中间数小于最右边的数，则右半部分是升序的
                if (target > nums[middle] && target <= nums[high]) {
                    //若目标数在右半部分
                    low = middle + 1;
                } else {
                    //目标数在左半部分
                    high = middle - 1;
                }
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {

        int[] nums = {5,6,7,0,1,2,4};
        int target = 0;
        int index = SearchRotatedSortedArray.search(nums, target);
        System.out.print(index);
    }
}
