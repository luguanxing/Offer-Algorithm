package leetcode.contest.week267;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test5927_反转偶数长度组的节点 {

    public static void main(String[] args) {
        System.out.println(new Solution().reverseEvenLengthGroups(new ListNode(5, new ListNode(2, new ListNode(
                6, new ListNode(3, new ListNode(9, new ListNode(1, new ListNode(7,
                new ListNode(3, new ListNode(8, new ListNode(4)))))))
        )))));
        System.out.println(new Solution().reverseEvenLengthGroups(new ListNode(1, new ListNode(1, new ListNode(
                0, new ListNode(6)
        )))));
        System.out.println(new Solution().reverseEvenLengthGroups(new ListNode(2, new ListNode(1))));
        System.out.println(new Solution().reverseEvenLengthGroups(new ListNode(8)));
        System.out.println(new Solution().reverseEvenLengthGroups(new ListNode()));
    }

    static class Solution {
        public ListNode reverseEvenLengthGroups(ListNode head) {
            List<List<ListNode>> groupList = new ArrayList<>();
            List<ListNode> group = new ArrayList<>();
            int len = 1;
            ListNode node = head;
            // 分组
            while (node != null) {
                group.add(node);
                if (group.size() == len) {
                    groupList.add(new ArrayList<>(group));
                    group.clear();
                    len++;
                }
                node = node.next;
            }
            if (!group.isEmpty()) {
                groupList.add(new ArrayList<>(group));
            }
            // 翻转长度为偶数的组
            for (int i = 0; i < groupList.size(); i++) {
                group = groupList.get(i);
                if (group.size() % 2 == 0) {
                    Collections.reverse(group);
                }
                for (int j = 1; j < group.size(); j++) {
                    group.get(j - 1).next = group.get(j);
                }
                group.get(group.size() - 1).next = null;
            }
            // 重新构建链表
            List<ListNode> res = new ArrayList<>();
            for (List<ListNode> currentGroup : groupList) {
                res.addAll(currentGroup);
            }
            res.add(null);
            for (int i = 1; i < res.size(); i++) {
                res.get(i - 1).next = res.get(i);
            }
            return res.get(0);
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
            return String.format("%d->%s", val, next);
        }
    }

}
