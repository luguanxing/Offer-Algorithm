package leetcode.contest.week260;

public class Test5881_增量元素之间的最大差值 {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumDifference(new int[]{
                7, 1, 5, 4
        }));
        System.out.println(new Solution().maximumDifference(new int[]{
                9, 4, 3, 2
        }));
        System.out.println(new Solution().maximumDifference(new int[]{
                1, 5, 2, 10
        }));
    }

    static class Solution {
        public int maximumDifference(int[] nums) {
            int res = -1;
            for (int i = 0; i < nums.length; i++) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[i] < nums[j]) {
                        res = Math.max(res, nums[j] - nums[i]);
                    }
                }
            }
            return res;
        }
    }

}
