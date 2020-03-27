package offer;

public class Test25_合并两个排序的链表 {

    public static void main(String[] args) {
        ListNode node1_1 = new ListNode(1);
        ListNode node1_2 = new ListNode(2);
        ListNode node1_3 = new ListNode(3);
        ListNode node2_1 = new ListNode(2);
        ListNode node2_2 = new ListNode(5);
        node1_1.next = node1_2;
        node1_2.next = node1_3;
        node2_1.next = node2_2;
        System.out.println(node1_1);
        System.out.println(node2_1);
        System.out.println(new Solution().Merge(node1_1, node2_1));
        System.out.println(new Solution().Merge(node1_1, null));
        System.out.println(new Solution().Merge(null, node2_1));
        System.out.println(new Solution().Merge(null, null));
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
        public ListNode Merge(ListNode list1, ListNode list2) {
            ListNode node1 = list1;
            ListNode node2 = list2;
            ListNode prev = new ListNode(0);
            ListNode prevHead = prev;
            while (node1 != null && node2 != null) {
                ListNode current = new ListNode(0);
                if (node1.val <= node2.val) {
                    current.val = node1.val;
                    node1 = node1.next;
                } else {
                    current.val = node2.val;
                    node2 = node2.next;
                }
                prev.next = current;
                prev = current;
            }
            if (node1 != null) {
                prev.next = node1;
            }
            if (node2 != null) {
                prev.next = node2;
            }
            return prevHead.next;
        }
    }

    static class Solution_递归 {
        public ListNode Merge(ListNode list1, ListNode list2) {
            if (list1 == null && list2 == null) {
                return null;
            } else if (list1 == null) {
                return list2;
            } else if (list2 == null) {
                return list1;
            } else {
                if (list1.val <= list2.val) {
                    list1.next = Merge(list1.next, list2);
                    return list1;
                } else {
                    list2.next = Merge(list1, list2.next);
                    return list2;
                }
            }
        }
    }

}
