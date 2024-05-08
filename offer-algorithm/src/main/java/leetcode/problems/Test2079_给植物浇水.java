package leetcode.problems;

public class Test2079_给植物浇水 {

    public static void main(String[] args) {
        // plants = [2,2,3,3], capacity = 5
        System.out.println(new Solution().wateringPlants(new int[]{2, 2, 3, 3}, 5));
        // plants = [1,1,1,4,2,3], capacity = 4
        System.out.println(new Solution().wateringPlants(new int[]{1, 1, 1, 4, 2, 3}, 4));
        // plants = [7,7,7,7,7,7,7], capacity = 8
        System.out.println(new Solution().wateringPlants(new int[]{7, 7, 7, 7, 7, 7, 7}, 8));
    }

    static class Solution {
        public int wateringPlants(int[] plants, int capacity) {
            int len = plants.length;
            int sum = 0;
            int current = capacity;
            for (int i = 0; i < len; i++) {
                if (current >= plants[i]) {
                    sum++;
                } else {
                    current = capacity;
                    sum += 2 * i + 1;
                }
                current -= plants[i];
            }
            return sum;
        }
    }

}
