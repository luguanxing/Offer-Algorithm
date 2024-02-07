package leetcode.problems;

import java.util.*;

public class Test2641_二叉树的堂兄弟节点II {

    public static void main(String[] args) {
        // root = [5,4,9,1,10,null,7]
        TreeNode res = new Solution().replaceValueInTree(
                new TreeNode(5,
                        new TreeNode(4,
                                new TreeNode(1),
                                new TreeNode(10)
                        ),
                        new TreeNode(9,
                                null,
                                new TreeNode(7)
                        )
                )
        );
        System.out.println(res);
    }

    static class Solution {
        Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        Map<TreeNode, Integer> valMap = new HashMap<>();
        Map<Integer, List<TreeNode>> depthMap = new HashMap<>();

        public TreeNode replaceValueInTree(TreeNode root) {
            dfs(root, 0);
            for (int depth = 0; depth < depthMap.size(); depth++) {
                List<TreeNode> nodes = depthMap.get(depth);
                int sum = nodes.stream().mapToInt(valMap::get).sum();
                for (TreeNode node : nodes) {
                    TreeNode parent = parentMap.get(node);
                    if (parent == null) {
                        node.val = 0;
                        continue;
                    }
                    int currentSum = sum;
                    currentSum -= valMap.getOrDefault(parent.left, 0);
                    currentSum -= valMap.getOrDefault(parent.right, 0);
                    node.val = currentSum;
                }
            }
            return root;
        }

        private void dfs(TreeNode root, int index) {
            if (root == null) {
                return;
            }
            depthMap.computeIfAbsent(index, k -> new ArrayList<>()).add(root);
            valMap.put(root, root.val);
            if (root.left != null) {
                parentMap.put(root.left, root);
                dfs(root.left, index + 1);
            }
            if (root.right != null) {
                parentMap.put(root.right, root);
                dfs(root.right, index + 1);
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
