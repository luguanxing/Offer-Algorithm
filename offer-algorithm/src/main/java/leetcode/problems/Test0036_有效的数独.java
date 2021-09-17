package leetcode.problems;

public class Test0036_有效的数独 {

    public static void main(String[] args) {
        System.out.println(new Solution().isValidSudoku(
                new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}
        ));
        System.out.println(new Solution().isValidSudoku(
                new char[][]{{'8', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}}
        ));
    }

    static class Solution {
        public boolean isValidSudoku(char[][] board) {
            // 检查每一行
            for (char[] line : board) {
                boolean[] contains = new boolean[10];
                for (char c : line) {
                    if (c != '.' && contains[c - '0']) {
                        return false;
                    }
                    if (c != '.') {
                        contains[c - '0'] = true;
                    }
                }
            }
            // 检查每一列
            for (int x = 0; x < 9; x++) {
                boolean[] contains = new boolean[10];
                for (int y = 0; y < 9; y++) {
                    char c = board[y][x];
                    if (c != '.' && contains[c - '0']) {
                        return false;
                    }
                    if (c != '.') {
                        contains[c - '0'] = true;
                    }
                }
            }
            // 检查每一个方块
            if (checkBlock(board, 0, 0) &&
                    checkBlock(board, 3, 0) &&
                    checkBlock(board, 6, 0) &&
                    checkBlock(board, 0, 3) &&
                    checkBlock(board, 3, 3) &&
                    checkBlock(board, 6, 3) &&
                    checkBlock(board, 0, 6) &&
                    checkBlock(board, 3, 6) &&
                    checkBlock(board, 6, 6)
            ) {
                return true;
            } else {
                return false;
            }
        }

        private boolean checkBlock(char[][] board, int startY, int startX) {
            boolean[] contains = new boolean[10];
            for (int x = startX; x < startX + 3; x++) {
                for (int y = startY; y < startY + 3; y++) {
                    char c = board[y][x];
                    if (c != '.' && contains[c - '0']) {
                        return false;
                    }
                    if (c != '.') {
                        contains[c - '0'] = true;
                    }
                }
            }
            return true;
        }
    }

}
