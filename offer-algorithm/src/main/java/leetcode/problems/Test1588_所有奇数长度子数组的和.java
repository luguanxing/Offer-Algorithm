package leetcode.problems;

import java.util.Arrays;

public class Test1588_所有奇数长度子数组的和 {

    public static void main(String[] args) {
        System.out.println(new Solution().sumOddLengthSubarrays(
                new int[]{1, 4, 2, 5, 3}
        ));
        System.out.println(new Solution().sumOddLengthSubarrays(
                new int[]{1, 2}
        ));
        System.out.println(new Solution().sumOddLengthSubarrays(
                new int[]{10, 11, 12}
        ));
    }

    static class Solution {
        public int sumOddLengthSubarrays(int[] arr) {
            int res = 0;
            int size = 1;
            while (size <= arr.length) {
                for (int i = 0; i + size <= arr.length; i++) {
                    res += Arrays.stream(Arrays.copyOfRange(arr, i, i + size)).sum();
                }
                size += 2;
            }
            return res;
        }
    }

}
