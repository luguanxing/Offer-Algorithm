package leetcode.problems;

import java.util.*;

public class Test1345_跳跃游戏IV {

    public static void main(String[] args) {
        System.out.println(new Solution().minJumps(new int[]{100, -23, -23, 404, 100, 23, 23, 23, 3, 404}));
        System.out.println(new Solution().minJumps(new int[]{7}));
        System.out.println(new Solution().minJumps(new int[]{7, 6, 9, 6, 9, 6, 9, 7}));
        System.out.println(new Solution().minJumps(new int[]{6, 1, 9}));
        System.out.println(new Solution().minJumps(new int[]{11, 22, 7, 7, 7, 7, 7, 7, 7, 22, 13}));
    }

    static class Solution {
        public int minJumps(int[] arr) {
            // 存储能跳的节点
            Map<Integer, Set<Integer>> valIndexMap = new HashMap<>();
            for (int i = 0; i < arr.length; i++) {
                int val = arr[i];
                Set<Integer> indexs = valIndexMap.getOrDefault(val, new HashSet<>());
                indexs.add(i);
                valIndexMap.put(val, indexs);
            }
            // bfs找最短（层次遍历）
            int steps = 0;
            Queue<Integer> queue = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();
            queue.add(0);
            while (!queue.isEmpty()) {
                List<Integer> posList = new ArrayList<>();
                while (!queue.isEmpty()) {
                    int pos = queue.poll();
                    if (pos == arr.length - 1) {
                        return steps;
                    }
                    posList.add(pos);
                    visited.add(pos);
                }
                for (int pos : posList) {
                    if (pos == arr.length - 1) {
                        return steps;
                    }
                    visited.add(pos);
                    for (int nextPos : getNextPosList(pos, arr, valIndexMap)) {
                        if (0 <= nextPos && nextPos < arr.length && !visited.contains(nextPos)) {
                            queue.add(nextPos);
                        }
                    }
                }
                steps++;
            }
            return arr.length;
        }

        private List<Integer> getNextPosList(int pos, int[] arr, Map<Integer, Set<Integer>> valIndexMap) {
            List<Integer> nexts = new ArrayList<>();
            nexts.add(pos - 1);
            nexts.add(pos + 1);
            if (valIndexMap.containsKey(arr[pos])) {
                nexts.addAll(valIndexMap.get(arr[pos]));
                // 过河拆桥，后续不会访问了
                valIndexMap.remove(arr[pos]);
            }
            return nexts;
        }
    }

}
