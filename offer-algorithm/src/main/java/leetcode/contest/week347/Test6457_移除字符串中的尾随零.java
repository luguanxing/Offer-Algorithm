package leetcode.contest.week347;

public class Test6457_移除字符串中的尾随零 {

    public static void main(String[] args) {
        System.out.println(new Solution().removeTrailingZeros("51230100"));
        System.out.println(new Solution().removeTrailingZeros("123"));
    }

    static class Solution {
        public String removeTrailingZeros(String num) {
            while (num.endsWith("0")) {
                num = num.substring(0, num.length() - 1);
            }
            return num;
        }
    }

}
