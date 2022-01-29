package leetcode.problems;

import java.util.*;

public class Test1765_地图中的最高点 {

    public static void main(String[] args) {
        int[][] res1 = new Solution().highestPeak(new int[][]{{0, 1}, {0, 0}});
        int[][] res2 = new Solution().highestPeak(new int[][]{{0, 0, 1}, {1, 0, 0}, {0, 0, 0}});
        for (int[] pos : res1) {
            System.out.println(Arrays.toString(pos));
        }
        System.out.println("==========");
        for (int[] pos : res2) {
            System.out.println(Arrays.toString(pos));
        }
    }

    static class Solution {
        public int[][] highestPeak(int[][] isWater) {
            int height = isWater.length;
            int width = isWater[0].length;
            // bfs + 层次遍历
            boolean[][] isVisited = new boolean[height][width];
            Queue<int[]> queue = new ArrayDeque<>();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (isWater[y][x] == 1) {
                        queue.add(new int[]{y, x});
                        isVisited[y][x] = true;
                        isWater[y][x] = 0;
                    }
                }
            }
            int currentLevel = 1;
            while (!queue.isEmpty()) {
                List<int[]> posList = new ArrayList<>(queue);
                queue.clear();
                for (int[] pos : posList) {
                    List<int[]> nextPosList = getNextPosList(pos);
                    for (int[] nextPos : nextPosList) {
                        int nextPosY = nextPos[0];
                        int nextPosX = nextPos[1];
                        if (0 <= nextPosY && nextPosY < height && 0 <= nextPosX && nextPosX < width && !isVisited[nextPosY][nextPosX]) {
                            queue.add(new int[]{nextPosY, nextPosX});
                            isVisited[nextPosY][nextPosX] = true;
                            isWater[nextPosY][nextPosX] = currentLevel;
                        }
                    }
                }
                currentLevel++;
            }
            return isWater;
        }

        private List<int[]> getNextPosList(int[] pos) {
            int y = pos[0];
            int x = pos[1];
            List<int[]> list = new ArrayList<>();
            list.add(new int[]{y, x - 1});
            list.add(new int[]{y, x + 1});
            list.add(new int[]{y - 1, x});
            list.add(new int[]{y + 1, x});
            return list;
        }
    }

}
