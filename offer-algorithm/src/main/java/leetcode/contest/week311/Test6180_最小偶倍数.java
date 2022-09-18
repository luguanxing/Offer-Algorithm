package leetcode.contest.week311;

public class Test6180_最小偶倍数 {

    public static void main(String[] args) {
        System.out.println(new Solution().smallestEvenMultiple(5));
        System.out.println(new Solution().smallestEvenMultiple(6));
    }

    static class Solution {
        public int smallestEvenMultiple(int n) {
            if (n % 2 == 0) {
                return n;
            } else {
                return 2 * n;
            }
        }
    }

}
