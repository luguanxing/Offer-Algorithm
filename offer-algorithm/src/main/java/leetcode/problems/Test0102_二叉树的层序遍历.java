package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0102_二叉树的层序遍历 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left1 = new TreeNode(4);
        TreeNode left2 = new TreeNode(5);
        root.left = left;
        root.right = right;
        left.left = left1;
        left.right = left2;
        System.out.println(new Solution().levelOrder(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        private List<List<Integer>> result = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            result.clear();
            preOrder(root, 0);
            return result;
        }

        private void preOrder(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (result.size() < level + 1) {
                result.add(new ArrayList<>());
            }
            result.get(level).add(root.val);
            preOrder(root.left, level + 1);
            preOrder(root.right, level + 1);
        }
    }

}
