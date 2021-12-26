package leetcode.problems;

public class Test0005_最长回文子串 {

    public static void main(String[] args) {
        System.out.println(new Solution().longestPalindrome("babad"));
        System.out.println(new Solution().longestPalindrome("cbbd"));
        System.out.println(new Solution().longestPalindrome("babba"));
        System.out.println(new Solution().longestPalindrome("a"));
        System.out.println(new Solution().longestPalindrome(""));
        System.out.println(new Solution().longestPalindrome(null));
    }

    static class Solution {
        public String longestPalindrome(String s) {
            String maxStr = "";
            for (int i = 0; i < s.length(); i++) {
                String str1 = findMax(s, i, i);
                String str2 = findMax(s, i, i + 1);
                if (str1.length() > maxStr.length()) {
                    maxStr = str1;
                }
                if (str2.length() > maxStr.length()) {
                    maxStr = str2;
                }
            }
            return maxStr;
        }

        private String findMax(String s, int left, int right) {
            if (left < 0 || right >= s.length() || s.charAt(left) != s.charAt(right)) {
                return "";
            }
            String current = (left == right ? "" + s.charAt(left) : s.charAt(left) + "" + s.charAt(right));
            while (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
                if (left < 0 || right >= s.length()) {
                    break;
                }
                if (s.charAt(left) == s.charAt(right)) {
                    current = s.charAt(left) + current + s.charAt(right);
                }
            }
            return current;
        }
    }

    static class Solution_Old {
        public String longestPalindrome(String s) {
            if (s == null) {
                return null;
            }
            // 动态规划isPalindrome[i][j] = ((isPalindrome[i+1][j-1]&&s[i]==s[j]) 或 ((i+1==j)&&s[i]==s[j])) ? true : false;
            int len = s.length();
            boolean[][] isPalindrome = new boolean[len][len];
            // 初始化
            for (int i = 0; i < len; i++) {
                isPalindrome[i][i] = true;
            }
            // 从下到上从左到右
            for (int y = len - 1; 0 <= y; y--) {
                for (int x = y + 1; x < len; x++) {
                    isPalindrome[y][x] = ((isPalindrome[y + 1][x - 1] || y + 1 == x) && (s.charAt(y) == s.charAt(x)));
                }
            }
            // 找最大的isPalindrome[i][j]
            int maxLen = 0;
            String maxStr = "";
            for (int i = 0; i < len; i++) {
                for (int j = i; j < len; j++) {
                    if (isPalindrome[i][j] && (maxLen < j + 1 - i)) {
                        maxLen = j + 1 - i;
                        maxStr = s.substring(i, j + 1);
                    }
                }
            }
            return maxStr;
        }
    }

    static class Solution_中心对称 {
        public String longestPalindrome(String s) {
            if (s == null) {
                return null;
            }
            // 以某个字符为中心找到并判断最长回文子串
            int maxLen = 0;
            String maxStr = "";
            for (int index = 0; index < s.length(); index++) {
                // 奇数，XAX往两边扩展，无需截取整段字符串避免内部重新判断，只需往外判断一次即可
                for (int len = 0; 0 <= index - len && index + len < s.length(); len++) {
                    char leftChar = s.charAt(index - len);
                    char rightChar = s.charAt(index + len);
                    if (leftChar != rightChar) {
                        break;
                    } else if (2 * len + 1 > maxLen) {
                        maxLen = 2 * len + 1;
                        maxStr = s.substring(index - len, index + len + 1);
                    }
                }
                // 偶数，XAXX也是往两边扩展，但是右边多一位
                for (int len = 0; 0 <= index - len && index + len + 1 < s.length(); len++) {
                    char leftChar = s.charAt(index - len);
                    char rightChar = s.charAt(index + len + 1);
                    if (leftChar != rightChar) {
                        break;
                    } else if (2 * (len + 1) > maxLen) {
                        maxLen = 2 * (len + 1);
                        maxStr = s.substring(index - len, index + len + 2);
                    }
                }
            }
            return maxStr;
        }
    }

}
