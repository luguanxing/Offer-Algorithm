package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0784_字母大小写全排列 {

    public static void main(String[] args) {
        System.out.println(new Solution().letterCasePermutation("a1b2"));
        System.out.println(new Solution().letterCasePermutation("3z4"));
        System.out.println(new Solution().letterCasePermutation("C"));
    }

    static class Solution {
        List<String> res = new ArrayList<>();

        public List<String> letterCasePermutation(String s) {
            dfs(s, 0);
            return res;
        }

        private void dfs(String s, int i) {
            if (i == s.length()) {
                res.add(s);
                return;
            }
            if (Character.isAlphabetic(s.charAt(i))) {
                String newS1 = s.substring(0, i) + Character.toUpperCase(s.charAt(i)) + s.substring(i + 1);
                String newS2 = s.substring(0, i) + Character.toLowerCase(s.charAt(i)) + s.substring(i + 1);
                dfs(newS1, i + 1);
                dfs(newS2, i + 1);
            } else {
                dfs(s, i + 1);
            }
        }
    }

}
