package leetcode.contest.week268;

public class Test5201_给植物浇水 {

    public static void main(String[] args) {
        System.out.println(new Solution().wateringPlants(new int[]{2, 2, 3, 3}, 5));
        System.out.println(new Solution().wateringPlants(new int[]{1, 1, 1, 4, 2, 3}, 4));
        System.out.println(new Solution().wateringPlants(new int[]{7, 7, 7, 7, 7, 7, 7}, 8));
    }

    static class Solution {
        public int wateringPlants(int[] plants, int capacity) {
            int res = 0;
            int left = capacity;
            for (int i = 0; i < plants.length; i++) {
                if (left >= plants[i]) {
                    res++;
                } else {
                    left = capacity;
                    res += i + i + 1;
                }
                left -= plants[i];
            }
            return res;
        }
    }

}
