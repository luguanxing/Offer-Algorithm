package leetcode.problems;

import java.util.*;

public class Test1711_大餐计数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countPairs(
                new int[]{1, 3, 5, 7, 9}
        ));
        System.out.println(new Solution().countPairs(
                new int[]{1, 1, 1, 3, 3, 3, 7}
        ));
    }

    static class Solution {
        public int countPairs(int[] deliciousness) {
            // 生成所有2的幂
            List<Integer> pows = new ArrayList<>();
            int pow = 1;
            for (int i = 1; i <= 22; i++) {
                pows.add(pow);
                pow *= 2;
            }
            int res = 0;
            Map<Integer, Integer> map = new HashMap<>();
            // 一边遍历累加已有结果一边更新
            for (int d : deliciousness) {
                for (int p : pows) {
                    res += map.getOrDefault(p - d, 0) % 1000000007;
                    res %= 1000000007;
                }
                map.put(d, map.getOrDefault(d, 0) + 1);
            }
            return res;
        }
    }

}
