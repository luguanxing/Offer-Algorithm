package leetcode.contest.week197;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class Test5211_概率最大的路径 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProbability(
                3,
                new int[][]{{0, 1}, {1, 2}, {0, 2}},
                new double[]{0.5, 0.5, 0.2},
                0,
                2
        ));
        System.out.println(new Solution().maxProbability(
                3,
                new int[][]{{0, 1}, {1, 2}, {0, 2}},
                new double[]{0.5, 0.5, 0.3},
                0,
                2
        ));
        System.out.println(new Solution().maxProbability(
                3,
                new int[][]{{0, 1}},
                new double[]{0.5},
                0,
                2
        ));
        System.out.println(new Solution().maxProbability(
                5,
                new int[][]{{1, 4}, {2, 4}, {0, 4}, {0, 3}, {0, 2}, {2, 3}},
                new double[]{0.37, 0.17, 0.93, 0.23, 0.39, 0.04},
                3,
                4
        ));
    }

    static class Solution {
        public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
            // 提前记录路径概率
            double[][] probMatrix = new double[n][n];
            Map<Integer, List<Integer>> map = new HashMap<>();
            int index = 0;
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                double prob = succProb[index++];
                probMatrix[from][to] = prob;
                probMatrix[to][from] = prob;
                if (!map.containsKey(from)) {
                    map.put(from, new ArrayList<>());
                }
                if (!map.containsKey(to)) {
                    map.put(to, new ArrayList<>());
                }
                map.get(from).add(to);
                map.get(to).add(from);
            }
            // BFS逐个添加路径
            Map<String, Double> currentPaths = new ConcurrentHashMap<>();
            for (int i = 0; i < n; i++) {
                if (probMatrix[start][i] != 0) {
                    currentPaths.put(start + "," + i + ",", probMatrix[start][i]);
                }
            }
            // 最多遍历N遍
            double max = 0;
            while (true) {
                boolean noMore = true;
                for (String currentPath : currentPaths.keySet()) {
                    if (currentPath.endsWith(end + ",")) {
                        max = Math.max(max, currentPaths.get(currentPath));
                        currentPaths.remove(currentPath);
                        continue;
                    }
                    Double currentProb = currentPaths.get(currentPath);
                    if (currentProb < max) {
                        currentPaths.remove(currentPath);
                        continue;
                    }
                    String[] nodes = currentPath.split(",");
                    Set<String> set = Arrays.stream(nodes).collect(Collectors.toSet());
                    int lastNode = Integer.parseInt(nodes[nodes.length - 1]);
                    for (int j : map.get(lastNode)) {
                        if (probMatrix[lastNode][j] != 0 && !set.contains(j + "")) {
                            String newPath = currentPath + j + ",";
                            double newProb = currentProb * probMatrix[lastNode][j];
                            currentPaths.put(newPath, newProb);
                        }
                    }
                    currentPaths.remove(currentPath);
                    noMore = false;
                }
                if (noMore) {
                    break;
                }
            }
            return max;
        }
    }

}
