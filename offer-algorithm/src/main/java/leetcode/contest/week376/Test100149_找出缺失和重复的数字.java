package leetcode.contest.week376;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test100149_找出缺失和重复的数字 {

    public static void main(String[] args) {
        // grid = [[1,3],[2,2]]
        System.out.println(Arrays.toString(new Solution().findMissingAndRepeatedValues(new int[][]{{1, 3}, {2, 2}})));
        // grid = [[9,1,7],[8,9,2],[3,4,6]]
        System.out.println(Arrays.toString(new Solution().findMissingAndRepeatedValues(new int[][]{{9, 1, 7}, {8, 9, 2}, {3, 4, 6}})));
    }

    static class Solution {
        public int[] findMissingAndRepeatedValues(int[][] grid) {
            int n = grid.length;
            Map<Integer, Integer> map = new HashMap<>();
            for (int[] row : grid) {
                for (int num : row) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                }
            }
            int a = -1;
            int b = -1;
            for (int i = 1; i <= n * n; i++) {
                if (!map.containsKey(i)) {
                    b = i;
                    continue;
                }
                if (map.get(i) == 2) {
                    a = i;
                }
            }
            return new int[]{a, b};
        }
    }

}
