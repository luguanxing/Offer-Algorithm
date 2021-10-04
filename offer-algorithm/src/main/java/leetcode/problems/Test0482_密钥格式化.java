package leetcode.problems;

public class Test0482_密钥格式化 {

    public static void main(String[] args) {
        System.out.println(new Solution().licenseKeyFormatting("5F3Z-2e-9-w", 4));
        System.out.println(new Solution().licenseKeyFormatting("2-5g-3-J", 2));
    }

    static class Solution {
        public String licenseKeyFormatting(String s, int k) {
            String str = s.toUpperCase().replaceAll("-", "");
            int mod = str.length() % k;
            String res = "";
            if (mod > 0) {
                for (int i = 0; i < mod; i++) {
                    res += str.charAt(0);
                    str = str.substring(1);
                }
                res += "-";
            }
            int count = 0;
            while (!str.isEmpty()) {
                res += str.charAt(0);
                str = str.substring(1);
                count++;
                if (count == k) {
                    count = 0;
                    res += "-";
                }
            }
            if (res.endsWith("-")) {
                res = res.substring(0, res.length() - 1);
            }
            return res;
        }
    }

}
