package leetcode.problems;

import java.util.*;

public class Test1026_节点与其祖先之间的最大差值 {

    public static void main(String[] args) {

    }

    static class Solution {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int res = 0;

        public int maxAncestorDiff(TreeNode root) {
            dfs(root);
            return res;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            if (!treeMap.isEmpty()) {
                int min = treeMap.firstKey();
                int max = treeMap.lastKey();
                res = Math.max(res, Math.abs(min - root.val));
                res = Math.max(res, Math.abs(max - root.val));
            }
            treeMap.put(root.val, treeMap.getOrDefault(root.val, 0) + 1);
            dfs(root.left);
            dfs(root.right);
            treeMap.put(root.val, treeMap.get(root.val) - 1);
            if (treeMap.get(root.val) == 0) {
                treeMap.remove(root.val);
            }
        }
    }

    static class Solution_暴力循环 {
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
