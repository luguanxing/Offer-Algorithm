package leetcode.contest.week319;

import java.util.ArrayList;
import java.util.List;

public class Test6234_最小公倍数为K的子数组数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().subarrayLCM(
                new int[]{3, 6, 2, 7, 1},
                6
        ));
        System.out.println(new Solution().subarrayLCM(
                new int[]{3},
                2
        ));
        System.out.println(new Solution().subarrayLCM(
                new int[]{2, 1, 1, 5},
                5
        ));
    }


    static class Solution {
        public int subarrayLCM(int[] nums, int k) {
            int len = nums.length;
            //  dp[i][j]是子数组nums[i..j]的最大公因数
            //  状态转移方程为 dp[i][j]=lcm(dp[i][j-1],nums[j])
            //  最后统计dp中值k的个数即可
            int res = 0;
            int[][] dp = new int[len][len];
            for (int i = 0; i < len; i++) {
                dp[i][i] = nums[i];
                if (nums[i] == k) {
                    res++;
                }
            }
            for (int i = 0; i < len; i++) {
                for (int j = i + 1; j < len; j++) {
                    dp[i][j] = getLcm(dp[i][j - 1], nums[j]);
                    if (dp[i][j] > k) {
                        break;
                    }
                    if (dp[i][j] == k) {
                        res++;
                    }
                }
            }
            return res;
        }

        public int getGcd(int m, int n) {
            while (n > 0) {
                int temp = m % n;
                m = n;
                n = temp;
            }
            return m;
        }

        public int getLcm(int m, int n) {
            int gcd = getGcd(m, n);
            return m * n / gcd;
        }
    }

    static class Solution_暴力 {
        public int subarrayLCM(int[] nums, int k) {
            int len = nums.length;
            int res = 0;
            for (int i = 0; i < len; i++) {
                if (k % nums[i] != 0) {
                    continue;
                }
                List<Integer> window = new ArrayList<>();
                for (int j = i; j < len; j++) {
                    if (k % nums[j] != 0) {
                        break;
                    }
                    window.add(nums[j]);
                    if (isOk(window, k)) {
                        res++;
                    }
                }
            }
            return res;
        }

        private boolean isOk(List<Integer> window, int k) {
            int num = window.get(0);
            for (int j = 1; j < window.size(); j++) {
                num = getLcm(num, window.get(j));
                if (num > k) {
                    break;
                }
            }
            return num == k;
        }

        public int getGcd(int m, int n) {
            while (n > 0) {
                int temp = m % n;
                m = n;
                n = temp;
            }
            return m;
        }

        public int getLcm(int m, int n) {
            int gcd = getGcd(m, n);
            return m * n / gcd;
        }
    }

}
