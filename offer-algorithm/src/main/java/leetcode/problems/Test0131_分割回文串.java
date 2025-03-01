package leetcode.problems;

import java.util.*;

public class Test0131_分割回文串 {

    public static void main(String[] args) {
        System.out.println(new Solution().partition("aab"));
        System.out.println(new Solution().partition("a"));
    }

    static class Solution {
        List<List<String>> res = new ArrayList<>();
        List<String> currents = new ArrayList<>();

        public List<List<String>> partition(String s) {
            dfs(s);
            return res;
        }

        private void dfs(String s) {
            if (s.isEmpty()) {
                res.add(new ArrayList<>(currents));
                return;
            }
            for (int i = 0; i < s.length(); i++) {
                String prefix = s.substring(0, i + 1);
                if (isPalindrome(prefix)) {
                    currents.add(prefix);
                    dfs(s.substring(i + 1));
                    currents.remove(currents.size() - 1);
                }
            }
        }

        private boolean isPalindrome(String str) {
            int len = str.length();
            for (int i = 0; i < len / 2; i++) {
                if (str.charAt(i) != str.charAt(len - i - 1)) {
                    return false;
                }
            }
            return true;
        }
    }

}
