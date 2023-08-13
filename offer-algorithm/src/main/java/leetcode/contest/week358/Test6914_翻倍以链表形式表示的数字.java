package leetcode.contest.week358;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Test6914_翻倍以链表形式表示的数字 {

    public static void main(String[] args) {
        System.out.println(new Solution().doubleIt(
                new ListNode(1, new ListNode(8, new ListNode(9)))
        ));
        System.out.println(new Solution().doubleIt(
                new ListNode(9, new ListNode(9, new ListNode(9)))
        ));
    }

    static class Solution {
        public ListNode doubleIt(ListNode head) {
            String str = "";
            ListNode node = head;
            while (node != null) {
                str = str + node.val;
                node = node.next;
            }
            String res = new BigInteger(str).multiply(new BigInteger("2")).toString();
            List<ListNode> list = new ArrayList<>();
            for (char c : res.toCharArray()) {
                list.add(new ListNode(c - '0'));
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

        @Override
        public String toString() {
            return val + "->" + next;
        }
    }

}
