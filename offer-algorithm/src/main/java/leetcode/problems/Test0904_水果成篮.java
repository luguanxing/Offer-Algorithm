package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test0904_水果成篮 {

    public static void main(String[] args) {
        System.out.println(new Solution().totalFruit(new int[]{1, 2, 1}));
        System.out.println(new Solution().totalFruit(new int[]{0, 1, 2, 2}));
        System.out.println(new Solution().totalFruit(new int[]{1, 2, 3, 2, 2}));
        System.out.println(new Solution().totalFruit(new int[]{0}));
        System.out.println(new Solution().totalFruit(new int[]{1, 1}));
    }

    static class Solution {
        public int totalFruit(int[] fruits) {
            int FURUIT_TYPE = 2;
            int max = 1;
            int lastIndex = 0;
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < fruits.length; i++) {
                int currentFruit = fruits[i];
                map.put(currentFruit, map.getOrDefault(currentFruit, 0) + 1);
                while (map.size() > FURUIT_TYPE) {
                    int lastFruist = fruits[lastIndex++];
                    map.put(lastFruist, map.getOrDefault(lastFruist, 0) - 1);
                    if (map.get(lastFruist) == 0) {
                        map.remove(lastFruist);
                    }
                }
                max = Math.max(max, i - lastIndex + 1);
            }
            return max;
        }
    }

}
