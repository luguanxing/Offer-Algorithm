package leetcode.contest.week300;

import java.util.*;

public class Test6109_知道秘密的人数 {

    public static void main(String[] args) {
        System.out.println(new Solution().peopleAwareOfSecret(6, 2, 4));
        System.out.println(new Solution().peopleAwareOfSecret(4, 1, 3));
    }

    static class Solution {
        public int peopleAwareOfSecret(int n, int delay, int forget) {
            int MOD = 1000000007;
            TreeMap<Integer, Integer> map = new TreeMap<>();
            map.put(forget, 1);
            for (int i = 1; i < n; i++) {
                TreeMap<Integer, Integer> nextMap = new TreeMap<>();
                // 计算到下一天
                for (int day : map.keySet()) {
                    int nextDay = day - 1;
                    int nextCount = map.get(day);
                    if (nextDay > 0) {
                        nextMap.put(nextDay, nextCount);
                    }
                }
                // key小于delay的可以分享
                long canShareCnt = 0;
                for (int day : map.keySet()) {
                    if (day <= forget - delay) {
                        canShareCnt += map.get(day);
                    }
                }
                if (canShareCnt > 0) {
                    nextMap.put(forget - 1, (int) (canShareCnt % MOD));
                }
                map = nextMap;
            }
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
