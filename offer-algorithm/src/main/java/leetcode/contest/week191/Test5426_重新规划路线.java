package leetcode.contest.week191;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test5426_重新规划路线 {

    public static void main(String[] args) {
        System.out.println(new Solution().minReorder(
                6,
                new int[][]{
                        new int[]{0, 1},
                        new int[]{1, 3},
                        new int[]{2, 3},
                        new int[]{4, 0},
                        new int[]{4, 5},
                }
        ));
        System.out.println(new Solution().minReorder(
                5,
                new int[][]{
                        new int[]{1, 0},
                        new int[]{1, 2},
                        new int[]{3, 2},
                        new int[]{3, 4},
                }
        ));
        System.out.println(new Solution().minReorder(
                3,
                new int[][]{
                        new int[]{1, 0},
                        new int[]{2, 0},
                }
        ));
    }

    static class Solution {
        public int minReorder(int n, int[][] connections) {
            // 标识某个节点是否可达0
            Set<Integer> canReach0 = new HashSet<>();
            canReach0.add(0);
            int cnt = 0;
            // 循环直到所有点都可达0
            while (canReach0.size() < n) {
                for (int[] connection : connections) {
                    int from = connection[0];
                    int to = connection[1];
                    if (canReach0.contains(from)) {
                        // 差一步就能到0
                        canReach0.add(to);
                        cnt++;
                    } else if (canReach0.contains(to)) {
                        // 能直接到0
                        canReach0.add(from);
                    }
                }
            }
            return cnt;
        }
    }

}
