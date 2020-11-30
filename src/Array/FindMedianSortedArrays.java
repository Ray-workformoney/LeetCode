package Array;

/**
 * @program: LeetCode_J
 * @description: 寻找两个正序数组的中位数
 * @author: huangrui
 * @create: 2020-11-30 10:28
 **/

public class FindMedianSortedArrays {

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len = nums1.length + nums2.length;
        int med1In = len % 2 == 0 ? len / 2 : (len + 1) / 2;
        int med2In = med1In + 1;
        int i = 0, j = 0, count = 0;
        int med1 = 0, med2 = 0;
        while (i < nums1.length && j < nums2.length) {
            int tmp;
            if (nums1[i] < nums2[j]) {
                tmp = nums1[i];
                i++;
            } else {
                tmp = nums2[j];
                j++;
            }
            count++;
            if (count == med1In) {
                med1 = tmp;
            }
            if (count == med2In) {
                med2 = tmp;
                break;
            }
        }
        while (i < nums1.length) {
            count++;
            if (count == med1In) {
                med1 = nums1[i];
            }
            if (count == med2In) {
                med2 = nums1[i];
                break;
            }
            i++;
        }
        while (j < nums2.length) {
            count++;
            if (count == med1In) {
                med1 = nums2[j];
            }
            if (count == med2In) {
                med2 = nums2[j];
                break;
            }
            j++;
        }
        return len % 2 == 0 ? (double) (med1 + med2) / 2 : med1;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
