package leetcode.problems;

import java.util.*;

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
            int height = board.length;
            int width = board[0].length;
            for (int y = 0; y < height; y++) {
                List<Integer> nums = new ArrayList<>();
                for (int x = 0; x < width; x++) {
                    char c = board[y][x];
                    if (c != '.') {
                        nums.add(c - '0');
                    }
                }
                if (!isOk(nums)) {
                    return false;
                }
            }
            for (int x = 0; x < width; x++) {
                List<Integer> nums = new ArrayList<>();
                for (int y = 0; y < height; y++) {
                    char c = board[y][x];
                    if (c != '.') {
                        nums.add(c - '0');
                    }
                }
                if (!isOk(nums)) {
                    return false;
                }
            }
            for (int blockY = 0; blockY < 3; blockY++) {
                for (int blockX = 0; blockX < 3; blockX++) {
                    List<Integer> nums = new ArrayList<>();
                    for (int y = blockY * 3; y < blockY * 3 + 3; y++) {
                        for (int x = blockX * 3; x < blockX * 3 + 3; x++) {
                            char c = board[y][x];
                            if (c != '.') {
                                nums.add(c - '0');
                            }
                        }
                    }
                    if (!isOk(nums)) {
                        return false;
                    }
                }
            }
            return  true;
        }

        private boolean isOk(List<Integer> nums) {
            boolean[] counts = new boolean[10];
            for (Integer num : nums) {
                if (counts[num]) {
                    return false;
                }
                counts[num] = true;
            }
            return  true;
        }
    }

    static class Solution_OLD {
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
