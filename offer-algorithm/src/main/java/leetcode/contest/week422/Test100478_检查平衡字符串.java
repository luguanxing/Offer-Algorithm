package leetcode.contest.week422;

public class Test100478_检查平衡字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().isBalanced("1234"));
        System.out.println(new Solution().isBalanced("24123"));
    }

    static class Solution {
        public boolean isBalanced(String num) {
            int sum1 = 0;
            int sum2 = 0;
            for (int i = 0; i < num.length(); i++) {
                if (i % 2 == 0) {
                    sum1 += num.charAt(i) - '0';
                } else {
                    sum2 += num.charAt(i) - '0';
                }
            }
            return sum1 == sum2;
        }
    }

}
