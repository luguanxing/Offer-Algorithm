package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0002_两数相加 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(6)));
        System.out.println(new Solution().addTwoNumbers(l1, l2));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        ListNode(int x, ListNode next) {
            val = x;
            this.next = next;
        }

        @Override
        public String toString() {
            return val + "->" + next;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            // 保留相加结果
            List<ListNode> list = new ArrayList<>();
            ListNode node1 = l1;
            ListNode node2 = l2;
            while (node1 != null && node2 != null) {
                list.add(new ListNode(node1.val + node2.val));
                node1 = node1.next;
                node2 = node2.next;
            }
            if (node2 != null) {
                while (node2 != null) {
                    list.add(new ListNode(node2.val));
                    node2 = node2.next;
                }
            }
            if (node1 != null) {
                while (node1 != null) {
                    list.add(new ListNode(node1.val));
                    node1 = node1.next;
                }
            }
            // 计算相加结果
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).val >= 10) {
                    list.get(i).val -= 10;
                    list.get(i + 1).val += 1;
                }
            }
            if (list.get(list.size() - 1).val >= 10) {
                list.get(list.size() - 1).val -= 10;
                list.add(new ListNode(1));
            }
            // 重新组织链表
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
            return list.get(0);
        }
    }

    static class Solution2 {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            List<ListNode> list = new ArrayList<>();
            while (l1 != null || l2 != null) {
                list.add(new ListNode((l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val)));
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).val >= 10) {
                    list.get(i).val -= 10;
                    list.get(i + 1).val += 1;
                }
            }
            if (list.get(list.size() - 1).val >= 10) {
                list.get(list.size() - 1).val -= 10;
                list.get(list.size() - 1).next = new ListNode(1);
            }
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
            return list.get(0);
        }
    }

}
