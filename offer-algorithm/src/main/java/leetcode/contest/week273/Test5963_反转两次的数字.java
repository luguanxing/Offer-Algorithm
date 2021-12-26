package leetcode.contest.week273;

public class Test5963_反转两次的数字 {

    public static void main(String[] args) {
        System.out.println(new Solution().isSameAfterReversals(526));
        System.out.println(new Solution().isSameAfterReversals(1800));
        System.out.println(new Solution().isSameAfterReversals(0));
    }

    static class Solution {
        public boolean isSameAfterReversals(int num) {
            StringBuilder reverseStr = new StringBuilder(String.valueOf(num)).reverse();
            int reverseNum = Integer.parseInt(reverseStr.toString());
            StringBuilder reverse2Str = new StringBuilder(String.valueOf(reverseNum)).reverse();
            int reverse2Num = Integer.parseInt(reverse2Str.toString());
            return num == reverse2Num;
        }
    }

}
