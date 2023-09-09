package leetcode.problems;

import java.util.*;

public class Test0207_课程表 {

    public static void main(String[] args) {
        System.out.println(new Solution2().canFinish(2, new int[][]{}));
        System.out.println(new Solution2().canFinish(2, new int[][]{{0, 1}}));
        System.out.println(new Solution2().canFinish(2, new int[][]{{1, 0}}));
        System.out.println(new Solution2().canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(new Solution2().canFinish(3, new int[][]{{1, 0}, {1, 2}, {0, 1}}));
        System.out.println(new Solution2().canFinish(4, new int[][]{{0, 1}, {0, 2}, {1, 3}, {3, 0}}));
        System.out.println(new Solution2().canFinish(3, new int[][]{{0, 2}, {1, 2}, {2, 0}}));
        System.out.println(new Solution2().canFinish(5, new int[][]{{3, 1}, {3, 2}, {1, 4}, {2, 4}}));
        System.out.println(new Solution2().canFinish(8, new int[][]{{1, 0}, {1, 7}, {7, 0}, {0, 5}, {2, 6}, {6, 4}}));
    }

    static class Solution2 {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            Map<Integer, List<Integer>> reachMap = new HashMap<>();
            // 拓补排序，统计入度
            int[] inDegree = new int[numCourses];
            for (int[] prerequisite : prerequisites) {
                int from = prerequisite[0];
                int to = prerequisite[1];
                List<Integer> list = reachMap.getOrDefault(from, new ArrayList<>());
                list.add(to);
                reachMap.put(from, list);
                inDegree[to]++;
            }
            // 从入度为0的点开始BFS
            Deque<Integer> deque = new ArrayDeque<>();
            for (int i = 0; i < numCourses; i++) {
                if (inDegree[i] == 0) {
                    deque.add(i);
                }
            }
            while (!deque.isEmpty()) {
                int current = deque.poll();
                for (int next : reachMap.getOrDefault(current, new ArrayList<>())) {
                    if (inDegree[next] > 0) {
                        inDegree[next]--;
                        if (inDegree[next] == 0) {
                            deque.add(next);
                        }
                    }
                }
            }
            return Arrays.stream(inDegree).sum() == 0;
        }
    }

    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // 标识每个点的入度，数值越大意味着门槛越高
            Map<Integer, Set<Integer>> reachableMap = new HashMap<>();
            int[] indegree = new int[numCourses];
            for (int[] prerequisit : prerequisites) {
                int to = prerequisit[0];
                int from = prerequisit[1];
                indegree[to]++;
                Set<Integer> set = reachableMap.getOrDefault(from, new HashSet<>());
                set.add(to);
                reachableMap.put(from, set);
            }
            // 从入度为0的点开始BFS，每轮遍历到的节点入度减1，直到所有点入度为0
            Set<Integer> finished = new HashSet<>();
            while (finished.size() < numCourses) {
                boolean noMore = true;
                for (int start = 0; start < indegree.length; start++) {
                    if (indegree[start] == 0 && !finished.contains(start)) {
                        noMore = false;
                        finished.add(start);
                        if (reachableMap.containsKey(start)) {
                            for (int next : reachableMap.get(start)) {
                                indegree[next]--;
                            }
                        }
                    }
                }
                if (noMore) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Solution_DFS {
        boolean hasLoop = false;
        Set<Integer> visited = new HashSet<>();
        Map<Integer, Set<Integer>> reachableMap = new HashMap<>();

        public boolean canFinish(int numCourses, int[][] prerequisites) {
            // 标识每个点可达的点，顺带统计入度
            int[] indegree = new int[numCourses];
            for (int[] prerequisit : prerequisites) {
                int to = prerequisit[0];
                int from = prerequisit[1];
                if (reachableMap.containsKey(from)) {
                    reachableMap.get(from).add(to);
                } else {
                    Set<Integer> set = new HashSet<>();
                    set.add(to);
                    reachableMap.put(from, set);
                }
                indegree[to]++;
            }
            // 寻找入度为0的点，使用DFS记录可达点和判断路径是否重复
            for (int start = 0; start < numCourses; start++) {
                if (indegree[start] == 0) {
                    dfsCheck(start, new HashSet<>());
                }
            }
            return visited.size() == numCourses && !hasLoop;
        }

        private void dfsCheck(int start, Set<Integer> currentNodes) {
            if (hasLoop) {
                return;
            }
            visited.add(start);
            if (reachableMap.containsKey(start)) {
                for (int next : reachableMap.get(start)) {
                    if (currentNodes.contains(next)) {
                        // 已经包含循环
                        hasLoop = true;
                        return;
                    }
                    currentNodes.add(next);
                    dfsCheck(next, currentNodes);
                    currentNodes.remove(next);
                }
            }
        }
    }

}
