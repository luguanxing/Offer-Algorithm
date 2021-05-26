package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test1190_反转每对括号间的子串 {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseParentheses("(abcd)"));
        System.out.println(new Solution().reverseParentheses("(u(love)i)"));
        System.out.println(new Solution().reverseParentheses("(ed(et(oc))el)"));
        System.out.println(new Solution().reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    static class Solution {
        public String reverseParentheses(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c != ')') {
                    stack.push(c);
                } else {
                    List<Character> list = new ArrayList<>();
                    while (!stack.isEmpty()) {
                        char last = stack.pop();
                        if (last == '(') {
                            break;
                        }
                        list.add(last);
                    }
                    for (char p : list) {
                        stack.push(p);
                    }
                }
            }
            String res = "";
            while (!stack.isEmpty()) {
                res = stack.pop() + res;
            }
            return res;
        }
    }

}
