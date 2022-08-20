package leetcode.problems;

import java.util.Arrays;

public class Test0654_最大二叉树 {

    public static void main(String[] args) {
        System.out.println(new Solution().constructMaximumBinaryTree(new int[]{3, 2, 1, 6, 0, 5}));
        System.out.println(new Solution().constructMaximumBinaryTree(new int[]{3, 2, 1}));
    }

    static class Solution {
        public TreeNode constructMaximumBinaryTree(int[] nums) {
            int len = nums.length;
            return build(nums, 0, len);
        }

        private TreeNode build(int[] nums, int left, int right) {
            if (left >= right) {
                return null;
            }
            int max = -1;
            int index = -1;
            for (int i = left; i < right; i++) {
                if (nums[i] > max) {
                    max = nums[i];
                    index = i;
                }
            }
            TreeNode root = new TreeNode(max);
            root.left = build(nums, left, index);
            root.right = build(nums, index + 1, right);
            return root;
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
