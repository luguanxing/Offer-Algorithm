package leetcode.contest.week370;

public class Test100115_找到冠军II {

    public static void main(String[] args) {
        System.out.println(new Solution().findChampion(3, new int[][]{{0, 1}, {1, 2}}));
        System.out.println(new Solution().findChampion(4, new int[][]{{0, 2}, {1, 3}, {1, 2}}));
    }

    static class Solution {
        public int findChampion(int n, int[][] grid) {
            int res = -1;
            int[] lostCnt = new int[n];
            for (int[] g : grid) {
                int winner = g[0];
                int loser = g[1];
                lostCnt[loser]++;
            }
            int zeroCnt = 0;
            for (int i = 0; i < n; i++) {
                if (lostCnt[i] == 0) {
                    res = i;
                    zeroCnt++;
                }
            }
            if (zeroCnt != 1) {
                return -1;
            }
            return res;
        }
    }

}
