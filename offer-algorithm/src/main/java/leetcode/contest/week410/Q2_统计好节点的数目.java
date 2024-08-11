package leetcode.contest.week410;

import java.util.*;

public class Q2_统计好节点的数目 {

    public static void main(String[] args) {
        // edges = [[0,1],[0,2],[1,3],[1,4],[2,5],[2,6]]
        System.out.println(new Solution().countGoodNodes(new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}}));
        // edges = [[0,1],[1,2],[2,3],[3,4],[0,5],[1,6],[2,7],[3,8]]
        System.out.println(new Solution().countGoodNodes(new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {0, 5}, {1, 6}, {2, 7}, {3, 8}}));
        // edges = [[0,1],[1,2],[1,3],[1,4],[0,5],[5,6],[6,7],[7,8],[0,9],[9,10],[9,12],[10,11]]
        System.out.println(new Solution().countGoodNodes(new int[][]{{0, 1}, {1, 2}, {1, 3}, {1, 4}, {0, 5}, {5, 6}, {6, 7}, {7, 8}, {0, 9}, {9, 10}, {9, 12}, {10, 11}}));
    }

    static class Solution {
        List<List<Integer>> adjList = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        int res = 0;

        public int countGoodNodes(int[][] edges) {
            int n = edges.length + 1;
            // 构建邻接表
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                adjList.get(edge[0]).add(edge[1]);
                adjList.get(edge[1]).add(edge[0]);
            }
            // 计算答案
            dfsGetWeight(0);
            return res;
        }

        private int dfsGetWeight(int current) {
            visited.add(current);
            int weight = 0;
            Set<Integer> childrenWeights = new HashSet<>();
            for (int next : adjList.get(current)) {
                if (!visited.contains(next)) {
                    int childrenWeight = dfsGetWeight(next);
                    weight += childrenWeight;
                    childrenWeights.add(childrenWeight);
                }
            }
            if (childrenWeights.isEmpty() || childrenWeights.size() == 1) {
                res++;
            }
            return weight + 1;
        }
    }

}
