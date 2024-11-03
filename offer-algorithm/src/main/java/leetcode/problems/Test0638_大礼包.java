package leetcode.problems;

import java.util.*;

public class Test0638_大礼包 {

    public static void main(String[] args) {
        // price = [2,5], special = [[3,0,5],[1,2,10]], needs = [3,2]
        System.out.println(new Solution().shoppingOffers(Arrays.asList(2, 5), Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10)), Arrays.asList(3, 2)));
        // price = [2,3,4], special = [[1,1,0,4],[2,2,1,9]], needs = [1,2,1]
        System.out.println(new Solution().shoppingOffers(Arrays.asList(2, 3, 4), Arrays.asList(Arrays.asList(1, 1, 0, 4), Arrays.asList(2, 2, 1, 9)), Arrays.asList(1, 2, 1)));
    }

    static class Solution {
        Map<String, Integer> memo = new HashMap<>();  // 记忆化存储
        int res = Integer.MAX_VALUE;

        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            return dfs(price, special, needs);
        }

        private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            // 将当前的 needs 作为 HashMap 的 key
            String key = needs.toString();
            if (memo.containsKey(key)) {
                return memo.get(key);
            }

            int n = price.size();
            // 不使用任何礼包，直接购买的总价格
            int minCost = 0;
            for (int i = 0; i < n; i++) {
                minCost += needs.get(i) * price.get(i);
            }

            // 尝试每一个礼包
            for (List<Integer> sp : special) {
                List<Integer> newNeeds = new ArrayList<>(needs);
                boolean valid = true;
                for (int i = 0; i < n; i++) {
                    if (newNeeds.get(i) < sp.get(i)) {
                        valid = false;  // 如果礼包中的某个商品数量超过了需求，则无效
                        break;
                    }
                    newNeeds.set(i, newNeeds.get(i) - sp.get(i));  // 更新需求
                }

                if (valid) {
                    // 使用这个礼包，并递归计算剩余需求的最小花费
                    minCost = Math.min(minCost, sp.get(n) + dfs(price, special, newNeeds));
                }
            }

            memo.put(key, minCost);  // 记忆化存储当前状态
            return minCost;
        }
    }

    static class Solution_暴力 {
        Map<String, Integer> map = new HashMap<>();
        int res = Integer.MAX_VALUE;

        public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
            dfs(0, needs, price, special);
            return res;
        }

        private void dfs(int currentCost, List<Integer> needs, List<Integer> price, List<List<Integer>> special) {
            // 剪枝
            if (currentCost > res) {
                return;
            }
            if (map.containsKey(needs.toString()) && map.get(needs.toString()) <= currentCost) {
                return;
            }
            map.put(needs.toString(), currentCost);
            // 判断是否已经满足所有需求
            boolean isAllFinished = true;
            int n = needs.size();
            for (int i = 0; i < n; i++) {
                if (needs.get(i) > 0) {
                    isAllFinished = false;
                    break;
                }
            }
            if (isAllFinished) {
                res = Math.min(res, currentCost);
                return;
            }
            // 单独购买或不购买
            for (int i = 0; i < n; i++) {
                if (needs.get(i) > 0) {
                    needs.set(i, needs.get(i) - 1);
                    dfs(currentCost + price.get(i), needs, price, special);
                    needs.set(i, needs.get(i) + 1);
                    dfs(currentCost, needs, price, special);
                }
            }
            // 单独使用礼包或不使用
            for (int i = 0; i < n; i++) {
                if (needs.get(i) > 0) {
                    for (List<Integer> sp : special) {
                        boolean canBuy = true;
                        for (int j = 0; j < n; j++) {
                            if (needs.get(j) < sp.get(j)) {
                                canBuy = false;
                                break;
                            }
                        }
                        if (canBuy) {
                            for (int j = 0; j < n; j++) {
                                needs.set(j, needs.get(j) - sp.get(j));
                            }
                            dfs(currentCost + sp.get(n), needs, price, special);
                            for (int j = 0; j < n; j++) {
                                needs.set(j, needs.get(j) + sp.get(j));
                            }
                        }
                    }
                    dfs(currentCost, needs, price, special);
                }
            }
        }
    }

}
