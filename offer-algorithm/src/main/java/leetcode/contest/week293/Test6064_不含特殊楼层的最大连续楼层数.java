package leetcode.contest.week293;

import java.util.Arrays;

public class Test6064_不含特殊楼层的最大连续楼层数 {

    public static void main(String[] args) {
        System.out.println(new Solution().maxConsecutive(2, 9, new int[]{4, 6}));
        System.out.println(new Solution().maxConsecutive(6, 8, new int[]{7, 6, 8}));
    }

    static class Solution {
        public int maxConsecutive(int bottom, int top, int[] special) {
            int len = special.length;
            Arrays.sort(special);
            int max = 0;
            max = Math.max(max, special[0] - bottom);
            for (int i = 1; i < len; i++) {
                int diff = special[i] - special[i - 1] - 1;
                max = Math.max(max, diff);
            }
            max = Math.max(max, top - special[len - 1]);
            return max;
        }
    }

}
