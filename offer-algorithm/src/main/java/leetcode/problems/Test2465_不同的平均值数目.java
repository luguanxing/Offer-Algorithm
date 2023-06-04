package leetcode.problems;

import java.util.Arrays;

public class Test2465_不同的平均值数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().distinctAverages(new int[]{4, 1, 4, 0, 3, 5}));
        System.out.println(new Solution().distinctAverages(new int[]{1, 100}));
        System.out.println(new Solution().distinctAverages(new int[]{0, 0, 2, 7}));
    }

    static class Solution {
        public int distinctAverages(int[] nums) {
            int len = nums.length;
            Arrays.sort(nums);
            int[] map = new int[250];
            for (int i = 0; i < len / 2; i++) {
                map[nums[i] + nums[len - 1 - i]]++;
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
