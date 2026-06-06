package leetcode.problems;

import java.util.*;

public class Test2196_根据描述创建二叉树 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public TreeNode createBinaryTree(int[][] descriptions) {
            Map<Integer, TreeNode> map = new HashMap<>();
            Map<TreeNode, Boolean> isNotRoot = new HashMap<>();
            for (int[] description : descriptions) {
                int parent = description[0];
                int child = description[1];
                int side = description[2];
                if (map.get(parent) == null) {
                    map.put(parent, new TreeNode(parent));
                }
                if (map.get(child) == null) {
                    map.put(child, new TreeNode(child));
                }
                if (side == 0) {
                    map.get(parent).left = map.get(child);
                } else {
                    map.get(parent).right = map.get(child);
                }
                isNotRoot.put(map.get(child), true);
            }
            for (TreeNode n : map.values()) {
                if (!isNotRoot.containsKey(n)) {
                    return n;
                }
            }
            return null;
        }
    }

}
