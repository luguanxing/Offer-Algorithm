package leetcode.problems;

import java.util.Arrays;

public class Test1498_满足条件的子序列数目 {

    public static void main(String[] args) {
        // nums = [3,5,6,7], target = 9
        System.out.println(new Solution().numSubseq(new int[]{3, 5, 6, 7}, 9));
        // nums = [3,3,6,8], target = 10
        System.out.println(new Solution().numSubseq(new int[]{3, 3, 6, 8}, 10));
        // nums = [2,3,3,4,6,7], target = 12
        System.out.println(new Solution().numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
    }

    static class Solution {
        public int numSubseq(int[] nums, int target) {
            int len = nums.length;
            int MOD = (int) (1e9 + 7);
            Arrays.sort(nums);
            // 每个左序号用二分找和不超过target的右边序号
            int res = 0;
            for (int l = 0; l < len; l++) {
                int r = getIndex(nums, l, len, target - nums[l]);
                if (r < l) {
                    continue;
                }
                res += powMod(2, r - l, MOD);
                res %= MOD;
            }
            return res;
        }

        private int getIndex(int[] nums, int start, int end, int target) {
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] <= target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            return start - 1; // 返回最后一个小于等于target的索引
        }

        private int powMod(int base, int pow, int mod) {
            long res = 1;
            long num = base;
            while (pow > 0) {
                if (pow % 2 == 1) {
                    // 要使用long类型，避免溢出
                    res = (res * num) % mod;
                }
                num = (num * num) % mod;
                pow /= 2;
            }
            return (int) res;
        }
    }

    static class Solution_两数和优化 {
        public int numSubseq(int[] nums, int target) {
            int len = nums.length;
            int MOD = (int) (1e9 + 7);
            Arrays.sort(nums);
            // 每个左序号用二分找和不超过target的右边序号
            int res = 0;
            for (int l = 0; l < len; l++) {
                int r = getIndex(nums, l, len, target - nums[l]);
                if (r < l) {
                    continue;
                }
                int cnt = 1;
                for (int i = 1; i <= r - l; i++) {
                    cnt *= 2;
                    cnt %= MOD;
                }
                res += cnt;
                res %= MOD;
            }
            return res;
        }

        private int getIndex(int[] nums, int start, int end, int target) {
            while (start < end) {
                int mid = start + (end - start) / 2;
                if (nums[mid] <= target) {
                    start = mid + 1;
                } else {
                    end = mid;
                }
            }
            return start - 1; // 返回最后一个小于等于target的索引
        }
    }

}
