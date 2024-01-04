package leetcode.problems;

import java.util.*;

public class Test2487_从链表中移除节点 {

    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode removeNodes(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            ListNode current = head;
            while (current != null) {
                while (!stack.isEmpty() && stack.peek().val < current.val) {
                    stack.pop();
                }
                stack.push(current);
                current = current.next;
            }
            List<ListNode> res = new ArrayList<>(stack);
            res.add(null);
            for (int i = 0; i < res.size() - 1; i++) {
                res.get(i).next = res.get(i + 1);
            }
            return res.get(0);
        }
    }

    static class Solution2 {
        public ListNode removeNodes(ListNode head) {
            List<Integer> allList = new ArrayList<>();
            ListNode current = head;
            while (current != null) {
                allList.add(current.val);
                current = current.next;
            }
            List<Integer> leftList = new ArrayList<>();
            leftList.add(allList.get(allList.size() - 1));
            int max = allList.get(allList.size() - 1);
            for (int i = allList.size() - 2; i >= 0; i--) {
                max = Math.max(max, allList.get(i + 1));
                if (allList.get(i) >= max) {
                    leftList.add(0, allList.get(i));
                }
            }
            List<ListNode> res = new ArrayList<>();
            for (int i = 0; i < leftList.size(); i++) {
                res.add(new ListNode(leftList.get(i)));
            }
            res.add(null);
            for (int i = 0; i < res.size() - 1; i++) {
                res.get(i).next = res.get(i + 1);
            }
            return res.get(0);
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
