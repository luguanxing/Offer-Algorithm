package leetcode.contest.week196;

import java.util.Arrays;

public class Test5452_判断能否形成等差数列 {

    public static void main(String[] args) {
        System.out.println(new Solution().canMakeArithmeticProgression(new int[]{3, 5, 1}));
        System.out.println(new Solution().canMakeArithmeticProgression(new int[]{1, 2, 4}));
    }

    static class Solution {
        public boolean canMakeArithmeticProgression(int[] arr) {
            // 先排序
            Arrays.sort(arr);
            // 判断差是否相等
            int diff = arr[1] - arr[0];
            for (int i = 2; i < arr.length; i++) {
                if (arr[i] - arr[i - 1] != diff) {
                    return false;
                }
            }
            return true;
        }
    }

}
