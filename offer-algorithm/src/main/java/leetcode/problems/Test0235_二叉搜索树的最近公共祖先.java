package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0235_二叉搜索树的最近公共祖先 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(4);
        TreeNode leftleft = new TreeNode(1);
        root.left = left;
        root.right = right;
        left.left = leftleft;
        System.out.println(new Solution().lowestCommonAncestor(root, leftleft, right).val);
        System.out.println(new Solution().lowestCommonAncestor(root, leftleft, left).val);
    }

    static class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 向下找，直到找到分叉点为止
            TreeNode current = root;
            while ((current.val < p.val && current.val < q.val) || (p.val < current.val && q.val < current.val)) {
                if (current.val < p.val && current.val < q.val) {
                    current = current.right;
                } else {
                    current = current.left;
                }
            }
            return current;
        }
    }

    static class Solution_找路径 {
        List<TreeNode> path = null;
        List<TreeNode> pathP = null;
        List<TreeNode> pathQ = null;

        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            // 从root开始分别找到达p点和q点的路径
            findPath(root, p, new ArrayList<>());
            pathP = new ArrayList<>(path);
            findPath(root, q, new ArrayList<>());
            pathQ = new ArrayList<>(path);
            // 找公共节点
            TreeNode lastNode = pathP.get(0);
            for (int i = 1; i < pathP.size(); i++) {
                TreeNode currentNode = pathP.get(i);
                if (pathQ.contains(currentNode)) {
                    lastNode = currentNode;
                } else {
                    return lastNode;
                }
            }
            return lastNode;
        }

        private void findPath(TreeNode root, TreeNode p, List<TreeNode> current) {
            if (root == null) {
                return;
            }
            current.add(root);
            if (root.val == p.val) {
                path = new ArrayList<>(current);
                return;
            } else if (root.val < p.val) {
                findPath(root.right, p, current);
            } else {
                findPath(root.left, p, current);
            }
            current.remove(current.size() - 1);
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
