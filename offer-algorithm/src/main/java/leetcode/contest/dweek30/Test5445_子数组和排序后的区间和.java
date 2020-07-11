package leetcode.contest.dweek30;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test5445_子数组和排序后的区间和 {

    public static void main(String[] args) {
        System.out.println(new Solution().rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 5));
        System.out.println(new Solution().rangeSum(new int[]{1, 2, 3, 4}, 4, 3, 4));
        System.out.println(new Solution().rangeSum(new int[]{1, 2, 3, 4}, 4, 1, 10));
    }

    static class Solution {
        public int rangeSum(int[] nums, int n, int left, int right) {
            // 添加所有连续子数组和
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int sum = 0;
                for (int j = i; j < n; j++) {
                    sum += nums[j];
                    list.add(sum);
                }
            }
            // 排序，计算求和
            Collections.sort(list);
            BigInteger sum = new BigInteger("0");
            for (int i = left - 1; i <= right - 1; i++) {
                sum = sum.add(new BigInteger(list.get(i) + ""));
            }
            return sum.mod(new BigInteger("1000000007")).intValue();
        }
    }

}
