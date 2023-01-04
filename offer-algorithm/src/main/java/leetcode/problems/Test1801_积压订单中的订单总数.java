package leetcode.problems;

import java.util.Comparator;
import java.util.TreeMap;

public class Test1801_积压订单中的订单总数 {

    public static void main(String[] args) {
        System.out.println(new Solution().getNumberOfBacklogOrders(new int[][]{
                {10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}
        }));
        System.out.println(new Solution().getNumberOfBacklogOrders(new int[][]{
                {7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}
        }));
    }

    static class Solution {
        public int getNumberOfBacklogOrders(int[][] orders) {
            int MOD = 1000000007;
            // 构造买盘和卖盘
            TreeMap<Integer, Integer> buys = new TreeMap<>(Comparator.reverseOrder());
            TreeMap<Integer, Integer> sells = new TreeMap<>();
            for (int[] order : orders) {
                int price = order[0];
                int quantity = order[1];
                int type = order[2];
                if (type == 0) {
                    buys.put(price, buys.getOrDefault(price, 0) + quantity);
                } else {
                    sells.put(price, sells.getOrDefault(price, 0) + quantity);
                }
                // 撮合最高买价和最低卖价的交易
                while (!buys.isEmpty() && !sells.isEmpty()) {
                    int buyPrice = buys.firstKey();
                    int sellPrice = sells.firstKey();
                    if (buyPrice < sellPrice) {
                        break;
                    }
                    int buyQuantity = buys.get(buyPrice);
                    int sellQuantity = sells.get(sellPrice);
                    if (buyQuantity >= sellQuantity) {
                        sells.remove(sellPrice);
                        buys.put(buyPrice, buyQuantity - sellQuantity);
                    } else {
                        buys.remove(buyPrice);
                        sells.put(sellPrice, sellQuantity - buyQuantity);
                    }
                }
            }
            int res = 0;
            for (int cnt : buys.values()) {
                res += cnt;
                res %= MOD;
            }
            for (int cnt : sells.values()) {
                res += cnt;
                res %= MOD;
            }
            return res;
        }
    }

}
