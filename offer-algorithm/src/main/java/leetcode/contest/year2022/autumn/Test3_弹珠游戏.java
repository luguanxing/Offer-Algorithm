package leetcode.contest.year2022.autumn;

import java.util.*;

public class Test3_弹珠游戏 {

    public static void main(String[] args) {
        System.err.println(Arrays.toString(new Solution().ballGame(
                4,
                new String[]{"..E.", ".EOW", "..W."}
        )));
        System.err.println(Arrays.toString(new Solution().ballGame(
                5,
                new String[]{".....", "..E..", ".WO..", "....."}
        )));
        System.err.println(Arrays.toString(new Solution().ballGame(
                3,
                new String[]{".....", "....O", "....O", "....."}
        )));
        System.err.println(Arrays.toString(new Solution().ballGame(
                1,
                new String[]{".....", "..O..", "....."}
        )));
        System.err.println(Arrays.toString(new Solution().ballGame(
                6,
                new String[]{"....", ".EE.", "O.E.", "...."}
        )));
        System.err.println(Arrays.toString(new Solution().ballGame(
                41,
                new String[]{"E...W..WW", ".E...O...", "...WO...W", "..OWW.O..", ".W.WO.W.E", "O..O.W...", ".OO...W..", "..EW.WEE."}
        )));
    }

    static class Solution {
        char[][] matrix;
        int height;
        int width;

        public int[][] ballGame(int num, String[] plate) {
            //  构造二维数组
            height = plate.length;
            width = plate[0].length();
            matrix = new char[height][width];
            for (int y = 0; y < plate.length; y++) {
                String line = plate[y];
                for (int x = 0; x < line.length(); x++) {
                    matrix[y][x] = line.charAt(x);
                }
            }
            // 尝试4个边
            // direction = 1上 2下 3左 4右
            List<int[]> list = new ArrayList<>();
            for (int y = 1; y < height - 1; y++) {
                if (matrix[y][0] == '.' && canGo(4, y, 0, num)) {
                    list.add(new int[]{y, 0});
                }
                if (matrix[y][width - 1] == '.' && canGo(3, y, width - 1, num)) {
                    list.add(new int[]{y, width - 1});
                }
            }
            for (int x = 1; x < width - 1; x++) {
                if (matrix[0][x]  == '.' && canGo(2, 0, x, num)) {
                    list.add(new int[]{0, x});
                }
                if (matrix[height - 1][x] == '.' && canGo(1, height - 1, x, num)) {
                    list.add(new int[]{height - 1, x});
                }
            }
            // 返回结果
            Collections.sort(list, (o1, o2) -> {
                if (o1[0] != o2[0]) {
                    return Integer.compare(o1[0], o2[0]);
                }
                return Integer.compare(o1[1], o2[1]);
            });
            int[][] res = new int[list.size()][2];
            for (int i = 0; i < list.size(); i++) {
                // System.out.println(Arrays.toString(list.get(i)));
                res[i] = list.get(i);
            }
            // System.out.println();
            return res;
        }

        private boolean canGo(int direction, int y, int x, int leftStep) {
            // direction = 1上 2下 3左 4右
            Set<String> visited = new HashSet<>();
            while (leftStep >= 0 && (0 <= y && y < height) && (0 <= x && x < width)) {
                if (visited.contains(y + "," + x + "," + direction)) {
                    return false;
                }
                visited.add(y + "," + x + "," + direction);
                if (matrix[y][x] == 'O') {
                    return true;
                } else if (matrix[y][x] == 'E') {
                    if (direction == 1) {
                        direction = 4;
                        x++;
                    } else if (direction == 2) {
                        direction = 3;
                        x--;
                    } else if (direction == 3) {
                        direction = 1;
                        y--;
                    } else if (direction == 4) {
                        direction = 2;
                        y++;
                    }
                } else if (matrix[y][x] == 'W') {
                    if (direction == 1) {
                        direction = 3;
                        x--;
                    } else if (direction == 2) {
                        direction = 4;
                        x++;
                    } else if (direction == 3) {
                        direction = 2;
                        y++;
                    } else if (direction == 4) {
                        direction = 1;
                        y--;
                    }
                } else {
                    if (direction == 1) {
                        y--;
                    } else if (direction == 2) {
                        y++;
                    } else if (direction == 3) {
                        x--;
                    } else if (direction == 4) {
                        x++;
                    }
                }
                leftStep--;
            }
            return false;
        }
    }

}
