package leetcode.problems;

public class Test0701_二叉搜索树中的插入操作 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        new Solution().insertIntoBST(root, 2);
        new Solution().insertIntoBST(root, 5);
        new Solution().insertIntoBST(root, 8);
        new Solution().insertIntoBST(root, 3);
        new Solution().insertIntoBST(root, 6);
        System.out.println(root);
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

    static class Solution {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            TreeNode prev = root;
            TreeNode current = root;
            // 定位val应该所处位置和父节点
            while (current != null) {
                prev = current;
                if (val < current.val) {
                    current = current.left;
                } else {
                    current = current.right;
                }
            }
            // 添加val节点
            if (val < prev.val) {
                prev.left = new TreeNode(val);
            } else {
                prev.right = new TreeNode(val);
            }
            return root;
        }
    }

    static class Solution_递归 {
        public TreeNode insertIntoBST(TreeNode root, int val) {
            if (root == null) {
                return new TreeNode(val);
            }
            if (val < root.val) {
                root.left = insertIntoBST(root.left, val);
            } else {
                root.right = insertIntoBST(root.right, val);
            }
            return root;
        }
    }

}
