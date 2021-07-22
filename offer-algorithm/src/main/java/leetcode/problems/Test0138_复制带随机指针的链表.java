package leetcode.problems;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Test0138_复制带随机指针的链表 {

    public static void main(String[] args) {

    }

    static class Solution {
        public Node copyRandomList(Node head) {
            Map<Node, Integer> map = new LinkedHashMap();
            Node node = head;
            int index = 0;
            while (node != null) {
                map.put(node, index++);
                node = node.next;
            }
            List<Node> oldList = new ArrayList<>();
            List<Node> newList = new ArrayList<>();
            for (Node oldNode : map.keySet()) {
                oldList.add(oldNode);
                newList.add(new Node(oldNode.val));
            }
            newList.add(null);
            for (int i = 0; i < newList.size() - 1; i++) {
                newList.get(i).next = newList.get(i+1);
                Node oldRandom = oldList.get(i).random;
                newList.get(i).random = oldRandom == null ? null : newList.get(map.get(oldRandom));
            }
            return newList.get(0);
        }
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
