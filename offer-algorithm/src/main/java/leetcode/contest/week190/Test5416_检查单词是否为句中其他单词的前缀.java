package leetcode.contest.week190;

public class Test5416_检查单词是否为句中其他单词的前缀 {

    public static void main(String[] args) {
        System.out.println(new Solution().isPrefixOfWord("i love eating burger", "burg"));
        System.out.println(new Solution().isPrefixOfWord("this problem is an easy problem", "pro"));
        System.out.println(new Solution().isPrefixOfWord("i am tired", "you"));
    }

    static class Solution {
        public int isPrefixOfWord(String sentence, String searchWord) {
            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length; i++) {
                if (words[i].startsWith(searchWord)) {
                    return i + 1;
                }
            }
            return -1;
        }
    }

}
