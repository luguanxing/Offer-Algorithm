package offer;

import java.util.ArrayList;

public class Test32_把二叉树打印成多行 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node11 = new TreeNode(4);
        TreeNode node12 = new TreeNode(5);
        TreeNode node22 = new TreeNode(6);
        node.left = node1;
        node.right = node2;
        node1.left = node11;
        node1.right = node12;
        node2.right = node22;
        System.out.println(new Solution().Print(node));
    }

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }


    static class Solution {
        private ArrayList<ArrayList<Integer>> levels = new ArrayList<>();

        ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
            // 递归记录层级并在对应列表添加
            levels.clear();
            bfs(pRoot, 0);
            // 返回结果
            return levels;
        }

        private void bfs(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            if (levels.size() <= level) {
                levels.add(level, new ArrayList<>());
            }
            levels.get(level).add(root.val);
            bfs(root.left, level + 1);
            bfs(root.right, level + 1);
        }
    }

}
