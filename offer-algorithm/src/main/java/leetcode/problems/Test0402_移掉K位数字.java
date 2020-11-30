package leetcode.problems;

import java.util.Stack;

public class Test0402_移掉K位数字 {

    public static void main(String[] args) {
        System.out.println(new Solution().removeKdigits("1432219", 3));
        System.out.println(new Solution().removeKdigits("10200", 1));
        System.out.println(new Solution().removeKdigits("10", 2));
        System.out.println(new Solution().removeKdigits("9", 1));
    }

    static class Solution {
        public String removeKdigits(String num, int k) {
            // 单调栈，尽量保留更小的
            Stack<Character> stack = new Stack<>();
            for (char c : num.toCharArray()) {
                while (!stack.isEmpty() && c < stack.peek() && k > 0) {
                    stack.pop();
                    k--;
                }
                stack.push(c);
            }
            while (k-- > 0) {
                stack.pop();
            }
            // 反向输出并去掉前置的0
            String res = "";
            while (!stack.isEmpty()) {
                res = stack.pop() + res;
            }
            while (res.length() > 1 && res.startsWith("0")) {
                res = res.substring(1);
            }
            return res.isEmpty() ? "0" : res;
        }
    }

}
