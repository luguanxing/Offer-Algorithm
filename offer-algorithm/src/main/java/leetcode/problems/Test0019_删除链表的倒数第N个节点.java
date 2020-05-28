package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0019_删除链表的倒数第N个节点 {

    public static void main(String[] args) {
        System.out.println(new Solution().removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
        System.out.println(new Solution().removeNthFromEnd(new ListNode(1), 1));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode n) {
            val = x;
            next = n;
        }

        @Override
        public String toString() {
            return val + "->" + next;
        }
    }

    static class Solution {
        public ListNode removeNthFromEnd(ListNode head, int n) {
            if (head == null) {
                return null;
            }
            // 保存所有节点
            List<ListNode> list = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                list.add(node);
                node = node.next;
            }
            // 重新组织节点
            if (list.size() < n) {
                return null;
            }
            list.remove(list.size() - n);
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
            if (!list.isEmpty()) {
                list.get(list.size() - 1).next = null;
                return list.get(0);
            } else {
                return null;
            }
        }
    }

}
