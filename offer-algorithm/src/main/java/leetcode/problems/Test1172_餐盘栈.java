package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

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
        TreeSet<Integer> fullIndexs;
        TreeSet<Integer> filledIndexs;
        TreeSet<Integer> emptyIndexs;

        public DinnerPlates(int capacity) {
            stacks = new ArrayList<>();
            capactiy = capacity;
            fullIndexs = new TreeSet<>();
            filledIndexs = new TreeSet<>();
            emptyIndexs = new TreeSet<>();
        }

        public void push(int val) {
            // 先从左到右找能放入的，找到则更新状态
            int idx = Integer.MAX_VALUE;
            if (!filledIndexs.isEmpty()) {
                idx = Math.min(idx, filledIndexs.first());
            }
            if (!emptyIndexs.isEmpty()) {
                idx = Math.min(idx, emptyIndexs.first());
            }
            if (idx != Integer.MAX_VALUE) {
                Stack<Integer> stack = stacks.get(idx);
                stack.add(val);
                if (stack.size() == capactiy) {
                    filledIndexs.remove(idx);
                    emptyIndexs.remove(idx);
                    fullIndexs.add(idx);
                } else {
                    filledIndexs.remove(idx);
                    emptyIndexs.remove(idx);
                    filledIndexs.add(idx);
                }
                return;
            }
            // 找不到就新建一个并更新状态
            int newIndex = stacks.size();
            Stack<Integer> stack = new Stack<>();
            stack.add(val);
            stacks.add(stack);
            if (stack.size() == capactiy) {
                fullIndexs.add(newIndex);
            } else {
                filledIndexs.add(newIndex);
            }
        }

        public int pop() {
            if (filledIndexs.isEmpty() && fullIndexs.isEmpty()) {
                return -1;
            }
            // 从右到左找非空的，找到则更新状态
            int idx = -1;
            if (!filledIndexs.isEmpty()) {
                idx = Math.max(idx, filledIndexs.last());
            }
            if (!fullIndexs.isEmpty()) {
                idx = Math.max(idx, fullIndexs.last());
            }
            if (idx != -1) {
                Stack<Integer> stack = stacks.get(idx);
                int ret = stack.pop();
                if (stack.size() != 0) {
                    fullIndexs.remove(idx);
                    filledIndexs.remove(idx);
                    filledIndexs.add(idx);
                } else {
                    fullIndexs.remove(idx);
                    filledIndexs.remove(idx);
                    emptyIndexs.add(idx);
                }
                return ret;
            }
            return -1;
        }

        public int popAtStack(int index) {
            if (index >= stacks.size() || stacks.get(index).isEmpty()) {
                return -1;
            }
            // 直接从对应的栈取出数据，并更新状态
            Stack<Integer> stack = stacks.get(index);
            int ret = stack.pop();
            if (stack.size() != 0) {
                fullIndexs.remove(index);
                filledIndexs.remove(index);
                filledIndexs.add(index);
            } else {
                fullIndexs.remove(index);
                filledIndexs.remove(index);
                emptyIndexs.add(index);
            }
            return ret;
        }
    }


    static class DinnerPlates_暴力 {
        List<Stack<Integer>> stacks;
        int capactiy;
        int total;

        public DinnerPlates_暴力(int capacity) {
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
