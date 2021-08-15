package leetcode.contest.week254;

import java.util.*;

public class Test5845_你能穿过矩阵的最后一天 {

    public static void main(String[] args) {
        System.out.println(new Solution().latestDayToCross(
                2, 2, new int[][]{{1, 1}, {2, 1}, {1, 2}, {2, 2}}
        ));
        System.out.println(new Solution().latestDayToCross(
                2, 2, new int[][]{{1, 1}, {1, 2}, {2, 1}, {2, 2}}
        ));
        System.out.println(new Solution().latestDayToCross(
                3, 3, new int[][]{{1, 2}, {2, 2}, {3, 3}, {3, 1}, {1, 1}, {1, 3}, {2, 3}, {3, 2}, {2, 1}}
        ));
        System.out.println(new Solution().latestDayToCross(
                55, 2, new int[][]{{53, 1}, {25, 1}, {9, 2}, {3, 1}, {54, 1}, {14, 2}, {28, 1}, {4, 1}, {44, 1}, {20, 2}, {28, 2}, {24, 2}, {50, 1}, {47, 2}, {21, 1}, {47, 1}, {22, 2}, {10, 1}, {17, 1}, {13, 1}, {12, 1}, {37, 2}, {46, 2}, {51, 1}, {32, 1}, {51, 2}, {6, 2}, {49, 2}, {13, 2}, {34, 1}, {33, 1}, {38, 2}, {52, 2}, {26, 2}, {46, 1}, {20, 1}, {33, 2}, {23, 2}, {17, 2}, {1, 2}, {3, 2}, {50, 2}, {25, 2}, {19, 1}, {21, 2}, {49, 1}, {29, 1}, {30, 2}, {41, 1}, {16, 1}, {39, 2}, {9, 1}, {48, 2}, {23, 1}, {27, 1}, {43, 1}, {45, 1}, {31, 1}, {40, 1}, {6, 1}, {42, 1}, {8, 2}, {12, 2}, {29, 2}, {36, 2}, {39, 1}, {41, 2}, {10, 2}, {44, 2}, {14, 1}, {35, 1}, {30, 1}, {2, 2}, {34, 2}, {55, 1}, {18, 1}, {32, 2}, {27, 2}, {4, 2}, {37, 1}, {38, 1}, {16, 2}, {26, 1}, {15, 2}, {19, 2}, {5, 1}, {45, 2}, {43, 2}, {55, 2}, {35, 2}, {54, 2}, {42, 2}, {22, 1}, {11, 1}, {48, 1}, {1, 1}, {36, 1}, {24, 1}, {8, 1}, {2, 1}, {7, 1}, {15, 1}, {31, 2}, {18, 2}, {7, 2}, {52, 1}, {40, 2}, {53, 2}, {11, 2}, {5, 2}}
        ));
        System.out.println(new Solution().latestDayToCross(
                24, 5, new int[][]{{23, 1}, {16, 4}, {19, 5}, {5, 3}, {12, 1}, {21, 1}, {13, 2}, {16, 3}, {12, 3}, {17, 3}, {4, 5}, {16, 2}, {14, 5}, {1, 2}, {12, 2}, {24, 5}, {4, 3}, {1, 1}, {1, 5}, {4, 1}, {13, 1}, {19, 4}, {8, 1}, {24, 2}, {22, 4}, {1, 3}, {14, 4}, {22, 5}, {7, 3}, {7, 5}, {8, 4}, {3, 2}, {13, 4}, {24, 4}, {19, 3}, {15, 2}, {24, 3}, {14, 3}, {5, 4}, {2, 5}, {18, 3}, {21, 5}, {10, 4}, {19, 2}, {3, 4}, {21, 3}, {17, 4}, {1, 4}, {15, 5}, {16, 1}, {6, 5}, {3, 3}, {20, 5}, {13, 5}, {9, 5}, {6, 4}, {2, 3}, {21, 4}, {24, 1}, {17, 2}, {14, 2}, {6, 1}, {8, 5}, {10, 2}, {16, 5}, {7, 4}, {18, 1}, {10, 3}, {6, 2}, {10, 1}, {18, 4}, {17, 5}, {9, 1}, {11, 3}, {13, 3}, {5, 1}, {9, 3}, {18, 2}, {11, 5}, {18, 5}, {23, 4}, {15, 1}, {11, 1}, {10, 5}, {7, 2}, {20, 2}, {19, 1}, {17, 1}, {5, 2}, {6, 3}, {15, 4}, {20, 4}, {14, 1}, {7, 1}, {12, 5}, {3, 5}, {4, 2}, {2, 1}, {12, 4}, {22, 1}, {20, 1}, {22, 3}, {23, 5}, {9, 2}, {23, 2}, {15, 3}, {9, 4}, {21, 2}, {23, 3}, {8, 2}, {5, 5}, {20, 3}, {8, 3}, {22, 2}, {11, 4}, {4, 4}, {2, 4}, {2, 2}, {11, 2}, {3, 1}}
        ));
    }

    static class Solution {
        public int latestDayToCross(int row, int col, int[][] cells) {
            int[][] safety = new int[row][col];
            int order = 0;
            for (int[] cell : cells) {
                int y = cell[0] - 1;
                int x = cell[1] - 1;
                safety[y][x] = order++;
            }
            // 从第一行每个点出发，看走到最后一行需要最少的点的最大值
            int res = 0;
            for (int x = 0; x < col; x++) {
                int min = bfs(safety, 0, x);
                res = Math.max(res, min);
            }
            return res;
        }

        private int bfs(int[][] safety, int y, int x) {
            int res = 0;
            Map<String, int[]> map = new HashMap<>();
            map.put("0,0", new int[]{y, x, safety[y][x], -1, -1});
            while (!map.isEmpty()) {
                int[] cur = null;
                for (String key : map.keySet()) {
                    cur = map.get(key);
                    map.remove(key);
                    break;
                }
                int curY = cur[0];
                int curX = cur[1];
                int curSafety = cur[2];
                int lastY = cur[3];
                int lastX = cur[4];
                if (curY == safety.length - 1) {
                    res = Math.max(res, curSafety);
                    continue;
                }
                List<int[]> nexts = getNexts(safety, curY, curX, lastY, lastX);
                for (int[] next : nexts) {
                    int nextY = next[0];
                    int nextX = next[1];
                    int nextSafety = next[2];
                    nextSafety = Math.min(curSafety, nextSafety);
                    if (map.containsKey(nextY + "," + nextX)) {
                        int s = map.get(nextY + "," + nextX)[2];
                        if (nextSafety > s) {
                            map.put(nextY + "," + nextX, new int[]{nextY, nextX, nextSafety, curY, curX});
                        }
                    } else {
                        map.put(nextY + "," + nextX, new int[]{nextY, nextX, nextSafety, curY, curX});
                    }
                }
            }
            return res;
        }

        private List<int[]> getNexts(int[][] safety, int curY, int curX, int lastY, int lastX) {
            List<int[]> list = new ArrayList<>();
            if (curY + 1 < safety.length) {
                list.add(new int[]{curY + 1, curX, safety[curY + 1][curX]});
            }
            if (curX + 1 < safety[0].length && curX + 1 != lastX) {
                list.add(new int[]{curY, curX + 1, safety[curY][curX + 1]});
            }
            if (0 <= curX - 1 && curX - 1 != lastX) {
                list.add(new int[]{curY, curX - 1, safety[curY][curX - 1]});
            }
            return list;
        }
    }

}
