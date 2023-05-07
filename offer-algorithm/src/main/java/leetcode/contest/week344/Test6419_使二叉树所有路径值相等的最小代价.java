package leetcode.contest.week344;

public class Test6419_使二叉树所有路径值相等的最小代价 {

    public static void main(String[] args) {
        System.out.println(new Solution().minIncrements(7, new int[]{1, 5, 2, 2, 3, 3, 1}));
        System.out.println(new Solution().minIncrements(3, new int[]{5, 3, 3}));
    }

    static class Solution {
        int ans = 0;

        public int minIncrements(int n, int[] cost) {
            TreeNode root = buildTree(cost, 0);
            dfs(root);
            return ans;
        }

        private int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftChildrenMax = dfs(root.left);
            int rightChildrenMax = dfs(root.right);
            // 后序遍历，不断在递归往上补充左右最大差，最终平衡
            ans += Math.abs(leftChildrenMax - rightChildrenMax);
            return root.val + Math.max(leftChildrenMax, rightChildrenMax);
        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        private TreeNode buildTree(int[] cost, int index) {
            if (index >= cost.length) {
                return null;
            }
            TreeNode node = new TreeNode(cost[index]);
            node.left = buildTree(cost, 2 * index + 1);
            node.right = buildTree(cost, 2 * index + 2);
            return node;
        }
    }

    static class Solution_暴力 {
        int ans = 0;
        int maxPathSum = 0;

        public int minIncrements(int n, int[] cost) {
            TreeNode root = buildTree(cost, 0);
            maxPathSum = findMaxPathSum(root);
            dfs(root, maxPathSum);
            return ans;
        }

        private void dfs(TreeNode root, int sum) {
            if (root == null) {
                return;
            }
            sum -= root.val;
            int leftNeed = getMaxSum(root.left);
            int rightNeed = getMaxSum(root.right);
            int add = sum - Math.max(leftNeed, rightNeed);
            ans += add;
            dfs(root.left, sum - add);
            dfs(root.right, sum - add);
        }

        private int getMaxSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return root.val + Math.max(getMaxSum(root.left), getMaxSum(root.right));
        }

        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        private TreeNode buildTree(int[] cost, int index) {
            if (index >= cost.length) {
                return null;
            }
            TreeNode node = new TreeNode(cost[index]);
            node.left = buildTree(cost, 2 * index + 1);
            node.right = buildTree(cost, 2 * index + 2);
            return node;
        }

        private int findMaxPathSum(TreeNode root) {
            if (root == null) {
                return 0;
            }
            return root.val + Math.max(findMaxPathSum(root.left), findMaxPathSum(root.right));
        }
    }

}
