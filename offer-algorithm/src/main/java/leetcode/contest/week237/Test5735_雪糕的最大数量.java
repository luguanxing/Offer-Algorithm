package leetcode.contest.week237;

import java.util.Arrays;

public class Test5735_雪糕的最大数量 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxIceCream(
                new int[]{1, 3, 2, 4, 1}, 7
        ));
        System.out.println(new Solution().maxIceCream(
                new int[]{10, 6, 8, 7, 7, 8}, 5
        ));
        System.out.println(new Solution().maxIceCream(
                new int[]{1, 6, 3, 1, 2, 5}, 20
        ));
    }

    static class Solution {
        public int maxIceCream(int[] costs, int coins) {
            Arrays.sort(costs);
            int res = 0;
            for (int cost : costs) {
                if (cost <= coins) {
                    res++;
                    coins -= cost;
                }
            }
            return res;
        }
    }

}
