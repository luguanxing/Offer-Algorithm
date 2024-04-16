package leetcode.problems;

import java.util.*;

public class Test0924_尽量减少恶意软件的传播 {

    public static void main(String[] args) {
        // graph = [[1,1,0],[1,1,0],[0,0,1]], initial = [0,1]
        System.out.println(new Solution().minMalwareSpread(new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}}, new int[]{0, 1}));
        // graph = [[1,0,0],[0,1,0],[0,0,1]], initial = [0,2]
        System.out.println(new Solution().minMalwareSpread(new int[][]{{1, 0, 0}, {0, 1, 0}, {0, 0, 1}}, new int[]{0, 2}));
        // graph = [[1,1,1],[1,1,1],[1,1,1]], initial = [1,2]
        System.out.println(new Solution().minMalwareSpread(new int[][]{{1, 1, 1}, {1, 1, 1}, {1, 1, 1}}, new int[]{1, 2}));
        // graph = [[1,0,0,0],[0,1,0,0],[0,0,1,1],[0,0,1,1]], initial = [3,1]
        System.out.println(new Solution().minMalwareSpread(new int[][]{{1, 0, 0, 0}, {0, 1, 0, 0}, {0, 0, 1, 1}, {0, 0, 1, 1}}, new int[]{3, 1}));
    }

    static class Solution {
        public int minMalwareSpread(int[][] graph, int[] initial) {
            // 枚举删除某个节点后，计算剩下感染的节点数量
            Map<Integer, Integer> idCntMap = new HashMap<>();
            for (int removeIndex : initial) {
                int cnt = 0;
                Queue<Integer> queue = new ArrayDeque<>();
                Set<Integer> visited = new HashSet<>();
                for (int i : initial) {
                    if (i != removeIndex) {
                        queue.offer(i);
                        visited.add(i);
                        cnt++;
                    }
                }
                while (!queue.isEmpty()) {
                    int cur = queue.poll();
                    for (int i = 0; i < graph[cur].length; i++) {
                        if (graph[cur][i] == 1 && !visited.contains(i)) {
                            queue.offer(i);
                            visited.add(i);
                            cnt++;
                        }
                    }
                }
                idCntMap.put(removeIndex, cnt);
            }
            // 找到删除某个节点后，感染的节点数量最多的节点，如果有多个，返回编号最小的
            int minRemoveIndex = Integer.MAX_VALUE;
            int minRemoveCnt = Integer.MAX_VALUE;
            for (int index : idCntMap.keySet()) {
                int cnt = idCntMap.get(index);
                if (cnt < minRemoveCnt || (cnt == minRemoveCnt && index < minRemoveIndex)) {
                    minRemoveIndex = index;
                    minRemoveCnt = cnt;
                }
            }
            return minRemoveIndex;
        }
    }

}
