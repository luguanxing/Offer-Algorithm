package leetcode.problems;

import java.util.*;

public class Test0901_股票价格跨度 {

    public static void main(String[] args) {
        StockSpanner S = new StockSpanner();
//        System.out.println(S.next(100));
//        System.out.println(S.next(80));
//        System.out.println(S.next(60));
//        System.out.println(S.next(70));
//        System.out.println(S.next(60));
//        System.out.println(S.next(75));
//        System.out.println(S.next(85));

//        System.out.println(S.next(29));
//        System.out.println(S.next(91));
//        System.out.println(S.next(62));
//        System.out.println(S.next(76));
//        System.out.println(S.next(51));

        System.out.println(S.next(28));
        System.out.println(S.next(14));
        System.out.println(S.next(28));
    }

    static class StockSpanner {
        Deque<int[]> stack;
        int index;

        public StockSpanner() {
            stack = new ArrayDeque<>();
            index = 0;
        }

        public int next(int price) {
            index++;
            // 单调栈，保存值和序号，栈内数逐渐递减
            while (!stack.isEmpty() && price >= stack.getLast()[0]) {
                stack.pollLast();
            }
            int lastIndex = stack.isEmpty() ? 0 : stack.getLast()[1];
            int diff = index - lastIndex;
            stack.add(new int[]{price, index});
            return diff;
        }
    }

    static class StockSpanner_暴力优化 {
        TreeMap<Integer, Integer> map;
        List<Integer> list;
        int index;

        public StockSpanner_暴力优化() {
            map = new TreeMap<>();
            list = new ArrayList<>();
            index = 0;
        }

        public int next(int price) {
            map.put(price, index);
            list.add(price);
            int higherPrice = map.higherKey(price) == null ? 0 : map.higherKey(price);
            int higherPriceIndex = map.getOrDefault(higherPrice, -1);
            for (int i = list.size() - 1; i >= Math.max(higherPriceIndex, 0); i--) {
                if (list.get(i) > price) {
                    higherPriceIndex = i;
                    break;
                }
            }
            return index++ - higherPriceIndex;
        }
    }


}
