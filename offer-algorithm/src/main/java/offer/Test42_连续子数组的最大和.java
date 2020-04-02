package offer;

public class Test42_连续子数组的最大和 {

    public static void main(String[] args) {
        System.out.println(new Solution().FindGreatestSumOfSubArray(new int[]{6, -3, -2, 7, -15, 1, 2, 2}));
        System.out.println(new Solution().FindGreatestSumOfSubArray(new int[]{-2, -8, -1, -5, -9}));
    }

    static class Solution {
        public int FindGreatestSumOfSubArray(int[] array) {
            if (array == null) {
                return 0;
            }
            // 动态规划，记录前N大的数
            int[] maxSum = new int[array.length];
            maxSum[0] = array[0];
            for (int i = 1; i < array.length; i++) {
                // 如果之前结果加上当前更大就加，否则重新开始算
                maxSum[i] = Math.max(maxSum[i - 1] + array[i], array[i]);
            }
            // 找出子序列和中的最大值
            int max = maxSum[0];
            for (int i = 1; i < maxSum.length; i++) {
                max = Math.max(max, maxSum[i]);
            }
            return max;
        }
    }

}
