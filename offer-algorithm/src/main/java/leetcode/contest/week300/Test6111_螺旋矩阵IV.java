package leetcode.contest.week300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test6111_螺旋矩阵IV {

    public static void main(String[] args) {

    }

    static class Solution {
        public int[][] spiralMatrix(int m, int n, ListNode head) {
            // 初始化数据
            int[][] matrix = new int[m][n];
            for (int[] row : matrix) {
                Arrays.fill(row, -1);
            }
            List<Integer> nodeVals = new ArrayList<>();
            ListNode node = head;
            while (node != null) {
                nodeVals.add(node.val);
                node = node.next;
            }
            // 螺旋填上链表
            int height = matrix.length;
            int width = matrix[0].length;
            boolean[][] isVisited = new boolean[height][width];
            int direction = 1;
            int y = 0;
            int x = 0;
            while (0 <= x && x < width && 0 <= y && y < height && !isVisited[y][x]) {
                isVisited[y][x] = true;
                if (!nodeVals.isEmpty()) {
                    matrix[y][x] = nodeVals.get(0);
                    nodeVals.remove(0);
                }
                if (direction == 1) {
                    // 继续向右或向下
                    if (x + 1 < width && !isVisited[y][x + 1]) {
                        x += 1;
                    } else {
                        direction = 2;
                        y += 1;
                    }
                } else if (direction == 2) {
                    // 继续向下或向左
                    if (y + 1 < height && !isVisited[y + 1][x]) {
                        y += 1;
                    } else {
                        direction = 3;
                        x -= 1;
                    }
                } else if (direction == 3) {
                    // 继续向左或向上
                    if (0 <= x - 1 && !isVisited[y][x - 1]) {
                        x -= 1;
                    } else {
                        direction = 4;
                        y -= 1;
                    }
                } else {
                    // 继续向上或者向右
                    if (0 <= y - 1 && !isVisited[y - 1][x]) {
                        y -= 1;
                    } else {
                        direction = 1;
                        x += 1;
                    }
                }
            }
            return matrix;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
