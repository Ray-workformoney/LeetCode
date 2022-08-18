package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huangrui
 * @date 2022/8/18
 */
public class MaxEqualFreq {

    public int maxEqualFreq(int[] nums) {
        Map<Integer, Integer> numShowTimesMap = new HashMap<>();
        Map<Integer, Integer> showTimeCountMap = new HashMap<>();
        int res = 1;
        int size = 0;
        int maxShowTimes = 0;
        for (int num : nums) {
            size++;
            int numShowTimesOld = numShowTimesMap.getOrDefault(num, 0);
            int numShowTimes = numShowTimesOld + 1;
            showTimeCountMap.put(numShowTimesOld, showTimeCountMap.getOrDefault(numShowTimesOld, 1) - 1);
            showTimeCountMap.put(numShowTimes, showTimeCountMap.getOrDefault(numShowTimes, 0) + 1);
            numShowTimesMap.put(num, numShowTimes);
            maxShowTimes = Math.max(maxShowTimes, numShowTimes);
            // case 1 every number show 1 times
            if (maxShowTimes == 1
                    // case 2 only one number show maxShowTimes times, other number show (maxShowTimes - 1) times, remove this number
                    || showTimeCountMap.get(maxShowTimes) * maxShowTimes + showTimeCountMap.get(maxShowTimes - 1) * (maxShowTimes - 1) == size && showTimeCountMap.get(maxShowTimes) == 1
                    // case 3 only one number show 1 time, the other number show maxShowTimes times, remove number what shows one time
                    || (showTimeCountMap.get(maxShowTimes) * maxShowTimes + 1 == size && showTimeCountMap.get(1) == 1)) {
                res = size;
            }
        }
        return res;
    }

    public int maxEqualFreq2(int[] nums) {
        int[] numFreq = new int[1000001];
        int[] freqCount = new int[1000001];
        Arrays.fill(numFreq, 0);
        Arrays.fill(freqCount, 0);
        int res = 1, size = 0, maxFreq = 0;
        for (int num : nums) {
            size++;
            freqCount[numFreq[num]] = freqCount[numFreq[num]] - 1;
            freqCount[numFreq[num] + 1] = freqCount[numFreq[num] + 1] + 1;
            numFreq[num] = numFreq[num] + 1;
            maxFreq = Math.max(maxFreq, numFreq[num]);
            if (maxFreq == 1
                    || (freqCount[maxFreq] * maxFreq + freqCount[maxFreq - 1] * (maxFreq - 1) == size && freqCount[maxFreq] == 1)
                    || (freqCount[maxFreq] * maxFreq + 1 == size && freqCount[1] == 1)) {
                res = size;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MaxEqualFreq maxEqualFreq = new MaxEqualFreq();
        System.out.println(maxEqualFreq.maxEqualFreq2(new int[] {1,2}));
    }
}