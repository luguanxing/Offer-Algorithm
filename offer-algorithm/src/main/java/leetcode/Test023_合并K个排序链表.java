package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Test023_合并K个排序链表 {

    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node12 = new ListNode(2);
        ListNode node13 = new ListNode(3);
        ListNode node21 = new ListNode(2);
        ListNode node22 = new ListNode(3);
        ListNode node31 = new ListNode(5);
        node11.next = node12;
        node12.next = node13;
        node21.next = node22;
        System.out.println(new Solution().mergeKLists(new ListNode[]{node11, node21, node31}));
        System.out.println(new Solution().mergeKLists(new ListNode[]{}));
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
        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null) {
                return null;
            }
            List<ListNode> nodeList = new ArrayList<>();
            // 保存所有节点
            for (ListNode node : lists) {
                while (node != null) {
                    nodeList.add(node);
                    node = node.next;
                }
            }
            // 重新排序
            nodeList.sort(Comparator.comparingInt(node -> node.val));
            // 重新组成链表
            for (int i = 1; i < nodeList.size(); i++) {
                nodeList.get(i - 1).next = nodeList.get(i);
            }
            if (nodeList.size() >= 1) {
                nodeList.get(nodeList.size() - 1).next = null;
                return nodeList.get(0);
            }
            return null;
        }
    }

}
