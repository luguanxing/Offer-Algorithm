package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0234_回文链表 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(1);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(1);
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
        System.out.println(new Solution().isPalindrome(node1));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public boolean isPalindrome(ListNode head) {
            int len = 0;
            ListNode node = head;
            while (node != null) {
                len++;
                node = node.next;
            }
            // 从中间翻转前半段
            ListNode part1 = null;
            ListNode part2 = null;
            ListNode fast = head;
            ListNode slow = null;
            for (int i = 0; i < len / 2; i++) {
                ListNode next = fast.next;
                if (len % 2 == 1) {
                    part2 = next.next;
                } else {
                    part2 = next;
                }
                fast.next = slow;
                slow = fast;
                fast = next;
            }
            part1 = slow;
            //  比较前后的两段
            while (part1 != null && part2 != null) {
                if (part1.val != part2.val) {
                    return false;
                }
                part1 = part1.next;
                part2 = part2.next;
            }
            return true;
        }
    }

    static class Solution_空间ON复杂度 {
        public boolean isPalindrome(ListNode head) {
            List<ListNode> list = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                list.add(node);
                node = node.next;
            }
            for (int i = 0; i < list.size() / 2; i++) {
                if (list.get(i).val != list.get(list.size() - 1 - i).val) {
                    return false;
                }
            }
            return true;
        }
    }

}
