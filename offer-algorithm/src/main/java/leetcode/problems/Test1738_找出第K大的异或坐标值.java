package leetcode.problems;

import java.util.PriorityQueue;

public class Test1738_找出第K大的异或坐标值 {

    public static void main(String[] args) {
        // matrix = [[5,2],[1,6]], k = 1
        System.out.println(new Solution().kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 1));
        // matrix = [[5,2],[1,6]], k = 2
        System.out.println(new Solution().kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 2));
        // matrix = [[5,2],[1,6]], k = 3
        System.out.println(new Solution().kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 3));
        // matrix = [[5,2],[1,6]], k = 4
        System.out.println(new Solution().kthLargestValue(new int[][]{{5, 2}, {1, 6}}, 4));
    }

    static class Solution {
        public int kthLargestValue(int[][] matrix, int k) {
            int height = matrix.length;
            int width = matrix[0].length;
            int[][] xorMatrix = new int[height][width];
            xorMatrix[0][0] = matrix[0][0];
            for (int x = 1; x < width; x++) {
                xorMatrix[0][x] = xorMatrix[0][x - 1] ^ matrix[0][x];
            }
            for (int y = 1; y < height; y++) {
                xorMatrix[y][0] = xorMatrix[y - 1][0] ^ matrix[y][0];
            }
            for (int y = 1; y < height; y++) {
                for (int x = 1; x < width; x++) {
                    xorMatrix[y][x] = xorMatrix[y - 1][x] ^ xorMatrix[y][x - 1] ^ xorMatrix[y - 1][x - 1] ^ matrix[y][x];
                }
            }
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    pq.add(xorMatrix[y][x]);
                    if (pq.size() > k) {
                        pq.poll();
                    }
                }
            }
            return pq.peek();
        }
    }

}
