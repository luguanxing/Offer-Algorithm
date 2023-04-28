package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test1172_餐盘栈 {

    public static void main(String[] args) {
        DinnerPlates D = new DinnerPlates(2);
        D.push(1);
        D.push(2);
        D.push(3);
        D.push(4);
        D.push(5);
        System.out.println(D.popAtStack(0));
        D.push(20);
        D.push(21);
        System.out.println(D.popAtStack(0));
        System.out.println(D.popAtStack(2));
        System.out.println(D.pop());
        System.out.println(D.pop());
        System.out.println(D.pop());
        System.out.println(D.pop());
        System.out.println(D.pop());
    }

    static class DinnerPlates {
        List<Stack<Integer>> stacks;
        int capactiy;
        int total;

        public DinnerPlates(int capacity) {
            stacks = new ArrayList<>();
            this.capactiy = capacity;
            this.total = 0;
        }

        public void push(int val) {
            total++;
            for (Stack<Integer> stack : stacks) {
                if (stack.size() < capactiy) {
                    stack.push(val);
                    return;
                }
            }
            Stack<Integer> stack = new Stack<>();
            stack.add(val);
            stacks.add(stack);
        }

        public int pop() {
            if (total == 0) {
                return -1;
            }
            total--;
            for (int i = stacks.size() - 1; i >= 0; i--) {
                if (!stacks.get(i).isEmpty()) {
                    return stacks.get(i).pop();
                }
            }
            return -1;
        }

        public int popAtStack(int index) {
            if (index >= stacks.size() || stacks.get(index).isEmpty()) {
                return -1;
            }
            total--;
            return stacks.get(index).pop();
        }
    }

}
