package leetcode.problems;

import java.util.Arrays;

public class Test0274_H指数 {

    public static void main(String[] args) {
//        System.out.println(new Solution().hIndex(new int[]{0, 1, 3, 5, 6}));
//        System.out.println(new Solution().hIndex(new int[]{0}));
//        System.out.println(new Solution().hIndex(new int[]{100}));
//        System.out.println(new Solution().hIndex(new int[]{1, 1}));
//        System.out.println(new Solution().hIndex(new int[]{1, 2}));
//        System.out.println(new Solution().hIndex(new int[]{11, 15}));
        System.out.println(new Solution2().hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(new Solution2().hIndex(new int[]{1, 3, 1}));
    }

    static class Solution2 {
        public int hIndex(int[] citations) {
            Arrays.sort(citations);
            int len = citations.length;
            int maxH = 0;
            for (int h = 1; h <= len; h++) {
                for (int i = 0; i < len; i++) {
                    if (citations[i] >= h && len - i >= h) {
                        maxH = Math.max(maxH, h);
                    }
                }
            }
            return maxH;
        }
    }

    static class Solution {
        public int hIndex(int[] citations) {
            int max = 0;
            for (int h = 1; h <= citations.length; h++) {
                int n = 0;
                for (int i = 0; i < citations.length; i++) {
                    if (citations[i] >= h) {
                        n++;
                    }
                }
                if (n >= h) {
                    max = Math.max(max, h);
                }
            }
            return max;
        }
    }

}
