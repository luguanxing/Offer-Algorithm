package leetcode.problems;

public class Test1774_最接近目标价格的甜点成本 {

    public static void main(String[] args) {
        System.out.println(new Solution().closestCost(
                new int[]{1, 7},
                new int[]{3, 4},
                10
        ));
        System.out.println(new Solution().closestCost(
                new int[]{2, 3},
                new int[]{4, 5, 100},
                18
        ));
        System.out.println(new Solution().closestCost(
                new int[]{3, 10},
                new int[]{2, 5},
                9
        ));
        System.out.println(new Solution().closestCost(
                new int[]{10},
                new int[]{1},
                1
        ));
    }

    static class Solution {
        int[] toppingCosts;
        int target;
        // 与目标价格差距，越小越好
        int diff;
        // 最小目标价格差距下的最低成本
        int cost;

        public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
            this.toppingCosts = toppingCosts;
            this.target = target;
            this.diff = Integer.MAX_VALUE;
            for (int baseCost : baseCosts) {
                dfs(baseCost, 0);
            }
            return cost;
        }

        private void dfs(int currentCost, int index) {
            if (index == toppingCosts.length) {
                if (Math.abs(currentCost - target) < diff) {
                    diff = Math.abs(currentCost - target);
                    cost = currentCost;
                } else if (Math.abs(currentCost - target) == diff) {
                    cost = Math.min(cost, currentCost);
                }
                return;
            }
            // 无配料
            dfs(currentCost, index + 1);
            // 加1份配料
            dfs(currentCost + toppingCosts[index], index + 1);
            // 加2份配料
            dfs(currentCost + 2 * toppingCosts[index], index + 1);
        }
    }

}
