package leetcode.contest.week222;

import java.math.BigInteger;

public class Test5643_将数组分成三个子数组的方案数 {

    public static void main(String[] args) {
        System.out.println(new Solution().waysToSplit(
                new int[]{1, 1, 1}
        ));
        System.out.println(new Solution().waysToSplit(
                new int[]{1, 2, 2, 2, 5, 0}
        ));
        System.out.println(new Solution().waysToSplit(
                new int[]{3, 2, 1}
        ));
        System.out.println(new Solution().waysToSplit(
                new int[]{0, 0, 0, 0}
        ));
    }

    static class Solution {
        public int waysToSplit(int[] nums) {
            // 前缀和
            int len = nums.length;
            int[] prefix = new int[len];
            int sum = 0;
            for (int i = 0; i < len; i++) {
                sum += nums[i];
                prefix[i] = sum;
            }
            // 查找中间点的左右边界
            BigInteger res = new BigInteger("0");
            int midLeft = 1;
            int midRight = 1;
            for (int left = 0; left < len; left++) {
                // 这里midLeft尽量使用上次的结果
                midLeft = Math.max(midLeft, left + 1);
                while (midLeft < len && prefix[left] > prefix[midLeft] - prefix[left]) {
                    midLeft++;
                }
                if (midLeft == len) {
                    break;
                }
                // 这里midRight尽量使用上次的结果
                midRight = Math.max(midRight, midLeft);
                while (midRight < len - 1 && prefix[midRight] - prefix[left] <= prefix[len - 1] - prefix[midRight]) {
                    midRight++;
                }
                res = res.add(new BigInteger(midRight - midLeft + ""));
            }
            return res.mod(new BigInteger("1000000007")).intValue();
        }
    }

}
