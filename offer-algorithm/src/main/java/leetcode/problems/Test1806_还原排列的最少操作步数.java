package leetcode.problems;

import java.util.Arrays;

public class Test1806_还原排列的最少操作步数 {

    public static void main(String[] args) {
        System.out.println(new Solution().reinitializePermutation(2));
        System.out.println(new Solution().reinitializePermutation(4));
        System.out.println(new Solution().reinitializePermutation(6));
    }

    static class Solution {
        public int reinitializePermutation(int n) {
            int[] target = new int[n];
            int[] current = new int[n];
            for (int i = 0; i < n; i++) {
                target[i] = i;
                current[i] = i;
            }
            int step = 0;
            while (true) {
                int[] next = current.clone();
                for (int i = 0; i < next.length; i++) {
                    if (i % 2 == 0) {
                        next[i] = current[i / 2];
                    } else {
                        next[i] = current[n / 2 + (i - 1) / 2];
                    }
                }
                current = next;
                step++;
                if (Arrays.equals(target, current)) {
                    break;
                }
            }
            return step;
        }
    }

}
