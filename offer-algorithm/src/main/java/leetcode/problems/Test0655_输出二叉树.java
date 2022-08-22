package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0655_输出二叉树 {

    public static void main(String[] args) {
        System.out.println(new Solution().printTree(
                new TreeNode(
                        1,
                        new TreeNode(2),
                        null
                )
        ));
        System.out.println(new Solution().printTree(
                new TreeNode(
                        1,
                        new TreeNode(
                                2,
                                null,
                                new TreeNode(4)
                        ),
                        new TreeNode(3)
                )
        ));
    }

    static class Solution {
        List<List<String>> result = new ArrayList<>();
        int height;

        public List<List<String>> printTree(TreeNode root) {
            getHeight(root, 1);
            for (int i = 0; i < height; i++) {
                List<String> nodes = new ArrayList<>();
                for (int j = 1; j <= Math.pow(2, height) - 1; j++) {
                    nodes.add("");
                }
                result.add(nodes);
            }
            setNodeValue(root, 0, (int) (Math.pow(2, height - 1) - 1));
            return result;
        }

        private void getHeight(TreeNode root, int currentHeight) {
            if (root == null) {
                return;
            }
            height = Math.max(height, currentHeight);
            getHeight(root.left, currentHeight + 1);
            getHeight(root.right, currentHeight + 1);
        }

        private void setNodeValue(TreeNode root, int y, int x) {
            if (root == null) {
                return;
            }
            result.get(y).set(x, String.valueOf(root.val));
            setNodeValue(root.left, y + 1, (int) (x - Math.pow(2, height - 1 - y - 1)));
            setNodeValue(root.right, y + 1, (int) (x + Math.pow(2, height - 1 - y - 1)));
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
