package leetcode.problems;

public class Test0504_七进制数 {

    public static void main(String[] args) {
        System.out.println(new Solution().convertToBase7(100));
        System.out.println(new Solution().convertToBase7(101));
        System.out.println(new Solution().convertToBase7(-7));
    }

    static class Solution {
        public String convertToBase7(int num) {
            boolean isNeg = false;
            String res = "";
            if (num < 0) {
                isNeg = true;
                num *= -1;
            }
            while (num >= 7) {
                int last = num % 7;
                res = last + res;
                num /= 7;
            }
            return (isNeg ? "-" : "") + num + res;
        }
    }

}
