package leetcode.contest.week300;

import java.util.*;

public class Test6109_知道秘密的人数 {

    public static void main(String[] args) {
        System.out.println(new Solution().peopleAwareOfSecret(6, 2, 4));
        System.out.println(new Solution().peopleAwareOfSecret(4, 1, 3));
    }

    static class Solution {
        private static int MOD = 1000000007;

        public int peopleAwareOfSecret(int n, int delay, int forget) {
            // 使用map存储当天剩余天数和对应数量，模拟每一天的变动
            Map<Integer, Integer> map = new HashMap<>();
            map.put(forget, 1);
            for (int i = 1; i <= n; i++) {
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
                // 下一天中新增分享的人
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

}
