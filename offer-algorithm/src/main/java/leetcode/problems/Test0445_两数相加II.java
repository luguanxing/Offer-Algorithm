package leetcode.problems;

import java.math.BigInteger;

public class Test0445_两数相加II {

    public static void main(String[] args) {
        System.out.println(new Solution().addTwoNumbers(
                new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3)))),
                new ListNode(5, new ListNode(6, new ListNode(4)))
        ));
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            String s1 = "";
            String s2 = "";
            while (l1 != null) {
                s1 += l1.val;
                l1 = l1.next;
            }
            while (l2 != null) {
                s2 += l2.val;
                l2 = l2.next;
            }
            String s3 = new BigInteger(s1).add(new BigInteger(s2)).toString();
            System.out.println(s3);
            ListNode l3 = new ListNode(0);
            ListNode cur = l3;
            ListNode next = l3.next;
            for (char c : s3.toCharArray()) {
                next = new ListNode(c - '0');
                cur.next = next;
                cur = next;
            }
            return l3.next;

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
