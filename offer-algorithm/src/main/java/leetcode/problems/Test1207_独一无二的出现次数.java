package leetcode.problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test1207_独一无二的出现次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().uniqueOccurrences(
                new int[]{1, 2, 2, 1, 1, 3}
        ));
        System.out.println(new Solution().uniqueOccurrences(
                new int[]{1, 2}
        ));
        System.out.println(new Solution().uniqueOccurrences(
                new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}
        ));
    }

    static class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> numCountMap = new HashMap<>();
            Set<Integer> countSet = new HashSet<>();
            for (int num : arr) {
                numCountMap.put(num, numCountMap.getOrDefault(num, 0) + 1);
            }
            for (int count : numCountMap.values()) {
                if (countSet.contains(count)) {
                    return false;
                } else {
                    countSet.add(count);
                }
            }
            return true;
        }
    }

}
