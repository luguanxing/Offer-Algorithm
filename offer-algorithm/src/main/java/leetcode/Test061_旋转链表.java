package leetcode;

public class Test061_旋转链表 {

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[]{new ListNode(1), new ListNode(2), new ListNode(3), new ListNode(4), new ListNode(5)};
        for (int i = 1; i < nodes.length; i++) {
            nodes[i - 1].next = nodes[i];
        }
        System.out.println(nodes[0]);
        System.out.println(new Solution().rotateRight(nodes[0], 7));
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
        @Override
        public String toString() {
            return val + "->" + next;
        }
    }

    static class Solution {
        public ListNode rotateRight(ListNode head, int k) {
            if (head == null) {
                return null;
            }
            // 重新连接成环
            ListNode node = head;
            int len = 1;
            while (node.next != null) {
                node = node.next;
                len++;
            }
            node.next = head;
            // head往前k步分割（或者往后len-k步），并返回新开始节点
            ListNode current = head;
            ListNode next = head.next;
            for (int i = 1; i < len - k % len; i++) {
                current = next;
                next = next.next;
            }
            current.next = null;
            return next;
        }
    }

}
