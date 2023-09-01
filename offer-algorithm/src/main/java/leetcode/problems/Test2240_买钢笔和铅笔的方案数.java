package leetcode.problems;

public class Test2240_买钢笔和铅笔的方案数 {

    public static void main(String[] args) {
        System.out.println(new Solution().waysToBuyPensPencils(20, 10, 5));
        System.out.println(new Solution().waysToBuyPensPencils(5, 10, 10));
    }

    static class Solution {
        public long waysToBuyPensPencils(int total, int cost1, int cost2) {
            long res = 0;
            for (int i = 0; i <= total / cost1; i++) {
                long leftMoney = total - (long) i * cost1;
                res += 1;
                res += leftMoney / cost2;
            }
            return res;
        }
    }

}
