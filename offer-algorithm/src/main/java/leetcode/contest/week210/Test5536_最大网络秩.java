package leetcode.contest.week210;

import java.util.*;

public class Test5536_最大网络秩 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximalNetworkRank(
                2, new int[][]{}
        ));
        System.out.println(new Solution().maximalNetworkRank(
                5, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}}
        ));
        System.out.println(new Solution().maximalNetworkRank(
                8, new int[][]{{0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}}
        ));
        System.out.println(new Solution().maximalNetworkRank(
                4, new int[][]{{0, 1}, {0, 3}, {1, 2}, {1, 3}}
        ));
    }

    static class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            Map<Integer, List<String>> reachableMap = new HashMap<>();
            // 保存所有道路
            for (int[] road : roads) {
                int c1 = road[0];
                int c2 = road[1];
                String roadStr = Math.min(c1, c2) + "-" + Math.max(c1, c2);
                List<String> list1 = reachableMap.getOrDefault(c1, new ArrayList<>());
                List<String> list2 = reachableMap.getOrDefault(c2, new ArrayList<>());
                list1.add(roadStr);
                list2.add(roadStr);
                reachableMap.put(c1, list1);
                reachableMap.put(c2, list2);
            }
            int max = 0;
            // 每两个点遍历
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    Set<String> set = new HashSet<>();
                    if (reachableMap.containsKey(i)) {
                        set.addAll(reachableMap.get(i));
                    }
                    if (reachableMap.containsKey(j)) {
                        set.addAll(reachableMap.get(j));
                    }
                    max = Math.max(max, set.size());
                }
            }
            return max;
        }
    }

}
