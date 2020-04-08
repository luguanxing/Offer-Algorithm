package offer;

import java.util.HashSet;
import java.util.Set;

public class Test52_两个链表的第一个公共结点 {

    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(3);
        ListNode node21 = new ListNode(-1);
        ListNode node22 = new ListNode(-2);
        ListNode node4 = new ListNode(0);
        ListNode node5 = new ListNode(9);
        node11.next = node12;
        node12.next = node13;
        node13.next = node4;
        node21.next = node22;
        node22.next = node4;
        node4.next = node5;
        System.out.println(new Solution().FindFirstCommonNode(node11, node21).val);
        System.out.println(new Solution().FindFirstCommonNode(node11, node22).val);
        System.out.println(new Solution().FindFirstCommonNode(node12, node21).val);
    }

    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            // 计算两条链的长度差值
            int len1 = 0;
            int len2 = 0;
            ListNode node1 = pHead1;
            ListNode node2 = pHead2;
            while (node1 != null) {
                node1 = node1.next;
                len1++;
            }
            while (node2 != null) {
                node2 = node2.next;
                len2++;
            }
            int lenDiff = Math.abs(len1 - len2);
            // 长链表指针先走差值步
            node1 = pHead1;
            node2 = pHead2;
            if (len1 > len2) {
                for (int i = 1; i <= lenDiff; i++) {
                    node1 = node1.next;
                }
            } else {
                for (int i = 1; i <= lenDiff; i++) {
                    node2 = node2.next;
                }
            }
            // 两指针共同向前最终相遇
            while (node1 != node2) {
                node1 = node1.next;
                node2 = node2.next;
            }
            return node1;
        }
    }

    static class Solution_空间换时间 {
        public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
            Set<ListNode> set = new HashSet<>();
            ListNode node = pHead1;
            while (node != null) {
                set.add(node);
                node = node.next;
            }
            node = pHead2;
            while (node != null) {
                if (set.contains(node)) {
                    return node;
                }
                node = node.next;
            }
            return null;
        }
    }

}
