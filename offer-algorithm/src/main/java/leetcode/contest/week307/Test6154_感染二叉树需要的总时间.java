package leetcode.contest.week307;

import java.util.*;

public class Test6154_感染二叉树需要的总时间 {

    public static void main(String[] args) {
        System.out.println(new Solution().amountOfTime(
                new TreeNode(
                        1,
                        new TreeNode(
                                5,
                                null,
                                new TreeNode(
                                        4,
                                        new TreeNode(9),
                                        new TreeNode(2)
                                )
                        ),
                        new TreeNode(
                                3,
                                new TreeNode(10),
                                new TreeNode(6)
                        )
                )
                ,3
        ));
    }

    static class Solution {
        Map<Integer, List<Integer>> relationMap = new HashMap<>();
        Set<Integer> visited = new HashSet<>();

        public int amountOfTime(TreeNode root, int start) {
            build(root);
            Queue<Integer> queue = new ArrayDeque<>();
            queue.add(start);
            int time = -1;
            while (!queue.isEmpty()) {
                time++;
                List<Integer> currents = new ArrayList<>();
                while (!queue.isEmpty()) {
                    currents.add(queue.poll());
                }
                for (int current : currents) {
                    visited.add(current);
                    for (int next : relationMap.getOrDefault(current, new ArrayList<>())) {
                        if (!visited.contains(next)) {
                            visited.add(next);
                            queue.add(next);
                        }
                    }
                }
            }
            return time;
        }

        private void build(TreeNode root) {
            if (root == null) {
                return;
            }
            int rootVal = root.val;
            if (root.left != null) {
                int leftVal = root.left.val;
                List<Integer> rootNexts = relationMap.getOrDefault(rootVal, new ArrayList<>());
                rootNexts.add(leftVal);
                relationMap.put(rootVal, rootNexts);
                List<Integer> leftNexts = relationMap.getOrDefault(leftVal, new ArrayList<>());
                leftNexts.add(rootVal);
                relationMap.put(leftVal, leftNexts);
            }
            if (root.right != null) {
                int rightVal = root.right.val;
                List<Integer> rootNexts = relationMap.getOrDefault(rootVal, new ArrayList<>());
                rootNexts.add(rightVal);
                relationMap.put(rootVal, rootNexts);
                List<Integer> rightNexts = relationMap.getOrDefault(rightVal, new ArrayList<>());
                rightNexts.add(rootVal);
                relationMap.put(rightVal, rightNexts);
            }
            build(root.left);
            build(root.right);
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
