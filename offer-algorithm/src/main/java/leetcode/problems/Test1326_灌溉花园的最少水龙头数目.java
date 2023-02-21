package leetcode.problems;

public class Test1326_灌溉花园的最少水龙头数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().minTaps(5, new int[]{3, 4, 1, 1, 0, 0}));
        System.out.println(new Solution().minTaps(3, new int[]{0, 0, 0, 0}));
    }

    static class Solution {
        public int minTaps(int n, int[] ranges) {
            // 计算某个点能到达的最右边界
            int[] maxReach = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                int range = ranges[i];
                if (i - range <= 0) {
                    maxReach[0] = Math.max(maxReach[0], i + range);
                } else {
                    maxReach[i - range] = Math.max(maxReach[i - range], i + range);
                }
            }
            // 看看到n需要换几次
            int res = 0;
            int currentRight = 0;
            int nextRight = 0;
            for (int i = 0; i < n; i++) {
                nextRight = Math.max(nextRight, maxReach[i]);
                if (i >= currentRight) {
                    if (nextRight == currentRight) {
                        return -1;
                    }
                    currentRight = nextRight;
                    res++;
                }
            }
            return res;
        }
    }

}
