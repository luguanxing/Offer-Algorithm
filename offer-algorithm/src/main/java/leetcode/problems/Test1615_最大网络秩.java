package leetcode.problems;

import java.util.*;

public class Test1615_最大网络秩 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximalNetworkRank(4, new int[][]{
                {0, 1}, {0, 3}, {1, 2}, {1, 3}
        }));
        System.out.println(new Solution().maximalNetworkRank(5, new int[][]{
                {0, 1}, {0, 3}, {1, 2}, {1, 3}, {2, 3}, {2, 4}
        }));
        System.out.println(new Solution().maximalNetworkRank(8, new int[][]{
                {0, 1}, {1, 2}, {2, 3}, {2, 4}, {5, 6}, {5, 7}
        }));

    }

    static class Solution {
        public int maximalNetworkRank(int n, int[][] roads) {
            Set<String> reachable = new HashSet<>();
            int[] degree = new int[n];
            for (int[] road : roads) {
                Arrays.sort(road);
                int from = road[0];
                int to = road[1];
                degree[from]++;
                degree[to]++;
                reachable.add(from + "-" + to);
                reachable.add(to + "-" + from);
            }
            int res = 0;
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    int cnt = degree[i] + degree[j];
                    if (reachable.contains(i + "-" + j)) {
                        cnt -= 1;
                    }
                    res = Math.max(res, cnt);
                }
            }
            return res;
        }
    }

}
