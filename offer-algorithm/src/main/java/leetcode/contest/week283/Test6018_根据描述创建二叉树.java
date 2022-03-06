package leetcode.contest.week283;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test6018_根据描述创建二叉树 {

    public static void main(String[] args) {
        System.out.println(new Solution().createBinaryTree(new int[][]{
                {20, 15, 1}, {20, 17, 0}, {50, 20, 1}, {50, 80, 0}, {80, 19, 1}
        }));
        System.out.println(new Solution().createBinaryTree(new int[][]{
                {1, 2, 1}, {2, 3, 0}, {3, 4, 1}
        }));
    }

    static class Solution {
        public TreeNode createBinaryTree(int[][] descriptions) {
            Map<Integer, TreeNode> nodeMap = new HashMap<>();
            Set<Integer> childrenSet = new HashSet<>();
            for (int[] description : descriptions) {
                int parent = description[0];
                int child = description[1];
                int isLeft = description[2];
                TreeNode parentNode = nodeMap.getOrDefault(parent, new TreeNode(parent));
                TreeNode childNode = nodeMap.getOrDefault(child, new TreeNode(child));
                if (isLeft == 1) {
                    parentNode.left = childNode;
                } else {
                    parentNode.right = childNode;
                }
                nodeMap.put(parent, parentNode);
                nodeMap.put(child, childNode);
                childrenSet.add(child);
            }
            for (int nodeVal : nodeMap.keySet()) {
                if (!childrenSet.contains(nodeVal)) {
                    return nodeMap.get(nodeVal);
                }
            }
            return null;
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
            return "TreeNode{" +
                    "val=" + val +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

}
