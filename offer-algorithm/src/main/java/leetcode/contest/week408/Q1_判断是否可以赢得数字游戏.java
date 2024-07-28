package leetcode.contest.week408;

public class Q1_判断是否可以赢得数字游戏 {

    public static void main(String[] args) {
        System.out.println(new Solution().canAliceWin(new int[]{1, 2, 3, 4, 10}));
        System.out.println(new Solution().canAliceWin(new int[]{1, 2, 3, 4, 5, 14}));
        System.out.println(new Solution().canAliceWin(new int[]{5, 5, 5, 25}));
    }

    static class Solution {
        public boolean canAliceWin(int[] nums) {
            int sum1 = 0;
            int sum2 = 0;
            int sum = 0;
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i];
                if (num < 10) {
                    sum1 += num;
                } else if (num < 100) {
                    sum2 += num;
                }
                sum += num;
            }
            if (sum1 > sum - sum1 || sum2 > sum - sum2) {
                return true;
            } else {
                return false;
            }
        }
    }

}
