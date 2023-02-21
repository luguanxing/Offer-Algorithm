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
                // 路程中不断更新最远下一条
                nextRight = Math.max(nextRight, maxReach[i]);
                if (i >= currentRight) {
                    // 没有下一跳了，返回失败
                    if (nextRight == currentRight) {
                        return -1;
                    }
                    // 更新下一跳，次数加一
                    currentRight = nextRight;
                    res++;
                }
            }
            return res;
        }
    }

}
