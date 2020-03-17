package offer;

import java.util.ArrayList;
import java.util.List;

public class Test08_二叉树的下一个节点 {

    public static void main(String[] args) {
        TreeLinkNode root = new TreeLinkNode(1);
        TreeLinkNode left = new TreeLinkNode(2);
        TreeLinkNode right = new TreeLinkNode(3);
        root.left = left;
        root.right = right;
        left.next = root;
        right.next = root;
        System.out.println(new Solution().GetNext(right).val);
    }

    static class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;
        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    static class Solution {
        private List<TreeLinkNode> inOrderList = new ArrayList<>();

        public TreeLinkNode GetNext(TreeLinkNode pNode) {
            if (pNode == null) {
                return null;
            }
            // 找到根节点
            TreeLinkNode root = pNode;
            while (root.next != null) {
                root = root.next;
            }
            // 保存中序遍历顺序
            inOrder(root);
            // 根据中序遍历顺序找到下一个节点
            for (int i = 0; i < inOrderList.size() - 1; i++) {
                if (inOrderList.get(i) == pNode) {
                    return inOrderList.get(i+1);
                }
            }
            return null;
        }

        public void inOrder(TreeLinkNode node) {
            if (node == null) {
                return;
            }
            inOrder(node.left);
            inOrderList.add(node);
            inOrder(node.right);
        }
    }

}
