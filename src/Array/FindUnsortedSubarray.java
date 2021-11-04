package Array;

import java.util.Arrays;
/**
 * [58]最短无序连续子数组
 * @author : huangrui
 * @version :
 * @date : 2021-11-04 14:34
 **/
public class FindUnsortedSubarray {

    /**
     * 先排序 再和原数组对比
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {

        int[] copy = nums.clone();
        Arrays.sort(nums);
        int start = 0, end = 0;
        int i = 0;
        while (i < nums.length && nums[i] == copy[i]) {
            i++;
        }
        if (i < nums.length) {
            start = i;
        }
        while (i < nums.length) {
            if (nums[i] != copy[i]) {
                end = i;
            }
            i++;
        }
        int res = end - start;
        return res == 0 ? res : res + 1;
    }

    public static void main(String[] args) {
        System.out.println(findUnsortedSubarray(new int[] {1,2,3,4}));
    }
}
