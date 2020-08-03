package leetcode.problems;

public class Test0415_字符串相加 {

    public static void main(String[] args) {
        System.out.println(new Solution().addStrings("123", "77"));
        System.out.println(new Solution().addStrings("666", "123"));
        System.out.println(new Solution().addStrings("9", "1"));
    }

    static class Solution {
        public String addStrings(String num1, String num2) {
            // 先翻转便于进位
            StringBuilder sb1 = new StringBuilder(num1).reverse();
            StringBuilder sb2 = new StringBuilder(num2).reverse();
            // 叠加对应位置的数
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Math.max(sb1.length(), sb2.length()); i++) {
                int pos = 0;
                if (i < sb.length()) {
                    // 已有进位的情况
                    pos = 1;
                    sb.deleteCharAt(sb.length() - 1);
                }
                if (i < sb1.length()) {
                    pos += sb1.charAt(i) - '0';
                }
                if (i < sb2.length()) {
                    pos += sb2.charAt(i) - '0';
                }
                if (pos < 10) {
                    // 无进位
                    sb.append(pos);
                } else {
                    // 有进位
                    sb.append(pos - 10);
                    sb.append(1);
                }
            }
            return sb.reverse().toString();
        }
    }

}
