package leetcode.problems;

import java.util.Arrays;

public class Test0106_从中序与后序遍历序列构造二叉树 {

    public static void main(String[] args) {
        // inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
        TreeNode node = new Solution().buildTree(
                new int[]{9, 3, 15, 20, 7},
                new int[]{9, 15, 7, 20, 3}
        );
        System.out.println(node);
        // inorder = [-1], postorder = [-1]
        node = new Solution().buildTree(
                new int[]{-1},
                new int[]{-1}
        );
        System.out.println(node);
    }

    static class Solution {
        public TreeNode buildTree(int[] inorder, int[] postorder) {
            if (postorder == null || postorder.length == 0) {
                return null;
            }
            int val = postorder[postorder.length - 1];
            int index = -1;
            for (int i = 0; i < inorder.length; i++) {
                if (inorder[i] == val) {
                    index = i;
                    break;
                }
            }
            return new TreeNode(
                    val,
                    buildTree(
                            Arrays.copyOfRange(inorder, 0, index),
                            Arrays.copyOfRange(postorder, 0, index)
                    ),
                    buildTree(
                            Arrays.copyOfRange(inorder, index + 1, inorder.length),
                            Arrays.copyOfRange(postorder, index, postorder.length - 1)
                    )
            );
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
