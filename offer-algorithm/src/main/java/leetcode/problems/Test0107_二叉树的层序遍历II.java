package leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test0107_二叉树的层序遍历II {

    public static void main(String[] args) {

    }

    static class Solution {
        List<List<Integer>> res = new ArrayList<>();

        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            dfs(root, 0);
            Collections.reverse(res);
            return res;
        }

        private void dfs(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (level == res.size()) {
                res.add(new ArrayList<>());
            }
            res.get(level).add(root.val);
            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
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
