package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Test092_反转链表II {

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[]{new ListNode(1), new ListNode(2), new ListNode(3), new ListNode(4), new ListNode(5)};
        for (int i = 1; i < nodes.length; i++) {
            nodes[i - 1].next = nodes[i];
        }
        System.out.println(nodes[0]);
        System.out.println(new Solution().reverseBetween(nodes[0], 2, 4));
    }

    static public class ListNode {
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
        public ListNode reverseBetween(ListNode head, int m, int n) {
            if (head == null) {
                return null;
            }
            // 存储所有节点
            List<ListNode> list = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                list.add(node);
                node = node.next;
            }
            // 翻转m到n的节点
            int left = m - 1;
            int right = n - 1;
            while (left < right) {
                ListNode tmp = list.get(left);
                list.set(left, list.get(right));
                list.set(right, tmp);
                left++;
                right--;
            }
            // 重新组织链表
            for (int i = 1; i < list.size(); i++) {
                list.get(i - 1).next = list.get(i);
            }
            list.get(list.size() - 1).next = null;
            return list.get(0);
        }
    }

}
