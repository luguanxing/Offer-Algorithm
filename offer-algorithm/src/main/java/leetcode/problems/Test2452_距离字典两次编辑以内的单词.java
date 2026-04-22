package leetcode.problems;

import java.util.*;

public class Test2452_距离字典两次编辑以内的单词 {

    public static void main(String[] args) {
        System.out.println(new Solution().twoEditWords(
                new String[]{"word", "note", "ants", "wood"},
                new String[]{"wood", "joke", "moat"}
        ));
        System.out.println(new Solution().twoEditWords(
                new String[]{"yes"},
                new String[]{"not"}
        ));
    }

    static class Solution {
        public List<String> twoEditWords(String[] queries, String[] dictionary) {
            List<String> ans = new ArrayList<>();
            for (String query : queries) {
                for (String word : dictionary) {
                    if (lessThan2Edits(query, word)) {
                        ans.add(query);
                        break;
                    }
                }
            }
            return ans;
        }

        private boolean lessThan2Edits(String str1, String str2) {
            int len = str1.length();
            int total = 0;
            for (int i = 0; i < len; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    total++;
                }
            }
            return total <= 2;
        }
    }

}
