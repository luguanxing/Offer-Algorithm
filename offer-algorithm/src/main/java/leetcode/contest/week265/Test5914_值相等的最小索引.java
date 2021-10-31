package leetcode.contest.week265;

public class Test5914_值相等的最小索引 {

    public static void main(String[] args) {
        System.out.println(new Solution().smallestEqual(new int[]{0, 1, 2}));
        System.out.println(new Solution().smallestEqual(new int[]{4, 3, 2, 1}));
        System.out.println(new Solution().smallestEqual(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0}));
        System.out.println(new Solution().smallestEqual(new int[]{2, 1, 3, 5, 2}));
    }

    static class Solution {
        public int smallestEqual(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (i % 10 == nums[i]) {
                    return i;
                }
            }
            return -1;
        }
    }

}
