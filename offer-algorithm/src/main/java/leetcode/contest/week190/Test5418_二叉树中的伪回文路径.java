package leetcode.contest.week190;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Test5418_二叉树中的伪回文路径 {

    public static void main(String[] args) {
        TreeNode node111 = new TreeNode(3);
        TreeNode node112 = new TreeNode(1);
        TreeNode node122 = new TreeNode(1);
        TreeNode node11 = new TreeNode(3, node111, node112);
        TreeNode node12 = new TreeNode(2, null, node122);
        TreeNode node1 = new TreeNode(2, node11, node12);
        System.out.println(new Solution().pseudoPalindromicPaths(node1));
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

    static class Solution {
        private List<Map<Integer, Integer>> pathMapList = new ArrayList<>();

        public int pseudoPalindromicPaths(TreeNode root) {
            pathMapList.clear();
            visitAllNodes(root, new ConcurrentHashMap<>());
            // 检查所有路径
            int res = 0;
            for (Map<Integer, Integer> pathMap : pathMapList) {
                // 出现次数为偶数可去掉
                for (Integer key : pathMap.keySet()) {
                    if (pathMap.get(key) % 2 == 0) {
                        pathMap.remove(key);
                    }
                }
                // 剩下0个或1个为伪回文数
                if (pathMap.size() == 1 || pathMap.size() == 0) {
                    res++;
                }
            }
            return res;
        }

        private void visitAllNodes(TreeNode root, ConcurrentHashMap<Integer, Integer> currentMap) {
            if (root == null) {
                return;
            }
            if (!currentMap.containsKey(root.val)) {
                currentMap.put(root.val, 1);
            } else {
                currentMap.put(root.val, currentMap.get(root.val) + 1);
            }
            if (root.left == null && root.right == null) {
                pathMapList.add(currentMap);
            } else {
                visitAllNodes(root.left, new ConcurrentHashMap<>(currentMap));
                visitAllNodes(root.right, new ConcurrentHashMap<>(currentMap));
            }
        }
    }

}
