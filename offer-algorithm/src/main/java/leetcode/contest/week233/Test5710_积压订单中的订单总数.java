package leetcode.contest.week233;

import java.math.BigInteger;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class Test5710_积压订单中的订单总数 {

    public static void main(String[] args) {
        System.out.println(new Solution().getNumberOfBacklogOrders(new int[][]{
                {10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0},
        }));
        System.out.println(new Solution().getNumberOfBacklogOrders(new int[][]{
                {7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1},
        }));
    }

    static class Solution {
        public int getNumberOfBacklogOrders(int[][] orders) {
            Map<Integer, BigInteger> buys = new TreeMap<>(Comparator.reverseOrder());
            Map<Integer, BigInteger> sells = new TreeMap<>(Comparator.naturalOrder());
            for (int[] order : orders) {
                int price = order[0];
                int count = order[1];
                if (order[2] == 0) {
                    // 买单
                    BigInteger currentCount = buys.getOrDefault(price, new BigInteger("0"));
                    currentCount = currentCount.add(new BigInteger(count + ""));
                    buys.put(price, currentCount);
                    // 撮合系统
                    while (!buys.isEmpty() && !sells.isEmpty()) {
                        int buy1 = buys.keySet().stream().findFirst().orElse(Integer.MIN_VALUE);
                        int sell1 = sells.keySet().stream().findFirst().orElse(Integer.MAX_VALUE);
                        if (buy1 < sell1) {
                            break;
                        }
                        BigInteger buy1Count = buys.get(buy1);
                        BigInteger sell1Count = sells.get(sell1);
                        if (buy1Count.compareTo(sell1Count) >= 0) {
                            buy1Count = buy1Count.subtract(sell1Count);
                            buys.put(buy1, buy1Count);
                            sells.remove(sell1);
                        } else {
                            sell1Count = sell1Count.subtract(buy1Count);
                            sells.put(sell1, sell1Count);
                            buys.remove(buy1);
                        }
                    }
                } else {
                    // 卖单
                    BigInteger currentCount = sells.getOrDefault(price, new BigInteger("0"));
                    currentCount = currentCount.add(new BigInteger(count + ""));
                    sells.put(price, currentCount);
                    // 撮合系统
                    while (!buys.isEmpty() && !sells.isEmpty()) {
                        int buy1 = buys.keySet().stream().findFirst().orElse(Integer.MIN_VALUE);
                        int sell1 = sells.keySet().stream().findFirst().orElse(Integer.MAX_VALUE);
                        if (buy1 < sell1) {
                            break;
                        }
                        BigInteger buy1Count = buys.get(buy1);
                        BigInteger sell1Count = sells.get(sell1);
                        if (buy1Count.compareTo(sell1Count) >= 0) {
                            buy1Count = buy1Count.subtract(sell1Count);
                            buys.put(buy1, buy1Count);
                            sells.remove(sell1);
                        } else {
                            sell1Count = sell1Count.subtract(buy1Count);
                            sells.put(sell1, sell1Count);
                            buys.remove(buy1);
                        }
                    }
                }
            }
            // 统计剩余
            BigInteger res = new BigInteger("0");
            for (BigInteger buyCount : buys.values()) {
                res = res.add(buyCount);
            }
            for (BigInteger sellCount : sells.values()) {
                res = res.add(sellCount);
            }
            res = res.mod(new BigInteger("1000000007"));
            return res.intValue();
        }
    }

}
