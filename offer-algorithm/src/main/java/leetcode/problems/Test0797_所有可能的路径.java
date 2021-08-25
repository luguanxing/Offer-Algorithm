package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test0797_所有可能的路径 {

    public static void main(String[] args) {
        System.out.println(new Solution().allPathsSourceTarget(new int[][]{{1, 2}, {3}, {3}, {}}));
        System.out.println(new Solution().allPathsSourceTarget(new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}}));
        System.out.println(new Solution().allPathsSourceTarget(new int[][]{{1}, {}}));
        System.out.println(new Solution().allPathsSourceTarget(new int[][]{{1, 2, 3}, {2}, {3}, {}}));
        System.out.println(new Solution().allPathsSourceTarget(new int[][]{{1, 3}, {2}, {3}, {}}));
    }

    static class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
            dfs(graph, 0, new ArrayList<>());
            return res;
        }

        private void dfs(int[][] graph, int currentPos, List<Integer> currentPath) {
            currentPath.add(currentPos);
            if (currentPos == graph.length - 1) {
                res.add(new ArrayList<>(currentPath));
                return;
            }
            List<Integer> nexts = Arrays.stream(graph[currentPos]).boxed().collect(Collectors.toList());
            for (int next : nexts) {
                dfs(graph, next, currentPath);
                currentPath.remove(currentPath.size() - 1);
            }
        }
    }

}
