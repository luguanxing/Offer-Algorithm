package leetcode.problems;

import java.util.Arrays;

public class Test0473_火柴拼正方形 {

    public static void main(String[] args) {
        System.out.println(new Solution().makesquare(new int[]{1, 1, 2, 2, 2}));
        System.out.println(new Solution().makesquare(new int[]{3, 3, 3, 3, 4}));
        System.out.println(new Solution().makesquare(new int[]{1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 6}));
    }

    static class Solution {
        boolean result = false;

        public boolean makesquare(int[] matchsticks) {
            int sum = Arrays.stream(matchsticks).sum();
            if (sum % 4 != 0) {
                return false;
            }
            int side = sum / 4;
            if (Arrays.stream(matchsticks).max().getAsInt() > side) {
                return false;
            }
            dfs(matchsticks, 0, side, side, side, side);
            return result;
        }

        private void dfs(int[] matchsticks, int index, int left1, int left2, int left3, int left4) {
            if (index == matchsticks.length && (left1 + left2 + left3 + left4 == 0)) {
                result = true;
                return;
            }
            int current = matchsticks[index];
            if (current <= left1) {
                dfs(matchsticks, index + 1, left1 - current, left2, left3, left4);
            }
            if (current <= left2) {
                dfs(matchsticks, index + 1, left1, left2 - current, left3, left4);
            }
            if (current <= left3) {
                dfs(matchsticks, index + 1, left1, left2, left3 - current, left4);
            }
            if (current <= left4) {
                dfs(matchsticks, index + 1, left1, left2, left3, left4 - current);
            }
        }
    }

}
