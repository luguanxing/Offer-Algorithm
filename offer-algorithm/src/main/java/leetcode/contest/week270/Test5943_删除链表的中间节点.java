package leetcode.contest.week270;

import java.util.ArrayList;
import java.util.List;

public class Test5943_删除链表的中间节点 {

    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode deleteMiddle(ListNode head) {
            List<ListNode> list = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                list.add(node);
                node = node.next;
            }
            list.remove(list.size() / 2);
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
    }

}
