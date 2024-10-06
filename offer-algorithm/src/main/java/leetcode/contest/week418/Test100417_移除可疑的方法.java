package leetcode.contest.week418;

import java.util.*;

public class Test100417_移除可疑的方法 {

    public static void main(String[] args) {
        //  n = 4, k = 1, invocations = [[1,2],[0,1],[3,2]]
        System.out.println(new Solution().remainingMethods(4, 1, new int[][]{{1, 2}, {0, 1}, {3, 2}}));
        // n = 5, k = 0, invocations = [[1,2],[0,2],[0,1],[3,4]]
        System.out.println(new Solution().remainingMethods(5, 0, new int[][]{{1, 2}, {0, 2}, {0, 1}, {3, 4}}));
        // n = 3, k = 2, invocations = [[1,2],[0,1],[2,0]]
        System.out.println(new Solution().remainingMethods(3, 2, new int[][]{{1, 2}, {0, 1}, {2, 0}}));
    }

    static class Solution {
        public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
            // 邻接表
            Map<Integer, List<Integer>> map = new HashMap<>();
            for (int[] invocation : invocations) {
                int from = invocation[0];
                int to = invocation[1];
                map.computeIfAbsent(from, x -> new ArrayList<>()).add(to);
            }
            // 找k出发所有可疑方法
            Set<Integer> suspicious = new HashSet<>();
            dfs(k, map, suspicious);
            // 检查是否有外部方法调用了可疑方法
            boolean canRemove = true;
            for (int[] invocation : invocations) {
                int from = invocation[0];
                int to = invocation[1];
                if (suspicious.contains(to) && !suspicious.contains(from)) {
                    // 存在外部方法调用可疑方法，不能移除
                    canRemove = false;
                    break;
                }
            }
            List<Integer> result = new ArrayList<>();
            if (canRemove) {
                // 移除可疑方法，返回剩余方法
                for (int i = 0; i < n; i++) {
                    if (!suspicious.contains(i)) {
                        result.add(i);
                    }
                }
            } else {
                // 无法移除，返回所有方法
                for (int i = 0; i < n; i++) {
                    result.add(i);
                }
            }
            return result;
        }

        private void dfs(int node, Map<Integer, List<Integer>> graph, Set<Integer> visited) {
            if (visited.contains(node)) {
                // 避免重复访问
                return;
            }
            visited.add(node);
            if (graph.containsKey(node)) {
                for (int neighbor : graph.get(node)) {
                    dfs(neighbor, graph, visited);
                }
            }
        }
    }


}
