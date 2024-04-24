package leetcode.problems;

import java.util.*;

public class Test2385_感染二叉树需要的总时间 {

    public static void main(String[] args) {

    }

    static class Solution {
        Map<Integer, List<Integer>> reachMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();
        int max = 0;

        public int amountOfTime(TreeNode root, int start) {
            buildReachMap(root);
            dfs(start, 0);
            return max;
        }

        private void buildReachMap(TreeNode root) {
            if (root == null) {
                return;
            }
            if (root.left != null) {
                reachMap.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.left.val);
                reachMap.computeIfAbsent(root.left.val, k -> new ArrayList<>()).add(root.val);
                buildReachMap(root.left);
            }
            if (root.right != null) {
                reachMap.computeIfAbsent(root.val, k -> new ArrayList<>()).add(root.right.val);
                reachMap.computeIfAbsent(root.right.val, k -> new ArrayList<>()).add(root.val);
                buildReachMap(root.right);
            }
        }

        private void dfs(int start, int level) {
            visited.add(start);
            for (int next : reachMap.getOrDefault(start, new ArrayList<>())) {
                if (!visited.contains(next)) {
                    max = Math.max(max, level + 1);
                    dfs(next, level + 1);
                }
            }
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
