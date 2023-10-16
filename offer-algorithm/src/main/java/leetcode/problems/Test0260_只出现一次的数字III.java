package leetcode.problems;

import java.util.Arrays;

public class Test0260_只出现一次的数字III {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
        System.out.println(Arrays.toString(new Solution().singleNumber(new int[]{-1, 0})));
        System.out.println(Arrays.toString(new Solution().singleNumber(new int[]{0, 1})));
    }

    static class Solution {
        public int[] singleNumber(int[] nums) {
            // 互相异或，结果最终为两个出现一次的数异或
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
            }
            // 找到右边的第一个1，把结果分两类，这两个数分别属于这两类
            int l = 1;
            while ((xor & l) == 0) {
                l <<= 1;
            }
            int num1 = 0;
            int num2 = 0;
            for (int num : nums) {
                if ((num & l) > 0) {
                    num1 ^= num;
                } else {
                    num2 ^= num;
                }
            }
            return new int[]{num1, num2};
        }
    }

}
