package Array;

/**
 * [剑指 offer 11]旋转数组的最小数字
 * @author : huangrui
 * @version :
 * @date : 2021-12-30 14:25
 **/
public class MinArray {

    public int minArray(int[] numbers) {

        int i = numbers.length - 1;
        while (i > 0 && numbers[i] >= numbers[i - 1]) {
            i--;
        }
        return numbers[i];
    }

    public static void main(String[] args) {
        MinArray minArray = new MinArray();
        System.out.println(minArray.minArray(new int[] {1,3,3}));
    }
}
