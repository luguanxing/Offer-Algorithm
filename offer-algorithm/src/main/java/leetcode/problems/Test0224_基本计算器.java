package leetcode.problems;

import java.util.Stack;

public class Test0224_基本计算器 {

    public static void main(String[] args) {
        System.out.println(new Solution().calculate("1 + 1"));
        System.out.println(new Solution().calculate(" 2-1 + 2 "));
        System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(new Solution().calculate("2-(5-6)"));
        System.out.println(new Solution().calculate("1-(2+3-(4+(5-(1-(2+4-(5+6))))))"));
    }

    static class Solution {
        public int calculate(String s) {
            s = s.replaceAll(" ", "");
            Stack<Character> stack = new Stack<>();
            int res = 0;
            for (char c : s.toCharArray()) {
                if (c != ')') {
                    stack.push(c);
                } else {
                    int num = calculateStack(stack);
                    if (!stack.isEmpty() && (stack.peek() == '-') && num < 0) {
                        stack.pop();
                        stack.push('+');
                        num = -1 * num;
                    } else if (!stack.isEmpty() && (stack.peek() == '+') && num < 0) {
                        stack.pop();
                    }
                    for (char cc : Integer.toString(num).toCharArray()) {
                        stack.push(cc);
                    }
                }
            }
            if (!stack.isEmpty()) {
                res += calculateStack(stack);
            }
            return res;
        }

        private int calculateStack(Stack<Character> stack) {
            try {
                int sum = 0;
                String res = "";
                while (!stack.isEmpty()) {
                    char c = stack.pop();
                    if (c == '(') {
                        break;
                    }
                    if (Character.isDigit(c)) {
                        res = c + res;
                    } else {
                        if (c == '+') {
                            sum += Integer.parseInt(res);
                        } else {
                            sum -= Integer.parseInt(res);
                        }
                        res = "";
                    }
                }
                if (!res.isEmpty()) {
                    sum += Integer.parseInt(res);
                }
                return sum;
            } catch (Exception e) {
                e.printStackTrace();
                return 0;
            }
        }
    }

}
