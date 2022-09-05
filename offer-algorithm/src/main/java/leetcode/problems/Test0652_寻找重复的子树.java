package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test0652_寻找重复的子树 {

    public static void main(String[] args) {
        System.out.println(new Solution().findDuplicateSubtrees(
                new TreeNode(
                        2,
                        new TreeNode(1),
                        new TreeNode(1)
                )
        ));
    }

    static class Solution {
        Map<TreeNode, String> nodeStrMap = new HashMap<>();

        public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
            dfs(root);

            Map<String, List<TreeNode>> strNodesMap = new HashMap<>();
            for (Map.Entry<TreeNode, String> entry : nodeStrMap.entrySet()) {
                TreeNode node = entry.getKey();
                String str = entry.getValue();
                List<TreeNode> nodes = strNodesMap.getOrDefault(str, new ArrayList<>());
                nodes.add(node);
                strNodesMap.put(str, nodes);
            }

            List<TreeNode> result = new ArrayList<>();
            for (List<TreeNode> nodes : strNodesMap.values()) {
                if (nodes.size() > 1) {
                    result.add(nodes.get(0));
                }
            }
            return result;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            dfs(root.left);
            dfs(root.right);
            String rootStr = root.val
                    + "["
                    + nodeStrMap.getOrDefault(root.left, "")
                    + "]["
                    + nodeStrMap.getOrDefault(root.right, "")
                    + "]";
            nodeStrMap.put(root, rootStr);
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
