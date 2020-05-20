package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0098_验证二叉搜索树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        System.out.println(new Solution().isValidBST(root));
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
        private List<Integer> result = new ArrayList<>();

        public boolean isValidBST(TreeNode root) {
            // 先序遍历，结果递增则为二叉搜索树
            result.clear();
            inOrder(root);
            String order = result.toString();
            // 判断是否递增
            Collections.sort(result);
            String sortedOrder = new TreeSet<>(result).toString();
            return order.equals(sortedOrder);
        }

        private void inOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            inOrder(root.left);
            result.add(root.val);
            inOrder(root.right);
        }
    }

}
