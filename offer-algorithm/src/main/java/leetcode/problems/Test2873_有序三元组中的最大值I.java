package leetcode.problems;

public class Test2873_有序三元组中的最大值I {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumTripletValue(new int[]{12, 6, 1, 2, 7}));
        System.out.println(new Solution().maximumTripletValue(new int[]{1, 10, 3, 4, 19}));
        System.out.println(new Solution().maximumTripletValue(new int[]{1, 2, 3}));
        System.out.println(new Solution().maximumTripletValue(new int[]{8, 6, 3, 13, 2, 12, 19, 5, 19, 6, 10, 11, 9}));
        System.out.println(new Solution().maximumTripletValue(new int[]{2, 3, 1}));
    }

    static class Solution {
        public long maximumTripletValue(int[] nums) {
            // 全部使用变量
            int len = nums.length;
            long res = 0;
            long prefixDiffMax = 0;
            int prefixMax = nums[0];
            for (int i = 1; i < len; i++) {
                res = Math.max(res, prefixDiffMax * nums[i]);
                prefixDiffMax = Math.max(prefixDiffMax, prefixMax - nums[i]);
                prefixMax = Math.max(prefixMax, nums[i]);
            }
            return res;
        }
    }

    static class Solution_数组记录 {
        public long maximumTripletValue(int[] nums) {
            int len = nums.length;
            int[] prefixDiffMax = new int[len];
            int prefixMax = nums[0];
            for (int i = 1; i < len; i++) {
                prefixDiffMax[i] = Math.max(prefixDiffMax[i - 1], prefixMax - nums[i]);
                prefixMax = Math.max(prefixMax, nums[i]);
            }
            long res = 0;
            int suffixMax = nums[len - 1];
            for (int i = len - 2; i >= 0; i--) {
                res = Math.max(res, (long) prefixDiffMax[i] * suffixMax);
                suffixMax = Math.max(suffixMax, nums[i]);
            }
            return res;
        }
    }

}
