package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test0501_二叉搜索树中的众数 {

    public static void main(String[] args) {

    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        Map<Integer, Integer> map = new HashMap<>();

        public int[] findMode(TreeNode root) {
            preOrder(root);
            int max = Integer.MIN_VALUE;
            for (Integer num : map.keySet()) {
                Integer cnt = map.get(num);
                max = Math.max(max, cnt);
            }
            List<Integer> list = new ArrayList<>();
            for (Integer num : map.keySet()) {
                Integer cnt = map.get(num);
                if (cnt == max) {
                    list.add(num);
                }
            }
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }

        private void preOrder(TreeNode root) {
            if (root == null) {
                return;
            }
            map.put(root.val, map.getOrDefault(root.val, 0) + 1);
            preOrder(root.left);
            preOrder(root.right);
        }
    }

}
