package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1609_奇偶树 {

    public static void main(String[] args) {
        System.out.println(new Solution().isEvenOddTree(
                new TreeNode(1,
                        new TreeNode(10,
                                new TreeNode(3,
                                        new TreeNode(12),
                                        new TreeNode(8)
                                ),
                                null
                        ),
                        new TreeNode(4,
                                new TreeNode(7,
                                        new TreeNode(6),
                                        null
                                ),
                                new TreeNode(9,
                                        null,
                                        new TreeNode(2)
                                )
                        )
                )
        ));
    }

    static class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();

        public boolean isEvenOddTree(TreeNode root) {
            dfs(root, 0);
            for (int level : map.keySet()) {
                List<Integer> list = map.get(level);
                if ((level % 2 == 0 && list.get(0) % 2 == 0) || (level % 2 == 1 && list.get(0) % 2 == 1)) {
                    return false;
                }
                for (int i = 1; i < list.size(); i++) {
                    int val = list.get(i);
                    if (level % 2 == 0) {
                        if (val % 2 == 0 || val <= list.get(i - 1)) {
                            return false;
                        }
                    }
                    if (level % 2 == 1) {
                        if (val % 2 == 1 || val >= list.get(i - 1)) {
                            return false;
                        }
                    }
                }
            }
            return true;
        }

        private void dfs(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            List<Integer> list = map.getOrDefault(level, new ArrayList<>());
            list.add(root.val);
            map.put(level, list);
            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
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
