package leetcode.problems;

import java.util.Arrays;

public class Test0105_从前序与中序遍历序列构造二叉树 {

    public static void main(String[] args) {
        // preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
        TreeNode node = new Solution().buildTree(
                new int[]{3, 9, 20, 15, 7},
                new int[]{9, 3, 15, 20, 7}
        );
        System.out.println(node);
        // preorder = [-1], inorder = [-1]
        node = new Solution().buildTree(
                new int[]{-1},
                new int[]{-1}
        );
        System.out.println(node);
    }

    static class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            int val = preorder[0];
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
                            Arrays.copyOfRange(preorder, 1, index + 1),
                            Arrays.copyOfRange(inorder, 0, index)
                    ),
                    buildTree(
                            Arrays.copyOfRange(preorder, index + 1, preorder.length),
                            Arrays.copyOfRange(inorder, index + 1, inorder.length)
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
