package Array;

/**
 * [240]搜索二维矩阵II
 * @author : huangrui
 * @version :
 * @date : 2021-12-10 11:22
 **/
public class SearchMatrix {

    /**
     * 二分查找
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {

        int col = matrix[0].length - 1;
        boolean find;
        for (int[] ints : matrix) {
            if (target >= ints[0] && target <= ints[col]) {
                find = binarySearch(ints, target);
                if (find) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean binarySearch (int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    /**
     * 从右上角开始遍历 向左当前数变小 向下当前数变大
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix2(int[][] matrix, int target) {

        int row = 0;
        int col = matrix[0].length - 1;
        while (row < matrix.length && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            }
            if (target < matrix[row][col]) {
                col--;
            } else {
                row++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix2(matrix, 5));
    }
}
