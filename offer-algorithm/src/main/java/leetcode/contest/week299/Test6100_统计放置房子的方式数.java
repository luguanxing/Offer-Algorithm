package leetcode.contest.week299;

public class Test6100_统计放置房子的方式数 {

    public static void main(String[] args) {
        System.out.println(new Solution().countHousePlacements(1));
        System.out.println(new Solution().countHousePlacements(2));
    }

    static class Solution {
        public int countHousePlacements(int n) {
            int MOD = 1000000007;
            int[] dpNone = new int[n];
            int[] dpSide1 = new int[n];
            int[] dpSide2 = new int[n];
            int[] dpBoth = new int[n];
            dpNone[0] = 1;
            dpSide1[0] = 1;
            dpSide2[0] = 1;
            dpBoth[0] = 1;
            for (int i = 1; i < n; i++) {
                dpNone[i] = (int) (((long)dpNone[i - 1] + dpSide1[i - 1] + dpSide2[i - 1] + dpBoth[i - 1]) % MOD);
                dpSide1[i] = (int) (((long)dpNone[i - 1] + dpSide2[i - 1]) % MOD);
                dpSide2[i] = (int) (((long)dpNone[i - 1] + dpSide1[i - 1]) % MOD);
                dpBoth[i] = dpNone[i - 1] % MOD;
            }
            return (int) (((long)dpNone[n - 1] + dpSide1[n - 1] + dpSide2[n - 1] + dpBoth[n - 1]) % MOD);
        }
    }

}
