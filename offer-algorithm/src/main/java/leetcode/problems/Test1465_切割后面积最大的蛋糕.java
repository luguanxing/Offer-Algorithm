package leetcode.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1465_切割后面积最大的蛋糕 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxArea(5, 4, new int[]{1, 2, 4}, new int[]{1, 3}));
        System.out.println(new Solution().maxArea(5, 4, new int[]{3, 1}, new int[]{1}));
        System.out.println(new Solution().maxArea(5, 4, new int[]{3}, new int[]{3}));
        System.out.println(new Solution().maxArea(1000000000, 1000000000, new int[]{2}, new int[]{2}));
    }

    static class Solution {
        public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
            int MOD = (int) (1E9 + 7);
            List<Integer> widths = new ArrayList<>();
            List<Integer> heights = new ArrayList<>();
            widths.add(0);
            heights.add(0);
            for (int c : verticalCuts) {
                widths.add(c);
            }
            for (int c : horizontalCuts) {
                heights.add(c);
            }
            widths.add(w);
            heights.add(h);
            Collections.sort(widths);
            Collections.sort(heights);
            int maxWidth = 0;
            int maxHeight = 0;
            for (int i = 1; i < widths.size(); i++) {
                maxWidth = Math.max(maxWidth, widths.get(i) - widths.get(i - 1));
            }
            for (int i = 1; i < heights.size(); i++) {
                maxHeight = Math.max(maxHeight, heights.get(i) - heights.get(i - 1));
            }
            return (int) ((long)maxWidth * maxHeight % MOD);
        }
    }

}
