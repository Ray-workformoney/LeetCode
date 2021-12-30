package Array;

/**
 * [剑指offer 04 二维数组中的查找]
 * @author : huangrui
 * @version :
 * @date : 2021-12-30 11:59
 **/
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix.length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[row].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }
}
