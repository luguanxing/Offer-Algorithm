package offer;

import java.util.Stack;

public class Test30_包含min函数的栈 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.push(5);
        solution.push(2);
        solution.push(3);
        solution.push(2);
        solution.push(1);
        System.out.println(solution.min());
        solution.pop();
        System.out.println(solution.min());
        solution.pop();
        System.out.println(solution.min());
        solution.pop();
        System.out.println(solution.min());
        solution.pop();
        System.out.println(solution.min());
    }

    static class Solution {
        Stack<Integer> sourceStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();

        public void push(int node) {
            sourceStack.push(node);
            if (!minStack.isEmpty()) {
                minStack.push(node < min() ? node : min());
            } else {
                minStack.push(node);
            }
        }

        public void pop() {
            sourceStack.pop();
            minStack.pop();
        }

        public int top() {
            return sourceStack.peek();
        }

        public int min() {
            return minStack.peek();
        }
    }

}
