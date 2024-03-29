package leetcode.problems;

import java.util.*;

public class Test1488_避免洪水泛滥 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{1, 2, 0, 0, 2, 1})));
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{1, 2, 0, 1, 2})));
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{69, 0, 0, 0, 69})));
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{0, 1, 1})));
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{1, 0, 2, 0, 2, 1})));
        System.out.println(Arrays.toString(new Solution().avoidFlood(new int[]{1, 0, 2, 3, 0, 1, 2})));
    }

    static class Solution {
        public int[] avoidFlood(int[] rains) {
            int len = rains.length;
            int[] ans = new int[len];
            Arrays.fill(ans, 1);
            Map<Integer, Integer> lastRain = new HashMap<>();
            TreeSet<Integer> freeIndexes = new TreeSet<>();
            for (int i = 0; i < len; i++) {
                int rain = rains[i];
                // 不下雨
                if (rain == 0) {
                    freeIndexes.add(i);
                    continue;
                }
                // 下雨
                if (lastRain.containsKey(rain)) {
                    if (freeIndexes.isEmpty()) {
                        // 没时间准备了
                        return new int[]{};
                    } else {
                        int lastIndex = lastRain.get(rain);
                        // 如果能找到lastIndex之后的准备时间就有救
                        Integer freeIndex = freeIndexes.higher(lastIndex);
                        if (freeIndex == null) {
                            return new int[]{};
                        }
                        ans[freeIndex] = rain;
                        freeIndexes.remove(freeIndex);
                    }
                }
                lastRain.put(rain, i);
                ans[i] = -1;
            }
            return ans;
        }
    }

}
