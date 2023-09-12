package leetcode.problems;

import java.util.*;

public class Test1462_课程表IV {

    public static void main(String[] args) {
        System.out.println(new Solution().checkIfPrerequisite(
                3, new int[][]{}, new int[][]{{1, 0}, {0, 1}}
        ));
        System.out.println(new Solution().checkIfPrerequisite(
                3, new int[][]{{1, 2}, {1, 0}, {2, 0}}, new int[][]{{1, 0}, {1, 2}}
        ));
    }

    static class Solution {
        public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
            Map<Integer, List<Integer>> reachMap = new HashMap<>();
            for (int[] prerequisite : prerequisites) {
                int from = prerequisite[0];
                int to = prerequisite[1];
                List<Integer> list = reachMap.getOrDefault(from, new ArrayList<>());
                list.add(to);
                reachMap.put(from, list);
            }
            List<Boolean> list = new ArrayList<>();
            for (int[] query : queries) {
                list.add(isPrerequisite(reachMap, query[0], query[1]));
            }
            return list;
        }

        private Boolean isPrerequisite(Map<Integer, List<Integer>> reachMap, int from, int to) {
            Deque<Integer> queue = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();
            queue.add(from);
            visited.add(from);
            while (!queue.isEmpty()) {
                int current = queue.poll();
                if (current == to) {
                    return true;
                }
                for (int next : reachMap.getOrDefault(current, new ArrayList<>())) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
            return false;
        }
    }

}
