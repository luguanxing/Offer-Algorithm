package leetcode.contest.week321;

import java.util.ArrayList;
import java.util.List;

public class Test6247_从链表中移除节点 {

    public static void main(String[] args) {
        System.out.println(new Solution().removeNodes(
                new ListNode(5, new ListNode(2, new ListNode(13, new ListNode(3, new ListNode(8)))))
        ));
        System.out.println(new Solution().removeNodes(
                new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(1))))
        ));
    }

    static class Solution {
        public ListNode removeNodes(ListNode head) {
            List<ListNode> nodeList = new ArrayList<>();
            ListNode currentNode = head;
            while (currentNode != null) {
                while (!nodeList.isEmpty()) {
                    ListNode lastNode = nodeList.get(nodeList.size() - 1);
                    if (lastNode.val < currentNode.val) {
                        nodeList.remove(nodeList.size() - 1);
                    } else {
                        break;
                    }
                }
                nodeList.add(currentNode);
                currentNode = currentNode.next;
            }
            nodeList.add(null);
            for (int i = 0; i < nodeList.size() - 1; i++) {
                nodeList.get(i).next = nodeList.get(i + 1);
            }
            return nodeList.get(0);
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
