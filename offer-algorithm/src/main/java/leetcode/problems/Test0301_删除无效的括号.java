package leetcode.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test0301_删除无效的括号 {

    public static void main(String[] args) {
        System.out.println(new Solution().removeInvalidParentheses("()())()"));
        System.out.println(new Solution().removeInvalidParentheses("(a)())()"));
        System.out.println(new Solution().removeInvalidParentheses(")("));

    }

    static class Solution {
        int minRemoveCnt = Integer.MAX_VALUE;
        Set<String> result = new HashSet<>();

        public List<String> removeInvalidParentheses(String s) {
            dfs(s, 0, 0);
            return new ArrayList<>(result);
        }

        private void dfs(String s, int index, int removeNum) {
            if (index > s.length()) {
                return;
            }
            if (removeNum > minRemoveCnt) {
                return;
            }
            if (isValid(s)) {
                if (removeNum < minRemoveCnt) {
                    minRemoveCnt = removeNum;
                    result.clear();
                }
                result.add(s);
                return;
            }
            for (int i = index; i < s.length(); i++) {
                if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                    dfs((i == 0 ? "" : s.substring(0, i)) + s.substring(i + 1), i, removeNum + 1);
                }
                dfs(s, i + 1, removeNum);
            }
        }


        private boolean isValid(String str) {
            int cnt = 0;
            for (char c : str.toCharArray()) {
                if (c == '(') {
                    cnt++;
                } else if (c == ')') {
                    if (cnt > 0) {
                        cnt--;
                    } else {
                        return false;
                    }
                }
            }
            return cnt == 0;
        }
    }
}
