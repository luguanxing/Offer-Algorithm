package leetcode.contest.week187;

public class Test1437_是否所有1都至少相隔k个元素 {

    public static void main(String[] args) {
        System.out.println(new Solution().kLengthApart(new int[]{1, 0, 0, 0, 1, 0, 0, 1}, 2));
        System.out.println(new Solution().kLengthApart(new int[]{1, 0, 0, 1, 0, 1}, 2));
        System.out.println(new Solution().kLengthApart(new int[]{1, 1, 1, 1, 1}, 0));
    }

    static class Solution {
        public boolean kLengthApart(int[] nums, int k) {
            int lastI = -1;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 1) {
                    if (lastI != -1) {
                        if (i - lastI <= k) {
                            return false;
                        }
                    }
                    lastI = i;
                }
            }
            return true;
        }
    }

}
