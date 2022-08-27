package leetcode.problems;

import java.util.*;

public class Test0662_二叉树最大宽度 {

    public static void main(String[] args) {
        System.out.println(new Solution().widthOfBinaryTree(
                new TreeNode(
                        1,
                        new TreeNode(
                                3,
                                new TreeNode(5),
                                new TreeNode(3)
                        ),
                        new TreeNode(
                                2,
                                null,
                                new TreeNode(9)
                        )
                )
        ));
        System.out.println(new Solution().widthOfBinaryTree(
                new TreeNode(
                        1,
                        new TreeNode(
                                3,
                                new TreeNode(
                                        5,
                                        new TreeNode(6),
                                        null
                                ),
                                null
                        ),
                        new TreeNode(
                                2,
                                null,
                                new TreeNode(
                                        9,
                                        new TreeNode(7),
                                        null
                                )
                        )
                )
        ));
        System.out.println(new Solution().widthOfBinaryTree(
                new TreeNode(
                        1,
                        new TreeNode(
                                3,
                                new TreeNode(5),
                                null
                        ),
                        new TreeNode(2)
                )
        ));
    }

    static class Solution {
        public int widthOfBinaryTree(TreeNode root) {
            Map<Integer, List<Long>> map = new HashMap<>();
            dfs(root, map, 0, 1);
            long max = 0;
            for (List<Long> list : map.values()) {
                Collections.sort(list);
                max = Math.max(max, list.get(list.size() - 1) - list.get(0) + 1);
            }
            return (int) max;
        }

        private void dfs(TreeNode root, Map<Integer, List<Long>> map, int currentHeight, long idx) {
            if (root == null) {
                return;
            }
            List<Long> list = map.getOrDefault(currentHeight, new ArrayList<>());
            list.add(idx);
            map.put(currentHeight, list);
            dfs(root.left, map, currentHeight + 1, idx * 2);
            dfs(root.right, map, currentHeight + 1, idx * 2 + 1);
        }
    }

    static class Solution_列表 {
        int height = 0;
        Map<Integer, List<Integer>> map = new HashMap<>();

        public int widthOfBinaryTree(TreeNode root) {
            getHeight(root, 1);
            storeMap(root, 1);
            int res = 0;
            for (List<Integer> list : map.values()) {
                while (list.get(0) == -1) {
                    list.remove(0);
                }
                while (list.get(list.size() - 1) == -1) {
                    list.remove(list.size() - 1);
                }
                res = Math.max(res, list.size());
            }
            return res;
        }

        private void getHeight(TreeNode root, int currentHeight) {
            if (root == null) {
                return;
            }
            height = Math.max(height, currentHeight);
            getHeight(root.left, currentHeight + 1);
            getHeight(root.right, currentHeight + 1);
        }

        private void storeMap(TreeNode root, int currentHeight) {
            if (currentHeight > height) {
                return;
            }
            List<Integer> list = map.getOrDefault(currentHeight, new ArrayList<>());
            list.add(root == null ? -1 : root.val);
            map.put(currentHeight, list);
            storeMap(root == null ? null : root.left, currentHeight + 1);
            storeMap(root == null ? null : root.right, currentHeight + 1);
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
