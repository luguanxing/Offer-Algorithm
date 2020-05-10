package leetcode;

public class Test27_二叉树的镜像 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node21 = new TreeNode(4);
        TreeNode node22 = new TreeNode(5);
        root.left = node1;
        root.right = node2;
        node2.left = node21;
        node2.right = node22;
        TreeNode rootMirror = new Solution().mirrorTree(root);
        System.out.println(rootMirror);
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public TreeNode mirrorTree(TreeNode root) {
            mirror(root);
            return root;
        }

        public void mirror(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            mirror(root.left);
            mirror(root.right);
        }
    }

}
