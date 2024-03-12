package leetcode.problems;

import java.util.*;

public class Test1261_在受污染的二叉树中查找元素 {

    public static void main(String[] args) {

    }

    static class FindElements {
        Set<Integer> set = new HashSet<>();

        // 还原二叉树
        public FindElements(TreeNode root) {
            root.val = 0;
            set.add(0);
            dfs(root.left, 0, true);
            dfs(root.right, 0, false);
        }

        private void dfs(TreeNode node, int lastVal, boolean isLeft) {
            if (node == null) {
                return;
            }
            node.val = lastVal * 2 + (isLeft ? 1 : 2);
            set.add(node.val);
            dfs(node.left, node.val, true);
            dfs(node.right, node.val, false);
        }

        // 查找某个值的元素
        public boolean find(int target) {
            return set.contains(target);
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
