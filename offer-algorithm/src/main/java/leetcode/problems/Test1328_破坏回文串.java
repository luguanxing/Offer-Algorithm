package leetcode.problems;

public class Test1328_破坏回文串 {

    public static void main(String[] args) {
        System.out.println(new Solution().breakPalindrome("abccba"));
        System.out.println(new Solution().breakPalindrome("a"));
        System.out.println(new Solution().breakPalindrome("aa"));
    }

    static class Solution_直接处理 {
        public String breakPalindrome(String palindrome) {
            int n = palindrome.length();
            if (n == 1) {
                return "";
            }
            char[] data = palindrome.toCharArray();
            for (int i = 0; i * 2 + 1 < n; i++) {
                if (data[i] != 'a') {
                    data[i] = 'a';
                    return new String(data);
                }
            }
            data[n - 1] = 'b';
            return new String(data);
        }
    }

    static class Solution {
        public String breakPalindrome(String palindrome) {
            int len = palindrome.length();
            String res = "";
            for (int i = 0; i < len; i++) {
                for (char c = 'a'; c <= 'z'; c++) {
                    char[] chars = palindrome.toCharArray();
                    chars[i] = c;
                    String current = new String(chars);
                    if (!isPalindrome(current) && (current.compareTo(res) < 0 || res.isEmpty())) {
                        res = current;
                    }
                }
            }
            return res;
        }

        private boolean isPalindrome(String str) {
            int l = 0;
            int r = str.length() - 1;
            while (l < r) {
                if (str.charAt(l++) != str.charAt(r--)) {
                    return false;
                }
            }
            return true;
        }
    }

}
