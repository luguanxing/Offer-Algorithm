package leetcode.problems;

public class Test0456_132模式 {

    public static void main(String[] args) {
        System.out.println(new Solution().find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(new Solution().find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(new Solution().find132pattern(new int[]{-1, 3, 2, 0}));
    }

    static class Solution {
        public boolean find132pattern(int[] nums) {
            Integer _1, _3;
            for (int i = 0; i < nums.length; i++) {
                _1 = nums[i];
                _3 = null;
                for (int j = i + 1; j < nums.length; j++) {
                    if (_1 < nums[j]) {
                        if (_3 == null) {
                            _3 = nums[j];
                        } else {
                            if (nums[j] < _3) {
                                return true;
                            } else {
                                _3 = nums[j];
                            }
                        }
                    }
                }
            }
            return false;
        }
    }

}
