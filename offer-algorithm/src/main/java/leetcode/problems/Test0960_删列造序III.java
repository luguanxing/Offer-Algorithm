package leetcode.problems;

import java.util.Arrays;

public class Test0960_删列造序III {

    public static void main(String[] args) {
        // strs = ["babca","bbazb"]
        System.out.println(new Solution().minDeletionSize(new String[]{"babca", "bbazb" }));
        // strs = ["edcba"]
        System.out.println(new Solution().minDeletionSize(new String[]{"edcba" }));
        // strs = ["ghi","def","abc"]
        System.out.println(new Solution().minDeletionSize(new String[]{"ghi", "def", "abc" }));
        // strs = ["abbba"]
        System.out.println(new Solution().minDeletionSize(new String[]{"abbba" }));
    }

    static class Solution {
        public int minDeletionSize(String[] strs) {
            int height = strs.length;
            int width = strs[0].length();
            // dp[i] 表示以第 i 行结尾的最长递增子序列长度
            // dp[i] = max(dp[j]) + 1, 0 <= j < i && 所有str[k][j]<=str[k][i]
            int[] dp = new int[width];
            dp[0] = 1;
            for (int i = 0; i < width; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    boolean isAllOk = true;
                    for (int row = 0; row < height; row++) {
                        if (strs[row].charAt(j) > strs[row].charAt(i)) {
                            isAllOk = false;
                            break;
                        }
                    }
                    if (isAllOk) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            return width - Arrays.stream(dp).max().getAsInt();
        }
    }

}
