package offer;

/*
    	    1
          /  \
         2   3
        / \
       4  5

            1
          /  \
         3    2
             / \
            5   4
 */
public class Test27_二叉树的镜像 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node11 = new TreeNode(4);
        TreeNode node12 = new TreeNode(5);
        node.left = node1;
        node.right = node2;
        node1.left = node11;
        node1.right = node12;
        new Solution().Mirror(node);
        System.out.println(node);
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
        public void Mirror(TreeNode root) {
            if (root == null) {
                return;
            }
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.left = right;
            root.right = left;
            Mirror(root.left);
            Mirror(root.right);
        }
    }

}
