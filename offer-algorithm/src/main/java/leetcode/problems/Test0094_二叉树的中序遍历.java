package leetcode.problems;

import java.util.*;

public class Test0094_二叉树的中序遍历 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode rightLeft = new TreeNode(3);
        root.right = right;
        right.left = rightLeft;
        System.out.println(new Solution().inorderTraversal(root));
    }

    static class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            Stack<TreeNode> stack = new Stack<>();
            if (root != null) {
                stack.push(root);
            }
            while (!stack.isEmpty()) {
                TreeNode node = stack.peek();
                // 有左子树先继续检查左子树
                if (node.left != null) {
                    stack.push(node.left);
                    node.left = null;
                    continue;
                }
                // 左子树检查完毕取出当前节点
                stack.pop();
                result.add(node.val);
                // 最后再继续检查右子树
                if (node.right != null) {
                    stack.push(node.right);
                    node.right = null;
                }
            }
            return result;
        }
    }

    static class Solution_递归 {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> result = new ArrayList<>();
            inOrder(root, result);
            return result;
        }

        private void inOrder(TreeNode root, List<Integer> result) {
            if (root == null) {
                return;
            }
            inOrder(root.left, result);
            result.add(root.val);
            inOrder(root.right, result);
        }
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
