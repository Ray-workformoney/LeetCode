package Array;

public class merge {

    public static void mergeArray(int[] nums1, int m, int[] nums2, int n){

        int index = nums1.length - 1;
        m--;
        n--;
        while (m >= 0 && n >= 0){
            nums1[index--] = nums1[m] > nums2[n] ? nums1[m--] : nums2[n--];
        }
        while (n >= 0){
            nums1[index--] = nums2[n--];
        }
    }

    public static void main(String[] Args){
        int[] nums1 = {4,5,6,0,0,0};
        int[] nums2 = {1,2,3};
        int m = 3, n = 3;

        mergeArray(nums1, m, nums2, n);
        for (int num : nums1){
            System.out.print(num + " ");
        }
        System.out.print("\n");
        for (int num : nums2){
            System.out.print(num + " ");
        }

    }

}
