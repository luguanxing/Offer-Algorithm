package leetcode.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test1072_按列翻转得到最大值等行数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxEqualRowsAfterFlips(new int[][]{{0, 1}, {1, 1}}));
        System.out.println(new Solution().maxEqualRowsAfterFlips(new int[][]{{0, 1}, {1, 0}}));
        System.out.println(new Solution().maxEqualRowsAfterFlips(new int[][]{{0, 0, 0}, {0, 0, 1}, {1, 1, 0}}));
    }

    static class Solution {
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            // 001和110是相同结构，都先转成相同结构（0开头），保存个数
            Map<String, Integer> map = new HashMap<>();
            for (int[] m : matrix) {
                if (m[0] == 1) {
                    for (int i = 0; i < m.length; i++) {
                        m[i] = 1 - m[i];
                    }
                }
                String str = Arrays.toString(m);
                map.put(str, map.getOrDefault(str, 0) + 1);
            }
            return map.values().stream().max(Integer::compareTo).get();
        }
    }

}
