package leetcode.problems;

public class Test0547_省份数量 {

    public static void main(String[] args) {
        System.out.println(new Solution().findCircleNum(
                new int[][]{
                        {1, 1, 0},
                        {1, 1, 0},
                        {0, 0, 1}
                }
        ));
        System.out.println(new Solution().findCircleNum(
                new int[][]{
                        {1, 0, 0},
                        {0, 1, 0},
                        {0, 0, 1}
                }
        ));
    }

    static class Solution {
        public int findCircleNum(int[][] isConnected) {
            int len = isConnected.length;
            int res = 0;
            boolean[] flag = new boolean[len];
            for (int i = 0; i < len; i++) {
                if (!flag[i]) {
                    bfs(isConnected, i, flag);
                    res++;
                }
            }
            return res;
        }

        private void bfs(int[][] isConnected, int i, boolean[] flag) {
            if (flag[i]) {
                return;
            }
            flag[i] = true;
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    bfs(isConnected, j, flag);
                }
            }
        }
    }

}
