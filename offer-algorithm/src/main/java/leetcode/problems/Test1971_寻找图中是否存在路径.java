package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test1971_寻找图中是否存在路径 {

    public static void main(String[] args) {
        System.out.println(new Solution_并查集().validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        System.out.println(new Solution_并查集().validPath(6, new int[][]{{0, 1}, {0, 2}, {3, 5}, {5, 4}, {4, 3}}, 0, 5));
    }

    static class Solution_并查集 {
        int[] group;

        public boolean validPath(int n, int[][] edges, int source, int destination) {
            group = new int[n];
            for (int i = 0; i < n; i++) {
                group[i] = i;
            }
            for (int[] edge : edges) {
                group[root(edge[0])] = group[root(edge[1])];
            }
            return root(source) == root(destination);
        }

        private int root(int x) {
            if (x == group[x]) {
                return x;
            }
            x = root(group[x]);
            return x;
        }
    }


    static class Solution {
        boolean isOk;
        boolean[] isVisited;
        List<Integer>[] reachMap;

        public boolean validPath(int n, int[][] edges, int source, int destination) {
            isVisited = new boolean[n];
            reachMap = new List[n];
            for (int i = 0; i < n; i++) {
                reachMap[i] = new ArrayList<>();
            }
            for (int[] edge : edges) {
                reachMap[edge[0]].add(edge[1]);
                reachMap[edge[1]].add(edge[0]);
            }
            dfs(source, destination);
            return isOk;
        }

        private void dfs(int src, int dest) {
            if (isOk || isVisited[src]) {
                return;
            }
            if (src == dest) {
                isOk = true;
                return;
            }
            isVisited[src] = true;
            for (int next : reachMap[src]) {
                dfs(next, dest);
            }
        }
    }

}
