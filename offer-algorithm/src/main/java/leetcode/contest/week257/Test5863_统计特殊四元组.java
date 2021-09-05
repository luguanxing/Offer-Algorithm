package leetcode.contest.week257;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test5863_统计特殊四元组 {

    public static void main(String[] args) {
        System.out.println(new Solution().countQuadruplets(
                new int[]{1, 2, 3, 6}
        ));
        System.out.println(new Solution().countQuadruplets(
                new int[]{3, 3, 6, 4, 5}
        ));
        System.out.println(new Solution().countQuadruplets(
                new int[]{1, 1, 1, 3, 5}
        ));
        System.out.println(new Solution().countQuadruplets(
                new int[]{28, 8, 49, 85, 37, 90, 20, 8}
        ));
    }

    static class Solution {
        public int countQuadruplets(int[] nums) {
            Set<String> set = new HashSet<>();
            for (int a = 0; a < nums.length; a++) {
                for (int b = a + 1; b < nums.length; b++) {
                    for (int c = b + 1; c < nums.length; c++) {
                        for (int d = c + 1; d < nums.length; d++) {
                            if (nums[a] + nums[b] + nums[c] == nums[d]) {
                                int[] res = {a,b,c,d};
                                Arrays.sort(res);
                                set.add(Arrays.toString(res));
                            }
                        }
                    }
                }
            }
            return set.size();
        }
    }

}
