package offer;

public class Test07_重建二叉树 {

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = new Solution().reConstructBinaryTree(pre, in);
        System.out.println(root);
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
        public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
            return construct(pre, 0, pre.length, in, 0, in.length);
        }

        private TreeNode construct(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
            if (preStart == preEnd) {
                return null;
            }
            // 先序第一个点为分叉点
            int branch = pre[preStart];
            TreeNode root = new TreeNode(branch);
            // 找分叉点在中序遍历里对应的点
            int index = 0;
            for (index = inStart; index < inEnd; index++) {
                if (branch == in[index]) {
                    break;
                }
            }
            // 向左子树和右子数继续递归
            int leftSize = index - inStart;
            int rightSize = inEnd - index - 1;
            root.left = construct(pre, preStart + 1, preStart + leftSize + 1, in, inStart, index);
            root.right = construct(pre, preEnd - rightSize, preEnd, in, index + 1, inEnd);
            return root;
        }
    }
}
