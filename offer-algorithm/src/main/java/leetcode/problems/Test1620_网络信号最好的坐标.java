package leetcode.problems;

import java.util.Arrays;

public class Test1620_网络信号最好的坐标 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().bestCoordinate(
                new int[][]{{1, 2, 5}, {2, 1, 7}, {3, 1, 9}},
                2
        )));
        System.out.println(Arrays.toString(new Solution().bestCoordinate(
                new int[][]{{23, 11, 21}},
                9
        )));
        System.out.println(Arrays.toString(new Solution().bestCoordinate(
                new int[][]{{1, 2, 13}, {2, 1, 7}, {0, 1, 9}},
                2
        )));
        System.out.println(Arrays.toString(new Solution().bestCoordinate(
                new int[][]{{42, 0, 0}},
                7
        )));
    }

    static class Solution {
        public int[] bestCoordinate(int[][] towers, int radius) {
            int XMAX = 50;
            int YMAX = 50;
            int len = towers.length;
            int maxSum = 0;
            int[] minTower = new int[]{-1, -1};
            for (int x = 0; x <= XMAX; x++) {
                for (int y = 0; y <= YMAX; y++) {
                    int sum = 0;
                    for (int i = 0; i < len; i++) {
                        int power = towers[i][2];
                        int xx = towers[i][0];
                        int yy = towers[i][1];
                        int dis = (y - yy) * (y - yy) + (x - xx) * (x - xx);
                        if (dis <= radius * radius) {
                            sum += (power / (1 + Math.sqrt(dis)));
                        }
                    }
                    if (sum > maxSum || (sum == maxSum && ((minTower[0] == -1 && minTower[1] == -1) || x < minTower[0] || (x == minTower[0] && y < minTower[1])))) {
                        maxSum = sum;
                        minTower[0] = x;
                        minTower[1] = y;
                    }
                }
            }
            return minTower;
        }
    }

}
