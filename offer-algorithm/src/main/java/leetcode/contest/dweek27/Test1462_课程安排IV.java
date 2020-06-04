package leetcode.contest.dweek27;

import java.util.*;

public class Test1462_课程安排IV {

    public static void main(String[] args) {
        System.out.println(new Solution().checkIfPrerequisite(2, new int[][]{{1, 0}}, new int[][]{{0, 1}, {1, 0}}));
        System.out.println(new Solution().checkIfPrerequisite(2, new int[][]{}, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(new Solution().checkIfPrerequisite(3, new int[][]{{1, 2}, {1, 0}, {2, 0}}, new int[][]{{1, 0}, {1, 2}}));
        System.out.println(new Solution().checkIfPrerequisite(3, new int[][]{{1, 0}, {2, 0}}, new int[][]{{0, 1}, {2, 0}}));
        System.out.println(new Solution().checkIfPrerequisite(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, new int[][]{{0, 4}, {4, 0}, {1, 3}, {3, 0}}));
    }

    static class Solution {
        public List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
            // 拉链法表示可达节点
            List<Set<Integer>> reachableList = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                reachableList.add(new HashSet<>());
            }
            // 把所有数放入拉链
            for (int[] prerequisite : prerequisites) {
                int from = prerequisite[0];
                int to = prerequisite[1];
                reachableList.get(from).add(to);
            }
            // BFS遍历所有节点
            for (Set<Integer> reachable : reachableList) {
                Queue<Integer> queue = new LinkedList<>(reachable);
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    Set<Integer> polls = reachableList.get(poll);
                    for (int num : polls) {
                        if (!reachable.contains(num)) {
                            reachable.add(num);
                            reachable.addAll(reachableList.get(num));
                            queue.add(num);
                            queue.addAll(reachableList.get(num));
                        }
                    }
                }
            }
            // 返回结果
            List<Boolean> result = new ArrayList<>();
            for (int[] query : queries) {
                int from = query[0];
                int to = query[1];
                if (reachableList.get(from).contains(to)) {
                    result.add(true);
                } else {
                    result.add(false);
                }
            }
            return result;
        }
    }

}
