package leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Test1171_从链表中删去总和值为零的连续节点 {

    public static void main(String[] args) {
        System.out.println(new Solution().removeZeroSumSublists(
                new ListNode(1, new ListNode(2, new ListNode(-3, new ListNode(3, new ListNode(1)))))
        ));
        System.out.println(new Solution().removeZeroSumSublists(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(-3, new ListNode(4)))))
        ));
        System.out.println(new Solution().removeZeroSumSublists(
                new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(-3, new ListNode(-2)))))
        ));
    }

    static class Solution {
        public ListNode removeZeroSumSublists(ListNode head) {
            Stack<ListNode> stack = new Stack<>();
            ListNode node = head;
            while (node != null) {
                stack.push(node);
                List<ListNode> list = new ArrayList<>();
                int sum = 0;
                while (!stack.isEmpty()) {
                    ListNode top = stack.pop();
                    sum += top.val;
                    list.add(top);
                    if (sum == 0) {
                        break;
                    }
                }
                if (sum == 0) {
                    list.clear();
                }
                Collections.reverse(list);
                stack.addAll(list);
                node = node.next;
            }
            List<ListNode> list = new ArrayList<>(stack);
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
