package offer;

public class Test28_对称的二叉树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;
        System.out.println(new Solution().isSymmetrical(root));
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        boolean isSymmetrical(TreeNode pRoot) {
            if (pRoot == null) {
                return true;
            }
            return checkSymmetrical(pRoot.left, pRoot.right);
        }

        private boolean checkSymmetrical(TreeNode left, TreeNode right) {
            if (left != null && right != null) {
                if (left.val != right.val) {
                    return false;
                }
                return checkSymmetrical(left.right, right.left) && checkSymmetrical(left.left, right.right);
            } else if (left == null && right == null) {
                return true;
            } else {
                return false;
            }
        }
    }

}
