package leetcode.contest.week275;

public class Test5977_最少交换次数来组合所有的1II {

    public static void main(String[] args) {
        System.out.println(new Solution().minSwaps(new int[]{0, 1, 0, 1, 1, 0, 0}));
        System.out.println(new Solution().minSwaps(new int[]{0, 1, 1, 1, 0, 0, 1, 1, 0}));
        System.out.println(new Solution().minSwaps(new int[]{1, 1, 0, 0, 1}));
        System.out.println(new Solution().minSwaps(new int[]{1}));
        System.out.println(new Solution().minSwaps(new int[]{1, 1, 1}));
        System.out.println(new Solution().minSwaps(new int[]{1, 1, 1, 0, 0, 1, 0, 1, 1, 0}));
    }

    static class Solution {
        public int minSwaps(int[] nums) {
            // 构建环形数组
            int len = nums.length;
            int[] roundNums = new int[len * 2];
            for (int i = 0; i < len; i++) {
                roundNums[i] = nums[i];
                roundNums[i + len] = nums[i];
            }
            // 算出1的总个数cnt，和环形数组里长度为cnt最多连续1的个数
            int cnt = 0;
            for (int num : nums) {
                if (num == 1) {
                    cnt++;
                }
            }
            int windowMax = 0;
            int windowCurrent = 0;
            for (int i = 0; i < cnt; i++) {
                if (nums[i] == 1) {
                    windowCurrent++;
                }
            }
            windowMax = Math.max(windowCurrent, windowMax);
            for (int i = cnt; i < roundNums.length; i++) {
                windowCurrent -= roundNums[i - cnt] == 1 ? 1 : 0;
                windowCurrent += roundNums[i] == 1 ? 1 : 0;
                windowMax = Math.max(windowCurrent, windowMax);
            }
            // 计算需要移动的个数
            return cnt - Math.min(windowMax, cnt);
        }
    }

}
