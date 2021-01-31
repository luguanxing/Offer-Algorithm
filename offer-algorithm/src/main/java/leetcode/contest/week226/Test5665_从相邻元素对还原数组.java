package leetcode.contest.week226;

import java.util.*;

public class Test5665_从相邻元素对还原数组 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().restoreArray(new int[][]{
                {2, 1}, {3, 4}, {3, 2}
        })));
        System.out.println(Arrays.toString(new Solution().restoreArray(new int[][]{
                {4, -2}, {1, 4}, {-3, 1}
        })));
        System.out.println(Arrays.toString(new Solution().restoreArray(new int[][]{
                {100000, -100000}
        })));
    }

    static class Solution {
        public int[] restoreArray(int[][] adjacentPairs) {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            Map<Integer, Integer> cntMap = new HashMap<>();
            for (int[] adjacentPair : adjacentPairs) {
                int num1 = adjacentPair[0];
                int num2 = adjacentPair[1];
                Set<Integer> list1 = map.getOrDefault(num1, new HashSet<>());
                Set<Integer> list2 = map.getOrDefault(num2, new HashSet<>());
                list1.add(num2);
                list2.add(num1);
                map.put(num1, list1);
                map.put(num2, list2);
                cntMap.put(num1, cntMap.getOrDefault(num1, 0) + 1);
                cntMap.put(num2, cntMap.getOrDefault(num2, 0) + 1);
            }

            List<Integer> list = new ArrayList<>();
            Set<Integer> vistited = new HashSet<>();
            int start = -1;
            for (int num : map.keySet()) {
                if (map.get(num).size() == 1) {
                    start = num;
                    break;
                }
            }
            while (map.containsKey(start)) {
                Set<Integer> nexts = map.get(start);
                int next = nexts.stream().findFirst().orElse(0);
                if (!vistited.contains(start)) {
                    list.add(start);
                    vistited.add(start);
                }
                if (!vistited.contains(next)) {
                    list.add(next);
                    vistited.add(next);
                }
                map.remove(start);
                if (map.containsKey(next)) {
                    map.get(next).remove(start);
                }
                start = next;
            }

            int[] res = new int[list.size() - 1];
            for (int i = 0; i < list.size() - 1; i++) {
                res[i] = list.get(i);
            }
            return res;
        }
    }

}
