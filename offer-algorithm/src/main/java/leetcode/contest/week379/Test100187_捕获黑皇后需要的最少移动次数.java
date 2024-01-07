package leetcode.contest.week379;

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
            // 如果车在同一行或同一列可以直接捕获皇后
            if (a == e || b == f) {
                // 如果象不在中间，直接搞定
                boolean isBlocked = false;
                int dX = a == e ? 0 : (a - e) > 0 ? -1 : 1;
                int dY = b == f ? 0 : (b - f) > 0 ? -1 : 1;
                for (int x = a, y = b; x != e || y != f; x += dX, y += dY) {
                    if (x == c && y == d) {
                        isBlocked = true;
                    }
                }
                if (!isBlocked) {
                    return 1;
                }
            }

            // 如果象在同一对角线上可以直接捕获皇后
            if (Math.abs(c - e) == Math.abs(d - f)) {
                // 如果车不在中间，直接搞定
                boolean isBlocked = false;
                int dX = c - e > 0 ? -1 : 1;
                int dY = d - f > 0 ? -1 : 1;
                for (int x = c, y = d; x != e || y != f; x += dX, y += dY) {
                    if (x == a && y == b) {
                        isBlocked = true;
                    }
                }
                if (!isBlocked) {
                    return 1;
                }
            }

            // 阻挡或绕行
            return 2;
        }
    }



}
