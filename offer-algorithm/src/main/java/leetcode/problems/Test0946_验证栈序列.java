package leetcode.problems;

import java.util.Stack;

public class Test0946_验证栈序列 {

    public static void main(String[] args) {
        System.out.println(new Solution().validateStackSequences(
                new int[]{1, 2, 3, 4, 5},
                new int[]{4, 5, 3, 2, 1}
        ));
        System.out.println(new Solution().validateStackSequences(
                new int[]{1, 2, 3, 4, 5},
                new int[]{4, 3, 5, 1, 2}
        ));
    }

    static class Solution {
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            int len = popped.length;
            int pushIdx = 0;
            int popIdx = 0;
            while (popIdx < len) {
                int target = popped[popIdx];
                // 若当前栈为空，向后找
                if (stack.isEmpty()) {
                    while (pushIdx < len) {
                        stack.push(pushed[pushIdx]);
                        if (pushed[pushIdx] == target) {
                            pushIdx++;
                            stack.pop();
                            break;
                        }
                        pushIdx++;
                    }
                    popIdx++;
                    continue;
                }
                // 当前栈不为空，先找栈内
                if (stack.contains(target)) {
                    if (stack.peek() == target) {
                        stack.pop();
                        popIdx++;
                        continue;
                    } else {
                        return false;
                    }
                }
                // 当前栈不为空，找栈内找不到再向后找
                while (pushIdx < len) {
                    stack.push(pushed[pushIdx]);
                    if (pushed[pushIdx] == target) {
                        stack.pop();
                        pushIdx++;
                        break;
                    }
                    pushIdx++;
                }
                popIdx++;
            }
            return true;
        }
    }

}
