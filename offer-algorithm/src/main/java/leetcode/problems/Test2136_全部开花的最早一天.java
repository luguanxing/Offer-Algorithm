package leetcode.problems;

import java.util.Arrays;

public class Test2136_全部开花的最早一天 {

    public static void main(String[] args) {
        System.out.println(new Solution().earliestFullBloom(
                new int[]{1, 4, 3},
                new int[]{2, 3, 1}
        ));
        System.out.println(new Solution().earliestFullBloom(
                new int[]{1, 2, 3, 2},
                new int[]{2, 1, 2, 1}
        ));
        System.out.println(new Solution().earliestFullBloom(
                new int[]{1},
                new int[]{1}
        ));
    }

    static class Solution {
        public int earliestFullBloom(int[] plantTime, int[] growTime) {
            int len = plantTime.length;
            // 优先种生长时间长的，其次是种植时间少的
            int[][] plants = new int[len][2];
            for (int i = 0; i < len; i++) {
                plants[i] = new int[]{plantTime[i], growTime[i]};
            }
            Arrays.sort(plants, (p1, p2) -> {
                if (p1[1] != p2[1]) {
                    return Integer.compare(p2[1], p1[1]);
                } else {
                    return Integer.compare(p1[0], p2[0]);
                }
            });
            int time = 0;
            int max = 0;
            for (int[] plant : plants) {
                time += plant[0];
                max = Math.max(max, time + plant[1]);
            }
            return max;
        }
    }

}
