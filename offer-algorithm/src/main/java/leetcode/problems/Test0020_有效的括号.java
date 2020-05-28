package leetcode.problems;

import java.util.Stack;

public class Test0020_有效的括号 {

    public static void main(String[] args) {
        System.out.println(new Solution().isValid("()"));
        System.out.println(new Solution().isValid("()[]{}"));
        System.out.println(new Solution().isValid("(]"));
        System.out.println(new Solution().isValid("([)]"));
        System.out.println(new Solution().isValid("{[]}"));
    }

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (Character c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else {
                    if (c == ')') {
                        if (!stack.isEmpty() && stack.pop() == '(') {
                            continue;
                        }
                    } else if (c == '}') {
                        if (!stack.isEmpty() && stack.pop() == '{') {
                            continue;
                        }
                    } else {
                        if (!stack.isEmpty() && stack.pop() == '[') {
                            continue;
                        }
                    }
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }

}
