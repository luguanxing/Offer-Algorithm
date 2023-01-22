package leetcode.contest.week329;

public class Test6298_执行逐位运算使字符串相等 {

    public static void main(String[] args) {
        System.out.println(new Solution().makeStringsEqual("1010", "0110"));
        System.out.println(new Solution().makeStringsEqual("11", "00"));
        System.out.println(new Solution().makeStringsEqual("001000", "000100"));
        System.out.println(new Solution().makeStringsEqual("001000", "000000"));
        System.out.println(new Solution().makeStringsEqual("001000", "001100"));
        System.out.println(new Solution().makeStringsEqual("001000", "001101"));
        System.out.println(new Solution().makeStringsEqual("001001", "000101"));
    }

    static class Solution {
        public boolean makeStringsEqual(String s, String target) {
            int len = s.length();
            int l1 = 0, r1 = 0;
            for (char c : s.toCharArray()) {
                if (c == '1') {
                    r1++;
                }
            }
            if (l1 + r1 == 1 && target.contains("1")) {
                return true;
            }
            char[] sChars = s.toCharArray();
            char[] tChars = target.toCharArray();
            for (int i = 0; i < len; i++) {
                char sc = sChars[i];
                char tc = tChars[i];
                if (sc == '1' && tc == '1') {
                    r1--;
                    l1++;
                } else if (sc == '1' && tc == '0') {
                    r1--;
                    if (r1 <= 0 && l1 <= 0) {
                        return false;
                    }
                } else if (sc == '0' && tc == '0') {

                } else if (sc == '0' && tc == '1') {
                    if (r1 <= 0 && l1 <= 0) {
                        return false;
                    }
                    l1++;
                }
            }
            return true;
        }
    }

}
