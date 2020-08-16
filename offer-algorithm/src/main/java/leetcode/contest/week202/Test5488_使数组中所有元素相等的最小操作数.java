package leetcode.contest.week202;

public class Test5488_使数组中所有元素相等的最小操作数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations(3));
        System.out.println(new Solution().minOperations(6));
    }

    static class Solution {
        public int minOperations(int n) {
            int mid = n;
            int res = 0;
            if (n % 2 == 0) {
                int side = n / 2;
                for (int i = 0; i < side; i++) {
                    res += i * 2 + 1;
                }
            } else {
                int side = (n - 1) / 2;
                for (int i = 1; i <= side; i++) {
                    res += i * 2;
                }
            }
            return res;
        }
    }

}
