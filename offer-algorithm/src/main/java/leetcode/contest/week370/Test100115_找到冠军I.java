package leetcode.contest.week370;

public class Test100115_找到冠军I {

    public static void main(String[] args) {
        System.out.println(new Solution().findChampion(new int[][]{{0, 1}, {0, 0}}));
        System.out.println(new Solution().findChampion(new int[][]{{0, 0, 1}, {1, 0, 1}, {0, 0, 0}}));
    }

    static class Solution {
        public int findChampion(int[][] grid) {
            int len = grid.length;
            int res = 0;
            int[] lostCnt = new int[len];
            for (int[] g : grid) {
                for (int i = 0; i < len; i++) {
                    if (g[i] == 1) {
                        lostCnt[i]++;
                    }
                }
            }
            for (int i = 0; i < len; i++) {
                if (lostCnt[i] == 0) {
                    res = i;
                    break;
                }
            }
            return res;
        }
    }

}
