package leetcode.problems;

import java.util.*;
import java.util.stream.Collectors;

public class Test0815_公交路线 {

    public static void main(String[] args) {
        // routes = [[1,2,7],[3,6,7]], source = 1, target = 6
        System.out.println(new Solution().numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));
        // routes = [[7,12],[4,5,15],[6],[15,19],[9,12,13]], source = 15, target = 12
        System.out.println(new Solution().numBusesToDestination(new int[][]{{7, 12}, {4, 5, 15}, {6}, {15, 19}, {9, 12, 13}}, 15, 12));
        System.out.println(new Solution().numBusesToDestination(new int[][]{{1, 7}, {3, 5}}, 5, 5));
        System.out.println(new Solution().numBusesToDestination(new int[][]{{1, 7}, {3, 5}}, 5, 3));
        System.out.println(new Solution().numBusesToDestination(new int[][]{{2}, {2, 8}}, 8, 2));
    }

    static class Solution {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            if (source == target) {
                return 0;
            }
            // 构建邻接表
            Map<Integer, Set<Integer>> busToStationMap = new HashMap<>();
            Map<Integer, Set<Integer>> stationToBusMap = new HashMap<>();
            for (int bus = 0; bus < routes.length; bus++) {
                int[] route = routes[bus];
                Set<Integer> busSet = busToStationMap.getOrDefault(bus, new HashSet<>());
                busSet.addAll(Arrays.stream(route).boxed().collect(Collectors.toList()));
                busToStationMap.put(bus, busSet);
                for (int station : route) {
                    Set<Integer> stationSet = stationToBusMap.getOrDefault(station, new HashSet<>());
                    stationSet.add(bus);
                    stationToBusMap.put(station, stationSet);
                }
            }
            // BFS遍历公交车而不是车站
            int steps = 0;
            Queue<Integer> busQueue = new LinkedList<>();
            Set<Integer> visitedBus = new HashSet<>();
            for (int bus : stationToBusMap.getOrDefault(source, new HashSet<>())) {
                busQueue.add(bus);
                visitedBus.add(bus);
            }
            while (!busQueue.isEmpty()) {
                List<Integer> buses = new ArrayList<>(busQueue);
                visitedBus.addAll(buses);
                busQueue.clear();
                Set<Integer> busesNextStations = new HashSet<>();
                for (int bus : buses) {
                    Set<Integer> busNextStations = busToStationMap.getOrDefault(bus, new HashSet<>());
                    if (busNextStations.contains(target)) {
                        return steps + 1;
                    }
                    busesNextStations.addAll(busNextStations);
                }
                // 找到下一辆bus
                for (int nextBus : busToStationMap.keySet()) {
                    Set<Integer> intersection = new HashSet<>(busToStationMap.get(nextBus));
                    intersection.retainAll(busesNextStations);
                    if (!visitedBus.contains(nextBus) && !intersection.isEmpty()) {
                        busQueue.add(nextBus);
                        visitedBus.add(nextBus);
                    }
                }
                steps++;
            }
            return -1;
        }
    }

    static class Solution_BFS {
        public int numBusesToDestination(int[][] routes, int source, int target) {
            // 构建邻接表
            Map<Integer, Set<Integer>> map = new HashMap<>();
            for (int[] route : routes) {
                for (int i = 0; i < route.length; i++) {
                    int current = route[i];
                    Set<Integer> list = map.getOrDefault(current, new HashSet<>());
                    list.addAll(Arrays.stream(route).boxed().collect(Collectors.toList()));
                    map.put(current, list);
                }
            }
            // BFS
            int steps = 0;
            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();
            queue.add(source);
            visited.add(source);
            while (!queue.isEmpty()) {
                List<Integer> currents = new ArrayList<>(queue);
                visited.addAll(currents);
                queue.clear();
                for (Integer current : currents) {
                    if (current == target) {
                        return steps;
                    }
                    Set<Integer> nexts = map.get(current);
                    for (Integer next : nexts) {
                        if (!visited.contains(next)) {
                            queue.add(next);
                        }
                    }
                }
                steps++;
            }
            return -1;
        }
    }

}
