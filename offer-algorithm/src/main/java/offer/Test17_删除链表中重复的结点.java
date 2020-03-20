package offer;

import java.util.*;

public class Test17_删除链表中重复的结点 {

    public static void main(String[] args) {
        ListNode[] nodes = new ListNode[]{
                new  ListNode(1),
                new ListNode(1),
                new ListNode(1),
                new ListNode(1),
                new ListNode(1),
                new ListNode(1),
                new ListNode(1)
        };
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }
        System.out.println(nodes[0]);
        System.out.println(new Solution().deleteDuplication(nodes[0]));
    }

    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
        @Override
        public String toString() {
            return val + "->" + next;
        }
    }

    static class Solution {
        public ListNode deleteDuplication(ListNode pHead) {
            if (pHead == null) {
                return null;
            }
            // 保存所有节点出现次数
            Map<Integer, Integer> map = new HashMap();
            ListNode current = pHead;
            while (current != null) {
                if (!map.containsKey(current.val)) {
                    map.put(current.val, 1);
                } else {
                    map.put(current.val, map.get(current.val) + 1);
                }
                current = current.next;
            }
            // 重新遍历节点，并建新链
            List<ListNode> list = new ArrayList<>();
            current = pHead;
            while (current != null) {
                if (map.containsKey(current.val) && map.get(current.val) == 1) {
                    list.add(current);
                }
                current = current.next;
            }
            for (int i = 0; i < list.size() - 1; i++) {
                list.get(i).next = list.get(i + 1);
            }
            if (!list.isEmpty()) {
                list.get(list.size() - 1).next = null;
            }
            return list.isEmpty() ? null : list.get(0);
        }
    }

    static class Solution_链表去重 {
        public ListNode deleteDuplication(ListNode pHead) {
            if (pHead == null) {
                return null;
            }
            Set<Integer> set = new HashSet<>();
            set.add(pHead.val);
            // 遍历后续节点，并去掉重复的节点
            ListNode current = pHead;
            ListNode next = pHead.next;
            while (next != null) {
                if (!set.contains(next.val)) {
                    set.add(next.val);
                    current.next = next;
                    current = next;
                }
                next = next.next;
            }
            current.next = next;
            return pHead;
        }
    }

}
