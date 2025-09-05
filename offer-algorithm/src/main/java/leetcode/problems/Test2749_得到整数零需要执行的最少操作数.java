package leetcode.problems;

public class Test2749_得到整数零需要执行的最少操作数 {

    public static void main(String[] args) {
        System.out.println(new Solution().makeTheIntegerZero(3, -2));
        System.out.println(new Solution().makeTheIntegerZero(5, 7));
        System.out.println(new Solution().makeTheIntegerZero(12, -55));
        System.out.println(new Solution().makeTheIntegerZero(71, -13));
    }

    static class Solution {
        public int makeTheIntegerZero(int num1, int num2) {
            // Xn-1 - (2^i-num2) = 0
            // Xn-1 = 2^I - num2
            // 即判断是否存在 X - k*num2 = 2^i1 + 2^i2 + ... 2^ik
            // k 最少有 Long.bitCount(num1 - k * num2) 个1
            // k 最多有 num1 - k * num2 个1（全是1）
            for (long k = 1; k <= num1 - num2 * k; k++) {
                long num = num1 - k * num2;
                int minCount = Long.bitCount(num);
                if (k >= minCount) {
                    return (int) k;
                }
            }
            return -1;
        }
    }

}
