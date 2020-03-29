package offer;

import java.util.Stack;

public class Test31_栈的压入弹出序列 {

    public static void main(String[] args) {
        System.out.println(new Solution().IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 3, 2, 1}));
        System.out.println(new Solution().IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2}));
    }

    static class Solution {
        public boolean IsPopOrder(int[] pushA, int[] popA) {
            int current = 0;
            int match = 0;
            Stack<Integer> stack = new Stack<>();
            while (match < popA.length) {
                int target = popA[match];
                // 先找栈顶元素是否匹配target
                if (!stack.isEmpty() && stack.peek() == target) {
                    stack.pop();
                    match++;
                    continue;
                }
                // 从pushA中找到匹配target的元素
                boolean isFound = false;
                while (current < pushA.length && !isFound) {
                    if (pushA[current] == target) {
                        // 找到了直接压栈弹出
                        current++;
                        match++;
                        isFound = true;
                    } else {
                        // 找不到，压栈并继续找
                        stack.push(pushA[current]);
                        current++;
                    }
                }
                if (!isFound) {
                    return false;
                }
            }
            return true;
        }
    }

}
