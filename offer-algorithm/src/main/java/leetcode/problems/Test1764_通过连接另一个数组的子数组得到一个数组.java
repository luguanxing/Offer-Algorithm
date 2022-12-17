package leetcode.problems;

import java.util.Arrays;

public class Test1764_通过连接另一个数组的子数组得到一个数组 {

    public static void main(String[] args) {
        System.out.println(new Solution().canChoose(
                new int[][]{{1, -1, -1}, {3, -2, 0}},
                new int[]{1, -1, 0, 1, -1, -1, 3, -2, 0}
        ));
        System.out.println(new Solution().canChoose(
                new int[][]{{10, -2}, {1, 2, 3, 4}},
                new int[]{1, 2, 3, 4, 10, -2}
        ));
        System.out.println(new Solution().canChoose(
                new int[][]{{1, 2, 3}, {3, 4}},
                new int[]{7, 7, 1, 2, 3, 4, 7, 7}
        ));
    }

    static class Solution {
        public boolean canChoose(int[][] groups, int[] nums) {
            int len = nums.length;
            int index = 0;
            for (int[] group : groups) {
                // check group[:] == nums[index:index+groupLen]
                int groupLen = group.length;
                boolean isMatch = false;
                while (index + groupLen <= len) {
                    int[] subNums = Arrays.copyOfRange(nums, index, index + groupLen);
                    if (Arrays.toString(group).equals(Arrays.toString(subNums))) {
                        index += groupLen;
                        isMatch = true;
                        break;
                    } else {
                        index++;
                    }
                }
                if (!isMatch) {
                    return false;
                }
            }
            return true;
        }
    }

}
