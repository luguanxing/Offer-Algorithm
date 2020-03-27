package offer;

public class Test26_树的子结构 {

    public static void main(String[] args) {
        TreeNode left1 = new TreeNode(8);
        TreeNode left11 = new TreeNode(8);
        TreeNode left111 = new TreeNode(9);
        TreeNode left112 = new TreeNode(2);
        TreeNode left1121 = new TreeNode(4);
        TreeNode left1122 = new TreeNode(7);
        TreeNode left12 = new TreeNode(7);
        left1.left = left11;
        left1.right = left12;
        left11.left = left111;
        left11.right = left112;
        left112.left = left1121;
        left112.right = left1122;
        TreeNode right1 = new TreeNode(8);
        TreeNode right11 = new TreeNode(9);
        TreeNode right12 = new TreeNode(2);
        right1.left = right11;
        right1.right = right12;
        System.out.println(new Solution().HasSubtree(left1, null));
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
        private boolean hasSame = false;

        public boolean HasSubtree(TreeNode root1, TreeNode root2) {
            if (root2 == null) {
                return false;
            }
            // 遍历A树，找和B树根相同的节点
            preOrderFindAndCheck(root1, root2);
            return hasSame;
        }

        private void preOrderFindAndCheck(TreeNode root1, TreeNode root2) {
            if (root1 == null) {
                return;
            }
            if (root1.val == root2.val) {
                hasSame = hasSame || checkSubtree(root1, root2);
            }
            preOrderFindAndCheck(root1.left, root2);
            preOrderFindAndCheck(root1.right, root2);
        }

        private boolean checkSubtree(TreeNode root1, TreeNode root2) {
            if (root2 == null) {
                return true;
            } else if (root1 != null && root2 != null) {
                if (root1.val == root2.val) {
                    return checkSubtree(root1.left, root2.left) && checkSubtree(root1.right, root2.right);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

}
