package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test1630_等差子数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().checkArithmeticSubarrays(
                new int[]{4, 6, 5, 9, 3, 7},
                new int[]{0, 0, 2},
                new int[]{2, 3, 5}
        ));
        System.out.println(new Solution().checkArithmeticSubarrays(
                new int[]{-12, -9, -3, -12, -6, 15, 20, -25, -20, -15, -10},
                new int[]{0, 1, 6, 4, 8, 7},
                new int[]{4, 4, 9, 7, 9, 10}
        ));
    }

    static class Solution {
        public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
            int len = l.length;
            List<Boolean> res = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                int[] subNums = Arrays.copyOfRange(nums, l[i], r[i] + 1);
                res.add(canBeArithmeticSubarrays(subNums));
            }
            return res;
        }

        private boolean canBeArithmeticSubarrays(int[] subNums) {
            if (subNums.length == 0 || subNums.length == 1) {
                return true;
            }
            Arrays.sort(subNums);
            int diff = subNums[1] - subNums[0];
            for (int i = 1; i < subNums.length; i++) {
                if (subNums[i] - subNums[i - 1] != diff) {
                    return false;
                }
            }
            return true;
        }
    }

}
