package leetcode.problems;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Test1161_最大层内元素和 {

    public static void main(String[] args) {

    }

    static class Solution {
        public int maxLevelSum(TreeNode root) {
            Map<Integer, Integer> levelSumMap = new TreeMap<>();
            dfs(root, 1, levelSumMap);
            int maxSum = levelSumMap
                    .values()
                    .stream()
                    .max(Integer::compareTo)
                    .get();
            for (int level : levelSumMap.keySet()) {
                if (maxSum == levelSumMap.get(level)) {
                    return level;
                }
            }
            return 0;
        }

        private void dfs(TreeNode node, int level, Map<Integer, Integer> levelSumMap) {
            if (node == null) {
                return;
            }
            int sum = levelSumMap.getOrDefault(level, 0);
            sum += node.val;
            levelSumMap.put(level, sum);
            dfs(node.left, level + 1, levelSumMap);
            dfs(node.right, level + 1, levelSumMap);
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
