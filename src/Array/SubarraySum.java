package Array;

import java.util.HashMap;
import java.util.Map;
/**
 * [560]和为K的子数组
 * @author : huangrui
 * @version :
 * @date : 2021-11-05 14:23
 **/
public class SubarraySum {

    /**
     * 定义一个map
     * key:从0到i的元素的和 value:和出现的次数
     * 遍历数组 若map中存在key为当前前缀和-目标数的元素 则说明从那个位置到这个位置的子数组的和为k
     * @param nums
     * @param k
     * @return
     */
    public static int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int pre = 0, count = 0;
        for (int n : nums) {
            pre += n;
            if (map.containsKey(pre - k)) {
                count = count + map.get(pre - k);
            }
            if (map.containsKey(pre)) {
                // 防止有0或者负数的情况
                int c = map.get(pre);
                map.put(pre, c + 1);
            } else {
                map.put(pre, 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] {1,1,1}, 2));
    }
}
