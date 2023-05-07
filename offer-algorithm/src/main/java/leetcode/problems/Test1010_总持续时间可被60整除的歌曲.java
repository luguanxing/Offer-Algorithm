package leetcode.problems;

public class Test1010_总持续时间可被60整除的歌曲 {

    public static void main(String[] args) {
        System.out.println(new Solution().numPairsDivisibleBy60(new int[]{30, 20, 150, 100, 40}));
        System.out.println(new Solution().numPairsDivisibleBy60(new int[]{60, 60, 60}));
    }

    static class Solution {
        public int numPairsDivisibleBy60(int[] time) {
            long[] map = new long[100];
            for (int t : time) {
                map[t % 60]++;
            }
            int res = 0;
            res += map[0] * (map[0] - 1) / 2;
            res += map[30] * (map[30] - 1) / 2;
            for (int i = 1; i < 30; i++) {
                res += map[i] * map[60 - i];
            }
            return res;
        }
    }

}
