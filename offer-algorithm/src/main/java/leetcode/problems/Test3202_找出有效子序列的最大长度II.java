package leetcode.problems;

public class Test3202_找出有效子序列的最大长度II {

    public static void main(String[] args) {
        // nums = [1,2,3,4,5], k = 2
        System.out.println(new Solution().maximumLength(new int[]{1, 2, 3, 4, 5}, 2));
        // nums = [1,4,2,3,1,4], k = 3
        System.out.println(new Solution().maximumLength(new int[]{1, 4, 2, 3, 1, 4}, 3));
    }

    static class Solution {
        public int maximumLength(int[] nums, int k) {
            // dp[i][j]表示后两个数取余k结果为i、j的个数
            int[][] dp = new int[k][k];
            int res = 0;
            for (int num : nums) {
                int mod = num % k;
                // 遍历上一个余数所有可能性
                for (int lastMod = 0; lastMod < k; lastMod++) {
                    // 和之前余数对子相反才能继续统计
                    dp[lastMod][mod] = dp[mod][lastMod] + 1;
                    res = Math.max(res, dp[lastMod][mod]);
                }
            }
            return res;
        }
    }

    static class Solution_超时 {
        public int maximumLength(int[] nums, int k) {
            // 穷举k^2种情况
            int res = 0;
            int[][] patterns = new int[k * k][2];
            for (int i = 0; i < k; i++) {
                for (int j = 0; j < k; j++) {
                    patterns[i * k + j] = new int[]{i, j};
                }
            }
            for (int[] pattern : patterns) {
                int cnt = 0;
                for (int num : nums) {
                    // 如果当前数的奇偶性和模式相同，则计数器加1
                    if (num % k == pattern[cnt % 2]) {
                        cnt++;
                    }
                }
                res = Math.max(res, cnt);
            }
            return res;
        }
    }

}
