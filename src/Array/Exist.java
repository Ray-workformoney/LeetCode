package Array;

/**
 * [剑指offer 12] 矩阵中的路径
 * @author : huangrui
 * @version :
 * @date : 2021-12-30 14:33
 **/
public class Exist {

    public boolean exist(char[][] board, String word) {

        if (board.length * board[0].length < word.length()) {
            return false;
        }
        int row;
        int col;
        int[][] use = new int[board.length][board[0].length];
        for (row = 0; row < board.length; row++) {
            for (col = 0; col < board[row].length; col++) {
                if (dfs(board, row, col, word, 0, use)) {
                    return true;
                };
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, String word, int i, int[][] use) {
        if (i == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[row].length) {
            return false;
        }
        if (use[row][col] == 1) {
            return false;
        }
        if (word.charAt(i) != board[row][col]) {
            return false;
        }
        i++;
        use[row][col] = 1;
        if (dfs(board, row + 1, col, word, i, use) || dfs(board, row - 1, col, word, i, use) || dfs(board, row, col + 1, word, i, use) || dfs(board, row, col - 1, word, i, use)) {
            return true;
        } else {
            use[row][col] = 0;
            return false;
        }
    }

    public static void main(String[] args) {
        char[][] board = new char[][] {
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        Exist exist = new Exist();
        System.out.println(exist.exist(board, "ABCCED"));
    }
}
