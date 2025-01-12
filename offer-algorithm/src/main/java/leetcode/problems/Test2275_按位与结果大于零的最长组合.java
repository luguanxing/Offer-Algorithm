package leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2275_按位与结果大于零的最长组合 {

    public static void main(String[] args) {
        // candidates = [16,17,71,62,12,24,14]
        System.out.println(new Solution().largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14}));
        // candidates = [8,8]
        System.out.println(new Solution().largestCombination(new int[]{8, 8}));
    }

    static class Solution {
        public int largestCombination(int[] candidates) {
            int[] map = new int[32];
            for (int candidate : candidates) {
                String binaryString = Integer.toBinaryString(candidate);
                binaryString = String.format("%32s", binaryString).replace(' ', '0');
                for (int i = 0; i < 32; i++) {
                    if (binaryString.charAt(i) == '1') {
                        map[i]++;
                    }
                }
            }
            return Arrays.stream(map).max().getAsInt();
        }
    }

}
