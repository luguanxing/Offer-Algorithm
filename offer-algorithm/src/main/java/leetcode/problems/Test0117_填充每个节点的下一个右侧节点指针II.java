package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test0117_填充每个节点的下一个右侧节点指针II {

    public static void main(String[] args) {
        Node root = new Node(1, new Node(2), new Node(3), null);
        System.out.println(new Solution().connect(root));
        System.out.println(root);
    }

    static class Solution {
        Map<Integer, List<Node>> levels = new HashMap<>();

        public Node connect(Node root) {
            // 层次遍历
            buildLevel(root, 0);
            // 构造右指针
            for (List<Node> list : levels.values()) {
                for (int i = 0; i < list.size() - 1; i++) {
                    list.get(i).next = list.get(i + 1);
                }
            }
            return root;
        }

        private void buildLevel(Node root, int level) {
            if (root == null) {
                return;
            }
            List<Node> list = levels.getOrDefault(level, new ArrayList<>());
            list.add(root);
            levels.put(level, list);
            buildLevel(root.left, level + 1);
            buildLevel(root.right, level + 1);
        }
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }


}
