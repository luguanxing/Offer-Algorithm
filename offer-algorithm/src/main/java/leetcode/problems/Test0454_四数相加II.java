package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test0454_四数相加II {

    public static void main(String[] args) {
        System.out.println(new Solution().fourSumCount(
                new int[]{-1, -1},
                new int[]{-1, 1},
                new int[]{-1, 1},
                new int[]{1, -1}
        ));
    }

    static class Solution {
        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer, Integer> map = new HashMap<>();
            int res = 0;
            for (int num1 : A) {
                for (int num2 : B) {
                    map.put(num1 + num2, map.getOrDefault(num1 + num2, 0) + 1);
                }
            }
            for (int num1 : C) {
                for (int num2 : D) {
                    if (map.containsKey(-num1 - num2)) {
                        res += map.get(-num1 - num2);
                    }
                }
            }
            return res;
        }
    }

}
