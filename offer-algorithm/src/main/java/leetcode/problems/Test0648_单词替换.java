package leetcode.problems;

import java.util.*;

public class Test0648_单词替换 {

    public static void main(String[] args) {
        System.out.println(new Solution().replaceWords(
                Arrays.asList("cat", "bat", "rat"),
                "the cattle was rattled by the battery"
        ));
        System.out.println(new Solution().replaceWords(
                Arrays.asList("a", "b", "c"),
                "aadsfasf absbs bbab cadsfafs"
        ));
        System.out.println(new Solution().replaceWords(
                Arrays.asList("a", "aa", "aaa", "aaaa"),
                "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"
        ));
        System.out.println(new Solution().replaceWords(
                Arrays.asList("catt","cat","bat","rat"),
                "the cattle was rattled by the battery"
        ));
    }

    static class Solution {
        public String replaceWords(List<String> dictionary, String sentence) {
            Collections.sort(dictionary, (str1, str2) -> {
                if (str1.length() != str2.length()) {
                    return Integer.compare(str1.length(), str2.length());
                } else {
                    return str1.compareTo(str2);
                }
            });
            List<String> result = new ArrayList<>();
            for (String word : sentence.split(" ")) {
                boolean isMatch = false;
                for (String prefix : dictionary) {
                    if (word.startsWith(prefix)) {
                        result.add(prefix);
                        isMatch = true;
                        break;
                    }
                }
                if (!isMatch) {
                    result.add(word);
                }
            }
            return String.join(" ", result);
        }
    }

}
