package leetcode.contest.week199;

import java.util.ArrayList;
import java.util.List;

public class Test5474_好叶子节点对的数量 {

    public static void main(String[] args) {
        TreeNode leftleft = new TreeNode(5);
        TreeNode leftright = new TreeNode(4);
        TreeNode left = new TreeNode(2, leftleft, leftright);
        TreeNode rightleft = new TreeNode(6);
        TreeNode rightright = new TreeNode(7);
        TreeNode right = new TreeNode(3, rightleft, rightright);
        TreeNode root = new TreeNode(1, left, right);
        System.out.println(new Solution().countPairs(root, 3));
    }

    static class Solution {
        List<MyTreeNode> leafs = new ArrayList<>();

        public int countPairs(TreeNode root, int distance) {
            // 构建带父树
            preOrderBuildMyTree(root, null);
            // 穷举叶节点检查路径
            int res = 0;
            for (int i = 0; i < leafs.size(); i++) {
                for (int j = i + 1; j < leafs.size(); j++) {
                    MyTreeNode node1 = leafs.get(i);
                    MyTreeNode node2 = leafs.get(j);
                    List<MyTreeNode> node1Ancestors = new ArrayList<>();
                    while (node1.parent != null) {
                        node1 = node1.parent;
                        node1Ancestors.add(node1);
                    }
                    int cnt2 = 1;
                    node2 = node2.parent;
                    while (!node1Ancestors.contains(node2)) {
                        cnt2++;
                        node2 = node2.parent;
                    }
                    int sum = cnt2 + node1Ancestors.indexOf(node2) + 1;
                    if (sum <= distance) {
                        res++;
                    }
                }
            }
            return res;
        }

        public void preOrderBuildMyTree(TreeNode root, MyTreeNode parent) {
            MyTreeNode myRoot = new MyTreeNode(root.val);
            myRoot.parent = parent;
            if (root.left != null) {
                preOrderBuildMyTree(root.left, myRoot);
            }
            if (root.right != null) {
                preOrderBuildMyTree(root.right, myRoot);
            }
            if (root.left == null && root.right == null) {
                leafs.add(myRoot);
            }
        }

        public class MyTreeNode {
            int val;
            MyTreeNode left;
            MyTreeNode right;
            MyTreeNode parent;

            MyTreeNode() {
            }

            MyTreeNode(int val) {
                this.val = val;
            }

            MyTreeNode(int val, MyTreeNode left, MyTreeNode right, MyTreeNode parent) {
                this.val = val;
                this.left = left;
                this.right = right;
                this.parent = parent;
            }
        }
    }

    public static class TreeNode {
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
