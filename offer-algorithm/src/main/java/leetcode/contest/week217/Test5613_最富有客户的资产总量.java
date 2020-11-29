package leetcode.contest.week217;

import java.util.Arrays;

public class Test5613_最富有客户的资产总量 {

    public static void main(String[] args) {

    }

    static class Solution {
        public int maximumWealth(int[][] accounts) {
            int max = 0;
            for (int[] account : accounts) {
                int sum = Arrays.stream(account).sum();
                max = Math.max(max, sum);
            }
            return max;
        }
    }

}
