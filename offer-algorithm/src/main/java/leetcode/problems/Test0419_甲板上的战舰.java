package leetcode.problems;

public class Test0419_甲板上的战舰 {

    public static void main(String[] args) {
        // board = [["X",".",".","X"],[".",".",".","X"],[".",".",".","X"]]
        System.out.println(new Solution().countBattleships(new char[][]{{'X', '.', '.', 'X'}, {'.', '.', '.', 'X'}, {'.', '.', '.', 'X'}}));
        // board = [["."]]
        System.out.println(new Solution().countBattleships(new char[][]{{'.'}}));
    }

    static class Solution {
        public int countBattleships(char[][] board) {
            int res = 0;
            for (int y = 0; y < board.length; y++) {
                for (int x = 0; x < board[0].length; x++) {
                    if (board[y][x] == 'X') {
                        res++;
                        dfs(board, y, x);
                    }
                }
            }
            return res;
        }

        private void dfs(char[][] board, int y, int x) {
            if (y < 0 || y >= board.length || x < 0 || x >= board[0].length || board[y][x] == '.') {
                return;
            }
            board[y][x] = '.';
            dfs(board, y - 1, x);
            dfs(board, y + 1, x);
            dfs(board, y, x - 1);
            dfs(board, y, x + 1);
        }
    }

}
