package leetcode.problems;

import java.util.*;

public class Test0886_可能的二分法 {

    public static void main(String[] args) {
        System.out.println(new Solution().possibleBipartition(4, new int[][]{{1, 2}, {1, 3}, {2, 4}}));
        System.out.println(new Solution().possibleBipartition(3, new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        System.out.println(new Solution().possibleBipartition(5, new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}, {1, 5}}));
        System.out.println(new Solution().possibleBipartition(10, new int[][]{{1, 2}, {3, 4}, {5, 6}, {6, 7}, {8, 9}, {7, 8}}));
    }

    static class Solution {
        List<Integer>[] dislikeMap;
        int[] colors;

        public boolean possibleBipartition(int n, int[][] dislikes) {
            // 初始化map和颜色数组，color=0,1,2
            dislikeMap = new List[n + 1];
            colors = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dislikeMap[i] = new ArrayList<>();
            }
            for (int[] dislike : dislikes) {
                int a = dislike[0];
                int b = dislike[1];
                dislikeMap[a].add(b);
                dislikeMap[b].add(a);
            }
            // 使用染色法进行dfs
            for (int i = 1; i <= n; i++) {
                // 如果还未染色（之前无上游），就尝试进行染色，这时会把所有相关的下游节点全部染上色
                if (colors[i] == 0) {
                    // 如果染色出现冲突则失败
                    if (!dye(i, 1)) {
                        return false;
                    }
                }
            }
            return true;
        }

        private boolean dye(int i, int color) {
            colors[i] = color;
            for (int j : dislikeMap[i]) {
                if (colors[j] == color) {
                    return false;
                }
                if (colors[j] == 0 && !dye(j, 3 - color)) {
                    return false;
                }
            }
            return true;
        }
    }

    static class Solution_暴力 {
        boolean isOk = false;

        public boolean possibleBipartition(int n, int[][] dislikes) {
            Set<Integer> group1 = new HashSet<>();
            Set<Integer> group2 = new HashSet<>();
            dfs(group1, group2, dislikes, 0);
            return isOk;
        }

        private void dfs(Set<Integer> group1, Set<Integer> group2, int[][] dislikes, int i) {
            if (isOk || i == dislikes.length) {
                isOk = true;
                return;
            }
            int a = dislikes[i][0];
            int b = dislikes[i][1];
            if (!group1.contains(a) && !group2.contains(a)) {
                if (group1.contains(b)) {
                    group2.add(a);
                    dfs(group1, group2, dislikes, i + 1);
                    group2.remove(a);
                } else {
                    group1.add(a);
                    group2.add(b);
                    dfs(group1, group2, dislikes, i + 1);
                    group1.remove(a);
                    group2.remove(b);
                    group1.add(b);
                    group2.add(a);
                    dfs(group1, group2, dislikes, i + 1);
                    group1.remove(b);
                    group2.remove(a);
                }
            } else if (group1.contains(a) && !group2.contains(a)) {
                if (group1.contains(b)) {
                    return;
                }
                group2.add(b);
                dfs(group1, group2, dislikes, i + 1);
                group2.remove(b);
            } else if (!group1.contains(a) && group2.contains(a)) {
                if (group2.contains(b)) {
                    return;
                }
                group1.add(b);
                dfs(group1, group2, dislikes, i + 1);
                group1.remove(b);
            }
        }
    }

}
