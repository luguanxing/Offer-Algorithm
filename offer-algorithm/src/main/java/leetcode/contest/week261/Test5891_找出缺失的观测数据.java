package leetcode.contest.week261;

import java.util.Arrays;

public class Test5891_找出缺失的观测数据 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().missingRolls(
                new int[]{3, 2, 4, 3}, 4, 2
        )));
        System.out.println(Arrays.toString(new Solution().missingRolls(
                new int[]{1, 5, 6}, 3, 4
        )));
        System.out.println(Arrays.toString(new Solution().missingRolls(
                new int[]{1, 2, 3, 4}, 6, 4
        )));
        System.out.println(Arrays.toString(new Solution().missingRolls(
                new int[]{1}, 3, 1
        )));
        System.out.println(Arrays.toString(new Solution().missingRolls(
                new int[]{6, 3, 4, 3, 5, 3}, 1, 6
        )));
        System.out.println(Arrays.toString(new Solution().missingRolls(
                new int[]{4,2,2,5,4,5,4,5,3,3,6,1,2,4,2,1,6,5,4,2,3,4,2,3,3,5,4,1,4,4,5,3,6,1,5,2,3,3,6,1,6,4,1,3}, 2, 53
        )));
    }

    static class Solution {
        public int[] missingRolls(int[] rolls, int mean, int n) {
            int m = rolls.length;
            int sum = Arrays.stream(rolls).sum();
            int total = mean * (m + n);
            int left = total - sum;
            // n个数字和要达到left
            if (n * 6 < left || left < 0 || left < n) {
                return new int[]{};
            }
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i]++;
                left--;
            }
            int index = 0;
            while (left > 0) {
                if (left <= 5) {
                    res[index] += left;
                    break;
                } else {
                    res[index++] += 5;
                    left -= 5;
                }
            }
            return res;
        }
    }

}
