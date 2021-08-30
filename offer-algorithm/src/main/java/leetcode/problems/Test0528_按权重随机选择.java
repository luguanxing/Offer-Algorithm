package leetcode.problems;

import java.util.Arrays;
import java.util.Random;

public class Test0528_按权重随机选择 {

    public static void main(String[] args) {
        Solution solution = new Solution(new int[]{1, 3});
        int cnt0 = 0;
        int cnt1 = 0;
        for (int i = 1; i <= 10000; i++) {
            if (solution.pickIndex() == 0) {
                cnt0++;
            } else {
                cnt1++;
            }
        }
        System.out.println(cnt0);
        System.out.println(cnt1);
    }

    static class Solution {
        double[] possibilities;
        int sum;

        public Solution(int[] w) {
            sum = Arrays.stream(w).sum();
            possibilities = new double[w.length];
            for (int i = 0; i < w.length; i++) {
                possibilities[i] = w[i] * 1.0 / sum;
            }
        }

        public int pickIndex() {
            // 搞个[0,1)随机数，看看在哪个区间即可
            double random = new Random().nextDouble();
            double current = 0;
            for (int i = 0; i < possibilities.length; i++) {
                current += possibilities[i];
                if (random < current) {
                    return i;
                }
            }
            return possibilities.length - 1;
        }
    }

}
