package offer;

import java.util.ArrayList;

public class Test34_二叉树中和为某一值的路径 {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node11 = new TreeNode(2);
        TreeNode node12 = new TreeNode(1);
        node.left = node1;
        node.right = node2;
        node1.left = node11;
        node1.right = node12;
        System.out.println(new Solution().FindPath(node, 5));
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
        private ArrayList<ArrayList<Integer>> allResults = new ArrayList<>();
        private ArrayList<Integer> currentResult = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            // 递归查找
            dfsFind(root, 0, target);
            // 返回结果
            return allResults;
        }

        private void dfsFind(TreeNode root, int lastSum, int target) {
            if (root == null) {
                return;
            }
            if (root.val + lastSum == target && root.left == null && root.right == null) {
                // 当前已为叶子节点且满足条件，添加到结果集中(注意要复制列表)
                currentResult.add(root.val);
                allResults.add(new ArrayList<>(currentResult));
                currentResult.remove(currentResult.size() - 1);
            } else {
                // 向子节点继续回溯
                if (root.left != null) {
                    currentResult.add(root.val);
                    dfsFind(root.left, lastSum + root.val, target);
                    currentResult.remove(currentResult.size() - 1);
                }
                if (root.right != null) {
                    currentResult.add(root.val);
                    dfsFind(root.right, lastSum + root.val, target);
                    currentResult.remove(currentResult.size() - 1);
                }
            }
        }
    }

    static class Solution_传参不回溯 {
        private ArrayList<ArrayList<Integer>> allResults = new ArrayList<>();

        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
            // 递归查找
            dfsFind(root, new ArrayList<>(), 0, target);
            // 返回结果
            return allResults;
        }

        private void dfsFind(TreeNode root, ArrayList<Integer> currentResult, int currentSum, int target) {
            if (root == null) {
                return;
            }
            if (currentSum + root.val == target && root.left == null && root.right == null) {
                // 到达叶子节点并且和达到目标
                currentResult.add(root.val);
                allResults.add(currentResult);
            } else {
                // 继续向下检测，注意不能直接引用列表，需要复制
                ArrayList<Integer> leftList = new ArrayList<>(currentResult);
                ArrayList<Integer> rightList = new ArrayList<>(currentResult);
                leftList.add(root.val);
                rightList.add(root.val);
                dfsFind(root.left, leftList, currentSum + root.val, target);
                dfsFind(root.right, rightList, currentSum + root.val, target);
            }
        }
    }

}
