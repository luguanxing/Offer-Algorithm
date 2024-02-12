package leetcode.problems;

import java.util.*;
import java.util.function.Function;

public class Test0987_二叉树的垂序遍历 {

    public static void main(String[] args) {

    }

    static class Solution {
        Map<Integer, List<int[]>> map = new TreeMap<>();

        public List<List<Integer>> verticalTraversal(TreeNode root) {
            dfs(root, 0, 0);
            List<List<Integer>> res = new ArrayList<>();
            for (int k : map.keySet()) {
                List<int[]> vals = map.get(k);
                List<Integer> r = new ArrayList<>();
                Collections.sort(vals, (o1, o2) -> {
                    if (o1[0] != o2[0]) {
                        return Integer.compare(o1[0], o2[0]);
                    } else {
                        return Integer.compare(o1[1], o2[1]);
                    }
                });
                vals.forEach(o -> r.add(o[1]));
                res.add(r);
            }
            return res;
        }

        private void dfs(TreeNode root, int y, int x) {
            if (root == null) {
                return;
            }
            List<int[]> list = map.getOrDefault(x, new ArrayList<>());
            list.add(new int[]{y, root.val});
            map.put(x, list);
            dfs(root.left, y + 1, x - 1);
            dfs(root.right, y + 1, x + 1);
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
