package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test2462_雇佣K位工人的总代价 {

    public static void main(String[] args) {
        // costs = [17,12,10,2,7,2,11,20,8], k = 3, candidates = 4
        System.out.println(new Solution().totalCost(new int[]{17, 12, 10, 2, 7, 2, 11, 20, 8}, 3, 4));
        // costs = [1,2,4,1], k = 3, candidates = 3
        System.out.println(new Solution().totalCost(new int[]{1, 2, 4, 1}, 3, 3));
    }

    static class Solution {
        public long totalCost(int[] costs, int k, int candidates) {
            // 两头treemap实现
            List<Integer> list = Arrays.stream(costs).boxed().collect(Collectors.toList());
            TreeMap<Integer, Integer> left = new TreeMap<>();
            TreeMap<Integer, Integer> right = new TreeMap<>();
            for (int i = 0; i < candidates; i++) {
                if (list.isEmpty()) {
                    break;
                }
                left.put(list.get(0), left.getOrDefault(list.get(0), 0) + 1);
                list.remove(0);
            }
            for (int i = 0; i < candidates; i++) {
                if (list.isEmpty()) {
                    break;
                }
                right.put(list.get(list.size() - 1), right.getOrDefault(list.get(list.size() - 1), 0) + 1);
                list.remove(list.size() - 1);
            }
            // 拿取k个，每次从左右找最小，拿取后若还有剩余需要补充
            long totalCost = 0;
            for (int i = 1; i <= k; i++) {
                if (right.isEmpty() || (!left.isEmpty() && left.firstKey() <= right.firstKey())) {
                    int take = left.firstKey();
                    totalCost += take;
                    if (left.get(take) == 1) {
                        left.remove(take);
                    } else {
                        left.put(take, left.get(take) - 1);
                    }
                    if (!list.isEmpty()) {
                        left.put(list.get(0), left.getOrDefault(list.get(0), 0) + 1);
                        list.remove(0);
                    }
                } else if (left.isEmpty() || (!right.isEmpty() && left.firstKey() > right.firstKey())) {
                    int take = right.firstKey();
                    totalCost += take;
                    if (right.get(take) == 1) {
                        right.remove(take);
                    } else {
                        right.put(take, right.get(take) - 1);
                    }
                    if (!list.isEmpty()) {
                        right.put(list.get(list.size() - 1), right.getOrDefault(list.get(list.size() - 1), 0) + 1);
                        list.remove(list.size() - 1);
                    }
                }
            }
            return totalCost;
        }
    }

    static class Solution_PQ {
        public long totalCost(int[] costs, int k, int candidates) {
            // 两头优先队列实现
            List<Integer> list = Arrays.stream(costs).boxed().collect(Collectors.toList());
            PriorityQueue<Integer> left = new PriorityQueue<>(Comparator.naturalOrder());
            PriorityQueue<Integer> right = new PriorityQueue<>(Comparator.naturalOrder());
            for (int i = 0; i < candidates; i++) {
                if (list.isEmpty()) {
                    break;
                }
                left.offer(list.get(0));
                list.remove(0);
            }
            for (int i = 0; i < candidates; i++) {
                if (list.isEmpty()) {
                    break;
                }
                right.offer(list.get(list.size() - 1));
                list.remove(list.size() - 1);
            }
            // 拿取k个，拿取后若还有剩余需要补充
            long totalCost = 0;
            for (int i = 1; i <= k; i++) {
                if (left.isEmpty()) {
                    totalCost += right.poll();
                    if (!list.isEmpty()) {
                        right.offer(list.get(list.size() - 1));
                        list.remove(list.size() - 1);
                    }
                    continue;
                }
                if (right.isEmpty()) {
                    totalCost += left.poll();
                    if (!list.isEmpty()) {
                        left.offer(list.get(0));
                        list.remove(0);
                    }
                    continue;
                }
                if (left.peek() <= right.peek()) {
                    totalCost += left.poll();
                    if (!list.isEmpty()) {
                        left.offer(list.get(0));
                        list.remove(0);
                    }
                } else {
                    totalCost += right.poll();
                    if (!list.isEmpty()) {
                        right.offer(list.get(list.size() - 1));
                        list.remove(list.size() - 1);
                    }
                }
            }
            return totalCost;
        }
    }

}
