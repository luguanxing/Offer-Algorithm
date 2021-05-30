package leetcode.contest.week243;

import java.math.BigInteger;

public class Test5772_检查某单词是否等于两单词之和 {

    public static void main(String[] args) {
        System.out.println(new Solution().isSumEqual("acb", "cba", "cdb"));
        System.out.println(new Solution().isSumEqual("aaa", "a", "aab"));
        System.out.println(new Solution().isSumEqual("aaa", "a", "aaaa"));
    }

    static class Solution {
        public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
            for (int i = 0; i < 10; i++) {
                firstWord = firstWord.replaceAll((char)('a' + i) + "", (char)('0' + i) + "");
                secondWord = secondWord.replaceAll((char)('a' + i) + "", (char)('0' + i) + "");
                targetWord = targetWord.replaceAll((char)('a' + i) + "", (char)('0' + i) + "");
            }
            return new BigInteger(targetWord).equals(new BigInteger(firstWord).add(new BigInteger(secondWord)));
        }
    }

}
