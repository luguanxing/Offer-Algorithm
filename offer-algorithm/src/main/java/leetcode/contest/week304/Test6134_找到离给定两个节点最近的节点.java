package leetcode.contest.week304;

import java.util.*;

public class Test6134_找到离给定两个节点最近的节点 {

    public static void main(String[] args) {
        System.out.println(new Solution().closestMeetingNode(
                new int[]{2, 2, 3, -1}, 0, 1
        ));
        System.out.println(new Solution().closestMeetingNode(
                new int[]{1, 2, -1}, 0, 2
        ));
    }

    static class Solution {
        public int closestMeetingNode(int[] edges, int node1, int node2) {
            Map<Integer, Integer> distanceMap1 = getDistanceMap(node1, edges);
            Map<Integer, Integer> distanceMap2 = getDistanceMap(node2, edges);
            int minStep = Integer.MAX_VALUE;
            int minNode = -1;
            for (int target : distanceMap1.keySet()) {
                if (distanceMap2.containsKey(target)) {
                    int distance1 = distanceMap1.get(target);
                    int distance2 = distanceMap2.get(target);
                    int distance = Math.max(distance1, distance2);
                    if (distance < minStep) {
                        minStep = distance;
                        minNode = target;
                    }
                }
            }
            return minNode;
        }

        private Map<Integer, Integer> getDistanceMap(int node, int[] edges) {
            Map<Integer, Integer> distanceMap = new HashMap<>();
            Queue<Integer> queue = new ArrayDeque<>();
            Set<Integer> visited = new HashSet<>();
            int distance = 0;
            queue.add(node);
            while (!queue.isEmpty()) {
                List<Integer> currents = new ArrayList<>();
                while (!queue.isEmpty()) {
                    int current = queue.poll();
                    if (current == -1) {
                        continue;
                    }
                    distanceMap.put(current, distance);
                    currents.add(current);
                    visited.add(current);
                }
                for (int current : currents) {
                    int next = edges[current];
                    if (!visited.contains(next)) {
                        queue.add(next);
                    }
                }
                distance++;
            }
            return distanceMap;
        }
    }

}
