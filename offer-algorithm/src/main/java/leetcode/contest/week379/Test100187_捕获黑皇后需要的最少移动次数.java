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
            // 检查车是否可以直接捕获皇后
            if (a == e) {
                if (isClearHorizontal(a, b, f, c, d)) return 1;
            } else if (b == f) {
                if (isClearVertical(b, a, e, c, d)) return 1;
            }

            // 检查象是否可以直接捕获皇后
            if (Math.abs(c - e) == Math.abs(d - f)) {
                if (isClearDiagonal(c, d, e, f, a, b)) return 1;
            }

            // 车和象都不能直接捕获皇后，需要两步
            return 2;
        }

        private boolean isClearHorizontal(int row, int startCol, int endCol, int obstructRow, int obstructCol) {
            if (startCol > endCol) {
                int temp = startCol;
                startCol = endCol;
                endCol = temp;
            }
            // 检查路径上是否有阻挡
            for (int col = startCol + 1; col < endCol; col++) {
                if (row == obstructRow && col == obstructCol) {
                    return false; // 路径上有阻挡
                }
            }
            return true; // 路径清晰
        }

        private boolean isClearVertical(int col, int startRow, int endRow, int obstructRow, int obstructCol) {
            if (startRow > endRow) {
                int temp = startRow;
                startRow = endRow;
                endRow = temp;
            }
            // 检查路径上是否有阻挡
            for (int row = startRow + 1; row < endRow; row++) {
                if (row == obstructRow && col == obstructCol) {
                    return false; // 路径上有阻挡
                }
            }
            return true; // 路径清晰
        }

        private boolean isClearDiagonal(int startRow, int startCol, int endRow, int endCol, int obstructRow, int obstructCol) {
            int rowIncrement = startRow < endRow ? 1 : -1;
            int colIncrement = startCol < endCol ? 1 : -1;
            int row = startRow + rowIncrement;
            int col = startCol + colIncrement;
            while (row != endRow && col != endCol) {
                if (row == obstructRow && col == obstructCol) {
                    return false; // 路径上有阻挡
                }
                row += rowIncrement;
                col += colIncrement;
            }
            return true; // 路径清晰
        }
    }



}
