package Array;

import java.util.Arrays;

public class FindKthLargest {
    private static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public static void main(String[] Args){
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int Kth = findKthLargest(nums, k);
        System.out.println(Kth);
    }
}
