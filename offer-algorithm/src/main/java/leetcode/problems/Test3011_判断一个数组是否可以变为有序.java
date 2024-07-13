package leetcode.problems;

import java.util.Arrays;

public class Test3011_判断一个数组是否可以变为有序 {

    public static void main(String[] args) {
        System.out.println(new Solution().canSortArray(new int[]{8, 4, 2, 30, 15}));
        System.out.println(new Solution().canSortArray(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().canSortArray(new int[]{3, 16, 8, 4, 2}));
        System.out.println(new Solution().canSortArray(new int[]{75, 34, 30}));
    }

    static class Solution {
        public boolean canSortArray(int[] nums) {
            int len = nums.length;
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    int c1 = Integer.bitCount(nums[i]);
                    int c2 = Integer.bitCount(nums[j]);
                    if (c1 == c2) {
                        if (nums[i] > nums[j]) {
                            int tmp = nums[i];
                            nums[i] = nums[j];
                            nums[j] = tmp;
                        }
                    } else {
                        // 不连续不能交换
                        break;
                    }
                }
            }
            String res1 = Arrays.toString(nums);
            Arrays.sort(nums);
            String res2 = Arrays.toString(nums);
            return res1.equals(res2);
        }
    }

}
