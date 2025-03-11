package leetcode.problems;

public class Test2012_数组美丽值求和 {

    public static void main(String[] args) {
        System.out.println(new Solution().sumOfBeauties(new int[]{1, 2, 3}));
        System.out.println(new Solution().sumOfBeauties(new int[]{2, 4, 6, 4}));
        System.out.println(new Solution().sumOfBeauties(new int[]{3, 2, 1}));
    }

    static class Solution {
        public int sumOfBeauties(int[] nums) {
            int len = nums.length;
            // 计算前缀最大值和后缀最小值
            int[] prefixMax = new int[len];
            int[] suffixMin = new int[len];
            prefixMax[0] = nums[0];
            for (int i = 1; i < len; i++) {
                prefixMax[i] = Math.max(prefixMax[i - 1], nums[i]);
            }
            suffixMin[len - 1] = nums[len - 1];
            for (int i = len - 2; i >= 0; i--) {
                suffixMin[i] = Math.min(suffixMin[i + 1], nums[i]);
            }
            // 计算得分
            int res = 0;
            for (int i = 1; i < len - 1; i++) {
                if (nums[i] > prefixMax[i - 1] && nums[i] < suffixMin[i + 1]) {
                    res += 2;
                } else if (nums[i] > nums[i - 1] && nums[i] < nums[i + 1]) {
                    res += 1;
                }
            }
            return res;
        }
    }

}
