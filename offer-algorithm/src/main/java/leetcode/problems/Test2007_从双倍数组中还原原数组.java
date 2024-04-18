package leetcode.problems;

import java.util.*;

public class Test2007_从双倍数组中还原原数组 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findOriginalArray(new int[]{1, 3, 4, 2, 6, 8})));
        System.out.println(Arrays.toString(new Solution().findOriginalArray(new int[]{6, 3, 0, 1})));
        System.out.println(Arrays.toString(new Solution().findOriginalArray(new int[]{1})));
    }

    static class Solution {
        public int[] findOriginalArray(int[] changed) {
            int len = changed.length;
            if (len % 2 != 0) {
                return new int[]{};
            }
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int num : changed) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int[] res = new int[len / 2];
            int index = 0;
            while (!map.isEmpty()) {
                // 从小到大找一个数
                int num = map.firstKey();
                map.put(num, map.get(num) - 1);
                if (map.get(num) == 0) {
                    map.remove(num);
                }
                // 找下一个数
                if (!map.containsKey(num * 2)) {
                    return new int[]{};
                }
                res[index++] = num;
                map.put(num * 2, map.get(num * 2) - 1);
                if (map.get(num * 2) == 0) {
                    map.remove(num * 2);
                }
            }
            return res;
        }
    }

}
