package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test0337_打家劫舍III {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode lr = new TreeNode(3);
        TreeNode rr = new TreeNode(1);
        root.left = l;
        root.right = r;
        l.right = lr;
        r.right = rr;
        System.out.println(new Solution().rob(root));
    }

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        Map<TreeNode, Integer> trueMap = new HashMap<>();
        Map<TreeNode, Integer> falseMap = new HashMap<>();

        public int rob(TreeNode root) {
            return Math.max(dfs(root, true), dfs(root, false));
        }

        public int dfs(TreeNode root, boolean available) {
            if (root == null) {
                return 0;
            }
            if (available && trueMap.containsKey(root)) {
                return trueMap.get(root);
            } else if (!available && falseMap.containsKey(root)) {
                return falseMap.get(root);
            }
            if (available) {
                int takeThis = root.val + dfs(root.left, false) + dfs(root.right, false);
                int noTakeThis = dfs(root.left, true) + dfs(root.right, true);
                int max = Math.max(takeThis, noTakeThis);
                if (available) {
                    trueMap.put(root, max);
                } else {
                    falseMap.put(root, max);
                }
                return max;
            } else {
                return dfs(root.left, true) + dfs(root.right, true);
            }
        }
    }

    static class Solution2 {
        public int rob(TreeNode root) {
            return Math.max(preOrder(root, true), preOrder(root, false));
        }

        public int preOrder(TreeNode root, boolean canTakeThis) {
            if (root == null) {
                return 0;
            }
            if (canTakeThis) {
                // 能拿当前节点的情况可以选择拿或不拿，如果拿了下个节点就不能拿
                int takeThis = preOrder(root.left, false) + preOrder(root.right, false);
                int noTakeThis = preOrder(root.left, true) + preOrder(root.right, true);
                return Math.max(root.val + takeThis, noTakeThis);
            } else {
                // 不能拿当前节点的情况，下个节点可以拿
                return preOrder(root.left, true) + preOrder(root.right, true);
            }
        }
    }

}
