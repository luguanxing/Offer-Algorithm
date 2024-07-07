package leetcode.problems;

public class Test1958_检查操作是否合法 {

    public static void main(String[] args) {
        // board = [[".",".",".","B",".",".",".","."],[".",".",".","W",".",".",".","."],[".",".",".","W",".",".",".","."],[".",".",".","W",".",".",".","."],["W","B","B",".","W","W","W","B"],[".",".",".","B",".",".",".","."],[".",".",".","B",".",".",".","."],[".",".",".","W",".",".",".","."]], rMove = 4, cMove = 3, color = "B"
        System.out.println(new Solution().checkMove(
                new char[][]{
                        {'.', '.', '.', 'B', '.', '.', '.', '.'},
                        {'.', '.', '.', 'W', '.', '.', '.', '.'},
                        {'.', '.', '.', 'W', '.', '.', '.', '.'},
                        {'.', '.', '.', 'W', '.', '.', '.', '.'},
                        {'W', 'B', 'B', '.', 'W', 'W', 'W', 'B'},
                        {'.', '.', '.', 'B', '.', '.', '.', '.'},
                        {'.', '.', '.', 'B', '.', '.', '.', '.'},
                        {'.', '.', '.', 'W', '.', '.', '.', '.'}
                },
                4, 3, 'B')
        );
        // board = [[".",".",".",".",".",".",".","."],[".","B",".",".","W",".",".","."],[".",".","W",".",".",".",".","."],[".",".",".","W","B",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".",".","B","W",".","."],[".",".",".",".",".",".","W","."],[".",".",".",".",".",".",".","B"]], rMove = 4, cMove = 4, color = "W"
        System.out.println(new Solution().checkMove(new char[][]{
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', 'B', '.', '.', 'W', '.', '.', '.'},
                {'.', '.', 'W', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'W', 'B', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', 'B', 'W', '.', '.'},
                {'.', '.', '.', '.', '.', '.', 'W', '.'},
                {'.', '.', '.', '.', '.', '.', '.', 'B'}
        }, 4, 4, 'W'));
        // board=[[".",".","W",".","B","W","W","B"],["B","W",".","W",".","W","B","B"],[".","W","B","W","W",".","W","W"],["W","W",".","W",".",".","B","B"],["B","W","B","B","W","W","B","."],["W",".","W",".",".","B","W","W"],["B",".","B","B",".",".","B","B"],[".","W",".","W",".","W",".","W"]], 5, 4, W
        System.out.println(new Solution().checkMove(new char[][]{
                {'.', '.', 'W', '.', 'B', 'W', 'W', 'B'},
                {'B', 'W', '.', 'W', '.', 'W', 'B', 'B'},
                {'.', 'W', 'B', 'W', 'W', '.', 'W', 'W'},
                {'W', 'W', '.', 'W', '.', '.', 'B', 'B'},
                {'B', 'W', 'B', 'B', 'W', 'W', 'B', '.'},
                {'W', '.', 'W', '.', '.', 'B', 'W', 'W'},
                {'B', '.', 'B', 'B', '.', '.', 'B', 'B'},
                {'.', 'W', '.', 'W', '.', 'W', '.', 'W'}
        }, 5, 4, 'W'));
    }

    static class Solution {
        public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
            boolean res = false;
            int[][] directions = {{0, -1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {-1, 1}, {-1, 0}, {-1, -1}};
            for (int[] direction : directions) {
                res |= checkValid(board, rMove, cMove, color, direction);
            }
            return res;
        }

        private boolean checkValid(char[][] board, int rMove, int cMove, char color, int[] direction) {
            int height = board.length;
            int width = board[0].length;
            int y = rMove + direction[0];
            int x = cMove + direction[1];
            int cnt = 1;
            char midColor = ' ';
            while (y >= 0 && y < height && x >= 0 && x < width) {
                if (cnt == 1) {
                    midColor = board[y][x];
                    if (midColor == color || midColor == '.') {
                        return false;
                    }
                    cnt++;
                    y += direction[0];
                    x += direction[1];
                    continue;
                } else if (board[y][x] == color && cnt >= 2) {
                    return true;
                } else if (board[y][x] != midColor || board[y][x] == '.') {
                    return false;
                } else if (board[y][x] == midColor) {
                    y += direction[0];
                    x += direction[1];
                    cnt++;
                }
            }
            return false;
        }
    }

}
