package leetcode.problems;

import java.util.Arrays;

public class Test0889_根据前序和后序遍历构造二叉树 {

    public static void main(String[] args) {
        // preorder = [1,2,4,5,3,6,7], postorder = [4,5,2,6,7,3,1]
        TreeNode node = new Solution().constructFromPrePost(
                new int[]{1, 2, 4, 5, 3, 6, 7},
                new int[]{4, 5, 2, 6, 7, 3, 1}
        );
        System.out.println(node);
        // preorder = [1], postorder = [1]
        node = new Solution().constructFromPrePost(
                new int[]{1},
                new int[]{1}
        );
        System.out.println(node);
    }

    static class Solution {
        public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
            if (postorder == null || postorder.length == 0) {
                return null;
            }
            if (preorder.length == 1) {
                return new TreeNode(preorder[0]);
            }
            int rootVal = preorder[0];
            int leftVal = preorder[1];
            int leftIndex = -1;
            for (int i = 0; i < postorder.length; i++) {
                if (postorder[i] == leftVal) {
                    leftIndex = i;
                    break;
                }
            }
            return new TreeNode(
                    rootVal,
                    constructFromPrePost(
                            Arrays.copyOfRange(preorder, 1, leftIndex + 2),
                            Arrays.copyOfRange(postorder, 0, leftIndex + 1)
                    ),
                    constructFromPrePost(
                            Arrays.copyOfRange(preorder, leftIndex + 2, preorder.length),
                            Arrays.copyOfRange(postorder, leftIndex + 1, postorder.length - 1)
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
