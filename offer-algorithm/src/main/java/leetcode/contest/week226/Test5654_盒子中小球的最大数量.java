package leetcode.contest.week226;

import java.util.Arrays;

public class Test5654_盒子中小球的最大数量 {

    public static void main(String[] args) {
        System.out.println(new Solution().countBalls(1, 10));
        System.out.println(new Solution().countBalls(5, 15));
        System.out.println(new Solution().countBalls(19, 28));
    }

    static class Solution {
        public int countBalls(int lowLimit, int highLimit) {
            int[] box = new int[10005];
            for (int i = lowLimit; i <= highLimit; i++) {
                int sum = 0;
                int num = i;
                while (num > 0) {
                    sum += num % 10;
                    num /= 10;
                }
                box[sum]++;
            }
            return Arrays.stream(box).max().orElse(0);
        }
    }

}
