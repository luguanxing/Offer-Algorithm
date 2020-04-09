package offer;

import java.util.ArrayList;
import java.util.List;

public class Test54_二叉搜索树的第k个结点 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(7);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(4);
        TreeNode node21 = new TreeNode(6);
        TreeNode node22 = new TreeNode(8);
        node.left = node1;
        node.right = node2;
        node1.left = node11;
        node1.right = node12;
        node2.left = node21;
        node2.right = node22;
        System.out.println(new Solution().KthNode(node, 0));
        System.out.println(new Solution().KthNode(node, 3));
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
        @Override
        public String toString() {
            return "" + val;
        }
    }

    static class Solution {
        TreeNode KthNode(TreeNode pRoot, int k) {
            if (pRoot == null || k == 0) {
                return null;
            }
            // 按左中右遍历树所有节点结果即排好序
            List<TreeNode> nodes = new ArrayList<>();
            inOrder(pRoot, nodes);
            if (k > nodes.size()) {
                return null;
            }
            return nodes.get(k-1);
        }

        public void inOrder(TreeNode pRoot, List<TreeNode> nodes) {
            if (pRoot == null) {
                return;
            }
            inOrder(pRoot.left, nodes);
            nodes.add(pRoot);
            inOrder(pRoot.right, nodes);
        }
    }

}
