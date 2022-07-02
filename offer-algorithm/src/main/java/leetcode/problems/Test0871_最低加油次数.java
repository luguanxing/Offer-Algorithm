package leetcode.problems;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test0871_最低加油次数 {

    public static void main(String[] args) {
        System.out.println(new Solution().minRefuelStops(
                1, 1, new int[][]{}
        ));
        System.out.println(new Solution().minRefuelStops(
                100, 1, new int[][]{{10, 100}}
        ));
        System.out.println(new Solution().minRefuelStops(
                100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}
        ));
        System.out.println(new Solution().minRefuelStops(
                100, 50, new int[][]{{50, 50}}
        ));
        System.out.println(new Solution().minRefuelStops(
                1000, 299, new int[][]{{13, 100}, {25, 117}, {122, 82}, {189, 123}, {268, 56}, {382, 214}, {408, 280}, {421, 272}, {589, 110}, {899, 4}}
        ));
    }

    static class Solution {
        public int minRefuelStops(int target, int startFuel, int[][] stations) {
            if (startFuel >= target) {
                return 0;
            }
            // 油可以带走，在不能到下个油站时选最大的使用
            PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
            int fuel = startFuel;
            int position = 0;
            int count = 0;
            for (int[] station : stations) {
                int currentPosition = station[0];
                int currentFuel = station[1];
                // 到不了本站就从之前加油站选最大的油加
                int positionDistance = currentPosition - position;
                while (fuel < positionDistance && !queue.isEmpty()) {
                    fuel += queue.poll();
                    count++;
                }
                // 仍到不了时失败
                if (fuel < positionDistance) {
                    return -1;
                }
                // 能到本站加油
                fuel -= positionDistance;
                position += positionDistance;
                queue.add(currentFuel);
            }
            // 看最后能否到tagret
            while (fuel < target - position && !queue.isEmpty()) {
                fuel += queue.poll();
                count++;
            }
            return position + fuel >= target ? count : -1;
        }
    }

}
