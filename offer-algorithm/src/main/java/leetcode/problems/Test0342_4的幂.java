package leetcode.problems;

public class Test0342_4的幂 {

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfFour(1));
        System.out.println(new Solution().isPowerOfFour(4));
        System.out.println(new Solution().isPowerOfFour(16));
        System.out.println(new Solution().isPowerOfFour(18));
    }

    static class Solution {
        public boolean isPowerOfFour(int n) {
            int index = 0;
            while (index <= 32) {
                if (n == (1 << index)) {
                    return true;
                }
                index += 2;
            }
            return false;
        }
    }

}
