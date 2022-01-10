package DynamicProgramming;

/**
 * [剑指offer13]机器人的运动范围
 * @author : huangrui
 * @version :
 * @date : 2021-12-31 00:05
 **/
public class MovingCount {

    public int movingCount(int m, int n, int k) {

        int[][] arr = new int[m][n];
        return dfs(0, 0, k, 0, arr);
    }

    private int dfs(int m, int n, int k, int count, int[][] arr) {
        if (m < 0 || m >= arr.length || n < 0 || n >= arr[m].length || arr[m][n] == 1) {
            return 0;
        }
        if (sum(m) + sum(n) > k) {
            return count;
        }
        arr[m][n] = 1;
        // 当前的这个位置加上从这个位置出发能达到的位置
        return 1 + dfs(m - 1, n, k, count, arr) + dfs(m + 1, n, k, count, arr) + dfs(m, n - 1, k, count, arr)  + dfs(m, n + 1, k, count, arr);
    }

    private int sum(int num) {
        int sum = 0;
        while (num >= 10) {
            sum += num % 10;
            num = num / 10;
        }
        return sum + num;
    }

    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();
        System.out.println(movingCount.movingCount(2, 3, 1));
    }

}
