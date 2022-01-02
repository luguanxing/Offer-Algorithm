package leetcode.contest.week274;

import java.util.Arrays;

public class Test5969_摧毁小行星 {

    public static void main(String[] args) {
        System.out.println(new Solution().asteroidsDestroyed(
                10,
                new int[]{3, 9, 19, 5, 21}
        ));
        System.out.println(new Solution().asteroidsDestroyed(
                5,
                new int[]{4, 9, 23, 4}
        ));
    }

    static class Solution {
        public boolean asteroidsDestroyed(int mass, int[] asteroids) {
            Arrays.sort(asteroids);
            long current = mass;
            for (int asteroid : asteroids) {
                if (current >= asteroid) {
                    current += asteroid;
                } else {
                    return false;
                }
            }
            return true;
        }
    }

}
