package leetcode.contest.week313;

public class Test6192_公因子的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().commonFactors(12, 6));
        System.out.println(new Solution().commonFactors(25, 30));
    }

    static class Solution {
        public int commonFactors(int a, int b) {
            int cnt = 0;
            for (int i = 1; i <= Math.min(a, b); i++) {
                if (a % i == 0 && b % i == 0) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

}
