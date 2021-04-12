package leetcode.problems;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Test0179_最大数 {

    public static void main(String[] args) {
        System.out.println(new Solution().largestNumber(new int[]{10, 2}));
        System.out.println(new Solution().largestNumber(new int[]{20, 1}));
        System.out.println(new Solution().largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(new Solution().largestNumber(new int[]{1}));
        System.out.println(new Solution().largestNumber(new int[]{10}));
        System.out.println(new Solution().largestNumber(new int[]{999999991, 9}));
        System.out.println(new Solution().largestNumber(new int[]{0, 0}));
    }

    static class Solution {
        public String largestNumber(int[] nums) {
            String res = Arrays.stream(nums)
                    .boxed()
                    .sorted((o1, o2) -> (o2.toString() + o1.toString()).compareTo(o1.toString() + o2.toString()))
                    .map(i -> i + "")
                    .collect(Collectors.joining(""));
            while (res.startsWith("0") && res.length() > 1) {
                res = res.substring(1);
            }
            return res;
        }
    }

}
