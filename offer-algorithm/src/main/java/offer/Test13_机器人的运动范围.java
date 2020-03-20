package offer;

public class Test13_机器人的运动范围 {

    public static void main(String[] args) {
        System.out.println(new Solution().movingCount(18, 50, 50));
    }

    static class Solution {
        boolean[][] isVisited = null;
        int count = 0;

        public int movingCount(int threshold, int rows, int cols) {
            isVisited = new boolean[rows][cols];
            bfs(0, 0, threshold);
            return count;
        }

        private void bfs(int y, int x, int threshold) {
            if (x < 0 || isVisited[0].length <= x || y < 0 || isVisited.length <= y || isVisited[y][x] || stepSum(y, x) > threshold) {
                return;
            }
            isVisited[y][x] = true;
            count++;
            bfs(y, x + 1, threshold);
            bfs(y, x - 1, threshold);
            bfs(y - 1, x, threshold);
            bfs(y + 1, x, threshold);
        }

        private int stepSum(int y, int x) {
            int sum = 0;
            while (y > 0) {
                sum += y % 10;
                y = y / 10;
            }
            while (x > 0) {
                sum += x % 10;
                x = x / 10;
            }
            return sum;
        }
    }

}
