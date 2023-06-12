package leetcode.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1483_树节点的第K个祖先 {

    public static void main(String[] args) {
        TreeAncestor treeAncestor = new TreeAncestor(7, new int[]{-1, 0, 0, 1, 1, 2, 2});
        System.out.println(treeAncestor.getKthAncestor(3, 1));
        System.out.println(treeAncestor.getKthAncestor(5, 2));
        System.out.println(treeAncestor.getKthAncestor(6, 3));
    }

    static class TreeAncestor {
        Map<Integer, List<Integer>> pathMap = new HashMap<>();

        public TreeAncestor(int n, int[] parent) {
            dfs(0, parent, new ArrayList<>());
        }

        private void dfs(int currentNode, int[] parent, List<Integer> path) {
            path.add(currentNode);
            pathMap.put(currentNode, new ArrayList<>(path));
            for (int i = 0; i < parent.length; i++) {
                if (parent[i] == currentNode) {
                    dfs(i, parent, path);
                }
            }
            path.remove(path.size() - 1);
        }

        public int getKthAncestor(int node, int k) {
            List<Integer> path = pathMap.get(node);
            if (path.size() - 1 - k < 0) {
                return -1;
            } else {
                return path.get(path.size() - 1 - k);
            }
        }
    }


}
