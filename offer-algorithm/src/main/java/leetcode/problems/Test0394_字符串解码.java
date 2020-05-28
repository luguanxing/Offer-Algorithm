package leetcode.problems;

import java.util.Stack;

public class Test0394_字符串解码 {

    public static void main(String[] args) {
        System.out.println(new Solution().decodeString("3[a]2[bc]"));
        System.out.println(new Solution().decodeString("3[a2[c]]"));
        System.out.println(new Solution().decodeString("2[abc]3[cd]ef"));
    }

    static class Solution {
        public String decodeString(String s) {
            StringBuilder result = new StringBuilder();
            Stack<Character> stack = new Stack<>();
            for (Character c : s.toCharArray()) {
                if (c != ']') {
                    // 不是反括号]则压栈
                    stack.push(c);
                } else {
                    // 是反括号则出栈里[后的字符串
                    StringBuilder strSb = new StringBuilder();
                    while (!stack.isEmpty() && Character.isAlphabetic(stack.peek())) {
                        Character ch = stack.pop();
                        strSb.insert(0, ch);
                    }
                    // 出栈正括号[
                    stack.pop();
                    // 出栈字符串前的数字
                    StringBuilder numSb = new StringBuilder();
                    while (!stack.isEmpty() && Character.isDigit(stack.peek())) {
                        Character ch = stack.pop();
                        numSb.insert(0, ch);
                    }
                    // 组成新的字符串重新压栈
                    String str = strSb.toString();
                    int num = Integer.parseInt(numSb.toString());
                    while (num-- > 0) {
                        for (Character ch : str.toCharArray()) {
                            stack.push(ch);
                        }
                    }
                }
            }
            // 返回最终结果
            stack.listIterator().forEachRemaining(result::append);
            return result.toString();
        }
    }

}
