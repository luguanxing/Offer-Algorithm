package leetcode.problems;

public class Test0108_将有序数组转换为二叉搜索树 {

    public static void main(String[] args) {
        TreeNode root = new Solution().sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        System.out.println(root);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public TreeNode sortedArrayToBST(int[] nums) {
            if (nums == null || nums.length == 0) {
                return null;
            }
            return getTree(nums, 0, nums.length - 1);
        }

        public TreeNode getTree(int[] nums, int left, int right) {
            // 从中间生成节点，左右子树递归
            if (left > right) {
                return null;
            }
            int mid = (left + right) / 2;
            TreeNode root = new TreeNode(nums[mid]);
            root.left = getTree(nums, left, mid - 1);
            root.right = getTree(nums, mid + 1, right);
            return root;
        }
    }


}
