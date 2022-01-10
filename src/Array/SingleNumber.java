package Array;

import java.util.HashMap;
import java.util.Map;
/**
 * [剑指offer56] 数组中数字出现的次数II
 * @author : huangrui
 * @version :
 * @date : 2022-01-05 10:12
 **/
public class SingleNumber {

    public int singleNumber(int[] nums) {

        int[] bitArr = new int[32];
        for (int num : nums) {
            String binary = Integer.toBinaryString(num);
            int len = binary.length() - 1;
            for (int j = len; j >= 0; j--) {
                if (binary.charAt(len - j) == '1') {
                    bitArr[j] = bitArr[j] + 1;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            int bit = bitArr[i];
            while (bit > 1) {
                bit = bit % 3;
            }
            if (bit == 1) {
                sb.append("1");
            } else {
                sb.append("0");
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }

    public int singleNumber2(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int num : nums) {
            if (countMap.containsKey(num)) {
                int count = countMap.get(num);
                count++;
                if (count == 3) {
                    countMap.remove(num);
                } else {
                    countMap.put(num, count);
                }
            } else {
                countMap.put(num, 1);
            }
        }
        return countMap.keySet().stream().findFirst().get();
    }

    public int singleNumber3(int[] nums) {
        int val = 0;
        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            int count = 0;
            for (int num : nums) {
                if ((mask & num) == mask) {
                    count++;
                }
            }
            count = count % 3;
            if (count == 1) {
                val ^= mask;
            }
        }
        return val;
    }

    public static void main(String[] args) {
        SingleNumber singleNumber = new SingleNumber();
        System.out.println(singleNumber.singleNumber3(new int[] {3,4,3,3}));
    }
}
