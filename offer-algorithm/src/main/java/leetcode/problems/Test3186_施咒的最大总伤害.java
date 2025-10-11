package leetcode.problems;

import java.util.TreeMap;

public class Test3186_施咒的最大总伤害 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumTotalDamage(new int[]{1, 1, 3, 4}));
        System.out.println(new Solution().maximumTotalDamage(new int[]{7, 1, 6, 6}));
        System.out.println(new Solution().maximumTotalDamage(new int[]{7, 1, 6, 3}));
        System.out.println(new Solution().maximumTotalDamage(new int[]{5, 9, 2, 10, 2, 7, 10, 9, 3, 8}));
    }

    static class Solution {
        public long maximumTotalDamage(int[] power) {
            // 使用treemap存储每个power对应最大的和
            TreeMap<Integer, Long> powerMaxSum = new TreeMap<>();
            for (int p : power) {
                powerMaxSum.put(p, powerMaxSum.getOrDefault(p, 0L) + p);
            }
            long max = 0;
            // 遍历treemap，计算每个power对应的最大和，只能从power-2之前获取最大值
            for (int k : powerMaxSum.keySet()) {
                Integer lastK = powerMaxSum.lowerKey(k - 2);
                if (lastK != null) {
                    powerMaxSum.put(k, powerMaxSum.get(k) + powerMaxSum.get(lastK));
                }
                max = Math.max(max, powerMaxSum.get(k));
                // 更当前k的值，保证powerSumMap的值只会递增
                powerMaxSum.put(k, Math.max(powerMaxSum.get(k), max));
            }
            return max;
        }
    }

}
