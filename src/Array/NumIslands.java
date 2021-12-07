package Array;

/**
 * [200]岛屿数量
 * @author : huangrui
 * @version :
 * @date : 2021-12-07 14:31
 **/
public class NumIslands {

    /**
     * dfs 遇到为1的节点 依次深度优先搜索其相邻的4个节点 同时把为1的节点置0 防止重复遍历
     * @param grid
     * @return
     */
    public static int numIslands(char[][] grid) {

        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j< 0 || j >= grid[i].length || grid[i][j] == '0') {
            return;
        }
        grid[i][j] = '0';
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','0','1','1','1'}, {'1','0','1','0','1'}, {'1','1','1','0','1'}};
        System.out.println(numIslands(grid));
    }
}
