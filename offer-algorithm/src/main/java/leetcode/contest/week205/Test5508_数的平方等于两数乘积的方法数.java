package leetcode.contest.week205;

import java.util.*;

public class Test5508_数的平方等于两数乘积的方法数 {

    public static void main(String[] args) {
        System.out.println(new Solution().numTriplets(
                new int[]{7, 4},
                new int[]{5, 2, 8, 9}
        ));
        System.out.println(new Solution().numTriplets(
                new int[]{1, 1},
                new int[]{1, 1, 1}
        ));
        System.out.println(new Solution().numTriplets(
                new int[]{7, 7, 8, 3},
                new int[]{1, 2, 9, 7}
        ));
        System.out.println(new Solution().numTriplets(
                new int[]{4, 7, 9, 11, 23},
                new int[]{3, 5, 1024, 12, 18}
        ));
    }

    static class Solution {
        public int numTriplets(int[] nums1, int[] nums2) {
            Map<Long, Integer> set1_square = new HashMap<>();
            Map<Long, Integer> set1_product = new HashMap<>();
            Map<Long, Integer> set2_square = new HashMap<>();
            Map<Long, Integer> set2_product = new HashMap<>();
            for (int num : nums1) {
                long square = (long) num * num;
                set1_square.put(square, set1_square.getOrDefault(square, 0) + 1);
            }
            for (int i = 0; i < nums1.length; i++) {
                for (int j = i + 1; j < nums1.length; j++) {
                    long product = (long) nums1[i] * nums1[j];
                    set1_product.put(product, set1_product.getOrDefault(product, 0) + 1);
                }
            }
            for (int num : nums2) {
                long square = (long) num * num;
                set2_square.put(square, set2_square.getOrDefault(square, 0) + 1);
            }
            for (int i = 0; i < nums2.length; i++) {
                for (int j = i + 1; j < nums2.length; j++) {
                    long product = (long) nums2[i] * nums2[j];
                    set2_product.put(product, set2_product.getOrDefault(product, 0) + 1);
                }
            }
            int res = 0;
            for (long square : set1_square.keySet()) {
                if (set2_product.keySet().contains(square)) {
                    int square_cnt = set1_square.get(square);
                    int product_cnt = set2_product.get(square);
                    res += square_cnt * product_cnt;
                }
            }
            for (long square : set2_square.keySet()) {
                if (set1_product.keySet().contains(square)) {
                    int square_cnt = set2_square.get(square);
                    int product_cnt = set1_product.get(square);
                    res += square_cnt * product_cnt;
                }
            }
            return res;
        }
    }

}
