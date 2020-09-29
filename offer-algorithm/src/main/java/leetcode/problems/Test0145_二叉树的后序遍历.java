package leetcode.problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Test0145_二叉树的后序遍历 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode rightLeft = new TreeNode(3);
        root.right = right;
        right.left = rightLeft;
        System.out.println(new Solution().postorderTraversal(root));
    }

    static class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            List<Integer> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            stack.add(root);
            while (!stack.isEmpty()) {
                TreeNode top = stack.peek();
                if (top.left == null && top.right == null) {
                    stack.pop();
                    res.add(top.val);
                } else {
                    if (top.left != null) {
                        stack.push(top.left);
                        top.left = null;
                        continue;
                    }
                    if (top.right != null) {
                        stack.push(top.right);
                        top.right = null;
                        continue;
                    }
                }
            }
            return res;
        }
    }

    static class Solution_递归 {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            postOrder(res, root);
            return res;
        }

        public void postOrder(List<Integer> res, TreeNode root) {
            if (root == null) {
                return;
            }
            postOrder(res, root.left);
            postOrder(res, root.right);
            res.add(root.val);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
