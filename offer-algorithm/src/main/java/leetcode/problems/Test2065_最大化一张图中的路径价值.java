package leetcode.problems;

import java.util.*;

public class Test2065_最大化一张图中的路径价值 {

    public static void main(String[] args) {
        // values = [0,32,10,43], edges = [[0,1,10],[1,2,15],[0,3,10]], maxTime = 49
        System.out.println(new Solution().maximalPathQuality(new int[]{0, 32, 10, 43}, new int[][]{{0, 1, 10}, {1, 2, 15}, {0, 3, 10}}, 49));
        // values = [5,10,15,20], edges = [[0,1,10],[1,2,10],[0,3,10]], maxTime = 30
        System.out.println(new Solution().maximalPathQuality(new int[]{5, 10, 15, 20}, new int[][]{{0, 1, 10}, {1, 2, 10}, {0, 3, 10}}, 30));
    }

    static class Solution {
        List<int[]>[] reachTable;
        boolean[] visited;
        int res = 0;

        public int maximalPathQuality(int[] values, int[][] edges, int maxTime) {
            int len = values.length;
            visited = new boolean[len];
            reachTable = new List[len];
            for (int i = 0; i < len; i++) {
                reachTable[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                reachTable[edge[0]].add(new int[]{edge[1], edge[2]});
                reachTable[edge[1]].add(new int[]{edge[0], edge[2]});
            }
            visited[0] = false;
            res = values[0];
            dfs(values, 0, 0, 0, maxTime);
            return res;
        }

        private void dfs(int[] values, int index, int currentValue, int currentCost, int maxTime) {
            if (currentCost > maxTime) {
                return;
            }
            if (index == 0) {
                res = Math.max(res, currentValue);
            }
            for (int[] reachInfo : reachTable[index]) {
                int nextP = reachInfo[0];
                int nextCost = reachInfo[1];
                if (!visited[nextP]) {
                    visited[nextP] = true;
                    dfs(values, nextP, currentValue + values[nextP], currentCost + nextCost, maxTime);
                    visited[nextP] = false;
                } else {
                    dfs(values, nextP, currentValue, currentCost + nextCost, maxTime);
                }
            }
        }
    }

}
