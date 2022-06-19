package leetcode.problems;

import java.util.*;

public class Test0508_出现次数最多的子树元素和 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                new Solution().findFrequentTreeSum(new TreeNode(
                        5,
                        new TreeNode(2),
                        new TreeNode(-3)
                ))
        ));
        System.out.println(Arrays.toString(
                new Solution().findFrequentTreeSum(new TreeNode(
                        5,
                        new TreeNode(2),
                        new TreeNode(-5)
                ))
        ));
    }

    static class Solution {
        Map<TreeNode, Integer> nodeSum = new HashMap<>();

        public int[] findFrequentTreeSum(TreeNode root) {
            postOrder(root);
            Map<Integer, Integer> sumCntMap = new HashMap<>();
            for (int sum : nodeSum.values()) {
                sumCntMap.put(sum, sumCntMap.getOrDefault(sum, 0) + 1);
            }
            int maxSumCnt = sumCntMap.values().stream().reduce(Math::max).get();
            List<Integer> maxSumList = new ArrayList<>();
            for (int sum : sumCntMap.keySet()) {
                int cnt = sumCntMap.get(sum);
                if (cnt == maxSumCnt) {
                    maxSumList.add(sum);
                }
            }
            int[] res = new int[maxSumList.size()];
            for (int i = 0; i < maxSumList.size(); i++) {
                res[i] = maxSumList.get(i);
            }
            return res;
        }

        private void postOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            postOrder(root.left);
            postOrder(root.right);
            nodeSum.put(root, nodeSum.getOrDefault(root.left, 0) + nodeSum.getOrDefault(root.right, 0) + root.val);
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
