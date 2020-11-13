package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0328_奇偶链表 {

    public static void main(String[] args) {
        ListNode node = new ListNode(2, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6, new ListNode(4, new ListNode(7)))))));
        ListNode res = new Solution().oddEvenList(node);
        System.out.println(res);
    }

    static class Solution {
        public ListNode oddEvenList(ListNode head) {
            List<ListNode> list1 = new ArrayList<>();
            List<ListNode> list2 = new ArrayList<>();
            ListNode node = head;
            int index = 0;
            while (node != null) {
                if (index++ % 2 == 0) {
                    list1.add(node);
                } else {
                    list2.add(node);
                }
                node = node.next;
            }
            List<ListNode> list = new ArrayList<>();
            list.addAll(list1);
            list.addAll(list2);
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
