package offer;

public class Test_左旋转字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().LeftRotateString("abcXYZdef", 3));
        System.out.println(new Solution().LeftRotateString("", 6));
    }

    static class Solution {
        public String LeftRotateString(String str, int n) {
            if (str == null) {
                return null;
            }
            if (str.length() == 0) {
                return str;
            }
            // 移动位数取余
            n = n % str.length();
            return str.substring(n, str.length()) + str.substring(0, n);
        }
    }

}
