package leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test0966_元音拼写检查器 {

    public static void main(String[] args) {
        // wordlist = ["KiTe","kite","hare","Hare"], queries = ["kite","Kite","KiTe","Hare","HARE","Hear","hear","keti","keet","keto"]
        System.out.println(Arrays.toString(new Solution().spellchecker(
                new String[]{"KiTe", "kite", "hare", "Hare"},
                new String[]{"kite", "Kite", "KiTe", "Hare", "HARE", "Hear", "hear", "keti", "keet", "keto"}
        )));
        // wordlist = ["yellow"], queries = ["YellOw"]
        System.out.println(Arrays.toString(new Solution().spellchecker(
                new String[]{"yellow"},
                new String[]{"YellOw"}
        )));
    }

    static class Solution {
        public String[] spellchecker(String[] wordlist, String[] queries) {
            int len = queries.length;
            Set<String> wordSet = new HashSet<>(Arrays.asList(wordlist));
            String[] res = new String[len];
            Arrays.fill(res, "");
            for (int i = 0; i < len; i++) {
                String query = queries[i];
                // 1. 全匹配
                if (wordSet.contains(query)) {
                    res[i] = query;
                    continue;
                }
                // 2. 大小写不敏感匹配
                boolean isMatched = false;
                for (String word : wordlist) {
                    if (word.equalsIgnoreCase(query)) {
                        res[i] = word;
                        isMatched = true;
                        break;
                    }
                }
                if (isMatched) {
                    continue;
                }
                // 3. 元音错误匹配
                for (String word : wordlist) {
                    if (word.length() != query.length()) {
                        continue;
                    }
                    boolean isVowelMatched = true;
                    for (int j = 0; j < word.length(); j++) {
                        char c1 = word.charAt(j);
                        char c2 = query.charAt(j);
                        if (c1 == c2 || Character.toLowerCase(c1) == Character.toLowerCase(c2)) {
                            continue;
                        }
                        if (isVowel(c1) && isVowel(c2)) {
                            continue;
                        }
                        isVowelMatched = false;
                        break;
                    }
                    if (isVowelMatched) {
                        res[i] = word;
                        isMatched = true;
                        break;
                    }
                }
            }
            return res;
        }

        private boolean isVowel(char c) {
            return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
                    || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
        }
    }

}
