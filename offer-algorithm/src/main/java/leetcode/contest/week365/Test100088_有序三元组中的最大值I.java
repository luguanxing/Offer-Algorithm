package leetcode.contest.week365;

public class Test100088_有序三元组中的最大值I {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumTripletValue(new int[]{12, 6, 1, 2, 7}));
        System.out.println(new Solution().maximumTripletValue(new int[]{1, 10, 3, 4, 19}));
        System.out.println(new Solution().maximumTripletValue(new int[]{1, 2, 3}));
    }

    static class Solution {
        public long maximumTripletValue(int[] nums) {
            int len = nums.length;
            long ans = 0;
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    for (int k = j + 1; k < len; k++) {
                        ans = Math.max(ans, ((long) (nums[i] - nums[j])) * nums[k]);
                    }
                }
            }
            return ans;
        }
    }

}
