package leetcode.contest.week246;

public class Test5788_字符串中的最大奇数 {

    public static void main(String[] args) {
        System.out.println(new Solution().largestOddNumber("52"));
        System.out.println(new Solution().largestOddNumber("4206"));
        System.out.println(new Solution().largestOddNumber("35427"));
    }

    static class Solution {
        public String largestOddNumber(String num) {
            for (int index = num.length() - 1; index >= 0; index--) {
                if ((num.charAt(index) - '0') % 2 == 1) {
                    return num.substring(0, index + 1);
                }
            }
            return "";
        }
    }

}
