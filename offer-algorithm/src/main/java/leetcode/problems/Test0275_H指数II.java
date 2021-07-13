package leetcode.problems;

public class Test0275_H指数II {

    public static void main(String[] args) {
        System.out.println(new Solution().hIndex(new int[]{0, 1, 3, 5, 6}));
        System.out.println(new Solution().hIndex(new int[]{0}));
        System.out.println(new Solution().hIndex(new int[]{100}));
        System.out.println(new Solution().hIndex(new int[]{1, 1}));
        System.out.println(new Solution().hIndex(new int[]{1, 2}));
        System.out.println(new Solution().hIndex(new int[]{11, 15}));
    }

    static class Solution {
        public int hIndex(int[] citations) {
            int len = citations.length;
            int l = 0;
            int r = len - 1;
            while (l <= r) {
                int m = (l + r) / 2;
                if (citations[m] < len - m) {
                    l = m + 1;
                } else {
                    r = m - 1;
                }
            }
            return len - l;
        }
    }

}
