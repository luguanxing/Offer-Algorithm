package leetcode.contest.week258;

public class Test5869_两个回文子序列长度的最大乘积 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxProduct("leetcodecom"));
        System.out.println(new Solution().maxProduct("bb"));
        System.out.println(new Solution().maxProduct("accbcaxxcxx"));
    }

    static class Solution {
        int max = 0;
        String s1 = "";
        String s2 = "";

        public int maxProduct(String s) {
            check(s, 0);
            return max;
        }

        private void check(String s, int index) {
            if (isHui(s1) && isHui(s2)) {
                max = Math.max(max, s1.length() * s2.length());
            }
            if (index == s.length()) {
                return;
            }
            char c = s.charAt(index);
            // 字符分配给s1
            s1 += c;
            check(s, index + 1);
            s1 = s1.substring(0, s1.length() - 1);
            // 字符分配给s2
            s2 += c;
            check(s, index + 1);
            s2 = s2.substring(0, s2.length() - 1);
            // 字符不分配
            check(s, index + 1);
        }

        private boolean isHui(String s) {
            for (int i = 0; i < s.length() / 2; i++) {
                if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }

}
