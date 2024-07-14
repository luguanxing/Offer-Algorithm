package leetcode.contest.week406;

import java.util.*;

public class Test100368_从链表中移除在数组中存在的节点 {

    public static void main(String[] args) {

    }

    static class Solution {
        public ListNode modifiedList(int[] nums, ListNode head) {
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }
            List<ListNode> list = new ArrayList<>();
            ListNode cur = head;
            while (cur != null) {
                if (!set.contains(cur.val)) {
                    list.add(cur);
                }
                cur = cur.next;
            }
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
