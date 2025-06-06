package leetcode.interview;

import java.util.*;

public class Test2434_使用机器人打印字典序最小的字符串 {

    public static void main(String[] args) {
        System.out.println(new Solution().robotWithString("zza"));
        System.out.println(new Solution().robotWithString("bac"));
        System.out.println(new Solution().robotWithString("bdda"));
    }

    static class Solution {
        public String robotWithString(String s) {
            StringBuilder res = new StringBuilder();
            // 贪心策略，每次优先从后面选最小的字符，没有了或者不如栈顶才用栈
            Stack<Character> stack = new Stack<>();
            while (!s.isEmpty() || !stack.isEmpty()) {
                // 找后面最小的字符
                char nextChar = 'a';
                int nextIndex = -1;
                while (nextChar <= 'z') {
                    nextIndex = s.indexOf(String.valueOf(nextChar));
                    if (nextIndex >= 0) {
                        break;
                    }
                    nextChar++;
                }
                // 和栈顶元素比较，如果后面没有最小字符或者不如栈顶则弹出栈
                while (!stack.isEmpty() && ((nextIndex >= 0 && stack.peek() <= nextChar) || s.isEmpty())) {
                    res.append(stack.pop());
                }
                // 如果后面有最小字符则直接加入，并把中间字符串入栈
                if (nextIndex >= 0) {
                    res.append(nextChar);
                    for (int i = 0; i < nextIndex; i++) {
                        stack.push(s.charAt(i));
                    }
                    s = s.substring(nextIndex + 1);
                }
            }
            return res.toString();
        }
    }

}
