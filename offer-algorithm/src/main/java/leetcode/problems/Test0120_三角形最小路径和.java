package leetcode.problems;

import java.util.Arrays;
import java.util.List;

public class Test0120_三角形最小路径和 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumTotal(
                Arrays.asList(
                        Arrays.asList(2),
                        Arrays.asList(3, 4),
                        Arrays.asList(6, 5, 7),
                        Arrays.asList(4, 1, 8, 3)
                )
        ));
    }

    static class Solution {
        public int minimumTotal(List<List<Integer>> triangle) {
            for (int level = 1; level < triangle.size(); level++) {
                updateLevel(triangle, level);
            }
            return triangle
                    .get(triangle.size() - 1)
                    .stream()
                    .min(Integer::compareTo)
                    .orElse(0);
        }

        private void updateLevel(List<List<Integer>> triangle, int level) {
            List<Integer> state = triangle.get(level - 1);
            List<Integer> current = triangle.get(level);
            for (int i = 0; i < current.size(); i++) {
                Integer num = current.get(i);
                if (i == 0) {
                    current.set(i, num + state.get(i));
                } else if (i == current.size() - 1) {
                    current.set(i, num + state.get(i - 1));
                } else {
                    current.set(i, num + Math.min(state.get(i - 1), state.get(i)));
                }
            }
        }
    }

}
