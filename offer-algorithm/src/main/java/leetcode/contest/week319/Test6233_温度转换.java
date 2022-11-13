package leetcode.contest.week319;

import java.util.Arrays;

public class Test6233_温度转换 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().convertTemperature(36.5)));
        System.out.println(Arrays.toString(new Solution().convertTemperature(122.11)));
    }

    static class Solution {
        public double[] convertTemperature(double celsius) {
            double k = celsius + 273.15;
            double f = celsius * 1.8 + 32;
            return new double[]{k, f};
        }
    }

}
