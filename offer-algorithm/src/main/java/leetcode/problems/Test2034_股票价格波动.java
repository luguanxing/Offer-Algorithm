package leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test2034_股票价格波动 {

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1, 10); // 时间戳为 [1] ，对应的股票价格为 [10] 。
        stockPrice.update(2, 5);  // 时间戳为 [1,2] ，对应的股票价格为 [10,5] 。
        System.out.println(stockPrice.current());     // 返回 5 ，最新时间戳为 2 ，对应价格为 5 。
        System.out.println(stockPrice.maximum());     // 返回 10 ，最高价格的时间戳为 1 ，价格为 10 。
        stockPrice.update(1, 3);  // 之前时间戳为 1 的价格错误，价格更新为 3 ，对应股票价格为 [3,5] 。
        System.out.println(stockPrice.maximum());     // 返回 5 ，更正后最高价格为 5 。
        stockPrice.update(4, 2);  // 时间戳为 [1,2,4] ，对应价格为 [3,5,2] 。
        System.out.println(stockPrice.minimum());     // 返回 2 ，最低价格时间戳为 4 ，价格为 2 。
    }

    static class StockPrice {
        TreeMap<Integer, Integer> timePriceMap = new TreeMap<>();
        TreeMap<Integer, Integer> priceCntMap = new TreeMap<>();

        public StockPrice() {

        }

        public void update(int timestamp, int price) {
            // 更新价格-次数表
            if (timePriceMap.containsKey(timestamp)) {
                int oldPrice = timePriceMap.get(timestamp);
                if (priceCntMap.containsKey(oldPrice)) {
                    int oldPriceCnt = priceCntMap.get(oldPrice);
                    if (oldPriceCnt == 1) {
                        priceCntMap.remove(oldPrice);
                    } else {
                        priceCntMap.put(oldPrice, oldPriceCnt - 1);
                    }
                }
            }
            priceCntMap.put(price, priceCntMap.getOrDefault(price, 0) + 1);
            // 更新时间-价格表
            timePriceMap.put(timestamp, price);
        }

        public int current() {
            return timePriceMap.lastEntry().getValue();
        }

        public int maximum() {
            return priceCntMap.lastKey();
        }

        public int minimum() {
            return priceCntMap.firstKey();
        }
    }

}
