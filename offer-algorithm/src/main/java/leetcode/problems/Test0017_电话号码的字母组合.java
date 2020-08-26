package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0017_电话号码的字母组合 {

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations(""));
        System.out.println(new Solution().letterCombinations("23"));
        System.out.println(new Solution().letterCombinations("239"));
    }

    static class Solution {
        private List<String> result = new ArrayList<>();

        public List<String> letterCombinations(String digits) {
            if (!digits.isEmpty()) {
                dfs(digits, "");
            }
            return result;
        }

        private void dfs(String digits, String current) {
            if (digits.isEmpty()) {
                result.add(current);
                return;
            }
            char c = digits.charAt(0);
            String lastDigits = digits.substring(1);
            if ('2' <= c && c <= '6') {
                dfs(lastDigits, current + (char) ((c - '2') * 3 + 'a'));
                dfs(lastDigits, current + (char) ((c - '2') * 3 + 'b'));
                dfs(lastDigits, current + (char) ((c - '2') * 3 + 'c'));
            } else if (c == '7') {
                dfs(lastDigits, current + 'p');
                dfs(lastDigits, current + 'q');
                dfs(lastDigits, current + 'r');
                dfs(lastDigits, current + 's');
            } else if (c == '8') {
                dfs(lastDigits, current + 't');
                dfs(lastDigits, current + 'u');
                dfs(lastDigits, current + 'v');
            } else if (c == '9') {
                dfs(lastDigits, current + 'w');
                dfs(lastDigits, current + 'x');
                dfs(lastDigits, current + 'y');
                dfs(lastDigits, current + 'z');
            }
        }
    }

}
