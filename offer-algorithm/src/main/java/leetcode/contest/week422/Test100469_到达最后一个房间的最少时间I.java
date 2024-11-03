package leetcode.contest.week422;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Test100469_到达最后一个房间的最少时间I {

    public static void main(String[] args) {
        // moveTime = [[0,4],[4,4]]
        System.out.println(new Solution().minTimeToReach(new int[][]{{0, 4}, {4, 4}}));
        // moveTime = [[0,0,0],[0,0,0]]
        System.out.println(new Solution().minTimeToReach(new int[][]{{0, 0, 0}, {0, 0, 0}}));
        // moveTime = [[0,1],[1,2]]
        System.out.println(new Solution().minTimeToReach(new int[][]{{0, 1}, {1, 2}}));
    }

    static class Solution {
        public int minTimeToReach(int[][] moveTime) {
            // 存储输入的变量
            int n = moveTime.length;
            int m = moveTime[0].length;
            int[] dirs = {-1, 0, 1, 0, -1};
            // 优先级队列，按当前时间升序排列
            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
            pq.offer(new int[]{0, 0, 0});
            // 记录每个房间的最早到达时间
            int[][] visited = new int[n][m];
            for (int[] row : visited) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
            visited[0][0] = 0;
            while (!pq.isEmpty()) {
                int[] current = pq.poll();
                int currentTime = current[0];
                int y = current[1];
                int x = current[2];

                // 如果到达目标房间，则返回时间
                if (y == n - 1 && x == m - 1) {
                    return currentTime;
                }
                // 遍历四个方向
                for (int d = 0; d < 4; d++) {
                    int newY = y + dirs[d];
                    int newX = x + dirs[d + 1];
                    // 检查边界
                    if (newY >= 0 && newY < n && newX >= 0 && newX < m) {
                        // 在 time + 1 的时候到达新房间
                        int arrivalTime = currentTime + 1;
                        // 要满足 moveTime 的条件
                        if (arrivalTime <= moveTime[newY][newX]) {
                            arrivalTime = moveTime[newY][newX] + 1;
                        }
                        // 如果这个时间比之前记录的早，更新并加入队列
                        if (arrivalTime < visited[newY][newX]) {
                            visited[newY][newX] = arrivalTime;
                            pq.offer(new int[]{arrivalTime, newY, newX});
                        }
                    }
                }
            }
            // 如果无法到达目标
            return -1;
        }
    }

}
