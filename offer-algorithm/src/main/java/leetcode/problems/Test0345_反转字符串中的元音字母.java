package leetcode.problems;

public class Test0345_反转字符串中的元音字母 {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseVowels("hello"));
        System.out.println(new Solution().reverseVowels("leetcode"));
        System.out.println(new Solution().reverseVowels("aA"));
    }

    static class Solution {
        public String reverseVowels(String s) {
            int left = 0;
            int right = s.length() - 1;
            char[] chars = s.toCharArray();
            while (left < right) {
                char leftChar = chars[left];
                char rightChar = chars[right];
                while (left < s.length() - 1 && !isYuanYin(leftChar)) {
                    left++;
                    leftChar = chars[left];
                }
                while (1 <= right && !isYuanYin(rightChar)) {
                    right--;
                    rightChar = chars[right];
                }
                if (left < right) {
                    chars[left] = rightChar;
                    left++;
                    chars[right] = leftChar;
                    right--;
                }
            }
            return new String(chars);
        }

        private boolean isYuanYin(char c) {
            return c == 'A' ||
                    c == 'E' ||
                    c == 'I' ||
                    c == 'O' ||
                    c == 'U' ||
                    c == 'a' ||
                    c == 'e' ||
                    c == 'i' ||
                    c == 'o' ||
                    c == 'u';
        }
    }

}
