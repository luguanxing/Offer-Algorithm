package leetcode.problems;

import java.util.*;

public class Test3607_电网维护 {

    public static void main(String[] args) {
        // c = 5, connections = [[1,2],[2,3],[3,4],[4,5]], queries = [[1,3],[2,1],[1,1],[2,2],[1,2]]
        System.out.println(Arrays.toString(new Solution().processQueries(
                5,
                new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}},
                new int[][]{{1, 3}, {2, 1}, {1, 1}, {2, 2}, {1, 2}}))
        );
        // c = 3, connections = [], queries = [[1,1],[2,1],[1,1]]
        System.out.println(Arrays.toString(new Solution().processQueries(
                3,
                new int[][]{},
                new int[][]{{1, 1}, {2, 1}, {1, 1}}))
        );
    }

    static class Solution {
        public int[] processQueries(int c, int[][] connections, int[][] queries) {
            // 构建可达对映射
            Map<Integer, List<Integer>> neighbors = new HashMap<>();
            for (int[] conn : connections) {
                neighbors.putIfAbsent(conn[0], new ArrayList<>());
                neighbors.putIfAbsent(conn[1], new ArrayList<>());
                neighbors.get(conn[0]).add(conn[1]);
                neighbors.get(conn[1]).add(conn[0]);
            }
            // bfs建立联通块，同时更新对应块和块信息
            Map<Integer, TreeSet<Integer>> blockInfoMap = new HashMap<>();
            Map<Integer, Integer> stationBlockMap = new HashMap<>();
            boolean[] visited = new boolean[c + 1];
            for (int i = 1; i <= c; i++) {
                if (!visited[i]) {
                    bfs(i, i, neighbors, visited, blockInfoMap, stationBlockMap);
                }
            }
            // 处理查询和更新
            List<Integer> resList = new ArrayList<>();
            for (int i = 0; i < queries.length; i++) {
                int[] query = queries[i];
                int type = query[0];
                int stationId = query[1];
                int blockId = stationBlockMap.get(stationId);
                TreeSet<Integer> block = blockInfoMap.get(blockId);
                if (type == 1) {
                    if (block.contains(stationId)) {
                        // 先看自己是否还在线
                        resList.add(stationId);
                    } else if (!block.isEmpty()) {
                        // 再看联通块中的最小值
                        resList.add(block.first());
                    } else {
                        // 都没有则返回-1
                        resList.add(-1);
                    }
                } else if (type == 2) {
                    // 从联通块中移除
                    block.remove(stationId);
                }
            }
            int[] res = new int[resList.size()];
            for (int i = 0; i < resList.size(); i++) {
                res[i] = resList.get(i);
            }
            return res;
        }

        private void bfs(int root, int current, Map<Integer, List<Integer>> neighbors, boolean[] visited, Map<Integer, TreeSet<Integer>> blockInfoMap, Map<Integer, Integer> stationBlockMap) {
            if (visited[current]) {
                return;
            }
            visited[current] = true;
            blockInfoMap.putIfAbsent(root, new TreeSet<>());
            blockInfoMap.get(root).add(current);
            stationBlockMap.put(current, root);
            for (int neighbor : neighbors.getOrDefault(current, new ArrayList<>())) {
                bfs(root, neighbor, neighbors, visited, blockInfoMap, stationBlockMap);
            }
        }
    }

}
