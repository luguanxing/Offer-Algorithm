package leetcode.contest.week272;

public class Test5956_找出数组中的第一个回文字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().firstPalindrome(new String[]{"abc", "car", "ada", "racecar", "cool"}));
        System.out.println(new Solution().firstPalindrome(new String[]{"notapalindrome", "racecar"}));
        System.out.println(new Solution().firstPalindrome(new String[]{"def", "ghi"}));
    }

    static class Solution {
        public String firstPalindrome(String[] words) {
            for (String word : words) {
                if (isHui(word)) {
                    return word;
                }
            }
            return "";
        }

        private boolean isHui(String str) {
            int l = 0;
            int r = str.length() - 1;
            while (l <= r) {
                if (str.charAt(l) != str.charAt(r)) {
                    return false;
                }
                l++;
                r--;
            }
            return true;
        }
    }

}
