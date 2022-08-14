package leetcode.contest.week306;

import java.util.Arrays;

public class Test6149_边积分最高的节点 {

    public static void main(String[] args) {
        System.out.println(new Solution().edgeScore(new int[]{1, 0, 0, 0, 0, 7, 7, 5}));
        System.out.println(new Solution().edgeScore(new int[]{2, 0, 0, 2}));
        System.out.println(new Solution().edgeScore(new int[]{1, 0}));
    }

    static class Solution {
        public int edgeScore(int[] edges) {
            int len = edges.length;
            long[] map = new long[len];
            for (int i = 0; i < len; i++) {
                map[edges[i]] += i;
            }
            long max = Arrays.stream(map).max().getAsLong();
            for (int i = 0; i < len; i++) {
                if (map[i] == max) {
                    return i;
                }
            }
            return -1;
        }
    }

}
