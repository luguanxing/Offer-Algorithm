package offer;

import java.util.ArrayList;
import java.util.List;

public class Test22_链表中倒数第k个结点 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        System.out.println(new Solution_提前指针().FindKthToTail(node1, 1).val);
    }

    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        public ListNode FindKthToTail(ListNode head, int k) {
            List<ListNode> nodeList = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                nodeList.add(node);
                node = node.next;
            }
            if (k == 0 || nodeList.size() < k) {
                return null;
            }
            return nodeList.get(nodeList.size() - k);
        }
    }

    static class Solution_提前指针 {
        public ListNode FindKthToTail(ListNode head, int k) {
            if (head == null || k == 0) {
                return null;
            }
            ListNode nextK = head;
            for (int i = 1; i < k; i++) {
                nextK = nextK.next;
                if (nextK == null) {
                    return null;
                }
            }
            ListNode current = head;
            while (nextK.next != null) {
                nextK = nextK.next;
                current = current.next;
            }
            return current;
        }
    }

}
