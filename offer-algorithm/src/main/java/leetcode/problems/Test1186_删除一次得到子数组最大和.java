package leetcode.problems;

import java.util.Arrays;

public class Test1186_删除一次得到子数组最大和 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumSum(new int[]{1, -2, 0, 3}));
        System.out.println(new Solution().maximumSum(new int[]{1, -2, -2, 3}));
        System.out.println(new Solution().maximumSum(new int[]{-1, -1, -1, -1}));
        System.out.println(new Solution().maximumSum(new int[]{2, 1, -2, -5, -2}));
    }

    static class Solution {
        public int maximumSum(int[] arr) {
            int len = arr.length;
            // dp0表示之前没删过数的最大结果，dp1表示之前删过1个数的最大结果
            int[] dp0 = new int[len];
            int[] dp1 = new int[len];
            dp0[0] = arr[0];
            dp1[0] = -Integer.MAX_VALUE / 2;
            for (int i = 1; i < len; i++) {
                // dp0[i]可选带之前结果或重新开
                dp0[i] = Math.max(dp0[i - 1] + arr[i], arr[i]);
                // dp1[i]可选删不要arr[i]或者之前已删1个的结果加上arr[i]
                dp1[i] = Math.max(dp0[i - 1], dp1[i - 1] + arr[i]);
            }
            return Math.max(
                    Arrays.stream(dp0).max().getAsInt(),
                    Arrays.stream(dp1).max().getAsInt()
            );
        }
    }

}
