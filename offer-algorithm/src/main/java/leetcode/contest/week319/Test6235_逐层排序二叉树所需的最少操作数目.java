package leetcode.contest.week319;

import java.util.*;

public class Test6235_逐层排序二叉树所需的最少操作数目 {

    public static void main(String[] args) {
        System.out.println(new Solution().minimumOperations(
                new TreeNode(
                        1,
                        new TreeNode(
                                4,
                                new TreeNode(7),
                                new TreeNode(6)
                        ),
                        new TreeNode(
                                3,
                                new TreeNode(
                                        8,
                                        new TreeNode(9),
                                        null
                                ),
                                new TreeNode(
                                        5,
                                        new TreeNode(10),
                                        null
                                )
                        )
                )
        ));
        System.out.println(new Solution().minimumOperations(
                new TreeNode(
                        1,
                        new TreeNode(
                                3,
                                new TreeNode(7),
                                new TreeNode(6)
                        ),
                        new TreeNode(
                                2,
                                new TreeNode(5),
                                new TreeNode(4)
                        )
                )
        ));
        System.out.println(new Solution().minimumOperations(
                new TreeNode(
                        1,
                        new TreeNode(
                                2,
                                new TreeNode(4),
                                new TreeNode(5)
                        ),
                        new TreeNode(
                                3,
                                new TreeNode(6),
                                null
                        )
                )
        ));
    }

    static class Solution {
        public int minimumOperations(TreeNode root) {
            Map<Integer, List<Integer>> map = new HashMap<>();
            dfs(root, 0, map);
            int res = 0;
            for (List<Integer> list : map.values()) {
                res += getMinOps(list);
            }
            return res;
        }

        private void dfs(TreeNode root, int level, Map<Integer, List<Integer>> map) {
            if (root == null) {
                return;
            }
            List<Integer> list = map.getOrDefault(level, new ArrayList<>());
            list.add(root.val);
            dfs(root.left, level + 1, map);
            dfs(root.right, level + 1, map);
            map.put(level, list);
        }


        private int getMinOps(List<Integer> list) {
            int res = 0;
            List<Integer> sortedList = new ArrayList<>(list);
            Collections.sort(sortedList);
            Map<Integer, Integer> valIdxMap = new HashMap<>();
            for (int i = 0; i < list.size(); i++) {
                valIdxMap.put(list.get(i), i);
            }
            for (int i = 0; i < list.size(); i++) {
                int sortedNum = sortedList.get(i);
                int currentNum = list.get(i);
                if (currentNum != sortedNum) {
                    int sortedNumIdx = valIdxMap.get(sortedNum);
                    list.set(sortedNumIdx, currentNum);
                    valIdxMap. put(currentNum, sortedNumIdx);
                    res++;
                }
            }
            return res;
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
