package leetcode.contest.week281;

import java.util.ArrayList;
import java.util.List;

public class Test6013_合并零之间的节点 {

    public static void main(String[] args) {
        System.out.println(new Solution().mergeNodes(
                new ListNode(0, new ListNode(3, new ListNode(1, new ListNode(0, new ListNode(4, new ListNode(5, new ListNode(2, new ListNode(0)))))))
                )));
        System.out.println(new Solution().mergeNodes(
                new ListNode(0, new ListNode(1, new ListNode(0, new ListNode(3, new ListNode(0, new ListNode(2, new ListNode(2, new ListNode(0)))))))
                )));
    }

    static class Solution {
        public ListNode mergeNodes(ListNode head) {
            // 放入list中
            List<Integer> list = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                list.add(node.val);
                node = node.next;
            }
            // 合并0之间的数
            List<ListNode> newList = new ArrayList<>();
            int sum = 0;
            for (int num : list) {
                if (num == 0 && sum > 0) {
                    newList.add(new ListNode(sum));
                    sum = 0;
                } else {
                    sum += num;
                }
            }
            // 返回结果
            for (int i = 0; i < newList.size() - 1; i++) {
                newList.get(i).next = newList.get(i + 1);
            }
            return newList.get(0);
        }
    }

    public static class ListNode {
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
