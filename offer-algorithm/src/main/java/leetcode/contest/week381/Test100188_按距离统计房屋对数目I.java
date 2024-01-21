package leetcode.contest.week381;

import java.util.Arrays;

public class Test100188_按距离统计房屋对数目I {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countOfPairs(3, 1, 3)));
        System.out.println(Arrays.toString(new Solution().countOfPairs(5, 2, 4)));
        System.out.println(Arrays.toString(new Solution().countOfPairs(4, 1, 1)));
        System.out.println(Arrays.toString(new Solution().countOfPairs(2, 1, 2)));
        System.out.println(Arrays.toString(new Solution().countOfPairs(3, 3, 1)));
    }

    static class Solution {
        public int[] countOfPairs(int n, int x, int y) {
            int[] cnt = new int[n];
            int[] res = new int[n];
            for (int i = 1; i <= n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    // 计算两种情况的距离并取较小值
                    int dist1 = Math.abs(i - j); // 直接沿街道走的距离
                    int dist2 = Math.min(Math.abs(x - i) + Math.abs(y - j), Math.abs(y - i) + Math.abs(x - j)) + 1; // 通过x和y之间的街道走的距离
                    int dist = Math.min(dist1, dist2); // 最短距离
                    if (dist < n) {
                        cnt[dist]++;
                    }
                }
            }

            // 每对房屋被计算了两次，所以结果需要乘以2
            for (int k = 0; k < n; k++) {
                cnt[k] *= 2;
                if (k >= 1) {
                    res[k - 1] = cnt[k];
                }
            }
            return res;
        }
    }



}
