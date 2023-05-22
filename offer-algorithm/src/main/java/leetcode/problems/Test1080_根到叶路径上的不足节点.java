package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1080_根到叶路径上的不足节点 {

    public static void main(String[] args) {
        TreeNode treeNode = new Solution().sufficientSubset(
                new TreeNode(
                        5,
                        new TreeNode(
                                4,
                                new TreeNode(
                                        11,
                                        new TreeNode(7),
                                        new TreeNode(1)
                                ),
                                null
                        ),
                        new TreeNode(
                                8,
                                new TreeNode(17),
                                new TreeNode(
                                        4,
                                        new TreeNode(5),
                                        new TreeNode(3)
                                )
                        )
                ),
                22
        );
        System.out.println(treeNode);
    }

    static class Solution {
        Map<TreeNode, List<Boolean>> nodeFlagsMap = new HashMap<>();
        int limit;

        public TreeNode sufficientSubset(TreeNode root, int limit) {
            this.limit = limit;
            // 检查所有根到叶路径，若结果不满足小于limit，路上所有节点标记为false，若满足则标记为true
            dfsPath(root, new ArrayList<>());
            // 从上到下删除所有标记全为负的节点
            if (!nodeFlagsMap.getOrDefault(root, new ArrayList<>()).stream().reduce(Boolean::logicalOr).orElse(false)) {
                return null;
            }
            dfsDelete(root);
            return root;
        }

        private void dfsDelete(TreeNode node) {
            if (node == null) {
                return;
            }
            boolean isLeftValid = node.left != null && nodeFlagsMap.getOrDefault(node.left, new ArrayList<>()).stream().reduce(Boolean::logicalOr).orElse(false);
            if (!isLeftValid) {
                node.left = null;
            }
            boolean isRightValid = node.right != null && nodeFlagsMap.getOrDefault(node.right, new ArrayList<>()).stream().reduce(Boolean::logicalOr).orElse(false);
            if (!isRightValid) {
                node.right = null;
            }
            dfsDelete(node.left);
            dfsDelete(node.right);
        }

        private void dfsPath(TreeNode root, List<TreeNode> path) {
            if (root == null) {
                return;
            }
            path.add(root);
            if (root.left == null && root.right == null) {
                int sum = 0;
                for (TreeNode node : path) {
                    sum += node.val;
                }
                boolean result = sum >= limit;
                for (TreeNode node : path) {
                    List<Boolean> list = nodeFlagsMap.getOrDefault(node, new ArrayList<>());
                    list.add(result);
                    nodeFlagsMap.put(node, list);
                }
            } else {
                dfsPath(root.left, path);
                dfsPath(root.right, path);
            }
            path.remove(path.size() - 1);
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

        @Override
        public String toString() {
            return "(" + val + ")";
        }
    }

}
