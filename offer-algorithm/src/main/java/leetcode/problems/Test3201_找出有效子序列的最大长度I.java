package leetcode.problems;

public class Test3201_找出有效子序列的最大长度I {

    public static void main(String[] args) {
        System.out.println(new Solution().maximumLength(new int[]{1, 2, 3, 4}));
        System.out.println(new Solution().maximumLength(new int[]{1, 2, 1, 1, 2, 1, 2}));
        System.out.println(new Solution().maximumLength(new int[]{1, 3}));
        System.out.println(new Solution().maximumLength(new int[]{1, 8, 4, 2, 4}));
        System.out.println(new Solution().maximumLength(new int[]{3, 1, 6, 2, 2}));
    }

    static class Solution {
        public int maximumLength(int[] nums) {
            // 穷举四种情况：奇奇、偶偶、奇偶、偶奇
            int res = 0;
            int[][] patterns = new int[][]{{1, 1}, {0, 0}, {1, 0}, {0, 1}};
            for (int[] pattern : patterns) {
                int cnt = 0;
                for (int num : nums) {
                    // 如果当前数的奇偶性和模式相同，则计数器加1
                    if (num % 2 == pattern[cnt % 2]) {
                        cnt++;
                    }
                }
                res = Math.max(res, cnt);
            }
            return res;
        }
    }

    static class Solution_枚举和 {
        public int maximumLength(int[] nums) {
            // 穷举和2种情况：0、1
            int res = 0;
            res = Math.max(res, getMaxCnt(nums, 0));
            res = Math.max(res, getMaxCnt(nums, 1));
            return res;
        }

        private int getMaxCnt(int[] nums, int sum) {
            int len = nums.length;
            int cnt0 = 1;
            int last0 = nums[0];
            for (int i = 1; i < len; i++) {
                if ((nums[i] + last0) % 2 == sum) {
                    cnt0++;
                    last0 = nums[i];
                }
            }
            // 下一个数从奇偶性和nums[0]不同的数开始
            int idx = 1;
            while (idx < len && nums[idx] % 2 == nums[0] % 2) {
                idx++;
            }
            if (idx >= len) {
                return cnt0;
            }
            int cnt1 = 1;
            int last1 = nums[idx];
            for (int i = idx + 1; i < len; i++) {
                if ((nums[i] + last1) % 2 == sum) {
                    cnt1++;
                    last1 = nums[i];
                }
            }
            return Math.max(cnt0, cnt1);
        }
    }

}
