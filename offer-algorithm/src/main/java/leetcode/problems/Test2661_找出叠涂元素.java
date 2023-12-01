package leetcode.problems;

import java.util.HashMap;
import java.util.Map;

public class Test2661_找出叠涂元素 {

    public static void main(String[] args) {
        // arr = [1,3,4,2], mat = [[1,4],[2,3]]
        System.out.println(new Solution().firstCompleteIndex(new int[]{1, 3, 4, 2}, new int[][]{{1, 4}, {2, 3}}));
        // arr = [2,8,7,4,1,3,5,6,9], mat = [[3,2,5],[1,4,6],[8,7,9]]
        System.out.println(new Solution().firstCompleteIndex(new int[]{2, 8, 7, 4, 1, 3, 5, 6, 9}, new int[][]{{3, 2, 5}, {1, 4, 6}, {8, 7, 9}}));
    }

    static class Solution {
        public int firstCompleteIndex(int[] arr, int[][] mat) {
            int height = mat.length;
            int width = mat[0].length;
            Map<Integer, int[]> indexMap = new HashMap<>();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    int index = mat[y][x];
                    indexMap.put(index, new int[]{y, x});
                }
            }
            int[] rows = new int[height];
            int[] cols = new int[width];
            for (int i = 0; i < arr.length; i++) {
                int index = arr[i];
                int[] pos = indexMap.get(index);
                int y = pos[0];
                int x = pos[1];
                rows[y]++;
                cols[x]++;
                if (rows[y] == width || cols[x] == height) {
                    return i;
                }
            }
            return -1;
        }
    }

}
