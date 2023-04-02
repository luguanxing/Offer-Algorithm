package leetcode.contest.week339;

public class Test6362_最长平衡子字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().findTheLongestBalancedSubstring("01000111"));
        System.out.println(new Solution().findTheLongestBalancedSubstring("00111"));
        System.out.println(new Solution().findTheLongestBalancedSubstring("111"));
    }

    static class Solution {
        public int findTheLongestBalancedSubstring(String s) {
            int res = 0;
            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j <= s.length(); j++) {
                    String subStr = s.substring(i, j);
                    if (isOk(subStr)) {
                        res = Math.max(res, subStr.length());
                    }
                }
            }
            return res;
        }

        private boolean isOk(String subStr) {
            int idx = subStr.indexOf("1");
            if (idx < 0) {
                return false;
            }
            int cnt0=0;
            int cnt1=0;
            for (int i = 0; i < idx; i++) {
                if (subStr.charAt(i) == '1') {
                    return false;
                }
                cnt0++;
            }
            for (int i = idx; i < subStr.length(); i++) {
                if (subStr.charAt(i) == '0') {
                    return false;
                }
                cnt1++;
            }
            return cnt0==cnt1;
        }
    }

}
