package leetcode.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Test_16_19_水域大小 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().pondSizes(new int[][]{
                {0, 2, 1, 0},
                {0, 1, 0, 1},
                {1, 1, 0, 1},
                {0, 1, 0, 1}
        })));
    }

    static class Solution {
        public int[] pondSizes(int[][] land) {
            int height = land.length;
            int width = land[0].length;
            List<Integer> list = new ArrayList<>();
            for (int y = 0; y < height; y++) {
                for (int x = 0; x < width; x++) {
                    if (land[y][x] == 0) {
                        list.add(dfs(land, y, x));
                    }
                }
            }
            Collections.sort(list);
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                res[i] = list.get(i);
            }
            return res;
        }

        private int dfs(int[][] land, int y, int x) {
            int height = land.length;
            int width = land[0].length;
            if (y < 0 || y >= height || x < 0 || x >= width) {
                return 0;
            }
            if (land[y][x] >= 1) {
                return 0;
            }
            land[y][x] = 1;
            return 1 +
                    dfs(land, y - 1, x) +
                    dfs(land, y - 1, x + 1) +
                    dfs(land, y - 1, x - 1) +
                    dfs(land, y + 1, x) +
                    dfs(land, y + 1, x + 1) +
                    dfs(land, y + 1, x - 1) +
                    dfs(land, y, x - 1) +
                    dfs(land, y, x + 1);
        }
    }

}
