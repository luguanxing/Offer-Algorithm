package leetcode.problems;

public class Test1145_二叉树着色游戏 {

    public static void main(String[] args) {
        System.out.println(new Solution().btreeGameWinningMove(
                new TreeNode(1, new TreeNode(2), new TreeNode(3)),
                3,
                1
        ));
    }

    static class Solution {
        private TreeNode xRoot = null;

        public boolean btreeGameWinningMove(TreeNode root, int n, int x) {
            findX(root, x);
            // 判断相邻节点能否过半
            int half = (n + 1) / 2;
            int leftCount = getRootChildrenCount(xRoot.left);
            int rightCount = getRootChildrenCount(xRoot.right);
            int parentCount = n - 1 - leftCount - rightCount;
            return leftCount >= half || rightCount >= half || parentCount >= half;
        }

        private void findX(TreeNode root, int x) {
            if (xRoot != null || root == null) {
                return;
            }
            if (root.val == x) {
                xRoot = root;
                return;
            }
            findX(root.left, x);
            findX(root.right, x);
        }

        private int getRootChildrenCount(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftCount = getRootChildrenCount(root.left);
            int rightCount = getRootChildrenCount(root.right);
            return leftCount + rightCount + 1;
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
