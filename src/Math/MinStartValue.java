package Math;

/**
 * [1413] Minimum Value to Get Positive Step by Step Sum
 * @author huangrui
 * @date 2022/8/9
 */
public class MinStartValue {

    public int minStartValue(int[] nums) {
        int initVal = 1;
        int stepSum = initVal;
        for (int num : nums) {
           stepSum += + num;
           if (stepSum < 1) {
               initVal += 1 - stepSum;
               stepSum = 1;
           }
        }
        return initVal;
    }

    public static void main(String[] args) {
        MinStartValue minStartValue = new MinStartValue();
        System.out.println(minStartValue.minStartValue(new int[]{1,-2,-3}));
    }
}
