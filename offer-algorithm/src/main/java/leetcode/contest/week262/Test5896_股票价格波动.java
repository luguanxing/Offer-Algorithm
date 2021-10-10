package leetcode.contest.week262;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test5896_股票价格波动 {

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10); // 时间戳为 [1] ，对应的股票价格为 [10] 。
        stockPrice.update(2, 5);  // 时间戳为 [1,2] ，对应的股票价格为 [10,5] 。
        System.out.println(stockPrice.current());     // 返回 5 ，最新时间戳为 2 ，对应价格为 5 。
        System.out.println(stockPrice.maximum());     // 返回 10 ，最高价格的时间戳为 1 ，价格为 10 。
        stockPrice.update(1, 3);  // 之前时间戳为 1 的价格错误，价格更新为 3 。
        // 时间戳为 [1,2] ，对应股票价格为 [3,5] 。
        System.out.println(stockPrice.maximum());     // 返回 5 ，更正后最高价格为 5 。
        stockPrice.update(4, 2);  // 时间戳为 [1,2,4] ，对应价格为 [3,5,2] 。
        System.out.println(stockPrice.minimum());     // 返回 2 ，最低价格时间戳为 4 ，价格为 2 。
    }

    static class StockPrice {
        HashMap<Integer, Integer> tsMap;
        TreeMap<Integer, Integer> priceMap;
        int currentTs;

        public StockPrice() {
            tsMap = new HashMap<>();
            priceMap = new TreeMap<>();
            currentTs = 0;
        }

        public void update(int timestamp, int price) {
            if (tsMap.containsKey(timestamp)) {
                int oldPrice = tsMap.get(timestamp);
                priceMap.put(oldPrice, priceMap.get(oldPrice) - 1);
                if (priceMap.get(oldPrice) == 0) {
                    priceMap.remove(oldPrice);
                }
            }
            priceMap.put(price, priceMap.getOrDefault(price, 0) + 1);
            tsMap.put(timestamp, price);
            currentTs = Math.max(currentTs, timestamp);
        }

        public int current() {
            return tsMap.get(currentTs);
        }

        public int maximum() {
            return priceMap.lastKey();
        }

        public int minimum() {
            return priceMap.firstKey();
        }
    }

}
