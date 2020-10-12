package leetcode.problems;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Test0530_二叉搜索树的最小绝对差 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(726);
        TreeNode left = new TreeNode(296);
        TreeNode right = new TreeNode(785);
        TreeNode leftRight = new TreeNode(543);
        TreeNode rightRight = new TreeNode(822);
        root.left = left;
        root.right = right;
        left.right = leftRight;
        right.right = rightRight;
        System.out.println(new Solution().getMinimumDifference(root));
    }

    static class Solution {
        public int getMinimumDifference(TreeNode root) {
            Set<Integer> set = new TreeSet<>();
            preOrder(root, set);
            Integer last = null;
            Integer min = Integer.MAX_VALUE;
            for (int num : set) {
                if (last != null) {
                    min = Math.min(min, Math.abs(num - last));
                }
                last = num;
            }
            return min;
        }

        private void preOrder(TreeNode root, Set<Integer> set) {
            if (root == null) {
                return;
            }
            set.add(root.val);
            preOrder(root.left, set);
            preOrder(root.right, set);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
