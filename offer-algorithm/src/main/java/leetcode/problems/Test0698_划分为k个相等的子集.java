package leetcode.problems;

import java.util.Arrays;

public class Test0698_划分为k个相等的子集 {

    public static void main(String[] args) {
        System.out.println(new Solution().canPartitionKSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        System.out.println(new Solution().canPartitionKSubsets(new int[]{1, 2, 3, 4}, 3));
        System.out.println(new Solution().canPartitionKSubsets(new int[]{3522, 181, 521, 515, 304, 123, 2512, 312, 922, 407, 146, 1932, 4037, 2646, 3871, 269}, 5));
        System.out.println(new Solution().canPartitionKSubsets(new int[]{1, 1, 1, 1, 2, 2, 2, 2}, 4));
    }

    static class Solution {
        private boolean isOk = false;

        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = Arrays.stream(nums).sum();
            if (sum % k != 0 || Arrays.stream(nums).max().getAsInt() > sum / k) {
                return false;
            }
            dfs(nums, sum/k, 0, new int[k]);
            return isOk;
        }

        private void dfs(int[] nums, int avg, int idx, int[] buckets) {
            if (isOk || idx == nums.length) {
                isOk = true;
                return;
            }
            int num = nums[idx];
            next:
            for (int i = 0; i < buckets.length; i++) {
                // 相同的桶可以跳过
                for (int j = i - 1; j >= 0; j--) {
                    if (buckets[j] == buckets[i]) {
                        continue next;
                    }
                }
                // 枚举
                if (num + buckets[i] <= avg) {
                    buckets[i] += num;
                    dfs(nums, avg, idx + 1, buckets);
                    buckets[i] -= num;
                }
            }
        }
    }

    static class Solution_Old {
        boolean isOk = false;
        int avg = 0;

        public boolean canPartitionKSubsets(int[] nums, int k) {
            int sum = Arrays.stream(nums).sum();
            // 无法整除k，可以剪枝
            if (sum % k != 0) {
                return false;
            }
            avg = sum / k;
            // 有数比平均值大，可以剪枝
            Arrays.sort(nums);
            if (nums[nums.length - 1] > avg) {
                return false;
            }
            dfs(nums, 0, new int[k]);
            return isOk;
        }

        private void dfs(int[] nums, int index, int[] buckets) {
            if (index == nums.length) {
                isOk = true;
                return;
            }
            int num = nums[index];
            for (int i = 0; i < buckets.length; i++) {
                if (buckets[i] + num <= avg) {
                    // 如果当前桶和上个桶一样，不改变结果，可以剪枝
                    if (i >= 1 && buckets[i] == buckets[i - 1]) {
                        continue;
                    }
                    // 尝试回溯
                    buckets[i] += num;
                    dfs(nums, index + 1, buckets);
                    buckets[i] -= num;
                    // 第一个桶选哪个都一样，可以剪枝
                    if (index == 0) {
                        break;
                    }
                }
            }
        }
    }

    static class Solution_暴力 {
        boolean isOk = false;
        int avg = 0;

        public boolean canPartitionKSubsets(int[] nums, int k) {
            avg = Arrays.stream(nums).sum() / k;
            dfs(nums, 0, new int[k]);
            return isOk;
        }

        private void dfs(int[] nums, int index, int[] groups) {
            if (index == nums.length) {
                isOk = true;
                return;
            }
            int num = nums[index];
            for (int i = 0; i < groups.length; i++) {
                if (groups[i] + num <= avg) {
                    groups[i] += num;
                    dfs(nums, index + 1, groups);
                    groups[i] -= num;
                }
            }
        }
    }

}
