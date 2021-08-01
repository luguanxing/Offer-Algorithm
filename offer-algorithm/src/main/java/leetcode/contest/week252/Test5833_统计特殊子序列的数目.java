package leetcode.contest.week252;

public class Test5833_统计特殊子序列的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().countSpecialSubsequences(
                new long[]{0, 1, 2, 2}
        ));
        System.out.println(new Solution().countSpecialSubsequences(
                new long[]{2, 2, 0, 0}
        ));
        System.out.println(new Solution().countSpecialSubsequences(
                new long[]{0, 1, 2, 0, 1, 2}
        ));
        System.out.println(new Solution().countSpecialSubsequences(
                new long[]{1, 0, 1, 0, 2}
        ));
    }

    static class Solution {
        public int countSpecialSubsequences(int[] nums) {
            int len = nums.length;
            int MOD = 1000000007;
            // fx[i]表示前i项可存在x的方法数
            long[] f0 = new long[len];
            long[] f1 = new long[len];
            long[] f2 = new long[len];
            if (nums[0] == 0) {
                f0[0] = 1;
            }
            for (int i = 1; i < len; i++) {
                long num = nums[i];
                if (num == 0) {
                    f1[i] = f1[i - 1];
                    f2[i] = f2[i - 1];
                    // 不要该0的方法数
                    f0[i] += f0[i - 1];
                    // 要该0方法数，也可单独存在
                    f0[i] += f0[i - 1] + 1;
                    f0[i] %= MOD;
                } else if (num == 1) {
                    f0[i] = f0[i - 1];
                    f2[i] = f2[i - 1];
                    // 不要该1的方法数
                    f1[i] += f1[i - 1];
                    // 要该1方法数，需要前面为0或1
                    f1[i] += f0[i - 1] + f1[i - 1];
                    f1[i] %= MOD;
                } else if (num == 2) {
                    f0[i] = f0[i - 1];
                    f1[i] = f1[i - 1];
                    // 不要该2的方法数
                    f2[i] += f2[i - 1];
                    // 要该2方法数，需要前面为1或2
                    f2[i] += f1[i - 1] + f2[i - 1];
                    f2[i] %= MOD;
                }
            }
            return (int) f2[len - 1];
        }
    }

}
