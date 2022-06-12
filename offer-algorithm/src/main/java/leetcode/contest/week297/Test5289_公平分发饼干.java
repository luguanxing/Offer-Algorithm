package leetcode.contest.week297;

import java.util.Arrays;

public class Test5289_公平分发饼干 {

    public static void main(String[] args) {
        System.out.println(new Solution().distributeCookies(
                new int[]{8, 15, 10, 20, 8},
                2
        ));
        System.out.println(new Solution().distributeCookies(
                new int[]{6, 1, 3, 2, 2, 4, 1, 2},
                3
        ));
        System.out.println(new Solution().distributeCookies(
                new int[]{20, 13, 18},
                2
        ));
    }

    static class Solution {
        int min = Integer.MAX_VALUE;

        public int distributeCookies(int[] cookies, int k) {
            dfs(cookies, 0, new int[k]);
            return min;
        }

        private void dfs(int[] cookies, int index, int[] currentState) {
            if (Arrays.stream(currentState).max().getAsInt() > min) {
                return;
            }
            if (index == cookies.length) {
                min = Math.min(min, Arrays.stream(currentState).max().getAsInt());
                return;
            }
            // 第index个饼干给任意一个小孩
            int cookie = cookies[index];
            for (int i = 0; i < currentState.length; i++) {
                currentState[i] += cookie;
                dfs(cookies, index + 1, currentState);
                currentState[i] -= cookie;
            }
        }
    }

}
