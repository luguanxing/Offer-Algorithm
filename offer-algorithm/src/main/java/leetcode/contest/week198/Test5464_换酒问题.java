package leetcode.contest.week198;

public class Test5464_换酒问题 {

    public static void main(String[] args) {
        System.out.println(new Solution().numWaterBottles(9, 3));
        System.out.println(new Solution().numWaterBottles(15, 4));
        System.out.println(new Solution().numWaterBottles(5, 5));
        System.out.println(new Solution().numWaterBottles(2, 3));
    }

    static class Solution {
        public int numWaterBottles(int numBottles, int numExchange) {
            int res = 0;
            int filled = numBottles;
            int empty = 0;
            while (filled > 0 || empty >= numExchange) {
                res += filled;
                empty += filled;
                filled = empty / numExchange;
                empty = empty % numExchange;
            }
            return res;
        }
    }

}
