package leetcode.contest.week371;

public class Test100120_找出强数对的最大异或值I {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumStrongPairXor(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Solution().maximumStrongPairXor(new int[]{10, 100}));
        System.out.println(new Solution().maximumStrongPairXor(new int[]{5, 6, 25, 30}));
    }

    static class Solution {
        public int maximumStrongPairXor(int[] nums) {
            int len = nums.length;
            int max = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    if (Math.abs(nums[i] - nums[j]) <= Math.min(nums[i], nums[j])) {
                        max = Math.max(max, nums[i] ^ nums[j]);
                    }
                }
            }
            return max;
        }
    }

}
