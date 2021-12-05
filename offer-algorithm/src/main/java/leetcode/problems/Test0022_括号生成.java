package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0022_括号生成 {

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(3));
        System.out.println(new Solution().generateParenthesis(1));
    }

    static class Solution {
        List<String> ans = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            dfs("", 2 * n);
            return ans;
        }

        private void dfs(String current, int len) {
            if (!isOk(current, len)) {
                return;
            }
            if (current.length() > len) {
                return;
            } else if (current.length() == len) {
                ans.add(current);
            } else {
                dfs(current + ")", len);
                dfs(current + "(", len);
            }
        }

        private boolean isOk(String str, int n) {
            // 最终左括号数等于右括号数
            if (str.length() == n) {
                int left = 0;
                int right = 0;
                for (char c : str.toCharArray()) {
                    if (c == '(') {
                        left++;
                    } else {
                        right++;
                    }
                }
                if (left != right) {
                    return false;
                }
            }
            // 过程中左括号数不少于右括号数
            int left = 0;
            int right = 0;
            for (char c : str.toCharArray()) {
                if (c == '(') {
                    left++;
                } else {
                    right++;
                }
                if (left < right) {
                    return false;
                }
            }
            return true;
        }
    }

}
