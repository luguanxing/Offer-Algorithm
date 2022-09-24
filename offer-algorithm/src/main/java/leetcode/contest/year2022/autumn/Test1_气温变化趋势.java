package leetcode.contest.year2022.autumn;

public class Test1_气温变化趋势 {

    public static void main(String[] args) {
        System.out.println(new Solution().temperatureTrend(
                new int[]{21, 18, 18, 18, 31},
                new int[]{34, 32, 16, 16, 17}
        ));
        System.out.println(new Solution().temperatureTrend(
                new int[]{5, 10, 16, -6, 15, 11, 3},
                new int[]{16, 22, 23, 23, 25, 3, -16}
        ));
    }

    static class Solution {
        public int temperatureTrend(int[] temperatureA, int[] temperatureB) {
            int len = temperatureA.length;
            int[] trend1 = new int[len];
            int[] trend2 = new int[len];
            for (int i = 1; i < len; i++) {
                if (temperatureA[i] > temperatureA[i - 1]) {
                    trend1[i - 1] = 1;
                } else if (temperatureA[i] < temperatureA[i - 1]) {
                    trend1[i - 1] = -1;
                } else {
                    trend1[i] = 0;
                }
                if (temperatureB[i] > temperatureB[i - 1]) {
                    trend2[i - 1] = 1;
                } else if (temperatureB[i] < temperatureB[i - 1]) {
                    trend2[i - 1] = -1;
                } else {
                    trend2[i] = 0;
                }
            }
            int max = 0;
            int current = 0;
            for (int i = 0; i < len - 1; i++) {
                if (trend1[i] == trend2[i]) {
                    current++;
                } else {
                    current = 0;
                }
                max = Math.max(max, current);
            }
            return max;
        }
    }

}
