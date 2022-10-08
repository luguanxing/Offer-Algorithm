package leetcode.problems;

import java.util.Arrays;
import java.util.TreeMap;

public class Test0870_优势洗牌 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().advantageCount(
                new int[]{2, 7, 11, 15},
                new int[]{1, 10, 4, 11}
        )));
        System.out.println(Arrays.toString(new Solution().advantageCount(
                new int[]{12, 24, 8, 32},
                new int[]{13, 25, 32, 11}
        )));
    }

    static class Solution {
        public int[] advantageCount(int[] nums1, int[] nums2) {
            TreeMap<Integer, Integer> map = new TreeMap<>();
            for (int num : nums1) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            // 找相对更大的数
            int len = nums1.length;
            int[] res = new int[len];
            for (int i = 0; i < len; i++) {
                int num2 = nums2[i];
                Integer higherKey = map.higherKey(num2);
                if (higherKey != null) {
                    res[i] = higherKey;
                    map.put(higherKey, map.get(higherKey) - 1);
                    if (map.get(higherKey) == 0) {
                        map.remove(higherKey);
                    }
                } else {
                    res[i] = -1;
                }
            }
            // 剩下没找到的数补上
            for (int i = 0; i < len; i++) {
                if (res[i] == -1) {
                    int firstKey = map.firstKey();
                    res[i] = firstKey;
                    map.put(firstKey, map.get(firstKey) - 1);
                    if (map.get(firstKey) == 0) {
                        map.remove(firstKey);
                    }
                }
            }
            return res;
        }
    }

}
