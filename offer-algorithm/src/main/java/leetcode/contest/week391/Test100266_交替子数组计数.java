package leetcode.contest.week391;

public class Test100266_交替子数组计数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countAlternatingSubarrays(new int[]{0, 1, 1, 1}));
        System.out.println(new Solution().countAlternatingSubarrays(new int[]{1, 0, 1, 0}));
    }

    static class Solution {
        public long countAlternatingSubarrays(int[] nums) {
            long count = 1;
            int length = 1;
            for (int i = 1; i < nums.length; i++) {
                if (nums[i] != nums[i - 1]) {
                    length++;
                } else {
                    length = 1;
                }
                count += length;
            }
            return count;
        }
    }


}
