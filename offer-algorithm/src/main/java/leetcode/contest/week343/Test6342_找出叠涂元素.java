package leetcode.contest.week343;

import java.util.HashMap;
import java.util.Map;

public class Test6342_找出叠涂元素 {

    public static void main(String[] args) {
        System.out.println(new Solution().firstCompleteIndex(
                new int[]{1, 3, 4, 2},
                new int[][]{{1, 4}, {2, 3}}
        ));
        System.out.println(new Solution().firstCompleteIndex(
                new int[]{2, 8, 7, 4, 1, 3, 5, 6, 9},
                new int[][]{{3, 2, 5}, {1, 4, 6}, {8, 7, 9}}
        ));
        System.out.println(new Solution().firstCompleteIndex(
                new int[]{1, 4, 5, 2, 6, 3},
                new int[][]{{4, 3, 5}, {1, 2, 6}}
        ));
    }

    static class Solution {
        public int firstCompleteIndex(int[] arr, int[][] mat) {
            int height = mat.length;
            int width = mat[0].length;
            Map<Integer, int[]> positionMap = new HashMap<>();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < mat[0].length; x++) {
                    int idx = mat[y][x];
                    positionMap.put(idx, new int[]{y, x});
                }
            }
            int[] yCnt = new int[height];
            int[] xCnt = new int[width];
            for (int i = 0; i < arr.length; i++) {
                int idx = arr[i];
                int[] position = positionMap.get(idx);
                yCnt[position[0]]++;
                xCnt[position[1]]++;
                if (yCnt[position[0]] == width || xCnt[position[1]] == height) {
                    return i;
                }
            }
            return 0;
        }
    }

}
