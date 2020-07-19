package leetcode.contest.week198;


import java.util.*;

public class Test5465_子树中标签相同的节点数 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().countSubTrees(
                7,
                new int[][]{{0, 1}, {0, 2}, {1, 4}, {1, 5}, {2, 3}, {2, 6}},
                "abaedcd"
        )));
        System.out.println(Arrays.toString(new Solution().countSubTrees(
                5,
                new int[][]{{0, 1}, {0, 2}, {1, 3}, {0, 4}},
                "aabab"
        )));
        System.out.println(Arrays.toString(new Solution().countSubTrees(
                7,
                new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}, {4, 5}, {5, 6}},
                "aaabaaa"
        )));
        System.out.println(Arrays.toString(new Solution().countSubTrees(
                4,
                new int[][]{{0, 2}, {0, 3}, {1, 2}},
                "aeed"
        )));
    }

    static class Solution {
        static class TreeNode {
            char val;
            Map<Character, Integer> countMap = new HashMap<>();
            List<TreeNode> children;

            TreeNode(char x) {
                val = x;
                children = new ArrayList<>();
                countMap.put(x, 1);
            }
        }

        public int[] countSubTrees(int n, int[][] edges, String labels) {
            // 构建所有节点，从0开始作为根节点
            List<TreeNode> nodes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nodes.add(new TreeNode(labels.charAt(i)));
            }
            Set<Integer> set = new HashSet<>();
            set.add(0);
            for (int[] fromTo : edges) {
                int from = fromTo[0];
                int to = fromTo[1];
                if (set.contains(from)) {
                    nodes.get(from).children.add(nodes.get(to));
                } else {
                    nodes.get(to).children.add(nodes.get(from));
                }
                set.add(to);
                set.add(from);
            }
            // 递归遍历一遍，计算出每个节点所含的子节点统计map
            dfs(nodes.get(0));
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                res[i] = nodes.get(i).countMap.get(nodes.get(i).val);
            }
            return res;
        }

        private void dfs(TreeNode root) {
            if (root == null) {
                return;
            }
            for (TreeNode child : root.children) {
                dfs(child);
                for (Character c : child.countMap.keySet()) {
                    Integer v = child.countMap.get(c);
                    root.countMap.put(c, root.countMap.getOrDefault(c, 0) + v);
                }
            }
        }
    }
}
