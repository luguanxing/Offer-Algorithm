package leetcode.contest.week194;

public class Test5440_数组异或操作 {

    public static void main(String[] args) {
        System.out.println(new Solution().xorOperation(5, 0));
        System.out.println(new Solution().xorOperation(4, 3));
        System.out.println(new Solution().xorOperation(1, 7));
        System.out.println(new Solution().xorOperation(10, 5));
    }

    static class Solution {
        public int xorOperation(int n, int start) {
            int num = start;
            for (int i = 1; i < n; i++) {
                num ^= start + 2 * i;
            }
            return num;
        }
    }

}
