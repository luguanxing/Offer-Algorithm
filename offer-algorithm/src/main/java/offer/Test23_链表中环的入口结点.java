package offer;

import java.util.HashSet;
import java.util.Set;

public class Test23_链表中环的入口结点 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node1;
        System.out.println(new Solution_双指针().EntryNodeOfLoop(node1).val);
        System.out.println(new Solution_双指针().getLoopMeet(node1));
        System.out.println(new Solution_双指针().getLoopLen(new Solution_双指针().getLoopMeet(node1)));
    }

    static class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        public ListNode EntryNodeOfLoop(ListNode pHead) {
            Set<ListNode> set = new HashSet<>();
            ListNode current = pHead;
            while (current != null) {
                if (set.contains(current)) {
                    return current;
                }
                set.add(current);
                current = current.next;
            }
            return null;
        }
    }

    static class Solution_双指针 {
        public ListNode EntryNodeOfLoop(ListNode pHead) {
            // 检查是否有环，有则返回快慢指针相遇的节点
            ListNode meet = getLoopMeet(pHead);
            if (meet != null) {
                // 有环的情况下通过快慢指针再次相遇耗时计算环长度
                int loopLen = getLoopLen(meet);
                // 使用同速指针，先锋指针提前环长度环入口，再次相遇时即为入口
                ListNode next = pHead;
                ListNode current = pHead;
                for (int i = 1; i <= loopLen; i++) {
                    next = next.next;
                }
                while (current != next) {
                    current = current.next;
                    next = next.next;
                }
                return current;
            }
            return null;
        }

        public ListNode getLoopMeet(ListNode pHead) {
            ListNode quick = pHead;
            ListNode slow = pHead;
            do {
                slow = slow.next;
                quick = quick.next;
                if (quick == null) {
                    return null;
                }
                quick = quick.next;
            } while (quick != slow);
            return quick;
        }

        public int getLoopLen(ListNode meet) {
            // 计算环长度(快慢指针再次相遇耗时)
            ListNode quick = meet;
            ListNode slow = meet;
            int loopLen = 0;
            do {
                slow = slow.next;
                quick = quick.next.next;
                loopLen++;
            } while (quick != slow);
            return loopLen;
        }
    }

}
