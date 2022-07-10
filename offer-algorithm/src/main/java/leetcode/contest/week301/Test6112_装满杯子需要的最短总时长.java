package leetcode.contest.week301;

import java.util.Arrays;

public class Test6112_装满杯子需要的最短总时长 {

    public static void main(String[] args) {
        System.out.println(new Solution().fillCups(new int[]{1, 4, 2}));
        System.out.println(new Solution().fillCups(new int[]{5, 4, 4}));
        System.out.println(new Solution().fillCups(new int[]{5, 0, 0}));
    }

    static class Solution {
        public int fillCups(int[] amount) {
            int cnt = 0;
            while (Arrays.stream(amount).sum() > 0) {
                Arrays.sort(amount);
                if (amount[2] > 0 && amount[1] > 0) {
                    amount[2]--;
                    amount[1]--;
                } else {
                    amount[2]--;
                }
                cnt++;
            }
            return cnt;
        }
    }

}
