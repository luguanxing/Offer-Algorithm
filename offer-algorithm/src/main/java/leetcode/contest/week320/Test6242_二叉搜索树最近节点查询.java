package leetcode.contest.week320;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class Test6242_二叉搜索树最近节点查询 {

    public static void main(String[] args) {
        System.out.println(new Solution().closestNodes(
                new TreeNode(4, null, new TreeNode(9)),
                Arrays.asList(3)
        ));
    }

    static class Solution {
        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            TreeSet<Integer> set = new TreeSet<>();
            dfs(root, set);
            List<List<Integer>> res = new ArrayList<>();
            for (int query : queries) {
                if (set.contains(query)) {
                    res.add(Arrays.asList(query, query));
                    continue;
                }
                Integer lower = set.lower(query);
                Integer higher = set.higher(query);
                res.add(Arrays.asList(lower == null ? -1 : lower, higher == null ? -1 : higher));
            }
            return res;
        }

        private void dfs(TreeNode root, TreeSet<Integer> set) {
            if (root == null) {
                return;
            }
            set.add(root.val);
            dfs(root.left, set);
            dfs(root.right, set);
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
