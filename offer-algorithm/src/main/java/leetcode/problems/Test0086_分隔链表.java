package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0086_分隔链表 {

    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode partition(ListNode head, int x) {
            List<ListNode> small = new ArrayList<>();
            List<ListNode> big = new ArrayList<>();
            List<ListNode> res = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                if (node.val < x) {
                    small.add(node);
                } else {
                    big.add(node);
                }
                node = node.next;
            }
            res.addAll(small);
            res.addAll(big);
            res.add(null);
            for (int i = 0; i < res.size() - 1; i++) {
                res.get(i).next = res.get(i + 1);
            }
            return res.get(0);
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
