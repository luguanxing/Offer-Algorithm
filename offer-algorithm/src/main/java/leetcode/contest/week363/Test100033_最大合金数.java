package leetcode.contest.week363;

import java.util.*;

public class Test100033_最大合金数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxNumberOfAlloys(
                3, 2, 15,
                Arrays.asList(
                        Arrays.asList(1, 1, 1),
                        Arrays.asList(1, 1, 10)
                ),
                Arrays.asList(0, 0, 0),
                Arrays.asList(1, 2, 3)
        ));
        System.out.println(new Solution().maxNumberOfAlloys(
                3, 2, 15,
                Arrays.asList(
                        Arrays.asList(1, 1, 1),
                        Arrays.asList(1, 1, 10)
                ),
                Arrays.asList(0, 0, 100),
                Arrays.asList(1, 2, 3)
        ));
        System.out.println(new Solution().maxNumberOfAlloys(
                2, 3, 10,
                Arrays.asList(
                        Arrays.asList(2, 1),
                        Arrays.asList(1, 2),
                        Arrays.asList(1, 1)
                ),
                Arrays.asList(1, 1),
                Arrays.asList(5, 5)
        ));
    }

    static class Solution {
        public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> compositions, List<Integer> stock, List<Integer> cost) {
            int maxCnt = 0;
            for (List<Integer> composition : compositions) {
                int left = 0, right = Integer.MAX_VALUE/2;
                while (left < right) {
                    int mid = left + (right - left) / 2;
                    if (canMake(mid, budget, composition, stock, cost)) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                maxCnt = Math.max(maxCnt, left - 1);
            }
            return maxCnt;
        }

        private boolean canMake(int makeCnt, int budget, List<Integer> composition, List<Integer> stock, List<Integer> cost) {
            long totalCost = 0;
            for (int i = 0; i < composition.size(); i++) {
                long needToBuy = Math.max((long) composition.get(i) * makeCnt - stock.get(i), 0);
                totalCost += needToBuy * cost.get(i);
            }
            return totalCost <= budget;
        }
    }

}
