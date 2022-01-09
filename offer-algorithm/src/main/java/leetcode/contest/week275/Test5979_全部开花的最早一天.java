package leetcode.contest.week275;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test5979_全部开花的最早一天 {

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
        System.out.println(new Solution().earliestFullBloom(
                new int[]{27, 5, 24, 17, 27, 4, 23, 16, 6, 26, 13, 17, 21, 3, 9, 10, 28, 26, 4, 10, 28, 2},
                new int[]{26, 9, 14, 17, 6, 14, 23, 24, 11, 6, 27, 14, 13, 1, 15, 5, 12, 15, 23, 27, 28, 12}
        ));
        System.out.println(new Solution().earliestFullBloom(
                new int[]{24, 28, 9, 1, 9, 27, 10, 10, 1, 4, 29, 29},
                new int[]{15, 15, 21, 19, 22, 27, 3, 18, 19, 16, 15, 22}
        ));
    }

    static class Solution {
        public int earliestFullBloom(int[] plantTime, int[] growTime) {
            List<Flower> flowers = new ArrayList<>();
            for (int i = 0; i < plantTime.length; i++) {
                flowers.add(new Flower(plantTime[i], growTime[i]));
            }
            Collections.sort(flowers, (o1, o2) -> Integer.compare(o2.grow, o1.grow));
            int max = 0;
            int days = 0;
            for (Flower flower : flowers) {
                days += flower.plant;
                max = Math.max(max, Math.max(days, days + flower.grow));
            }
            return max;
        }

        class Flower {
            int plant;
            int grow;

            public Flower(int plant, int grow) {
                this.plant = plant;
                this.grow = grow;
            }
        }
    }

}
