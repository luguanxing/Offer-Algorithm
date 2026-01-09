package leetcode.problems;

public class Test0865_具有所有最深节点的最小子树 {

    public static void main(String[] args) {

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        int maxHeight = 0;
        int maxHeightCnt = 0;
        int targetHeight = 0;
        TreeNode target = null;

        public TreeNode subtreeWithAllDeepest(TreeNode root) {
            target = root;
            getMaxHeight(root, 0);
            getMaxHeightCnt(root, 0);
            getMaxHeightNodeCount(root, 0);
            return target;
        }

        public void getMaxHeight(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            maxHeight = Math.max(maxHeight, level);
            getMaxHeight(root.left, level+1);
            getMaxHeight(root.right, level+1);
        }

        public void getMaxHeightCnt(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (level == maxHeight) {
                maxHeightCnt++;
            }
            getMaxHeightCnt(root.left, level+1);
            getMaxHeightCnt(root.right, level+1);
        }

        public int getMaxHeightNodeCount(TreeNode root, int level) {
            if (root == null) {
                return 0;
            }
            int lCnt = getMaxHeightNodeCount(root.left, level+1);
            int rCnt = getMaxHeightNodeCount(root.right, level+1);
            if (lCnt + rCnt == maxHeightCnt && level > targetHeight) {
                targetHeight = level;
                target = root;
            }
            if (maxHeightCnt == 1 && level == maxHeight) {
                targetHeight = level;
                target = root;
            }
            return lCnt + rCnt + (level==maxHeight?1:0);
        }
    }

}
