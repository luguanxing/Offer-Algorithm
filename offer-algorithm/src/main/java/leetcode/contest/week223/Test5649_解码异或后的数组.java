package leetcode.contest.week223;

import java.util.Arrays;

public class Test5649_解码异或后的数组 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().decode(new int[]{1, 2, 3}, 1)));
        System.out.println(Arrays.toString(new Solution().decode(new int[]{6, 2, 7, 3}, 4)));
    }

    static class Solution {
        public int[] decode(int[] encoded, int first) {
            int[] res = new int[encoded.length + 1];
            res[0] = first;
            for (int i = 1; i <= encoded.length; i++) {
                res[i] = res[i - 1] ^ encoded[i - 1];
            }
            return res;
        }
    }

}
