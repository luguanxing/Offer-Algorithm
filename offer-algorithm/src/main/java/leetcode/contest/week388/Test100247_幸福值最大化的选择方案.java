package leetcode.contest.week388;

import java.util.Arrays;

public class Test100247_幸福值最大化的选择方案 {

    public static void main(String[] args) {
        // happiness = [1,2,3], k = 2
        System.out.println(new Solution().maximumHappinessSum(new int[]{1, 2, 3}, 2));
        // happiness = [1,1,1,1], k = 2
        System.out.println(new Solution().maximumHappinessSum(new int[]{1, 1, 1, 1}, 2));
        // happiness = [2,3,4,5], k = 1
        System.out.println(new Solution().maximumHappinessSum(new int[]{2, 3, 4, 5}, 1));
    }

    static class Solution {
        public long maximumHappinessSum(int[] happiness, int k) {
            Arrays.sort(happiness);
            int currentRound = 0;
            long res = 0;
            for (int i = 1; i <= k; i++) {
                res += Math.max(0, happiness[happiness.length - i] - currentRound);
                currentRound++;
            }
            return res;
        }
    }

}
