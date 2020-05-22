package leetcode.problems;

public class Test0007_整数反转 {

    public static void main(String[] args) {
        System.out.println(new Solution().reverse(123));
        System.out.println(new Solution().reverse(-123));
        System.out.println(new Solution().reverse(120));
        System.out.println(new Solution().reverse(0));
        System.out.println(new Solution().reverse(-1));
        System.out.println(new Solution().reverse(1534236469));
    }

    static class Solution {
        public int reverse(int x) {
            boolean isNegative = x < 0;
            String str = String.valueOf(Math.abs(x));
            String reverseStr = new StringBuffer(str).reverse().toString();
            try {
                return Integer.parseInt(reverseStr) * (isNegative ? -1 : 1);
            } catch (Exception e) {
                return 0;
            }
        }
    }

}
