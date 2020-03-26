package offer;

public class Test24_反转链表 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        System.out.println(node1);
        System.out.println(new Solution_递归().ReverseList(node1));
    }

    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
        @Override
        public String toString() {
            return val + "->" + next;
        }
    }

    static class Solution {
        public ListNode ReverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode current = head;
            ListNode next = current.next;
            // 逐节点翻转，并向后推进
            while (next != null) {
                ListNode realNext = next.next;
                next.next = current;
                current = next;
                next = realNext;
            }
            // 原尾节点置空
            head.next = null;
            return current;
        }
    }

    static class Solution_递归 {
        public ListNode ReverseList(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode tail = reverse(head, head.next);
            head.next = null;
            return tail;
        }

        private ListNode reverse(ListNode current, ListNode next) {
            // 假设current节点之前的都为已翻转的链表，则翻转当前节点向后递归
            if (next == null) {
                return current;
            }
            ListNode readNext = next.next;
            next.next = current;
            return reverse(next, readNext);
        }
    }

}
