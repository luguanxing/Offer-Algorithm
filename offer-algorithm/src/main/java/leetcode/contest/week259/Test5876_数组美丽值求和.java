package leetcode.contest.week259;

public class Test5876_数组美丽值求和 {

    public static void main(String[] args) {
        System.out.println(new Solution().sumOfBeauties(new int[]{
                1, 2, 3
        }));
        System.out.println(new Solution().sumOfBeauties(new int[]{
                2, 4, 6, 4
        }));
        System.out.println(new Solution().sumOfBeauties(new int[]{
                3, 2, 1
        }));
        System.out.println(new Solution().sumOfBeauties(new int[]{
                6, 8, 3, 7, 8, 9, 4, 8
        }));
    }

    static class Solution {
        public int sumOfBeauties(int[] nums) {
            // 计算出前边最小，后边最大
            int[] maxBefore = new int[nums.length];
            int[] minAfter = new int[nums.length];
            maxBefore[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                maxBefore[i] = Math.max(maxBefore[i - 1], nums[i]);
            }
            minAfter[nums.length - 1] = nums[nums.length - 1];
            for (int i = nums.length - 2; i >= 0; i--) {
                minAfter[i] = Math.min(minAfter[i + 1], nums[i]);
            }
            // 计算结果
            int res = 0;
            for (int i = 1; i < nums.length - 1; i++) {
                if (maxBefore[i - 1] < nums[i] && nums[i] < minAfter[i + 1]) {
                    res += 2;
                } else if (nums[i - 1] < nums[i] && nums[i] < nums[i + 1]) {
                    res += 1;
                }
            }
            return res;
        }
    }

}
