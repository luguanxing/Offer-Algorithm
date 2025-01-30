package leetcode.problems;

public class Test0541_反转字符串II {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseStr("abcdefg", 2));
        System.out.println(new Solution().reverseStr("abcd", 2));
    }

    static class Solution {
        public String reverseStr(String s, int k) {
            StringBuilder ss = new StringBuilder(s);
            StringBuilder sb = new StringBuilder();
            while (ss.length() != 0) {
                String str = ss.substring(0, Math.min(2 * k, ss.length()));
                ss.delete(0, Math.min(2 * k, ss.length()));
                if (str.length() <= k) {
                    sb.append(new StringBuilder(str).reverse());
                } else {
                    sb.append(new StringBuilder(str.substring(0, k)).reverse());
                    sb.append(str.substring(k));
                }
            }
            return sb.toString();
        }
    }

}
