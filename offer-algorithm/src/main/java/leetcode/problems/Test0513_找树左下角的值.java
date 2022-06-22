package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test0513_找树左下角的值 {

    public static void main(String[] args) {
        System.out.println(new Solution().findBottomLeftValue(
                new TreeNode(2, new TreeNode(1), new TreeNode(3))
        ));
        System.out.println(new Solution().findBottomLeftValue(
                new TreeNode(
                        1,
                        new TreeNode(
                                2,
                                new TreeNode(4),
                                null
                        ),
                        new TreeNode(
                                3,
                                new TreeNode(
                                        5,
                                        new TreeNode(7),
                                        null
                                ),
                                new TreeNode(6)
                        ))
        ));
    }

    static class Solution {
        Map<Integer, List<Integer>> map = new HashMap<>();

        public int findBottomLeftValue(TreeNode root) {
            dfs(root, 0);
            int maxLevel = map.keySet().stream().reduce(Math::max).get();
            return map.get(maxLevel).get(0);
        }

        private void dfs(TreeNode root, int currentLevel) {
            if (root == null) {
                return;
            }
            List<Integer> list = map.getOrDefault(currentLevel, new ArrayList<>());
            list.add(root.val);
            map.put(currentLevel, list);
            dfs(root.left, currentLevel + 1);
            dfs(root.right, currentLevel + 1);
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
