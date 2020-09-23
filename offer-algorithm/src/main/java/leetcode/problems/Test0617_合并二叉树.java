package leetcode.problems;

public class Test0617_合并二叉树 {

    public static void main(String[] args) {
        TreeNode root1 = new TreeNode(1);
        root1.right = new TreeNode(2);
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(3);
        TreeNode mergeRoot = new Solution().mergeTrees(root1, root2);
        System.out.println(mergeRoot);
    }

    static class Solution {
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            if (t1 == null && t2 == null) {
                return null;
            }
            int val1 = t1 == null ? 0 : t1.val;
            int val2 = t2 == null ? 0 : t2.val;
            TreeNode t = new TreeNode(val1 + val2);
            t.left = mergeTrees(t1 == null ? null : t1.left, t2 == null ? null : t2.left);
            t.right = mergeTrees(t1 == null ? null : t1.right, t2 == null ? null : t2.right);
            return t;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

}
