package leetcode.problems;

public class Test2786_访问数组中的位置使分数最大 {

    public static void main(String[] args) {
        // nums = [2,3,6,1,9,2], x = 5
        System.out.println(new Solution().maxScore(new int[]{2, 3, 6, 1, 9, 2}, 5));
        // nums = [2,4,6,8], x = 3
        System.out.println(new Solution().maxScore(new int[]{2, 4, 6, 8}, 3));
        System.out.println(new Solution().maxScore(new int[]{85, 12}, 79));
    }

    static class Solution {
        public long maxScore(int[] nums, int x) {
            // 考虑以奇数或偶数结尾时的最大分数
            long res = nums[0];
            long maxOddEnd = Integer.MIN_VALUE;
            long maxEvenEnd = Integer.MIN_VALUE;
            if (nums[0] % 2 == 0) {
                maxEvenEnd = nums[0];
            } else {
                maxOddEnd = nums[0];
            }
            // 以当前奇数或偶数结尾的结果，从上一个奇数或偶数过来
            for (int i = 1; i < nums.length; i++) {
                int num = nums[i];
                long curMax = Integer.MIN_VALUE;
                if (num % 2 == 0) {
                    curMax = Math.max(curMax, maxEvenEnd + num);
                    curMax = Math.max(curMax, maxOddEnd + num - x);
                    maxEvenEnd = curMax;
                } else {
                    curMax = Math.max(curMax, maxOddEnd + num);
                    curMax = Math.max(curMax, maxEvenEnd + num - x);
                    maxOddEnd = curMax;
                }
                res = Math.max(res, curMax);
            }
            return res;
        }
    }

}
