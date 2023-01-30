package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test1669_合并两个链表 {

    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
            List<ListNode> nodes1 = new ArrayList<>();
            List<ListNode> nodes2 = new ArrayList<>();
            List<ListNode> nodes = new ArrayList<>();
            ListNode p1 = list1;
            while (p1 != null) {
                nodes1.add(p1);
                p1 = p1.next;
            }
            ListNode p2 = list2;
            while (p2 != null) {
                nodes2.add(p2);
                p2 = p2.next;
            }
            for (int i = 0; i < a; i++) {
                nodes.add(nodes1.get(i));
            }
            nodes.addAll(nodes2);
            for (int i = b + 1; i < nodes1.size(); i++) {
                nodes.add(nodes1.get(i));
            }
            nodes.add(null);
            for (int i = 1; i < nodes.size(); i++) {
                nodes.get(i - 1).next = nodes.get(i);
            }
            return nodes.get(0);
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
    }

}
