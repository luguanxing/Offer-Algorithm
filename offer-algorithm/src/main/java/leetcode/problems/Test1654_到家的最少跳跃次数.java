package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test1654_到家的最少跳跃次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumJumps(
                new int[]{14, 4, 18, 1, 15}, 3, 15, 9
        ));
        System.out.println(new Solution().minimumJumps(
                new int[]{8, 3, 16, 6, 12, 20}, 15, 13, 11
        ));
        System.out.println(new Solution().minimumJumps(
                new int[]{1, 6, 2, 14, 5, 17, 4}, 16, 9, 7
        ));
        System.out.println(new Solution().minimumJumps(
                new int[]{162, 118, 178, 152, 167, 100, 40, 74, 199, 186, 26, 73, 200, 127, 30, 124, 193, 84, 184, 36, 103, 149, 153, 9, 54, 154, 133, 95, 45, 198, 79, 157, 64, 122, 59, 71, 48, 177, 82, 35, 14, 176, 16, 108, 111, 6, 168, 31, 134, 164, 136, 72, 98},
                29, 98, 80
        ));
        System.out.println(new Solution().minimumJumps(
                new int[]{1998},
                1999, 2000, 2000
        ));
    }

    static class Solution {
        public int minimumJumps(int[] forbidden, int a, int b, int x) {
            int MAX_BOUNDARY = (x + a + b) * 2;
            int MIN_BOUNDARY = 0;
            Set<Integer> forbiddenSet = Arrays.stream(forbidden).boxed().collect(Collectors.toSet());
            Set<Integer> visited = new HashSet<>();
            Set<Integer> back = new HashSet<>();
            // BFS尝试
            int step = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(0);
            visited.add(0);
            while (!queue.isEmpty()) {
                List<Integer> currentPositions = new ArrayList<>(queue);
                queue.clear();
                Set<Integer> newBack = new HashSet<>();
                for (int currentPosition : currentPositions) {
                    if (currentPosition == x) {
                        return step;
                    }
                    if (!back.contains(currentPosition) && currentPosition - b >= MIN_BOUNDARY && !forbiddenSet.contains(currentPosition - b) && !visited.contains(currentPosition - b)) {
                        queue.add(currentPosition - b);
                        visited.add(currentPosition - b);
                        newBack.add(currentPosition - b);
                    }
                    if (currentPosition + a <= MAX_BOUNDARY && !forbiddenSet.contains(currentPosition + a) && !visited.contains(currentPosition + a)) {
                        queue.add(currentPosition + a);
                        visited.add(currentPosition + a);
                        // 往前移动也能到达某点就可去掉限制
                        newBack.remove(currentPosition + a);
                    }
                }
                back = newBack;
                step++;
            }
            return -1;
        }
    }

}
