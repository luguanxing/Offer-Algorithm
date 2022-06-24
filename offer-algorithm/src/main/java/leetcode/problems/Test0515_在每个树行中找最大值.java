package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0515_在每个树行中找最大值 {

    public static void main(String[] args) {
        System.out.println(new Solution().largestValues(
                new TreeNode(
                        1,
                        new TreeNode(2),
                        new TreeNode(3)
                )
        ));
    }

    static class Solution {
        List<Integer> list = new ArrayList<>();

        public List<Integer> largestValues(TreeNode root) {
            dfs(root, 0);
            return list;
        }

        private void dfs(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (level >= list.size()) {
                list.add(root.val);
            } else {
                list.set(level, Math.max(list.get(level), root.val));
            }
            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
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
