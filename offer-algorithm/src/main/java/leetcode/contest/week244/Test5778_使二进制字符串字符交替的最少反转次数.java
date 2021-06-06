package leetcode.contest.week244;

public class Test5778_使二进制字符串字符交替的最少反转次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minFlips("111000"));
        System.out.println(new Solution().minFlips("010"));
        System.out.println(new Solution().minFlips("1110"));
    }

    static class Solution {
        public int minFlips(String s) {
            // 拼接 + 滑动窗口
            int len = s.length();
            String target = "10";
            // 初始化窗口
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                cnt += (s.charAt(i) == target.charAt(i % 2)) ? 1 : 0;
            }
            // 拼接 + 移动窗口
            int ans = Math.max(cnt, len - cnt); //可能是1开头串或0开头串
            s = s + s;
            for (int i = 0; i < len; i++) {
                cnt -= (s.charAt(i) == target.charAt(i % 2)) ? 1 : 0;
                cnt += (s.charAt(i + len) == target.charAt((i + len) % 2)) ? 1 : 0;
                ans = Math.min(ans, Math.min(cnt, len - cnt));
            }
            return ans;
        }
    }

}
