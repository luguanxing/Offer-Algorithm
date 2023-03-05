package leetcode.contest.week355;

import java.util.*;

public class Test6308_二叉树中的第K大层和 {

    public static void main(String[] args) {

    }

    static class Solution {
        public long kthLargestLevelSum(TreeNode root, int k) {
            Map<Integer, Long> map = new HashMap<>();
            dfs(map, root, 0);
            List<Long> list = new ArrayList<>(map.values());
            Collections.sort(list);
            if (list.size() < k) {
                return -1;
            } else {
                return list.get(list.size() - k);
            }
        }

        private void dfs(Map<Integer, Long> map, TreeNode root, int level) {
            if (root == null) {
                return;
            }
            map.put(level, map.getOrDefault(level, 0L) + root.val);
            dfs(map, root.left, level + 1);
            dfs(map, root.right, level + 1);
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
