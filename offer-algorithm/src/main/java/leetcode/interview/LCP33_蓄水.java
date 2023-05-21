package leetcode.interview;

import java.util.Arrays;
import java.util.Map;

public class LCP33_蓄水 {

    public static void main(String[] args) {
        System.out.println(new Solution().storeWater(
                new int[]{1, 3},
                new int[]{6, 8}
        ));
        System.out.println(new Solution().storeWater(
                new int[]{9, 0, 1},
                new int[]{0, 2, 2}
        ));
    }

    static class Solution {
        public int storeWater(int[] bucket, int[] vat) {
            // 计算最大打水次数=最多水数/1=最多水数
            int maxCnt = Arrays.stream(vat).max().getAsInt();
            if (maxCnt == 0) {
                return 0;
            }
            // 枚举打水次数，同时看看每个需要增加多少容量达到这个次数，以及总成本多少，保留最小的成本
            int min = Integer.MAX_VALUE;
            for (int cnt = 1; cnt <= maxCnt; cnt++) {
                int totalCost = 0;
                for (int i = 0; i < bucket.length; i++) {
                    int currentBucket = (vat[i] + cnt - 1) / cnt;
                    int cost = currentBucket - bucket[i];
                    totalCost += Math.max(cost, 0);
                }
                min = Math.min(min, totalCost + cnt);
            }
            return min;
        }
    }

}
