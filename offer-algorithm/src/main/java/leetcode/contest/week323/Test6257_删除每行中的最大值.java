package leetcode.contest.week323;

import java.util.ArrayList;
import java.util.List;

public class Test6257_删除每行中的最大值 {

    public static void main(String[] args) {
        System.out.println(new Solution().deleteGreatestValue(new int[][]{
                {1, 2, 4}, {3, 3, 1}
        }));
        System.out.println(new Solution().deleteGreatestValue(new int[][]{
                {10}
        }));
    }

    static class Solution {
        public int deleteGreatestValue(int[][] grid) {
            int h = grid.length;
            int w = grid[0].length;
            List<List<Integer>> lists = new ArrayList<>();
            for (int y = 0; y < h; y++) {
                List<Integer> list = new ArrayList<>();
                for (int x = 0; x < w; x++) {
                    list.add(grid[y][x]);
                }
                lists.add(list);
            }
            int ans = 0;
            for (int t = 1; t <= w; t++) {
                int max = 0;
                for (int y = 0; y < h; y++) {
                    int currentMax = -1;
                    int currentMaxIndex = -1;
                    for (int x = 0; x < lists.get(y).size(); x++) {
                        if (lists.get(y).get(x) >= currentMax) {
                            currentMax = lists.get(y).get(x);
                            currentMaxIndex = x;
                        }
                    }
                    lists.get(y).remove(currentMaxIndex);
                    max = Math.max(max, currentMax);
                }
                ans += max;
            }
            return ans;
        }
    }

}
