package offer;

public class Test55_二叉树的深度 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        node.left = node1;
        node.right = node2;
        node1.left = node3;
        System.out.println(new Solution().TreeDepth(node));
        System.out.println(new Solution().TreeDepth(node1));
        System.out.println(new Solution().TreeDepth(node2));
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
        public int TreeDepth(TreeNode root) {
            return dfsCheck(root, 0);
        }
        public int dfsCheck(TreeNode root, int currentDepth) {
            if (root == null) {
                return currentDepth;
            }
            return Math.max(dfsCheck(root.left, currentDepth + 1), dfsCheck(root.right, currentDepth + 1));
        }
    }

}
