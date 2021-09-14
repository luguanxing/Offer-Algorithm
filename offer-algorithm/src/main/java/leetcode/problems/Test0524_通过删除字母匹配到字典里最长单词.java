package leetcode.problems;

import java.util.Arrays;
import java.util.List;

public class Test0524_通过删除字母匹配到字典里最长单词 {

    public static void main(String[] args) {
        System.out.println(new Solution().findLongestWord(
                "abpcplea", Arrays.asList("ale", "apple", "monkey", "plea")
        ));
        System.out.println(new Solution().findLongestWord(
                "abpcplea", Arrays.asList("a", "b", "c")
        ));
    }

    static class Solution {
        public String findLongestWord(String s, List<String> dictionary) {
            String res = "";
            int max = 0;
            for (String str : dictionary) {
                // 找出最长子序列即可
                int current = isSubstr(s, str);
                if (current > max) {
                    max = current;
                    res = str;
                } else if (current == max) {
                    if (str.compareTo(res) < 0) {
                        res = str;
                    }
                }
            }
            return res;
        }

        private int isSubstr(String s, String str) {
            int match = 0;
            char[] chars1 = s.toCharArray();
            char[] chars2 = str.toCharArray();
            int index1 = 0;
            int index2 = 0;
            while (index1 < chars1.length && index2 < chars2.length) {
                if (chars1[index1] == chars2[index2]) {
                    index1++;
                    index2++;
                    match++;
                } else {
                    index1++;
                }
            }
            if (index2 != chars2.length) {
                return 0;
            }
            return match;
        }
    }

}
