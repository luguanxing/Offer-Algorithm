package leetcode.contest.week349;

public class Test6449_收集巧克力 {

    public static void main(String[] args) {
        System.out.println(new Solution().minCost(new int[]{20, 1, 15}, 5));
        System.out.println(new Solution().minCost(new int[]{1, 2, 3}, 4));
        System.out.println(new Solution().minCost(new int[]{15, 150, 56, 69, 214, 203}, 42));
    }

    static class Solution {
        public long minCost(int[] nums, int x) {
            int len = nums.length;
            long min = Long.MAX_VALUE;
            int[] minCost = nums.clone();
            for (int moveStep = 0; moveStep < len; moveStep++) {
                for (int i = 0; i < len; i++) {
                    minCost[i] = Math.min(minCost[i], nums[(i + moveStep) % len]);
                }
                long sum = 0;
                for (int c : minCost) {
                    sum += c;
                }
                sum += (long) moveStep * x;
                min = Math.min(min, sum);
            }
            return min;
        }
    }

}
