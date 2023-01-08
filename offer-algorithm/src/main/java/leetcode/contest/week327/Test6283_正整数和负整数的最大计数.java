package leetcode.contest.week327;

public class Test6283_正整数和负整数的最大计数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumCount(new int[]{-2, -1, -1, 1, 2, 3}));
        System.out.println(new Solution().maximumCount(new int[]{-3, -2, -1, 0, 0, 1, 2}));
        System.out.println(new Solution().maximumCount(new int[]{5, 20, 66, 1314}));
    }

    static class Solution {
        public int maximumCount(int[] nums) {
            int cnt1 = 0;
            int cnt2 = 0;
            for (int num : nums) {
                if (num > 0) {
                    cnt1++;
                } else if (num < 0) {
                    cnt2++;
                }
            }
            return Math.max(cnt1, cnt2);
        }
    }

}
