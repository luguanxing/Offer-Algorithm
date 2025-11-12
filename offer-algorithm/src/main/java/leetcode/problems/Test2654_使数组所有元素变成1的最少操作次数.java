package leetcode.problems;

public class Test2654_使数组所有元素变成1的最少操作次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(new int[]{2, 6, 3, 4}));
        System.out.println(new Solution().minOperations(new int[]{2, 10, 6, 14}));
        System.out.println(new Solution().minOperations(new int[]{6, 10, 15}));
        System.out.println(new Solution().minOperations(new int[]{4, 2, 6, 3}));
    }

    static class Solution {
        public int minOperations(int[] nums) {
            int len = nums.length;
            int cnt1 = 0;
            int gcdAll = 0;
            for (int num : nums) {
                gcdAll = getGcd(gcdAll, num);
                if (num == 1) {
                    cnt1++;
                }
            }
            // 所有元素的gcd大于1，无法变成1
            if (gcdAll > 1) {
                return -1;
            }
            // 已经有1，直接返回非1的个数
            if (cnt1 > 0) {
                return len - cnt1;
            }
            // 找有没有片段使gcd为1，再从这个1扩展到整个数组
            int minLen = len;
            for (int l  = 0; l < len; l++) {
                int gcd = 0;
                for (int r = l; r < len; r++) {
                    gcd = getGcd(gcd, nums[r]);
                    if (gcd == 1) {
                        minLen = Math.min(minLen, r - l);
                        break;
                    }
                }
            }
            return  minLen + len - 1;
        }

        public int getGcd(int m, int n) {
            while (n > 0) {
                int temp = m % n;
                m = n;
                n = temp;
            }
            return m;
        }
    }

}
