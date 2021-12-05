package leetcode.contest.week270;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Test5944_从二叉树一个节点到另一个节点每一步的方向 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(1,
                        new TreeNode(3),
                        null
                ),
                new TreeNode(2,
                        new TreeNode(6),
                        new TreeNode(4)
                )
        );
        System.out.println(new Solution().getDirections(root, 3, 6));
    }

    static class Solution {
        private Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        private String res = "";
        private Set<TreeNode> visited = new HashSet<>();

        public String getDirections(TreeNode root, int startValue, int destValue) {
            preOrder(root, null);
            for (TreeNode node : parentMap.keySet()) {
                if (node.val == startValue) {
                    bfs(node, destValue, new StringBuilder());
                }
            }
            return res;
        }

        private void preOrder(TreeNode node, TreeNode parent) {
            if (node == null) {
                return;
            }
            parentMap.put(node, parent);
            preOrder(node.left, node);
            preOrder(node.right, node);
        }

        private void bfs(TreeNode node, int destValue, StringBuilder sb) {
            if (node == null || visited.contains(node) || !res.isEmpty()) {
                return;
            }
            if (node.val == destValue) {
                res = sb.toString();
                return;
            }
            visited.add(node);
            bfs(node.left, destValue, sb.append("L"));
            sb.deleteCharAt(sb.length() - 1);
            bfs(node.right, destValue, sb.append("R"));
            sb.deleteCharAt(sb.length() - 1);
            bfs(parentMap.get(node), destValue, sb.append("U"));
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    static class Solution_OOM {
        private Map<TreeNode, TreeNode> parentMap = new HashMap<>();
        private String res = "";
        private Set<TreeNode> visited = new HashSet<>();

        public String getDirections(TreeNode root, int startValue, int destValue) {
            preOrder(root, null);
            for (TreeNode node : parentMap.keySet()) {
                if (node.val == startValue) {
                    bfs(node, destValue, "");
                }
            }
            return res;
        }

        private void preOrder(TreeNode node, TreeNode parent) {
            if (node == null) {
                return;
            }
            parentMap.put(node, parent);
            preOrder(node.left, node);
            preOrder(node.right, node);
        }

        private void bfs(TreeNode node, int destValue, String currentPath) {
            if (node == null || visited.contains(node) || !res.isEmpty()) {
                return;
            }
            if (node.val == destValue) {
                res = currentPath;
                return;
            }
            visited.add(node);
            bfs(node.left, destValue, currentPath + "L");
            bfs(node.right, destValue, currentPath + "R");
            bfs(parentMap.get(node), destValue, currentPath + "U");
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
