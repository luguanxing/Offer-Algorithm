package leetcode.problems;

import java.util.*;

public class Test0894_所有可能的真二叉树 {

    public static void main(String[] args) {
        List<TreeNode> treeNodes = new Solution().allPossibleFBT(7);
        System.out.println(treeNodes.size());
    }

    static class Solution {
        public List<TreeNode> allPossibleFBT(int n) {
            if (n == 0) {
                return Collections.emptyList();
            }
            if (n == 1) {
                return Collections.singletonList(new TreeNode(0));
            }
            // 该函数生成已root为根的所有可能结果
            TreeNode root = new TreeNode(0);
            List<TreeNode> res = new ArrayList<>();
            for (int i = 1; i < n; i += 2) {
                List<TreeNode> left = allPossibleFBT(i);
                List<TreeNode> right = allPossibleFBT(n - i - 1);
                for (TreeNode l : left) {
                    for (TreeNode r : right) {
                        root.left = l;
                        root.right = r;
                        res.add(copyTree(root));
                    }
                }
            }
            return res;
        }

        private TreeNode copyTree(TreeNode current) {
            TreeNode newNode = new TreeNode(current.val);
            if (current.left != null) {
                newNode.left = copyTree(current.left);
            }
            if (current.right != null) {
                newNode.right = copyTree(current.right);
            }
            return newNode;
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
