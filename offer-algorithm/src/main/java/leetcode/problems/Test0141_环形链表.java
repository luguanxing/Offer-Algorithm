package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Test0141_环形链表 {

    public static void main(String[] args) {

    }

    static class Solution {
        public boolean hasCycle(ListNode head) {
            if (head == null) {
                return false;
            }
            ListNode slow = head;
            ListNode fast = head.next;
            while (fast != slow) {
                if (fast == null || slow == null) {
                    return false;
                }
                fast = fast.next;
                if (fast == null) {
                    return false;
                }
                fast = fast.next;
                slow = slow.next;
            }
            return true;
        }
    }

    static class Solution_Set {
        public boolean hasCycle(ListNode head) {
            Set<ListNode> set = new HashSet<>();
            ListNode listNode = head;
            while (listNode != null) {
                if (set.contains(listNode)) {
                    return true;
                }
                set.add(listNode);
                listNode = listNode.next;
            }
            return false;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
