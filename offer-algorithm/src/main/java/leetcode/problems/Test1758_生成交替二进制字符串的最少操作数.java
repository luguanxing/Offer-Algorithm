package leetcode.problems;

public class Test1758_生成交替二进制字符串的最少操作数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minOperations("0100"));
        System.out.println(new Solution().minOperations("10"));
        System.out.println(new Solution().minOperations("1111"));
        System.out.println(new Solution().minOperations("10010100"));
        System.out.println(new Solution().minOperations("1000"));
    }

    static class Solution {
        public int minOperations(String s) {
            // 直接从结果出发，比改成对1开头串和0开头串的代价
            String s1 = "1";
            String s2 = "0";
            for (int i = 1; i < s.length(); i++) {
                s1 += s1.charAt(i - 1) == '1' ? '0' : '1';
                s2 += s2.charAt(i - 1) == '1' ? '0' : '1';
            }
            int cnt1 = compare(s, s1);
            int cnt2 = compare(s, s2);
            return Math.min(cnt1, cnt2);
        }

        private int compare(String s, String s1) {
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != s1.charAt(i)) {
                    cnt++;
                }
            }
            return cnt;
        }
    }

}
