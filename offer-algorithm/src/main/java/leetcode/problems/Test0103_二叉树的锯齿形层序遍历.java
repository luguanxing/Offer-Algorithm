package leetcode.problems;

import java.util.*;

public class Test0103_二叉树的锯齿形层序遍历 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(9);
        TreeNode right = new TreeNode(20);
        TreeNode rightLeft = new TreeNode(15);
        TreeNode rightRight = new TreeNode(7);
        root.left = left;
        root.right = right;
        right.left = rightLeft;
        right.right = rightRight;
        System.out.println(new Solution().zigzagLevelOrder(root));
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        Map<Integer, List<Integer>> map = new TreeMap<>();

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            preOrder(root, 0);
            return zTravel();
        }

        private void preOrder(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            List<Integer> list = map.getOrDefault(level, new ArrayList<>());
            list.add(root.val);
            map.put(level, list);
            preOrder(root.left, level + 1);
            preOrder(root.right, level + 1);
        }

        private List<List<Integer>> zTravel() {
            List<List<Integer>> res = new ArrayList<>();
            boolean flag = false;
            for (int level : map.keySet()) {
                List<Integer> list = map.get(level);
                if (flag) {
                    Collections.reverse(list);
                }
                flag = !flag;
                res.add(list);
            }
            return res;
        }
    }

}
