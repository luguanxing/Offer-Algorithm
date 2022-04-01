package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0954_二倍数对数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().canReorderDoubled(new int[]{3, 1, 3, 6}));
        System.out.println(new Solution().canReorderDoubled(new int[]{2, 1, 2, 6}));
        System.out.println(new Solution().canReorderDoubled(new int[]{4, 2, 2, 4}));
        System.out.println(new Solution().canReorderDoubled(new int[]{4, -2, 2, -4}));
    }

    static class Solution {
        public boolean canReorderDoubled(int[] arr) {
            return isPairMatch(Arrays.stream(arr).boxed().collect(Collectors.toList()));
        }

        private boolean isPairMatch(List<Integer> list) {
            if (list.size() % 2 != 0) {
                return false;
            }
            // 排序后贪心匹配
            Collections.sort(list, Comparator.comparingInt(Math::abs));
            Map<Integer, Integer> map = new HashMap<>();
            for (int num : list) {
                if (num % 2 != 0) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                    continue;
                }
                int half = num / 2;
                if (map.containsKey(half)) {
                    map.put(half, map.get(half) - 1);
                    if (map.get(half) == 0) {
                        map.remove(half);
                    }
                } else {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }
            for (int cnt : map.values()) {
                if (cnt != 0) {
                    return false;
                }
            }
            return true;
        }
    }

}
