package leetcode.problems;

import java.util.Arrays;

public class Test2028_找出缺失的观测数据 {

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
                new int[]{4, 5, 6, 2, 3, 6, 5, 4, 6, 4, 5, 1, 6, 3, 1, 4, 5, 5, 3, 2, 3, 5, 3, 2, 1, 5, 4, 3, 5, 1, 5}, 4, 40
        )));
        System.out.println(Arrays.toString(new Solution().missingRolls(
                new int[]{4, 2, 2, 5, 4, 5, 4, 5, 3, 3, 6, 1, 2, 4, 2, 1, 6, 5, 4, 2, 3, 4, 2, 3, 3, 5, 4, 1, 4, 4, 5, 3, 6, 1, 5, 2, 3, 3, 6, 1, 6, 4, 1, 3}, 2, 53
        )));
        System.out.println(Arrays.toString(new Solution().missingRolls(
                new int[]{3, 5, 3}, 5, 3
        )));
    }

    static class Solution {
        public int[] missingRolls(int[] rolls, int mean, int n) {
            int totalSum = mean * (n + rolls.length);
            int rollSum = Arrays.stream(rolls).sum();
            int leftSum = totalSum - rollSum;
            // 使用剩余的n凑出leftSum
            int[] res = new int[n];
            if (leftSum / n < 1 || leftSum / n > 6) {
                return new int[]{};
            }
            Arrays.fill(res, leftSum / n);
            for (int i = 0; i < leftSum % n; i++) {
                res[i]++;
                if (res[i] > 6) {
                    return new int[]{};
                }
            }
            return res;
        }
    }

    static class Solution_OLD {
        public int[] missingRolls(int[] rolls, int mean, int n) {
            int rollLen = rolls.length;
            int rollSum = Arrays.stream(rolls).sum();
            int sum = mean * (n + rollLen);
            // 需要用n个数凑出leftSum
            int leftSum = sum - rollSum;
            if (leftSum < 0 || n * 6 < leftSum || n > leftSum) {
                return new int[]{};
            }
            int[] res = new int[n];
            Arrays.fill(res, leftSum / n);
            leftSum = leftSum - Arrays.stream(res).sum();
            for (int i = 0; i < leftSum; i++) {
                res[i]++;
            }
            return res;
        }
    }

}
