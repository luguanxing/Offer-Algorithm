package leetcode.contest.week234;

import java.util.Arrays;

public class Test5715_还原排列的最少操作步数 {

    public static void main(String[] args) {
        System.out.println(new Solution().reinitializePermutation(2));
        System.out.println(new Solution().reinitializePermutation(4));
        System.out.println(new Solution().reinitializePermutation(6));
    }

    static class Solution {
        public int reinitializePermutation(int n) {
            int res = 1;
            int[] perm = new int[n];
            for (int i = 0; i < n; i++) {
                perm[i] = i;
            }
            int[] tmp = op(perm);
            while (!Arrays.toString(tmp).equals(Arrays.toString(perm))) {
                tmp = op(tmp);
                res++;
            }
            return res;
        }

        private int[] op(int[] perm) {
            int[] tmp = new int[perm.length];
            for (int i = 0; i < perm.length; i++) {
                if (i % 2 == 0) {
                    tmp[i] = perm[i / 2];
                } else {
                    tmp[i] = perm[perm.length / 2 + (i - 1) / 2];
                }
            }
            return tmp;
        }
    }

}
