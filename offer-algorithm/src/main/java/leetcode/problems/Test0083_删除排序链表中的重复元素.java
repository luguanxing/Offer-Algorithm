package leetcode.problems;

import java.util.HashSet;
import java.util.Set;

public class Test0083_删除排序链表中的重复元素 {

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[]{
                new ListNode(1),
                new ListNode(2),
                new ListNode(2),
                new ListNode(3),
                new ListNode(3),
        };
        for (int i = 0; i < listNodes.length - 1; i++) {
            listNodes[i].next = listNodes[i + 1];
        }
        System.out.println(new Solution().deleteDuplicates(listNodes[0]));
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
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null) {
                return null;
            }
            ListNode current = head;
            ListNode next = head.next;
            int lastVal = current.val;
            while (next != null) {
                if (lastVal == next.val) {
                    // 已出现过则跳过
                    next = next.next;
                    current.next = next;
                } else {
                    // 未出现过则继续推进
                    lastVal = next.val;
                    current = next;
                    next = next.next;
                }
            }
            return head;
        }
    }

}
