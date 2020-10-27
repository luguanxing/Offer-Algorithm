package leetcode.problems;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Test0144_二叉树的前序遍历 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(
                1,
                new TreeNode(
                        2,
                        new TreeNode(4),
                        new TreeNode(5)
                ),
                new TreeNode(3)
        );
        System.out.println(new Solution().preorderTraversal(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            Deque<TreeNode> deque = new ArrayDeque<>();
            List<Integer> res = new ArrayList<>();
            if (root != null) {
                deque.push(root);
            }
            while (!deque.isEmpty()) {
                TreeNode first = deque.pollFirst();
                res.add(first.val);
                if (first.right != null) {
                    deque.addFirst(first.right);
                }
                if (first.left != null) {
                    deque.addFirst(first.left);
                }
            }
            return res;
        }
    }

    static class Solution_递归 {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            preOrder(root, res);
            return res;
        }

        private void preOrder(TreeNode root, List<Integer> res) {
            if (root == null) {
                return;
            }
            res.add(root.val);
            preOrder(root.left, res);
            preOrder(root.right, res);
        }
    }

}
