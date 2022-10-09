package leetcode.problems;

import java.util.Stack;

public class Test0856_括号的分数 {

    public static void main(String[] args) {
        System.out.println(new Solution().scoreOfParentheses("()"));
        System.out.println(new Solution().scoreOfParentheses("(())"));
        System.out.println(new Solution().scoreOfParentheses("()()"));
        System.out.println(new Solution().scoreOfParentheses("(()(()))"));
    }

    static class Solution {
        public int scoreOfParentheses(String s) {
            Stack<String> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.add("(");
                    continue;
                }
                int sum = 0;
                while (!stack.isEmpty()) {
                    String pop = stack.pop();
                    if (!pop.equals("(")) {
                        sum += Integer.parseInt(pop);
                    } else {
                        sum = sum == 0 ? 1 : sum * 2;
                        stack.add(String.valueOf(sum));
                        break;
                    }
                }
            }
            return stack.stream().map(Integer::parseInt).reduce(Integer::sum).get();
        }
    }

}
