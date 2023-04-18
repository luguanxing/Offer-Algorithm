package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test1026_节点与其祖先之间的最大差值 {

    public static void main(String[] args) {

    }

    static class Solution {
        List<Integer> vals = new ArrayList<>();
        int res = 0;

        public int maxAncestorDiff(TreeNode root) {
            dfs(root);
            return res;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            for (int val : vals) {
                res = Math.max(res, Math.abs(val - root.val));
            }
            vals.add(root.val);
            dfs(root.left);
            dfs(root.right);
            vals.remove(vals.size() - 1);
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
