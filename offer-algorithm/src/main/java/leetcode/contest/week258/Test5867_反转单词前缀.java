package leetcode.contest.week258;

public class Test5867_反转单词前缀 {

    public static void main(String[] args) {
        System.out.println(new Solution().reversePrefix("abcdefd", 'd'));
        System.out.println(new Solution().reversePrefix("xyxzxe", 'z'));
        System.out.println(new Solution().reversePrefix("abcd", 'z'));
    }

    static class Solution {
        public String reversePrefix(String word, char ch) {
            int index = word.indexOf(ch);
            if (index == -1) {
                return word;
            }
            return new StringBuilder(word.substring(0, index + 1)).reverse().toString() + word.substring(index + 1);
        }
    }

}
