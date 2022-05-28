package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test1021_删除最外层的括号 {

    public static void main(String[] args) {
        System.out.println(new Solution().removeOuterParentheses("(()())(())"));
        System.out.println(new Solution().removeOuterParentheses("(()())(())(()(()))"));
        System.out.println(new Solution().removeOuterParentheses("()()"));
    }

    static class Solution {
        public String removeOuterParentheses(String s) {
            List<String> list = new ArrayList<>();
            String result = "";
            int size = 0;
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    size++;
                    list.add("(");
                } else {
                    size--;
                    if (size == 0) {
                        list.remove(0);
                        result += String.join("", list);
                        list.clear();
                    } else {
                        list.add(")");
                    }
                }
            }
            return result;
        }
    }

}
