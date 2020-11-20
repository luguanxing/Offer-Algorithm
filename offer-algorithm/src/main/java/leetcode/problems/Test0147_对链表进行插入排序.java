package leetcode.problems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test0147_对链表进行插入排序 {

    public static void main(String[] args) {

    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode insertionSortList(ListNode head) {
            List<ListNode> list = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                list.add(node);
                node = node.next;
            }
            list.sort(Comparator.comparingInt(o -> o.val));
            list.add(null);
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
            return list.get(0);
        }
    }

}
