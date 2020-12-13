package leetcode.contest.week219;

public class Test5625_比赛中的配对次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().numberOfMatches(7));
        System.out.println(new Solution().numberOfMatches(14));
    }

    static class Solution {
        public int numberOfMatches(int n) {
            int res = 0;
            while (n > 1) {
                if (n % 2 == 0) {
                    res += n / 2;
                    n /= 2;
                } else {
                    res += (n - 1) / 2;
                    n = (n - 1) / 2 + 1;
                }
            }
            return res;
        }
    }

}
