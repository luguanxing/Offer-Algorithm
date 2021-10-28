package leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Test0869_重新排序得到2的幂 {

    public static void main(String[] args) {
        System.out.println(new Solution().reorderedPowerOf2(1));
        System.out.println(new Solution().reorderedPowerOf2(10));
        System.out.println(new Solution().reorderedPowerOf2(16));
        System.out.println(new Solution().reorderedPowerOf2(24));
        System.out.println(new Solution().reorderedPowerOf2(46));
    }

    static class Solution {
        public boolean reorderedPowerOf2(int n) {
            Set<String> set = new HashSet<>();
            for (long num = 1; num < 1000000000; num <<= 1) {
                int[] map = new int[10];
                String str = Long.toString(num);
                for (char c : str.toCharArray()) {
                    map[c - '0']++;
                }
                set.add(Arrays.toString(map));
            }

            int[] map = new int[10];
            String str = Long.toString(n);
            for (char c : str.toCharArray()) {
                map[c - '0']++;
            }
            return set.contains(Arrays.toString(map));
        }
    }

}
