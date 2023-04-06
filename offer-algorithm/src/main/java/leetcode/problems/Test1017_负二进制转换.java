package leetcode.problems;

public class Test1017_负二进制转换 {

    public static void main(String[] args) {
        System.out.println(new Solution().baseNeg2(2));
        System.out.println(new Solution().baseNeg2(3));
        System.out.println(new Solution().baseNeg2(4));
        System.out.println(new Solution().baseNeg2(5));
        System.out.println(new Solution().baseNeg2(6));
        System.out.println(new Solution().baseNeg2(7));
        System.out.println(new Solution().baseNeg2(10));
        System.out.println(new Solution().baseNeg2(9));
    }

    static class Solution {
        public String baseNeg2(int n) {
            if (n == 0 || n == 1) {
                return String.valueOf(n);
            }
            String res = "";
            while (n != 0) {
                int r = n & 1;
                res = r + res;
                n -= r; // 作为负数进制需要减去余数
                n /= (-2);
            }
            return res;
        }
    }

}
