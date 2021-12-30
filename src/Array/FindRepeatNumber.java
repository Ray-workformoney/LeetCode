package Array;

import java.util.HashSet;
import java.util.Set;
/**
 * [剑指offer 03 数组中重复的数字]
 * @author : huangrui
 * @version :
 * @date : 2021-12-30 11:55
 **/
public class FindRepeatNumber {

    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return 0;
    }

}
