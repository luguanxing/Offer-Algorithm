package leetcode.problems;

import java.util.*;

public class Test0143_重排链表 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode node2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println(node1);
        System.out.println(node2);
        new Solution().reorderList(node1);
        new Solution().reorderList(node2);
        System.out.println(node1);
        System.out.println(node2);
    }

    static class Solution2 {
        public void reorderList(ListNode head) {
            Deque<ListNode> deque = new ArrayDeque<>();
            ListNode node = head;
            while (node != null) {
                deque.add(node);
                node = node.next;
            }
            List<ListNode> list = new ArrayList<>();
            boolean flag = true;
            while (!deque.isEmpty()) {
                if (flag) {
                    list.add(deque.pollFirst());
                } else {
                    list.add(deque.pollLast());
                }
                flag = !flag;
            }
            list.add(null);
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
        }
    }

    static class Solution {
        public void reorderList(ListNode head) {
            if (head == null) {
                return;
            }
            // 保存所有节点
            List<ListNode> list = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                list.add(node);
                node = node.next;
            }
            // 前后翻转
            List<ListNode> res = new ArrayList<>();
            boolean isHead = true;
            while (!list.isEmpty()) {
                if (isHead) {
                    res.add(list.get(0));
                    list.remove(0);
                } else {
                    res.add(list.get(list.size() - 1));
                    list.remove(list.size() - 1);
                }
                isHead = !isHead;
            }
            // 重新整链
            res.add(null);
            for (int i = 0; i < res.size() - 1; i++) {
                res.get(i).next = res.get(i + 1);
            }
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

        @Override
        public String toString() {
            return "(" + val + ")->" + next;
        }
    }

}
