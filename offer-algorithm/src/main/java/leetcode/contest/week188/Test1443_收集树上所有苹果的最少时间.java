package leetcode.contest.week188;

import java.util.*;

public class Test1443_收集树上所有苹果的最少时间 {

    public static void main(String[] args) {
        System.out.println(new Solution().minTime(
                7,
                new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                Arrays.asList(false, false, true, false, true, true, false)
        ));
    }

    static class Solution {
        private int sum = 0;
        private Map<Integer, List<Integer>> nextNodesMap = new HashMap<>();

        public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
            // 预先保存每个节点的可达节点
            for (int[] edge : edges) {
                int from = edge[0];
                int to = edge[1];
                if (!nextNodesMap.containsKey(from)) {
                    nextNodesMap.put(from, new ArrayList<>());
                }
                nextNodesMap.get(from).add(to);
            }
            // DFS+回溯遍历所有节点，遍历过程中把所有含苹果的路程加起来
            checkHasApple(0, hasApple);
            return sum;
        }

        private boolean checkHasApple(int currentNode, List<Boolean> hasApple) {
            // 判断当前节点是否包含苹果
            Boolean pathHasApple = hasApple.get(currentNode);
            // DFS该节点的分支
            List<Integer> nextNodes = nextNodesMap.get(currentNode);
            if (nextNodes != null) {
                for (Integer nextNode : nextNodes) {
                    sum++;
                    boolean branchHasApple = checkHasApple(nextNode, hasApple);
                    if (!branchHasApple) {
                        // 回溯时若子分支没有苹果则正常回溯计数
                        sum--;
                    } else {
                        // 回溯时若子分支有苹否则保留计数，并且加上返回路程
                        sum++;
                    }
                    // 子分支有苹果，即该路径分支有苹果
                    pathHasApple = pathHasApple || branchHasApple;
                }
            }
            return pathHasApple;
        }
    }

}
