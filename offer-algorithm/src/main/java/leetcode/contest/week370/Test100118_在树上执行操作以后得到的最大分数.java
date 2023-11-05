package leetcode.contest.week370;

import java.util.*;

public class Test100118_在树上执行操作以后得到的最大分数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumScoreAfterOperations(
                new int[][]{{0, 1}, {0, 2}, {0, 3}, {2, 4}, {4, 5}},
                new int[]{5, 2, 5, 2, 1, 1}
        ));
        System.out.println(new Solution().maximumScoreAfterOperations(
                new int[][]{{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {2, 6}},
                new int[]{20, 10, 9, 7, 4, 3, 5}
        ));
        System.out.println(new Solution().maximumScoreAfterOperations(
                new int[][]{{0, 1}, {0, 2}, {0, 3}},
                new int[]{1000000000, 1000000000, 1000000000, 1000000000}
        ));
        System.out.println(new Solution().maximumScoreAfterOperations(
                new int[][]{{7, 0}, {3, 1}, {6, 2}, {4, 3}, {4, 5}, {4, 6}, {4, 7}},
                new int[]{2, 16, 23, 17, 22, 21, 8, 6}
        ));
    }

    static class Solution {
        List<List<Integer>> adjList = new ArrayList<>();  // 邻接表表示树
        int[] values;  // 节点值
        boolean[] isVisited;    // 记录节点是否被访问过
        Map<String, Long> memo = new HashMap<>();  // 记忆化哈希表

        public long maximumScoreAfterOperations(int[][] edges, int[] values) {
            this.values = values;
            int n = values.length;
            for (int i = 0; i < n; i++) {
                adjList.add(new ArrayList<>());
            }
            for (int[] edge : edges) {
                adjList.get(edge[0]).add(edge[1]);
                adjList.get(edge[1]).add(edge[0]);
            }
            isVisited = new boolean[n];
            return dfs( 0, false);
        }

        // dfs 返回以节点 currentNode 为根的子树中可以获得的最大分数，
        // pathHasLeft 表示 node节点的父节点的值是否已经拿过
        public long dfs(int currentNode, boolean pathHasLeft) {
            String key = currentNode + "," + pathHasLeft;  // 定义状态
            if (memo.containsKey(key)) {
                return memo.get(key);  // 如果已经计算过，直接返回结果
            }
            // 叶子节点
            int nextCnt = 0;
            for (int next : adjList.get(currentNode)) {
                if (!isVisited[next]) {
                    nextCnt++;
                }
            }
            if (nextCnt == 0) {
                return (pathHasLeft ? values[currentNode] : 0);
            }
            isVisited[currentNode] = true;
            // 保留当前节点值的情况
            long saveThis = 0;
            for (int child : adjList.get(currentNode)) {
                if (!isVisited[child]) {
                    saveThis += dfs(child, true);
                }
            }
            // 拿走当前节点值的情况
            long takeThis = values[currentNode];
            for (int child : adjList.get(currentNode)) {
                if (!isVisited[child]) {
                    takeThis += dfs(child, pathHasLeft);
                }
            }
            isVisited[currentNode] = false;
            long result = Math.max(saveThis, takeThis);
            memo.put(key, result);  // 保存计算结果
            return result;
        }
    }


}
