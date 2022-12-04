package leetcode.contest.week322;

public class Test6253_回环句 {

    public static void main(String[] args) {
        System.out.println(new Solution().isCircularSentence("leetcode exercises sound delightful"));
        System.out.println(new Solution().isCircularSentence("eetcode"));
        System.out.println(new Solution().isCircularSentence("Leetcode is cool"));
    }

    static class Solution {
        public boolean isCircularSentence(String sentence) {
            int len = sentence.length();
            String[] words = sentence.split(" ");
            for (int i = 0; i < words.length - 1; i++) {
                String w1 = words[i];
                String w2 = words[i + 1];
                if (w1.charAt(w1.length() - 1) != w2.charAt(0)) {
                    return false;
                }
            }
            return sentence.charAt(0) == sentence.charAt(len - 1);
        }
    }

}
