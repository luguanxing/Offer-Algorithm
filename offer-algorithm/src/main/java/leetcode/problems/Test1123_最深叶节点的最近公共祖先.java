package leetcode.problems;

import java.util.TreeMap;

public class Test1123_最深叶节点的最近公共祖先 {

    public static void main(String[] args) {
        System.out.println(new Solution().lcaDeepestLeaves(
                new TreeNode(
                        3,
                        new TreeNode(
                                5,
                                new TreeNode(6),
                                new TreeNode(
                                        2,
                                        new TreeNode(7),
                                        new TreeNode(4)
                                )
                        ),
                        new TreeNode(
                                1,
                                new TreeNode(0),
                                new TreeNode(8)
                        )
                )
        ));
        System.out.println(new Solution().lcaDeepestLeaves(
                new TreeNode(1)
        ));
        System.out.println(new Solution().lcaDeepestLeaves(
                new TreeNode(
                        0,
                        new TreeNode(
                                1,
                                null,
                                new TreeNode(2)
                        ),
                        new TreeNode(3)
                )
        ));
    }

    static class Solution {
        TreeMap<Integer, Integer> levelCntMap = new TreeMap<>();
        TreeNode ans = null;

        public TreeNode lcaDeepestLeaves(TreeNode root) {
            dfsCnt(root, 0);
            dfsCheckCnt(root, 0);
            return ans;
        }

        private void dfsCnt(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            levelCntMap.put(level, levelCntMap.getOrDefault(level, 0) + 1);
            dfsCnt(root.left, level + 1);
            dfsCnt(root.right, level + 1);
        }

        private int dfsCheckCnt(TreeNode root, int level) {
            if (root == null) {
                return 0;
            }
            if (level == levelCntMap.lastKey()) {
                if (levelCntMap.get(levelCntMap.lastKey()) == 1) {
                    ans = root;
                }
                return 1;
            }
            int leftCnt = dfsCheckCnt(root.left, level + 1);
            int rightCnt = dfsCheckCnt(root.right, level + 1);
            if (ans == null && leftCnt + rightCnt == levelCntMap.get(levelCntMap.lastKey())) {
                ans = root;
            }
            return leftCnt + rightCnt;
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

        @Override
        public String toString() {
            return "TreeNode{" +
                    "val=" + val +
                    '}';
        }
    }

}
