package leetcode.problems;

public class Test0206_反转链表 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        System.out.println(node1);
        System.out.println(new Solution().reverseList(node1));
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    ", next=" + next +
                    '}';
        }
    }

    static class Solution {
        public ListNode reverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode current = head;
            ListNode next = head.next;
            while (next != null) {
                ListNode realNext = next.next;
                next.next = current;
                current = next;
                next = realNext;
            }
            head.next = null;
            return current;
        }
    }

}
