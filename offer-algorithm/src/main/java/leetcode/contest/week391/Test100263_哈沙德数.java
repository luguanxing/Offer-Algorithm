package leetcode.contest.week391;

public class Test100263_哈沙德数 {

    public static void main(String[] args) {
        System.out.println(new Solution().sumOfTheDigitsOfHarshadNumber(18));
        System.out.println(new Solution().sumOfTheDigitsOfHarshadNumber(23));
    }

    static class Solution {
        public int sumOfTheDigitsOfHarshadNumber(int x) {
            int old = x;
            int sum = 0;
            while (x > 0) {
                sum += x % 10;
                x /= 10;
            }
            return old % sum == 0 ? sum : -1;
        }
    }

}
