package leetcode.problems;

public class Test0100_相同的树 {

    public static void main(String[] args) {
        TreeNode r1 = new TreeNode(1);
        TreeNode r11 = new TreeNode(2);
        r1.left = r11;
        TreeNode r2 = new TreeNode(1);
        TreeNode r21 = new TreeNode(3);
        r2.left = r21;
        System.out.println(new Solution().isSameTree(r1, r2));
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if (p == null && q == null) {
                return true;
            } else if (p != null && q != null) {
                if (p.val != q.val) {
                    return false;
                } else {
                    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
                }
            } else {
                return false;
            }
        }
    }

}
