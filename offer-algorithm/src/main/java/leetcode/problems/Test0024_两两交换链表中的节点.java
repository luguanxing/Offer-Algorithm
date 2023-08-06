package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0024_两两交换链表中的节点 {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode newHead = new Solution().swapPairs(head);
        System.out.println(newHead);
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

    static class Solution {
        public ListNode swapPairs(ListNode head) {
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
            // 两两交换顺序
            for (int i = 0; i < list.size(); i++) {
                if (i % 2 == 1) {
                    ListNode tmp = list.get(i - 1);
                    list.set(i - 1, list.get(i));
                    list.set(i, tmp);
                }
            }
            list.add(null);
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
            return list.get(0);
        }
    }

}
