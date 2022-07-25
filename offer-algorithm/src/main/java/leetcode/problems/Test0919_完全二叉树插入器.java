package leetcode.problems;

import java.util.*;

public class Test0919_完全二叉树插入器 {

    public static void main(String[] args) {
        CBTInserter cBTInserter = new CBTInserter(
                new TreeNode(
                        1,
                        new TreeNode(2),
                        null
                )
        );
        System.out.println(cBTInserter.insert(3));  // 返回 1
        System.out.println(cBTInserter.insert(4));  // 返回 2
        System.out.println(cBTInserter.get_root()); // 返回 [1, 2, 3, 4]
    }

    static class CBTInserter {
        TreeMap<Integer, List<TreeNode>> map = new TreeMap<>();

        public CBTInserter(TreeNode root) {
            dfs(root, 0);
        }

        private void dfs(TreeNode root, int level) {
            if (root == null) {
                return;
            }
            List<TreeNode> list = map.getOrDefault(level, new ArrayList<>());
            list.add(root);
            map.put(level, list);
            dfs(root.left, level + 1);
            dfs(root.right, level + 1);
        }

        public int insert(int val) {
            int level = map.lastKey();
            int maxSize = 1 << level;
            List<TreeNode> list = map.getOrDefault(level, new ArrayList<>());
            int currentSize = list.size();
            TreeNode currentNode = new TreeNode(val);
            if (currentSize < maxSize) {
                TreeNode lastNode = map.get(level - 1).get(currentSize / 2);
                list.add(currentNode);
                if (currentSize % 2 == 0) {
                    lastNode.left = currentNode;
                } else {
                    lastNode.right = currentNode;
                }
                return lastNode.val;
            } else {
                List<TreeNode> nextList = new ArrayList<>();
                nextList.add(currentNode);
                map.put(level + 1, nextList);
                TreeNode lastNode = list.get(0);
                lastNode.left = currentNode;
                return lastNode.val;
            }
        }

        public TreeNode get_root() {
            return map.get(0).get(0);
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
