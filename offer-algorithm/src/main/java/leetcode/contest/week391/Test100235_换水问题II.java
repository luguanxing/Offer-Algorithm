package leetcode.contest.week391;

public class Test100235_换水问题II {

    public static void main(String[] args) {
        System.out.println(new Solution().maxBottlesDrunk(13, 6));
        System.out.println(new Solution().maxBottlesDrunk(10, 3));
    }

    static class Solution {
        public int maxBottlesDrunk(int numBottles, int numExchange) {
            int res = 0;
            int current = numBottles;
            int empty = 0;
            while (current > 0) {
                res += current;
                empty += current;
                current = 0;
                while (empty >= numExchange) {
                    empty -= numExchange;
                    current++;
                    numExchange++;
                }
            }
            return res;
        }
    }


}
