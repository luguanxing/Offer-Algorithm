package leetcode.contest.week338;

public class Test6354_K件物品的最大和 {

    public static void main(String[] args) {
        System.out.println(new Solution().kItemsWithMaximumSum(3, 2, 0, 2));
        System.out.println(new Solution().kItemsWithMaximumSum(3, 2, 0, 4));
        System.out.println(new Solution().kItemsWithMaximumSum(3, 2, 5, 6));
        System.out.println(new Solution().kItemsWithMaximumSum(6, 6, 6, 13));
    }

    static class Solution {
        public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
            if (numOnes >= k) {
                return k;
            }
            if (numOnes + numZeros >= k) {
                return numOnes;
            }
            return numOnes - (k - numOnes - numZeros);
        }
    }

}
