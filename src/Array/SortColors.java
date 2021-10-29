package Array;

import java.util.Arrays;
/**
 * [75]颜色分类
 * @author : huangrui
 * @version :
 * @date : 2021-10-28 17:48
 **/
public class SortColors {

    /**
     * 双指针 头尾指针分别指向 0 和 2 的边界 遍历过程中遇到0就换到前面 遇到2就换到后面 遇到1可以不做处理 因为1本来就应该在中间
     * @param nums
     */
    public static void sortColors(int[] nums) {

        int head = 0, end = nums.length - 1, i = 0;
        while (i <= end) {
            switch (nums[i]) {
            case 0:
                // 当前数字是0 交换到前面
                swap(i, head, nums);
                head++;
                break;
            case 2:
                // 当前数字是2 交换到后面
                swap(i, end, nums);
                end--;
                if (nums[i] == 0) {
                    // 换过来的是0 再把0换到前面
                    swap(i, head, nums);
                    head++;
                } else if (nums[i] == 2) {
                    // 换过来的是2 下一轮继续处理这个数
                    i--;
                }
                break;
            // 当前数字是1 不做处理
            default:break;
            }
            i++;
        }
    }

    private static void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }



    public static void main(String[] args) {
        int[] nums = {2,0,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
