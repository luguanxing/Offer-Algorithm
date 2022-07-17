package leetcode.contest.week302;

import java.util.Arrays;

public class Test6120_数组能形成多少数对 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().numberOfPairs(new int[]{1, 3, 2, 1, 3, 2, 2})));
        System.out.println(Arrays.toString(new Solution().numberOfPairs(new int[]{1, 1})));
        System.out.println(Arrays.toString(new Solution().numberOfPairs(new int[]{0})));
    }

    static class Solution {
        public int[] numberOfPairs(int[] nums) {
            int[] map = new int[105];
            for (int num : nums) {
                map[num]++;
            }
            int pair = 0;
            for (int i = 0; i <= 100; i++) {
                if (map[i] >= 2) {
                    pair += map[i] / 2;
                    map[i] %= 2;
                }
            }
            return new int[]{pair, Arrays.stream(map).sum()};
        }
    }

}
