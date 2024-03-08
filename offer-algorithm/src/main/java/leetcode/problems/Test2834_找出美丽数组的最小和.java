package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Test2834_找出美丽数组的最小和 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumPossibleSum(2, 3));
        System.out.println(new Solution().minimumPossibleSum(3, 3));
        System.out.println(new Solution().minimumPossibleSum(1, 1));
        System.out.println(new Solution().minimumPossibleSum(1000000000, 1000000000));
    }

    static class Solution {
        public int minimumPossibleSum(int n, int target) {
            int MOD = 1000000007;
            long sum = 0;
            // 小于target的数，要去掉target-1,target-2..target/2-1，只剩下1,2...target/2
            if (n <= target / 2) {
                sum = ((long) n * (n + 1) / 2);
            } else {
                sum += ((long) (target / 2) * (target / 2 + 1) / 2);
                // 大于n的个数，从target开始加到剩下的数
                int cnt = n - (target / 2);
                sum += (long) (target + (long) (target + cnt - 1)) * cnt / 2;
            }
            return (int) (sum % MOD);
        }
    }

    static class Solution_暴力 {
        public int minimumPossibleSum(int n, int target) {
            int MOD = 1000000007;
            int sum = 0;
            int i = 1;
            Set<Integer> set = new HashSet<>();
            while (set.size() < n) {
                if (!set.contains(target - i)) {
                    sum = (sum + i) % MOD;
                    set.add(i);
                }
                i++;
            }
            return sum;
        }
    }

}
