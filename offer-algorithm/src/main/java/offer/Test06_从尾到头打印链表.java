package offer;

import java.util.ArrayList;
import java.util.Collections;

public class Test06_从尾到头打印链表 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        node1.next = node2;
        node2.next = node3;
        System.out.println(new Solution().printListFromTailToHead(node1));
    }

    static class Solution {
        public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
            ArrayList<Integer> list = new ArrayList<>();
            while (listNode != null) {
                list.add(listNode.val);
                listNode = listNode.next;
            }
            Collections.reverse(list);
            return list;
        }
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

}
