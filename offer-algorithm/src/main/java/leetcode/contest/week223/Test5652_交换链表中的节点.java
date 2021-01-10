package leetcode.contest.week223;

import java.util.ArrayList;
import java.util.List;

public class Test5652_交换链表中的节点 {

    public static void main(String[] args) {
        System.out.println(new Solution().swapNodes(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))),
                2
        ));
        System.out.println(new Solution().swapNodes(
                new ListNode(7, new ListNode(9, new ListNode(6, new ListNode(6, new ListNode(7, new ListNode(8, new ListNode(3, new ListNode(0, new ListNode(9, new ListNode(5)))))))))),
                5
        ));
        System.out.println(new Solution().swapNodes(
                new ListNode(1),
                1
        ));
        System.out.println(new Solution().swapNodes(
                new ListNode(1, new ListNode(2)),
                1
        ));
        System.out.println(new Solution().swapNodes(
                new ListNode(1, new ListNode(2, new ListNode(3))),
                2
        ));
    }

    static class Solution {
        public ListNode swapNodes(ListNode head, int k) {
            List<ListNode> list = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                list.add(node);
                node = node.next;
            }
            ListNode nodeK1 = list.get(k - 1);
            ListNode nodeK2 = list.get(list.size() - k);
            list.set(k - 1, nodeK2);
            list.set(list.size() - k, nodeK1);
            list.add(null);
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
            return list.get(0);
        }
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

        @Override
        public String toString() {
            return val + "->" + next;
        }
    }

}
