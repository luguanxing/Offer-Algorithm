package leetcode.problems;

import java.util.*;

public class Test2476_二叉搜索树最近节点查询 {

    public static void main(String[] args) {

    }

    static class Solution {
        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            TreeSet<Integer> set = new TreeSet<>();
            dfs(root, set);
            List<List<Integer>> res = new ArrayList<>();
            for (int query : queries) {
                res.add(Arrays.asList(
                        set.contains(query)? query : set.lower(query) == null ? -1 : set.lower(query),
                        set.contains(query)? query : set.higher(query) == null ? -1 : set.higher(query)
                ));
            }
            return res;
        }

        private void dfs(TreeNode root, TreeSet<Integer> set) {
            if (root == null) {
                return;
            }
            set.add(root.val);
            dfs(root.left, set);
            dfs(root.right, set);
        }
    }

    static class Solution_遍历树 {
        public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
            List<List<Integer>> res = new ArrayList<>();
            for (int query : queries) {
                List<Integer> list = new ArrayList<>();
                // 查询小于等于query的最大值
                list.add(queryLessMax(root, query, Integer.MAX_VALUE));
                // 查询大于等于query的最小值
                list.add(queryLargerMin(root, query, Integer.MIN_VALUE));
                res.add(list);
            }
            return res;
        }

        private Integer queryLessMax(TreeNode root, int query, int lastVal) {
            if (root == null) {
                if (lastVal > query) {
                    return -1;
                }
                return lastVal;
            }
            if (root.val == query) {
                return root.val;
            }
            if (root.val < query) {
                // 当前节点小于查询值，保留该值，继续向右查找
                return queryLessMax(root.right, query, root.val);
            } else {
                // 当前节点大于查询值，不能要该值，继续向左查找
                return queryLessMax(root.left, query, lastVal);
            }
        }

        private Integer queryLargerMin(TreeNode root, int query, int lastVal) {
            if (root == null) {
                if (lastVal < query) {
                    return -1;
                }
                return lastVal;
            }
            if (root.val == query) {
                return root.val;
            }
            if (root.val < query) {
                // 当前节点小于查询值，不能要该值，继续向右查找
                return queryLargerMin(root.right, query, lastVal);
            } else {
                // 当前节点大于查询值，保留该值，继续向左查找
                return queryLargerMin(root.left, query, root.val);
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
