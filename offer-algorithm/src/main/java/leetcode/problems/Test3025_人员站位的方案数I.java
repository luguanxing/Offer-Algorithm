package leetcode.problems;

public class Test3025_人员站位的方案数I {

    public static void main(String[] args) {
        // points = [[1,1],[2,2],[3,3]]
        System.out.println(new Solution().numberOfPairs(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        // points = [[6,2],[4,4],[2,6]]
        System.out.println(new Solution().numberOfPairs(new int[][]{{6, 2}, {4, 4}, {2, 6}}));
        // points = [[3,1],[1,3],[1,1]]
        System.out.println(new Solution().numberOfPairs(new int[][]{{3, 1}, {1, 3}, {1, 1}}));
    }

    static class Solution {
        public int numberOfPairs(int[][] points) {
            int len = points.length;
            int res = 0;
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    if (i == j) {
                        continue;
                    }
                    int ly = points[i][0];
                    int lx = points[i][1];
                    int ry = points[j][0];
                    int rx = points[j][1];
                    if (ly < ry || lx > rx) {
                        continue;
                    }
                    boolean isOk = true;
                    for (int k = 0; k < len; k++) {
                        if (k == i || k == j) {
                            continue;
                        }
                        int y = points[k][0];
                        int x = points[k][1];
                        if (ry <= y && y <= ly && lx <= x && x <= rx) {
                            isOk = false;
                            break;
                        }
                    }
                    if (isOk) {
                        res++;
                    }
                }
            }
            return res;
        }
    }

}
