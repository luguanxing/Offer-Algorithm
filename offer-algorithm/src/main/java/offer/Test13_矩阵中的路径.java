package offer;

public class Test13_矩阵中的路径 {

    public static void main(String[] args) {
        char[] fMatrix = new char[]{'a', 'b', 'c', 'e', 's', 'f', 'c', 's', 'a', 'd', 'e', 'e'};
        char[] str1 = new char[]{'a', 's', 'f', 'c', 's'};
        char[] str2 = new char[]{'a', 'b', 'c', 'b'};
        System.out.println(new Solution().hasPath(fMatrix, 3, 4, str1));
        System.out.println(new Solution().hasPath(fMatrix, 3, 4, str2));
    }

    static class Solution {
        boolean[][] isVisited = null;
        char[][] matrix = null;
        boolean isOk = false;

        public boolean hasPath(char[] fMatrix, int rows, int cols, char[] str) {
            isVisited = new boolean[rows][cols];
            matrix = new char[rows][cols];
            for (int y = 0; y < matrix.length; y++) {
                for (int x = 0; x < matrix[0].length; x++) {
                    matrix[y][x] = fMatrix[y * cols + x];
                }
            }
            for (int y = 0; y < matrix.length; y++) {
                for (int x = 0; x < matrix[0].length; x++) {
                    if (matrix[y][x] == str[0]) {
                        bfs(y, x, "", str.length-1, new String(str));
                    }
                }
            }
            return isOk;
        }

        private void bfs(int y, int x, String currentStr, int length, String target) {
            if (y < 0 || matrix.length <= y || x < 0 || matrix[0].length <= x || isVisited[y][x] || isOk) {
                return;
            }
            if (length == 0) {
                if (target.equals(currentStr + matrix[y][x])) {
                    isOk = true;
                }
                return;
            }
            isVisited[y][x] = true;
            bfs(y - 1, x, currentStr + matrix[y][x], length - 1, target);
            bfs(y, x - 1, currentStr + matrix[y][x], length - 1, target);
            bfs(y + 1, x, currentStr + matrix[y][x], length - 1, target);
            bfs(y, x + 1, currentStr + matrix[y][x], length - 1, target);
            isVisited[y][x] = false;
        }
    }

}
