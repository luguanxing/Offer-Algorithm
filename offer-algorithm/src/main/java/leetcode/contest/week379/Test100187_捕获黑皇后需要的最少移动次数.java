package leetcode.contest.week379;

import java.util.*;

public class Test100187_捕获黑皇后需要的最少移动次数 {

    public static void main(String[] args) {
        // a = 1, b = 1, c = 8, d = 8, e = 2, f = 3
        System.out.println(new Solution().minMovesToCaptureTheQueen(1, 1, 8, 8, 2, 3));
        // a = 5, b = 3, c = 3, d = 4, e = 5, f = 2
        System.out.println(new Solution().minMovesToCaptureTheQueen(5, 3, 3, 4, 5, 2));
        System.out.println(new Solution().minMovesToCaptureTheQueen(4, 3, 3, 4, 5, 2));
        System.out.println(new Solution().minMovesToCaptureTheQueen(1, 1, 1, 4, 1, 8));
        System.out.println(new Solution().minMovesToCaptureTheQueen(4, 3, 3, 4, 2, 5));
        System.out.println(new Solution().minMovesToCaptureTheQueen(6, 8, 6, 6, 6, 3));
        System.out.println(new Solution().minMovesToCaptureTheQueen(7, 5, 7, 6, 2, 8));
    }

    static class Solution {
        public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
            // 检查车是否可以直接捕获黑皇后
            if ((a == e && !isBlocked(a, b, c, d, e, f, true)) || (b == f && !isBlocked(a, b, c, d, e, f, false))) {
                return 1;
            }

            // 检查象是否可以直接捕获黑皇后
            if (Math.abs(c - e) == Math.abs(d - f) && !isDiagonalBlocked(a, b, c, d, e, f)) {
                return 1;
            }

            // 如果车和象都不能直接捕获，比较它们各自需要的最少步数
            int rookMoves = 2; // 车需要的步数
            int bishopMoves = 2; // 象需要的步数

            return Math.min(rookMoves, bishopMoves);
        }

        private boolean isBlocked(int ax, int ay, int bx, int by, int qx, int qy, boolean isRow) {
            // 检查车的路径是否被另一棋子阻挡
            if (isRow) {
                return (bx == ax) && (by > ay && by < qy || by < ay && by > qy);
            } else {
                return (by == ay) && (bx > ax && bx < qx || bx < ax && bx > qx);
            }
        }

        private boolean isDiagonalBlocked(int ax, int ay, int bx, int by, int qx, int qy) {
            // 检查象的路径是否被车或另一棋子阻挡
            if (Math.abs(bx - qx) != Math.abs(by - qy)) {
                return false; // 不在同一对角线上
            }
            for (int i = 1; i < Math.abs(bx - qx); i++) {
                int x = bx + i * Integer.signum(qx - bx);
                int y = by + i * Integer.signum(qy - by);
                if ((x == ax && y == ay) || (x == qx && y == qy)) {
                    return true; // 对角线上有阻挡
                }
            }
            return false;
        }
    }




}
