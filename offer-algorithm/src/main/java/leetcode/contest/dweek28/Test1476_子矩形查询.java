package leetcode.contest.dweek28;

public class Test1476_子矩形查询 {

    public static void main(String[] args) {
        SubrectangleQueries subrectangleQueries = new SubrectangleQueries(new int[][]{{1, 2, 1}, {4, 3, 4}, {3, 2, 1}, {1, 1, 1}});
        // 初始的 (4x3) 矩形如下：
        // 1 2 1
        // 4 3 4
        // 3 2 1
        // 1 1 1
        subrectangleQueries.getValue(0, 2); // 返回 1
        subrectangleQueries.updateSubrectangle(0, 0, 3, 2, 5);
        // 此次更新后矩形变为：
        // 5 5 5
        // 5 5 5
        // 5 5 5
        // 5 5 5
        subrectangleQueries.getValue(0, 2); // 返回 5
        subrectangleQueries.getValue(3, 1); // 返回 5
        subrectangleQueries.updateSubrectangle(3, 0, 3, 2, 10);
        // 此次更新后矩形变为：
        // 5   5   5
        // 5   5   5
        // 5   5   5
        // 10  10  10
        subrectangleQueries.getValue(3, 1); // 返回 10
        subrectangleQueries.getValue(0, 2); // 返回 5
    }

    static class SubrectangleQueries {
        int[][] rectangle = null;

        public SubrectangleQueries(int[][] rectangle) {
            this.rectangle = rectangle;
        }

        public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
            for (int y = row1; y <= row2; y++) {
                for (int x = col1; x <= col2; x++) {
                    rectangle[y][x] = newValue;
                }
            }
        }

        public int getValue(int row, int col) {
            return rectangle[row][col];
        }
    }

}
