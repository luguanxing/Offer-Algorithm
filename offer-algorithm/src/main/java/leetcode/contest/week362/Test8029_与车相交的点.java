package leetcode.contest.week362;

import java.util.Arrays;
import java.util.List;

public class Test8029_与车相交的点 {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfPoints(
                Arrays.asList(
                        Arrays.asList(3, 6),
                        Arrays.asList(1, 5),
                        Arrays.asList(4, 7)
                )
        ));
        System.out.println(new Solution().numberOfPoints(
                Arrays.asList(
                        Arrays.asList(1, 3),
                        Arrays.asList(5, 8)
                )
        ));
    }

    static class Solution {
        public int numberOfPoints(List<List<Integer>> nums) {
            int[] map = new int[105];
            for (List<Integer> se : nums) {
                for (int i = se.get(0); i <= se.get(1); i++) {
                    map[i]++;
                }
            }
            int res = 0;
            for (int cnt : map) {
                if (cnt > 0) {
                    res++;
                }
            }
            return res;
        }
    }

}
