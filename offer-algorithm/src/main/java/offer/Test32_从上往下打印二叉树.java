package offer;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Test32_从上往下打印二叉树 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node11 = new TreeNode(4);
        TreeNode node12 = new TreeNode(5);
        TreeNode node22 = new TreeNode(6);
        node.left = node1;
        node.right = node2;
        node1.left = node11;
        node1.right = node12;
        node2.right = node22;
        System.out.println(new Solution().PrintFromTopToBottom(node));
        new Solution_层级分隔打印().PrintFromTopToBottom(node);
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> result = new ArrayList<>();
            if (root == null) {
                return result;
            }
            // 从根节点开始遍历
            Deque<TreeNode> deque = new LinkedBlockingDeque<>();
            deque.add(root);
            // 不断从队列头取出节点，并将子节点放入到队列末尾
            while (!deque.isEmpty()) {
                TreeNode node = deque.pollFirst();
                result.add(node.val);
                if (node.left != null) {
                    deque.add(node.left);
                }
                if (node.right != null) {
                    deque.add(node.right);
                }
            }
            return result;
        }
    }

    static class Solution_层级分隔打印 {
        private Map<Integer, List<Integer>> levels = new HashMap<>();

        public void PrintFromTopToBottom(TreeNode root) {
            // 递归记录层级并在对应列表添加
            levels.clear();
            bfs(root, 0);
            // 输出结果
            System.out.println(levels);
        }

        private void bfs(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (!levels.containsKey(level)) {
                levels.put(level, new ArrayList<>());
            }
            levels.get(level).add(root.val);
            bfs(root.left, level + 1);
            bfs(root.right, level + 1);
        }
    }

}
