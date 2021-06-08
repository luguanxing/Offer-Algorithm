package leetcode.problems;

import java.util.Arrays;

public class Test1049_最后一块石头的重量II {

    public static void main(String[] args) {
        System.out.println(new Solution().lastStoneWeightII(new int[]{2, 7, 4, 1, 8, 1}));
        System.out.println(new Solution().lastStoneWeightII(new int[]{31, 26, 33, 21, 40}));
        System.out.println(new Solution().lastStoneWeightII(new int[]{1, 2}));
    }

    static class Solution {
        public int lastStoneWeightII(int[] stones) {
            // 相当于两个子集的差最小，即划分出最接近总容量一半的子集
            int sum = Arrays.stream(stones).sum();
            int res = packeting(stones, stones, sum / 2);
            // S1-S2=S1-(S-S1)=2S1-S
            return sum - 2 * res;
        }

        public int packeting(int[] w, int[] v, int c) {
            int n = w.length;
            if (n == 0)
                return 0;
            int[][] maxValue = new int[n][c + 1];
            for (int j = 0; j <= c; j++)
                maxValue[0][j] = (j >= w[0] ? v[0] : 0);
            for (int i = 1; i < n; i++)
                for (int j = 0; j <= c; j++) {
                    //不拿第i件物品时
                    int noTakeItemI = maxValue[i - 1][j];
                    maxValue[i][j] = noTakeItemI;
                    if (j >= w[i]) {
                        //能拿且拿第i件物品时
                        int takeItemI = maxValue[i - 1][j - w[i]] + v[i];
                        maxValue[i][j] = Math.max(maxValue[i][j], takeItemI);
                    }
                }
            return maxValue[n - 1][c];
        }
    }

}
