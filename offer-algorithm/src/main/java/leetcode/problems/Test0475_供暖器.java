package leetcode.problems;

import java.util.Arrays;

public class Test0475_供暖器 {

    public static void main(String[] args) {
        System.out.println(new Solution().findRadius(
                new int[]{1, 2, 3},
                new int[]{2}
        ));
        System.out.println(new Solution().findRadius(
                new int[]{1, 2, 3, 4},
                new int[]{1, 4}
        ));
        System.out.println(new Solution().findRadius(
                new int[]{1, 5},
                new int[]{2}
        ));
    }

    static class Solution {
        public int findRadius(int[] houses, int[] heaters) {
            Arrays.sort(houses);
            Arrays.sort(heaters);
            int minRadius = 0;
            int maxRadius = Math.max(
                    Math.abs(houses[0] - heaters[heaters.length - 1]),
                    Math.abs(houses[houses.length - 1] - heaters[0])
            );
            return binarySearchRadius(houses, heaters, minRadius, maxRadius);
        }

        private int binarySearchRadius(int[] houses, int[] heaters, int minRadius, int maxRadius) {
            int left = minRadius;
            int right = maxRadius + 1;
            // 二分找左边界
            while (left < right) {
                int mid = (left + right) / 2;
                if (isOk(mid, houses, heaters)) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            return left;
        }

        private boolean isOk(int radius, int[] houses, int[] heaters) {
            int index = 0;
            int cnt = 0;
            for (int i = 0; i < houses.length; ) {
                int house = houses[i];
                if (heaters[index] - radius <= house && house <= heaters[index] + radius) {
                    cnt++;
                    i++;
                } else {
                    index++;
                    if (index == heaters.length) {
                        break;
                    }
                }
            }
            return cnt == houses.length;
        }
    }

}
