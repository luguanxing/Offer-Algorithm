package leetcode.problems;

public class Test0441_排列硬币 {

    public static void main(String[] args) {
        System.out.println(new Solution().arrangeCoins(5));
        System.out.println(new Solution().arrangeCoins(8));
    }

    static class Solution {
        public int arrangeCoins(int n) {
            long sqrt = (long)Math.sqrt(2.0*n);
            if ((sqrt-1)*sqrt/2 <= n && n < sqrt*(sqrt+1)/2) {
                return (int)sqrt-1;
            }
            if (sqrt*(sqrt+1)/2 <= n && n < (sqrt+1)*(sqrt+2)/2) {
                return (int)sqrt;
            }
            return 1;
        }
    }

}
