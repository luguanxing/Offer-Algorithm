package leetcode.problems;

import java.util.TreeMap;

public class Test1448_统计二叉树中好节点的数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().goodNodes(
                new TreeNode(
                        3,
                        new TreeNode(1, new TreeNode(3), null),
                        new TreeNode(4, new TreeNode(1), new TreeNode(5))
                )
        ));
        System.out.println(new Solution().goodNodes(
                new TreeNode(
                        3,
                        new TreeNode(3, new TreeNode(4), new TreeNode(2)),
                        null
                )
        ));
        System.out.println(new Solution().goodNodes(
                new TreeNode(1)
        ));
    }

    static class Solution {
        int total = 0;
        TreeMap<Integer, Integer> pathMap = new TreeMap<>();

        public int goodNodes(TreeNode root) {
            dfs(root);
            return total;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            int current = root.val;
            if (pathMap.isEmpty() || current >= pathMap.lastKey()) {
                total++;
            }
            pathMap.put(current, pathMap.getOrDefault(current, 0) + 1);
            dfs(root.left);
            dfs(root.right);
            pathMap.put(current, pathMap.get(current) - 1);
            if (pathMap.get(current) == 0) {
                pathMap.remove(current);
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
