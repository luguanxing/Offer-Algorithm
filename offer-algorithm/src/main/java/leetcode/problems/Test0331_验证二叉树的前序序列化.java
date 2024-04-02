package leetcode.problems;

import java.util.*;

public class Test0331_验证二叉树的前序序列化 {

    public static void main(String[] args) {
        System.out.println(new Solution().isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(new Solution().isValidSerialization("1,#"));
        System.out.println(new Solution().isValidSerialization("9,#,#,1"));
        System.out.println(new Solution().isValidSerialization("#"));
        System.out.println(new Solution().isValidSerialization("9,3,4,#,#,1,#,#,#,2,#,6,#,#"));
    }

    static class Solution {
        public boolean isValidSerialization(String preorder) {
            if (preorder.equals("#")) {
                return true;
            }
            String[] words = preorder.split(",");
            Stack<Integer> stack = new Stack<>();
            for (int i = 0; i < words.length; i++) {
                String word = words[i];
                // 是数字直接放入
                if (!word.equals("#")) {
                    stack.push(2);
                    continue;
                }
                // 不是数字，是#，用来消除栈顶元素（若栈顶为0有可能连续消）
                if (stack.isEmpty()) {
                    return false;
                }
                stack.push(stack.pop() - 1);
                while (!stack.isEmpty() && stack.peek() == 0) {
                    stack.pop();
                    if (!stack.isEmpty()) {
                        stack.push(stack.pop() - 1);
                    }
                }
                if (stack.isEmpty() && i != words.length - 1) {
                    return false;
                }
            }
            return stack.isEmpty();
        }
    }

}
