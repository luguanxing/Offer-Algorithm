package leetcode.problems;

import java.util.*;

public class Test1222_可以攻击国王的皇后 {

    public static void main(String[] args) {
        System.out.println(new Solution().queensAttacktheKing(
                new int[][]{{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}},
                new int[]{0, 0}
        ));
        System.out.println(new Solution().queensAttacktheKing(
                new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 4}, {3, 5}, {4, 4}, {4, 5}},
                new int[]{3, 3}

        ));
        System.out.println(new Solution().queensAttacktheKing(
                new int[][]{{5, 6}, {7, 7}, {2, 1}, {0, 7}, {1, 6}, {5, 1}, {3, 7}, {0, 3}, {4, 0}, {1, 2}, {6, 3}, {5, 0}, {0, 4}, {2, 2}, {1, 1}, {6, 4}, {5, 4}, {0, 0}, {2, 6}, {4, 5}, {5, 2}, {1, 4}, {7, 5}, {2, 3}, {0, 5}, {4, 2}, {1, 0}, {2, 7}, {0, 1}, {4, 6}, {6, 1}, {0, 6}, {4, 3}, {1, 7}},
                new int[]{3, 4}
        ));
    }

    static class Solution {
        private int N = 8;

        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            List<List<Integer>> lists = new ArrayList<>();
            int kingY = king[0];
            int kingX = king[1];
            int[][] directions = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
            for (int[] direction : directions) {
                checkDirection(queens, kingY, kingX, direction, lists);
            }
            return lists;
        }

        private void checkDirection(int[][] queens, int y, int x, int[] direction, List<List<Integer>> lists) {
            if (y < 0 || y >= N || x < 0 || x >= N) {
                return;
            }
            for (int[] queen : queens) {
                if (y == queen[0] && x == queen[1]) {
                    lists.add(Arrays.asList(y, x));
                    return;
                }
            }
            checkDirection(queens, y + direction[0], x + direction[1], direction, lists);
        }
    }

}
