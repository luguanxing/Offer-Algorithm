package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0082_删除排序链表中的重复元素II {

    public static void main(String[] args) {
        ListNode[] listNodes = new ListNode[]{
                new ListNode(1),
                new ListNode(1),
                new ListNode(2),
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
            // 遍历并统计每个数出现次数
            Map<Integer, Integer> map = new TreeMap<>();
            ListNode current = head;
            while (current != null) {
                if (!map.containsKey(current.val)) {
                    map.put(current.val, 1);
                } else {
                    map.put(current.val, 0);
                }
                current = current.next;
            }
            // 重新组成链表
            List<ListNode> newList = map
                    .entrySet()
                    .stream()
                    .filter(entry -> entry.getValue() == 1)
                    .map(Map.Entry::getKey)
                    .map(ListNode::new)
                    .collect(Collectors.toList());
            for (int i = 0; i < newList.size() - 1; i++) {
                newList.get(i).next = newList.get(i + 1);
            }
            return newList.isEmpty() ? null : newList.get(0);
        }
    }

}
