package leetcode.problems;

public class Test0926_将字符串翻转到单调递增 {

    public static void main(String[] args) {
        System.out.println(new Solution().minFlipsMonoIncr("00110"));
        System.out.println(new Solution().minFlipsMonoIncr("010110"));
        System.out.println(new Solution().minFlipsMonoIncr("00011000"));
    }

    static class Solution {
        public int minFlipsMonoIncr(String s) {
            // 枚举从第i位开始，前面是0，后面是1的代价，找出最小的代价即可
            int len = s.length();
            int[] prefixSum = new int[len];
            prefixSum[0] = s.charAt(0) - '0';
            for (int i = 1; i < len; i++) {
                prefixSum[i] = prefixSum[i - 1] + s.charAt(i) - '0';
            }
            int min = Integer.MAX_VALUE;
            for (int i = -1; i < len; i++) {
                int leftCost = i == -1 ? 0 : prefixSum[i];
                int rightCost = i == -1 ? len - prefixSum[len - 1] : (len - 1 - i) - (prefixSum[len - 1] - prefixSum[i]);
                min = Math.min(min, leftCost + rightCost);
            }
            return min;
        }
    }

}
