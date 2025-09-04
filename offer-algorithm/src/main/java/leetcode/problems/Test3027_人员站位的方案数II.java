package leetcode.problems;

public class Test3027_人员站位的方案数II {

    public static void main(String[] args) {
        // points = [[1,1],[2,2],[3,3]]
        System.out.println(new Solution().numberOfPairs(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        // points = [[6,2],[4,4],[2,6]]
        System.out.println(new Solution().numberOfPairs(new int[][]{{6, 2}, {4, 4}, {2, 6}}));
        // points = [[3,1],[1,3],[1,1]]
        System.out.println(new Solution().numberOfPairs(new int[][]{{3, 1}, {1, 3}, {1, 1}}));
        // [[1,4],[1,1],[5,4],[1,0]]
        System.out.println(new Solution().numberOfPairs(new int[][]{{1, 4}, {1, 1}, {5, 4}, {1, 0}}));
    }

    static class Solution {
        public int numberOfPairs(int[][] points) {
            // 按x升序，y降序排序
            java.util.Arrays.sort(points, (a, b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return b[1] - a[1];
                }
            });
            // 遍历右下角可能的点
            int len = points.length;
            int res = 0;
            for (int i = 0; i < len; i++) {
                int y1 = points[i][1];
                int maxY = Integer.MIN_VALUE;
                // 由于x已经排序，所以只需要判断y是否小于等于y1或大于maxY即可
                for (int j = i + 1; j < len; j++) {
                    int y2 = points[j][1];
                    if (maxY < y2 && y2 <= y1) {
                        res++;
                        maxY = Math.max(maxY, y2);
                    }
                }
            }
            return res;
        }
    }

}
