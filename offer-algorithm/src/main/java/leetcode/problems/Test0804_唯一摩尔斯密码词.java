package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Test0804_唯一摩尔斯密码词 {

    public static void main(String[] args) {
        System.out.println(new Solution().uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
        System.out.println(new Solution().uniqueMorseRepresentations(new String[]{"a"}));
    }

    static class Solution {
        public int uniqueMorseRepresentations(String[] words) {
            String[] tables = new String[]{".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
            Set<String> set = new HashSet<>();
            for (String word : words) {
                String wordRes = "";
                for (char c : word.toCharArray()) {
                    wordRes += tables[c - 'a'];
                }
                set.add(wordRes);
            }
            return set.size();
        }
    }

}
