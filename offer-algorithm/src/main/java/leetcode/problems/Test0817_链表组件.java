package leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Test0817_链表组件 {

    public static void main(String[] args) {
        System.out.println(new Solution().numComponents(
                new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3)))),
                new int[]{0, 1, 3}
        ));
        System.out.println(new Solution().numComponents(
                new ListNode(0, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))))),
                new int[]{0, 3, 1, 4}
        ));
    }

    static class Solution {
        public int numComponents(ListNode head, int[] nums) {
            Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
            int cnt = 0;
            boolean lastInSet = false;
            ListNode node = head;
            while (node != null) {
                if (lastInSet && set.contains(node.val)) {
                    lastInSet = true;
                } else if (!lastInSet && set.contains(node.val)) {
                    lastInSet = true;
                } else if (lastInSet && !set.contains(node.val)) {
                    lastInSet = false;
                    cnt++;
                } else if (!lastInSet && !set.contains(node.val)) {
                    lastInSet = false;
                }
                node = node.next;
            }
            if (lastInSet) {
                cnt++;
            }
            return cnt;
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
