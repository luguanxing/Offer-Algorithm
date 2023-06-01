package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Test1110_删点成林 {

    public static void main(String[] args) {
        System.out.println(new Solution().delNodes(
                new TreeNode(
                        1,
                        new TreeNode(
                                2,
                                new TreeNode(4),
                                new TreeNode(3)
                        ),
                        null
                ),
                new int[]{2, 3}
        ));
    }

    static class Solution {
        public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
            Set<Integer> delSet = Arrays
                    .stream(to_delete)
                    .boxed()
                    .collect(Collectors.toSet());
            List<TreeNode> roots = new ArrayList<>();
            dfs(null, root, roots, delSet);
            return roots;
        }

        private void dfs(TreeNode parent, TreeNode root, List<TreeNode> roots, Set<Integer> delSet) {
            if (root == null) {
                return;
            }
            if (parent == null && !delSet.contains(root.val)) {
                roots.add(root);
            }
            if (!delSet.contains(root.val)) {
                // 保留该节点
                dfs(root, root.left, roots, delSet);
                dfs(root, root.right, roots, delSet);
            } else {
                //  删除该节点
                if (parent != null) {
                    if (parent.left == root) {
                        parent.left = null;
                    }
                    if (parent.right == root) {
                        parent.right = null;
                    }
                }
                dfs(null, root.left, roots, delSet);
                dfs(null, root.right, roots, delSet);
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

        @Override
        public String toString() {
            return "[" + val + ']';
        }
    }

}
