package leetcode.contest.week339;

import java.util.Arrays;
import java.util.Comparator;

public class Test6364_老鼠和奶酪 {

    public static void main(String[] args) {
        System.out.println(new Solution().miceAndCheese(new int[]{1, 1, 3, 4}, new int[]{4, 4, 1, 1}, 2));
        System.out.println(new Solution().miceAndCheese(new int[]{1}, new int[]{4}, 1));
        System.out.println(new Solution().miceAndCheese(new int[]{2, 1}, new int[]{1, 2}, 1));
        System.out.println(new Solution().miceAndCheese(new int[]{2, 1}, new int[]{6, 2}, 1));
    }

    static class Solution {
        public int miceAndCheese(int[] reward1, int[] reward2, int k) {
            int len = reward1.length;
            int[][] tuples = new int[len][2];
            for (int i = 0; i < len; i++) {
                tuples[i][0] = reward1[i];
                tuples[i][1] = reward2[i];
            }
            // 让tuple[i][1]尽可能小tuple[i][0]尽可能大
            Arrays.sort(tuples, Comparator.comparingInt(o -> o[1] - o[0]));
            int res = Arrays.stream(reward2).sum();
            for (int i = 0; i < k; i++) {
                res += tuples[i][0] - tuples[i][1];
            }
            return res;
        }
    }

    static class Solution_dfs {
        int max = 0;

        public int miceAndCheese(int[] reward1, int[] reward2, int k) {
            dfs(reward1, reward2, k - 1, 1, reward1[0]);
            dfs(reward1, reward2, k, 1, reward2[0]);
            return max;
        }

        private void dfs(int[] reward1, int[] reward2, int k, int idx, int sum) {
            int len = reward1.length;
            if (idx == len) {
                if (k == 0) {
                    max = Math.max(max, sum);
                }
                return;
            }
            dfs(reward1, reward2, k - 1, idx + 1, sum + reward1[idx]);
            dfs(reward1, reward2, k, idx + 1, sum + reward2[idx]);
        }
    }

}
