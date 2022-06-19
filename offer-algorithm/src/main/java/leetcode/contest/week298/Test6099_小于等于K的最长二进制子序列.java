package leetcode.contest.week298;

public class Test6099_小于等于K的最长二进制子序列 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestSubsequence("1001010", 5));
        System.out.println(new Solution().longestSubsequence("00101001", 1));
        System.out.println(new Solution().longestSubsequence("1", 215358216));
    }

    static class Solution {
        public int longestSubsequence(String s, int k) {
            // 统计左边0个数
            int len = s.length();
            int[] zeroCnt = new int[len];
            zeroCnt[0] = s.charAt(0) == '0' ? 1 : 0;
            for (int i = 1; i < len; i++) {
                zeroCnt[i] = zeroCnt[i - 1] + (s.charAt(i) == '0' ? 1 : 0);
            }
            // 右边小于K的二进制串+左边0个数
            int max = 0;
            for (int index = len - 1; index >= 0; index--) {
                for (int right = 1; index + right <= len; right++) {
                    String subStr = s.substring(index, index + right);
                    if (Integer.parseInt(subStr, 2) <= k) {
                        max = Math.max(max, (index == 0 ? 0 : zeroCnt[index - 1]) + subStr.length());
                    } else {
                        break;
                    }
                }
            }
            return max;
        }
    }

}
