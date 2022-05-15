package leetcode.contest.week293;

import java.util.Arrays;

public class Test6065_按位与结果大于零的最长组合 {

    public static void main(String[] args) {
        System.out.println(new Solution().largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14}));
        System.out.println(new Solution().largestCombination(new int[]{8, 8}));
    }

    static class Solution {
        public int largestCombination(int[] candidates) {
            int[] map = new int[32];
            for (int candidate : candidates) {
                String binaryStr = Integer.toBinaryString(candidate);
                int len = binaryStr.length();
                for (int i = 0; i < len; i++) {
                    if (binaryStr.charAt(len - i - 1) == '1') {
                        map[i]++;
                    }
                }
            }
            return Arrays.stream(map).max().getAsInt();
        }
    }

}
