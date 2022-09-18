package leetcode.contest.week311;

import java.util.*;

public class Test6182_反转二叉树的奇数层 {

    public static void main(String[] args) {

    }

    static class Solution {
        Map<Integer, List<Integer>> levelMap;

        public TreeNode reverseOddLevels(TreeNode root) {
            levelMap = new HashMap<>();
            dfs(root, 0);
            for (int level : levelMap.keySet()) {
                if (level % 2 == 0) {
                    continue;
                }
                List<Integer> list = levelMap.get(level);
                Collections.reverse(list);
            }
            dfsSet(root, 0);
            return root;
        }

        private void dfs(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            List<Integer> list = levelMap.getOrDefault(level, new ArrayList<>());
            list.add(root.val);
            levelMap.put(level, list);
            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
        }

        private void dfsSet(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            List<Integer> list = levelMap.get(level);
            root.val = list.get(0);
            list.remove(0);
            dfsSet(root.left, level + 1);
            dfsSet(root.right, level + 1);
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
