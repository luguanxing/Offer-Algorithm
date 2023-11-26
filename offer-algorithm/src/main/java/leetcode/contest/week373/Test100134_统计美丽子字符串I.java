package leetcode.contest.week373;

public class Test100134_统计美丽子字符串I {

    public static void main(String[] args) {
        // s = "baeyh", k = 2
        System.out.println(new Solution().beautifulSubstrings("baeyh", 2));
        // "abba", k = 1
        System.out.println(new Solution().beautifulSubstrings("abba", 1));
        // "bcdf", k = 1
        System.out.println(new Solution().beautifulSubstrings("bcdf", 1));
    }

    // 给你一个字符串 s 和一个正整数 k 。
    // 用 vowels 和 consonants 分别表示字符串中元音字母和辅音字母的数量。
    // 如果某个字符串满足以下条件，则称其为 美丽字符串 ：
    // vowels == consonants，即元音字母和辅音字母的数量相等。
    // (vowels * consonants) % k == 0，即元音字母和辅音字母的数量的乘积能被 k 整除。
    // 返回字符串 s 中 非空美丽子字符串 的数量。
    // 子字符串是字符串中的一个连续字符序列。
    // 英语中的 元音字母 为 'a'、'e'、'i'、'o' 和 'u' 。
    // 英语中的 辅音字母 为除了元音字母之外的所有字母。
    static class Solution {
        public int beautifulSubstrings(String s, int k) {
            int len = s.length();
            int res = 0;
            for (int l = 0; l < len; l++) {
                int vowels = 0;
                int consonants = 0;
                for (int r = l; r < len; r++) {
                    if (isVowel(s.charAt(r))) {
                        vowels++;
                    } else {
                        consonants++;
                    }
                    if (vowels == consonants && vowels * consonants % k == 0) {
                        res++;
                    }
                }
            }
            return res;
        }

        private boolean isVowel(char c) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                return true;
            }
            return false;
        }
    }

}
