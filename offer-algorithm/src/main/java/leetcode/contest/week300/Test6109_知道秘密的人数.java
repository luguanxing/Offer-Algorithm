package leetcode.contest.week300;

import java.util.*;

public class Test6109_知道秘密的人数 {

    public static void main(String[] args) {
        System.out.println(new Solution().peopleAwareOfSecret(6, 2, 4));
        System.out.println(new Solution().peopleAwareOfSecret(4, 1, 3));
        System.out.println(new Solution_DP().peopleAwareOfSecret(6, 2, 4));
        System.out.println(new Solution_DP().peopleAwareOfSecret(4, 1, 3));
    }

    static class Solution {
        static int MOD = 1000000007;

        public int peopleAwareOfSecret(int n, int delay, int forget) {
            // 使用map存储当天剩余天数和对应数量，模拟每一天的变动
            Map<Integer, Integer> map = new HashMap<>();
            map.put(forget, 1);
            for (int i = 1; i <= n - 1; i++) {
                Map<Integer, Integer> nextMap = new HashMap<>();
                long canShareCnt = 0;
                for (int day : map.keySet()) {
                    // 剩余天数达到forget - delay的可以分享
                    if (day <= forget - delay) {
                        canShareCnt += map.get(day);
                    }
                    // 计算下一天的情况
                    int nextDay = day - 1;
                    int nextCount = map.get(day);
                    if (nextDay > 0) {
                        nextMap.put(nextDay, nextCount);
                    }
                }
                // 下一天中新增的人
                if (canShareCnt > 0) {
                    nextMap.put(forget - 1, (int) (canShareCnt % MOD));
                }
                map = nextMap;
            }
            // 计算第n天的最终结果
            int res = 0;
            for (int day : map.keySet()) {
                res += map.get(day);
                res %= MOD;
                if (day <= forget - delay) {
                    res += map.get(day);
                    res %= MOD;
                }
            }
            return res;
        }
    }

    static class Solution_DP {
        public int peopleAwareOfSecret(int n, int delay, int forget) {
            int MOD = (int) (1e9 + 7);
            // dp[i]表示第i天新增的人数
            int[] dp = new int[n + 1];
            dp[1] = 1;
            // dp[i]能影响到dp[i+delay]到dp[i+forget]的人数
            for (int i = 1; i < n; i++) {
                for (int j = i + delay; j <= Math.min(n, i + forget - 1); j++) {
                    dp[j] += dp[i];
                    dp[j] %= MOD;
                }
            }
            // 计算能对第n天产生影响的人数
            int res = 0;
            for (int i = 1; i <= n; i++) {
                if (n < i + forget) {
                    res += dp[i];
                    res %= MOD;
                }
            }
            return res;
        }
    }

}
