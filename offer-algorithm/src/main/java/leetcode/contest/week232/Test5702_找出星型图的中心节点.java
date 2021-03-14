package leetcode.contest.week232;

import java.util.HashMap;
import java.util.Map;

public class Test5702_找出星型图的中心节点 {

    public static void main(String[] args) {
        System.out.println(new Solution().findCenter(new int[][]{
                {1, 2}, {2, 3}, {4, 2}
        }));
        System.out.println(new Solution().findCenter(new int[][]{
                {1, 2}, {5, 1}, {1, 3}, {1, 4}
        }));
    }

    static class Solution {
        public int findCenter(int[][] edges) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] edge : edges) {
                map.put(edge[0], map.getOrDefault(edge[0], 0) + 1);
                map.put(edge[1], map.getOrDefault(edge[1], 0) + 1);
            }
            int max = 0;
            int maxNode = 0;
            for (int node : map.keySet()) {
                if (map.get(node) > max) {
                    max = map.get(node);
                    maxNode = node;
                }
            }
            return maxNode;
        }
    }

}
