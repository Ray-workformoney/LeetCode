package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * [1403]Minimum Subsequence in Non-Increasing Order
 * @author huangrui
 * @date 2022/8/4
 */
public class MinSubsequence {

    public List<Integer> minSubsequence(int[] nums) {

        Arrays.sort(nums);
        int totalSum = Arrays.stream(nums).sum();
        List<Integer> result = new ArrayList<>();
        int subSum = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
           subSum += nums[i];
           result.add(nums[i]);
           if (totalSum - subSum < subSum) {
              break;
           }
        }
        return result;
    }

    public List<Integer> minSubSequenceBucketSort(int[] nums) {
        int[] bucket = new int[101];
        int totalSum = 0;
        for (int num : nums) {
            bucket[num] = bucket[num] + num;
            totalSum += num;
        }
        int subSum = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = bucket.length - 1; i > 0; i--) {
           while (bucket[i] > 0) {
               result.add(i);
               subSum += i;
               if (totalSum - subSum < subSum) {
                   break;
               }
               bucket[i] -= i;
           }
            if (totalSum - subSum < subSum) {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinSubsequence minSubsequence = new MinSubsequence();
        System.out.println(minSubsequence.minSubSequenceBucketSort(new int[]{4,4,7,6,7}));
    }
}
