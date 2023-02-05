package leetcode.contest.week331;

import java.util.Arrays;

public class Test6346_打家劫舍IV {

    public static void main(String[] args) {
        System.out.println(new Solution().minCapability(new int[]{2, 3, 5, 9}, 2));
        System.out.println(new Solution().minCapability(new int[]{2, 7, 9, 3, 1}, 2));
        System.out.println(new Solution().minCapability(new int[]{7, 3, 9, 5}, 2));
        System.out.println(new Solution().minCapability(new int[]{5038, 3053, 2825, 3638, 4648, 3259, 4948, 4248, 4940, 2834, 109, 5224, 5097, 4708, 2162, 3438, 4152, 4134, 551, 3961, 2294, 3961, 1327, 2395, 1002, 763, 4296, 3147, 5069, 2156, 572, 1261, 4272, 4158, 5186, 2543, 5055, 4735, 2325, 1206, 1019, 1257, 5048, 1563, 3507, 4269, 5328, 173, 5007, 2392, 967, 2768, 86, 3401, 3667, 4406, 4487, 876, 1530, 819, 1320, 883, 1101, 5317, 2305, 89, 788, 1603, 3456, 5221, 1910, 3343, 4597}, 28));
    }

    static class Solution {
        public int minCapability(int[] nums, int k) {
            // 使用二分查找，试出最小的窃取能力
            int max = Arrays.stream(nums).max().orElse(Integer.MAX_VALUE);
            int min = 0;
            while (min < max) {
                int mid = (max + min) / 2;
                int count = maxStealCount(nums, mid);
                if (count < k) {
                    min = mid + 1;
                } else {
                    max = mid;
                }
            }
            return min;
        }

        private int maxStealCount(int[] nums, int target) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] <= target) {
                    count++;
                    i++;
                }
            }
            return count;
        }
    }

    static class Solution_TLE {
        int max = Integer.MAX_VALUE;

        public int minCapability(int[] nums, int k) {
            // 从数组中选出k个内部元素彼此不相邻的数，找出使里面最大的数最小化的结果值（最小窃取能力）
            dfs(nums, k, 0, true, 0, 0);
            return max;
        }

        private void dfs(int[] nums, int k, int index, boolean isValid, int cnt, int res) {
            if (index == nums.length) {
                if (cnt >= k) {
                    max = Math.min(max, res);
                }
                return;
            }
            if (cnt > k) {
                return;
            }
            if (res >= max) {
                return;
            }
            if (!isValid) {
                dfs(nums, k, index + 1, true, cnt, res);
            } else {
                dfs(nums, k, index + 1, false, cnt + 1, Math.max(res, nums[index]));
                dfs(nums, k, index + 1, true, cnt, res);
            }
        }
    }

}
