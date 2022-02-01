package Array;

import com.huangrui.leetcode.PrintUtils;
/**
 * [剑指offer29]顺时针打印矩阵
 * @author : huangrui
 * @version :
 * @date : 2022-02-01 22:55
 **/
public class SpiralOrder {

    public int[] spiralOrder(int[][] matrix) {

        if (matrix.length == 0) {
            return new int[0];
        }
        int up = 0;
        int down = matrix.length;
        int left = 0;
        int right = matrix[0].length;
        int[] res = new int[down * right];
        int index = 0;
        down = down - 1;
        right = right - 1;
        while (true) {
           for (int i = left; i <= right; i++) {
               res[index++] = matrix[up][i];
           }
           up++;
           if (up > down) {
               break;
           }
           for (int i = up; i <= down; i++) {
               res[index++] = matrix[i][right];
           }
           right--;
           if (right < left) {
               break;
           }
           for (int i = right; i >= left; i--) {
               res[index++] = matrix[down][i];
           }
           down--;
           if (down < up) {
               break;
           }
           for (int i = down; i >= up; i--) {
               res[index++] = matrix[i][left];
           }
           left++;
           if (left > right) {
               break;
           }
        }
        return res;
    }

    public static void main(String[] args) {
        SpiralOrder spiralOrder = new SpiralOrder();
        PrintUtils.print(spiralOrder.spiralOrder(new int[][] {{1,2},{1,2},{1,2},{1,2},{1,2},{1,2},{1,2},{1,2},{1,2},{1,2}}));
    }
}
