package leetcode.problems;

public class Test1144_递减元素使数组呈锯齿状 {

    public static void main(String[] args) {
        System.out.println(new Solution().movesToMakeZigzag(new int[]{1, 2, 3}));
        System.out.println(new Solution().movesToMakeZigzag(new int[]{9, 6, 1, 6, 2}));
    }

    static class Solution {
        public int movesToMakeZigzag(int[] nums) {
            int len = nums.length;
            int res1 = 0;
            int res2 = 0;
            for (int i = 0; i < len; i++) {
                if (i % 2 == 1) {
                    // 只减奇数位置的nums[i]
                    int left = nums[i - 1];
                    int right = i + 1 == len ? Integer.MAX_VALUE : nums[i + 1];
                    int num = nums[i];
                    if (left > num && num < right) {
                        continue;
                    }
                    // num要比left和right都小
                    int diff = num - Math.min(left, right) + 1;
                    res2 += diff;
                } else {
                    // 只减偶数位置的nums[i]
                    int left = i - 1 < 0 ? Integer.MAX_VALUE : nums[i - 1];
                    int right = i + 1 == len ? Integer.MAX_VALUE : nums[i + 1];
                    int num = nums[i];
                    if (left > num && num < right) {
                        continue;
                    }
                    // num要比left和right都小
                    int diff = num - Math.min(left, right) + 1;
                    res1 += diff;
                }
            }
            return Math.min(res1, res2);
        }
    }

}
