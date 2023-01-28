package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author huangrui
 * @date 2023/1/28
 */
public class WayToMakeFair {

    public int waysToMakeFair(int[] nums) {

        Map<Integer, Integer> index = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            index.put(i, nums[i]);
        }
        int res = 0;
        for (int del = 0; del < nums.length; del++) {
            int oddSum = 0;
            int evenSum = 0;
            for (int lo : index.keySet()) {
                if (lo == del) {
                    continue;
                }
                int val = index.get(lo);
                if (lo > del) {
                    lo--;
                }
                if (lo % 2 == 0) {
                    evenSum += val;
                } else {
                    oddSum += val;
                }
            }
            if (evenSum == oddSum) {
                res++;
            }
        }
        return res;
    }

    public int waysToMakeFairPre(int[] nums) {
        int originalEvenSum = 0;
        int originalOddSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                originalEvenSum += nums[i];
            } else {
                originalOddSum += nums[i];
            }
        }
        int res = 0;
        int eventSum = 0;
        int oddSum = 0;
        for (int del = 0; del < nums.length; del++) {
            int finalEventSum = 0;
            int finalOddSum = 0;
            if (del % 2 == 0) {
                finalEventSum = eventSum + originalOddSum - oddSum;
                finalOddSum = oddSum + originalEvenSum - eventSum - nums[del];
            } else {
                finalEventSum = eventSum + originalOddSum - oddSum - nums[del];
                finalOddSum = oddSum + originalEvenSum - eventSum;
            }
            if (finalOddSum == finalEventSum) {
                res++;
            }
            if (del % 2 == 0) {
                eventSum += nums[del];
            } else {
                oddSum += nums[del];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1};
        WayToMakeFair wayToMakeFair = new WayToMakeFair();
        System.out.println(wayToMakeFair.waysToMakeFairPre(nums));
    }
}
