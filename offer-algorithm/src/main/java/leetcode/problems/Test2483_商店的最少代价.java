package leetcode.problems;

public class Test2483_商店的最少代价 {

    public static void main(String[] args) {
        System.out.println(new Solution().bestClosingTime("YYNY"));
        System.out.println(new Solution().bestClosingTime("NNNNN"));
        System.out.println(new Solution().bestClosingTime("YYYY"));
    }

    static class Solution {
        public int bestClosingTime(String customers) {
            int len = customers.length();
            // 计算总的Y和N的数量以及前缀和(末尾是开区间)
            int totalYCount = 0;
            int totalNCount = 0;
            int[] prefixYCount = new int[len + 1];
            int[] prefixNCount = new int[len + 1];
            for (int i = 0; i < len; i++) {
                char c = customers.charAt(i);
                prefixYCount[i + 1] = prefixYCount[i];
                prefixNCount[i + 1] = prefixNCount[i];
                if (c == 'Y') {
                    totalYCount++;
                    prefixYCount[i + 1]++;
                } else {
                    totalNCount++;
                    prefixNCount[i + 1]++;
                }
            }
            // 计算每个关闭时间点的代价 = 前面的N数量 + 后面的Y数量
            int minPenalty = totalYCount;
            int bestCloseTime = 0;
            for (int closeTime = 1; closeTime <= len; closeTime++) {
                int currentPenalty = prefixNCount[closeTime] + (totalYCount - prefixYCount[closeTime]);
                if (currentPenalty < minPenalty) {
                    minPenalty = currentPenalty;
                    bestCloseTime = closeTime;
                }
            }
            return bestCloseTime;
        }
    }

}
