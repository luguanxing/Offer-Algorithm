package leetcode.problems;

import java.util.ArrayList;
import java.util.List;

public class Test0095_不同的二叉搜索树II {

    public static void main(String[] args) {
        System.out.println(new Solution().generateTrees(3));
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n == 0) {
                return new ArrayList<>();
            }
            return generateTrees(1, n);
        }

        private List<TreeNode> generateTrees(int left, int right) {
            List<TreeNode> res = new ArrayList<>();
            // 左闭右闭区间
            if (left > right) {
                res.add(null);
                return res;
            }
            for (int root = left; root <= right; root++) {
                List<TreeNode> leftNodes = generateTrees(left, root - 1);
                List<TreeNode> rightNodes = generateTrees(root + 1, right);
                // 左右子树组合成新树
                for (TreeNode leftNode : leftNodes) {
                    for (TreeNode rightNode : rightNodes) {
                        TreeNode newNode = new TreeNode(root, leftNode, rightNode);
                        res.add(newNode);
                    }
                }
            }
            return res;
        }
    }


}
